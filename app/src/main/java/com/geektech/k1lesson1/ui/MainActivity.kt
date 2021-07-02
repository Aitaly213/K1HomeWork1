package com.geektech.k1lesson1.ui

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.result.ActivityResult
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import com.geektech.k1lesson1.R
import com.geektech.k1lesson1.utils.EXTRA_MESSAGE
import com.geektech.k1lesson1.utils.Toasts
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    private lateinit var resultLauncher: ActivityResultLauncher<Intent>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        registerForActivity()
        setupListener()
    }

    private fun setupListener() {
        btn_mainAct.setOnClickListener {
            if (et_MainAct.text.toString() == "") {
                Toasts.showToast(this, getString(R.string.warning))
            } else openActivity()
        }
    }

    private fun registerForActivity() {
        resultLauncher =
            registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result: ActivityResult ->
                if (result.resultCode == Activity.RESULT_OK) {
                    et_MainAct.setText(result.data?.getStringExtra(EXTRA_MESSAGE))
                }
            }
    }

    private fun openActivity() {
        val intent = Intent(this, ActivityTwo::class.java).apply {
            putExtra(EXTRA_MESSAGE, et_MainAct.text.toString())
        }
        resultLauncher.launch(intent)
    }

}





