package com.example.quest8

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.view.Menu
import android.view.MenuItem
import androidx.core.content.edit
import androidx.preference.PreferenceManager
import com.example.quest8.databinding.ActivityMainBinding
import java.io.File

class MainActivity : AppCompatActivity() {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private val pref by lazy { getSharedPreferences("MY-SETTINGS", 0) }


    private fun displaySettings() {
        val settings = PreferenceManager.getDefaultSharedPreferences(this)
        val signature = settings.getString("signature", "")
        val reply = settings.getString("reply", "")
        val sync = settings.getBoolean("sync", false)
        val attachment = settings.getBoolean("attachment", false)
        val str = """signature: $signature
        reply: $reply
        sync: $sync
        attachment: $attachment
        """
        binding.textViewSettings.text = str
    }

    //라이프 사이클 의도 파악 -> 파괴 후 생성이므로 onCreate /onResume / onStart 3개중 하나 가능
    override fun onCreate(savedInstanceState: Bundle?) {
        setContentView(binding.root)
        super.onCreate(savedInstanceState)

    }

    override fun onStart() {
        super.onStart()
        println("onStart")
    }
    
    override fun onResume() {
        super.onResume()
        displaySettings()
        println("onResume")
    }

    override fun onRestart() {
        super.onRestart()
        println("onRestart")
    }

    override fun onDestroy() {
        super.onDestroy()
        println("onDestroy")
    }

    override fun onStop() {
        super.onStop()
        println("onStop")
    }

    override fun onPause() {
        super.onPause()
        println("onPause")
    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return true
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.settings -> startActivity(Intent(this, SettingsActivity::class.java))
            else -> super.onOptionsItemSelected(item)
        }
        return super.onOptionsItemSelected(item)
    }
}