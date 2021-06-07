package com.example.quest3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.quest3.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
       binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.button.setOnClickListener {
            binding.textView2.text = binding.editTextTextPersonName.text

            //내가 작성한 코드
            val pet: String =  getString(R.string.dog) + ": ${binding.radioDog.isChecked} "+ getString(R.string.cat) + ": ${binding.radioCat.isChecked} "

            //교수님 조언
            // format(String, Object...)과 getString(int, Object...) 포맷스트링 활용

            Snackbar.make(it, pet, Snackbar.LENGTH_SHORT).show()

            when (binding.radioGroup.checkedRadioButtonId) {
                R.id.radioDog -> println("Dog checked")
                R.id.radioCat -> println("Cat checked")
            }
        }
    }

}
