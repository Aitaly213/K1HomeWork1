package com.geektech.k1lesson1.ui

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.geektech.k1lesson1.R
import com.geektech.k1lesson1.utils.EXTRA_MESSAGE
import com.geektech.k1lesson1.utils.Toasts
import kotlinx.android.synthetic.main.activity_two.*

class ActivityTwo : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_two)

        checkIntent()
        setupListener()
    }

    private fun checkIntent() {
        et_ActTwo.setText(intent.getStringExtra(EXTRA_MESSAGE))
    }

    private fun setupListener() {
        btn_ActTwo.setOnClickListener {
            if (et_ActTwo.text.toString() == "") {
                Toasts.showToast(this, getString(R.string.warning))
            } else openActivity()
        }
    }

    private fun openActivity() {
        val intent = Intent(this, MainActivity::class.java).apply {
            putExtra(EXTRA_MESSAGE, et_ActTwo.text.toString())
        }
        setResult(Activity.RESULT_OK, intent)
        finish()
    }
}