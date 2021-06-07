package com.example.quest4

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.quest4.databinding.ActivitySecondBinding


class SecondActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySecondBinding
    private lateinit var viewModel: MyViewModel.MyViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        viewModel = ViewModelProvider(this).get(MyViewModel.MyViewModel::class.java)
        setContentView(binding.root)
        val resultsIntent = Intent()
        setResult(RESULT_OK, resultsIntent)
        val et = intent?.getStringExtra("key")?.toInt()?: 0
        viewModel.count.value = et

        viewModel.count.observe(this){
            binding.textView2.text = it.toString()
        }

        binding.button3.setOnClickListener {
            viewModel.increaseCount()
            resultsIntent.putExtra("return", binding.textView2.text.toString())
        }

        binding.button4.setOnClickListener {
            viewModel.dereaseCount()
            resultsIntent.putExtra("return", binding.textView2.text.toString())
        }

    }

}