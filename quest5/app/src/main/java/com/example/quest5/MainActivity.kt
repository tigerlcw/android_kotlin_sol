package com.example.quest5

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.fragment.findNavController
import com.example.quest5.databinding.ExampleFrag2Binding
import com.example.quest5.databinding.ExampleFrag3Binding
import com.example.quest5.databinding.ExampleFragBinding

class MyViewModel : ViewModel(){
    val testLiveData = MutableLiveData<Int>()
    init {
        testLiveData.value = 0
    }

    fun increase() {
        testLiveData.value = (testLiveData.value ?: 0)+ 1
    }
}
class ExampleFragment : Fragment(R.layout.example_frag)
{
    val viewModel: MyViewModel by activityViewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = ExampleFragBinding.bind(view)


        binding.button2.setOnClickListener {
            findNavController().navigate(R.id.action_exampleFragment_to_example2Fragment)
            viewModel.increase()

        }


        viewModel.testLiveData.observe(viewLifecycleOwner) {
            binding.textView5.text="$it"
        }
    }
}
class Example2Fragment : Fragment(R.layout.example_frag2)
{
    val viewModel: MyViewModel by activityViewModels()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = ExampleFrag2Binding.bind(view)


        binding.button3.setOnClickListener {
            findNavController().navigate(R.id.action_example2Fragment_to_example3Fragment)
            viewModel.increase()
        }

        viewModel.testLiveData.observe(viewLifecycleOwner) {
            binding.textView4.text="$it"
        }
    }
}

class Example3Fragment : Fragment(R.layout.example_frag3)
{
    val viewModel: MyViewModel by activityViewModels()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = ExampleFrag3Binding.bind(view)

        binding.button4.setOnClickListener {
            findNavController().navigate(R.id.action_example3Fragment_to_exampleFragment)
            viewModel.increase()

        }

        viewModel.testLiveData.observe(viewLifecycleOwner) {
            binding.textView8.text="$it"
        }


    }
}


class MainActivity : AppCompatActivity() {
    private val viewModel: MyViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
       // val textView = findViewById<TextView>(R.id.textView7)

        viewModel.testLiveData.observe(this){

         //   textView.text= it.toString()
         //   title = "$it"
        }
    }
}