package com.silva.murillo.developingandroid.digital.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.widget.AppCompatButton
import com.silva.murillo.developingandroid.R
import kotlin.random.Random

class FirstActivity : AppCompatActivity() {
    private lateinit var  imageDice : ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first)
        configure()
        imageDice = findViewById(R.id.imageView)
    }

    private fun configure() {
        val button = findViewById<AppCompatButton>(R.id.buttonNewu)
        button.setOnClickListener {
            configureText()
            button.text = "click me"
        }
    }

    private fun configureText() {
        val randomNuber = Random.nextInt(6) + 1
        Toast.makeText(this, "numero sorteado: $randomNuber", Toast.LENGTH_SHORT).show()

        val drawablabe = when (randomNuber) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
       imageDice.setImageResource(drawablabe)
    }
}