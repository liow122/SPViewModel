package com.example.spviewmodel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var countViewModel: CountViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.d("MainActivity","onCreate")

        countViewModel = ViewModelProviders.of(this).get(CountViewModel::class.java)

        textViewCount.text = countViewModel.count.value?.toString()

        buttonPlus.setOnClickListener{
            countViewModel.increment()
            textViewCount.text = countViewModel.count.value?.toString()
        }

        buttonMinus.setOnClickListener{
            countViewModel.decrement()
            textViewCount.text = countViewModel.count.value?.toString()
        }
    }

    private fun goodLuck(){
        Toast.makeText(applicationContext,
            "Good Luck!!!",
            Toast.LENGTH_SHORT
        ).show()
    }

    override fun onDestroy() {
        Log.d("MainActivity","onDestroy")
        super.onDestroy()
    }
}
