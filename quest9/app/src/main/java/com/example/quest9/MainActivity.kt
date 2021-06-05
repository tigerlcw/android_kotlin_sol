package com.example.quest9

import android.content.ComponentName
import android.content.Intent
import android.content.ServiceConnection
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.IBinder
import android.util.Log
import android.widget.Toast
import com.example.quest9.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    val binding by lazy { ActivityMainBinding.inflate(layoutInflater)}
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.buttonBind.isEnabled = true
        binding.buttonService.isEnabled = false
        binding.buttonUnBind.isEnabled = false
        binding.buttonBind.setOnClickListener {
            Intent(this, MyService::class.java).also {
                bindService(it, serviceConnection, BIND_AUTO_CREATE)

            }
        }
        binding.buttonService.setOnClickListener {
            myService?.doService("Hello")
        }

        binding.buttonUnBind.setOnClickListener {
            unbindService(serviceConnection)
            myService = null
            binding.buttonService.isEnabled = false
            binding.buttonUnBind.isEnabled = false
            binding.buttonBind.isEnabled = true
        }

    }


    private var myService:MyService? = null

    private val serviceConnection = object : ServiceConnection{
        override fun onServiceConnected(name: ComponentName?, service: IBinder?) {
            myService = (service as MyService.LocalBinder).getService()
            binding.buttonService.isEnabled = true
            binding.buttonUnBind.isEnabled = true
            binding.buttonBind.isEnabled = false
            Log.d("Sevice", "Service Oncreate")
        }

        override fun onServiceDisconnected(name: ComponentName?) {
            myService = null
        }

    }

}