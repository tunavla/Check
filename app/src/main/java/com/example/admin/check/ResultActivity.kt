package com.example.admin.check

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.ProgressBar
import com.squareup.picasso.Picasso

class ResultActivity : Activity() {
    companion object{
        private var checkIn = true
    }

    override fun onCreate(savedInstanceState: Bundle?) {


        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)
        View.SYSTEM_UI_FLAG_FULLSCREEN
        val resultBar = findViewById(R.id.result_progress_bar) as ProgressBar
        val resultImg = findViewById(R.id.result_img) as ImageView
        if (checkIn) Picasso.with(applicationContext).load(R.drawable.yes).into(resultImg)
        else Picasso.with(applicationContext).load(R.drawable.yes).into(resultImg)
        Thread {
            Thread.sleep(3000)
        resultBar.visibility = View.GONE
            resultImg.visibility = View.VISIBLE
        }.start()


        checkIn = false
       resultImg.setOnClickListener {
           val intent = Intent(applicationContext, MainActivity::class.java)
           startActivity(intent)
       }
    }
}
