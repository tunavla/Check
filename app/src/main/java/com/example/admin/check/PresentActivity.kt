package com.example.admin.check

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Process
import android.view.View
import android.widget.ProgressBar

class PresentActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        View.SYSTEM_UI_FLAG_FULLSCREEN
        setContentView(R.layout.activity_present)

     Thread {
         Thread.sleep(5000)
         var intent = Intent(applicationContext, EnterActivity::class.java)
         startActivity(intent)

     }.start()

    }
}
