package com.silva.murillo.passowrdgeneratet.ui.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.databinding.DataBindingUtil
import com.silva.murillo.passowrdgeneratet.R
import com.silva.murillo.passowrdgeneratet.ui.adapter.SpinnerAdapter
import com.silva.murillo.passowrdgeneratet.databinding.ActivityGeneratePasswordBinding

class GeneratePasswordActivity : AppCompatActivity() {
    private var spinnerAdapter = SpinnerAdapter()
    private lateinit var binding: ActivityGeneratePasswordBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_generate_password)
        configureSelectType()
        configureClickGenereate()
    }

    private fun configureSelectType() {
        val spinner: Spinner = findViewById(R.id.planets_spinner)
        ArrayAdapter.createFromResource(
            this, R.array.spinner_array, android.R.layout.simple_spinner_dropdown_item
        ).also { arrayAdapter ->
            arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinner.adapter = arrayAdapter
        }
    }

    private fun configureClickGenereate() {
        binding.apply {
            button.setOnClickListener {
                val stringRandom = "QWERTYUIOPASDFGHJKLZXCVBNM" + 123455667780
                val strinG = stringRandom.random()
                strinG.let {
                    Log.d(strinG.toString(), "aqui")
                }
            }
        }
    }
}