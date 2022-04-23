package com.silva.murillo.passowrdgeneratet.ui

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.databinding.DataBindingUtil
import com.silva.murillo.passowrdgeneratet.R
import com.silva.murillo.passowrdgeneratet.databinding.ActivityOnboardingBinding

class OnboardingActivity : AppCompatActivity() {
    private lateinit var binding: ActivityOnboardingBinding
    companion object {
        const val RESULT = "RESULT"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_onboarding)
        configureClicks()
    }

    private fun configureClicks() {
        binding.apply {
            btnGo.setOnClickListener {
                intent.putExtra(RESULT, true)
                startActivity(Intent(applicationContext, GeneratePasswordActivity::class.java))
            }
        }
    }
}