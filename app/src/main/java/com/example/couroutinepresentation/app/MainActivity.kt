package com.example.couroutinepresentation.app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.couroutinepresentation.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_api_call.setOnClickListener(this)
        btn_expensive_call.setOnClickListener(this)
        btn_img_download.setOnClickListener(this)
    }

    override fun onClick(view: View?) {
        when (view?.id) {
            R.id.btn_img_download -> {
                startActivity(Intent(this, ImageDownloadActivity::class.java))
            }
            R.id.btn_api_call -> {
                startActivity(Intent(this, APICallActivity::class.java))
            }
            R.id.btn_expensive_call -> {
                startActivity(Intent(this, ExpensiveCallActivity::class.java))
            }
        }
    }
}