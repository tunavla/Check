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


        
        checkIn = !checkIn

        Thread{
            Thread.sleep(3000)
            resultImg.post {
                Picasso.with(applicationContext).load(
                        if (checkIn) R.drawable.yes
                        else R.drawable.no
                ).into(resultImg)
                resultImg.visibility = View.VISIBLE
                resultBar.visibility = View.GONE
            }
            Thread.sleep(2000)
            val intent = Intent(applicationContext, MainActivity::class.java)
            startActivity(intent)
        }.start()


    }
}
