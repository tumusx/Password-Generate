package com.silva.murillo.developingandroid.digital.views

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.silva.murillo.developingandroid.digital.views.fragments.BottomSheetList
import com.silva.murillo.developingandroid.R

class MainActivity : AppCompatActivity() {
    companion object {
        const val FIRST_FEATURE = 12
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        clickButons()
    }

    private fun clickButons(): Boolean {
        val firstFeature = findViewById<Button>(R.id.firstFeature)
        val secondFeature = findViewById<Button>(R.id.secondFeature)

        secondFeature.setOnClickListener {
            val bottomSheet = BottomSheetList()
            bottomSheet.show(supportFragmentManager, bottomSheet.TAG)
        }

        firstFeature.setOnClickListener {
            val intent = Intent(this, FirstActivity::class.java)
            startActivityForResult(intent, FIRST_FEATURE)
        }
        return true
    }
}