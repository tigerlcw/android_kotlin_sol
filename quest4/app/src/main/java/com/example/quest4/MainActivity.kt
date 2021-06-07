package com.example.quest4

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.quest4.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.button.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            intent.putExtra("key", binding.editTextNumber.text.toString())
            startActivityForResult(intent, 1)
        }

        binding.button2.setOnClickListener {
            val implicitIntent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:114"))
            startActivity(implicitIntent)
        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 1) {
            val msg = data?.getStringExtra("return") ?: "error"
            Snackbar.make(binding.root, "ActivityResult:$msg", Snackbar.LENGTH_SHORT).show()
        }
    }


}