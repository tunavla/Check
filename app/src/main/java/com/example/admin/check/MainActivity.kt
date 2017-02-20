package com.example.admin.check

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.os.Environment
import android.provider.MediaStore
import android.view.View
import android.widget.Button
import android.widget.ImageView
import com.squareup.picasso.Picasso
import java.io.File
import android.graphics.Bitmap




class MainActivity: Activity() {

    companion object {
        private var TAKE_PICTURE = 1
        private var mOutputFileUri: Uri? = null
        private var next = 0
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        View.SYSTEM_UI_FLAG_FULLSCREEN

        val btn_check = findViewById(R.id.btn_checked) as Button
        val btn_newuser = findViewById(R.id.btn_registration) as Button
        val mainLogo = findViewById(R.id.main_logo) as ImageView

        Picasso.with(applicationContext).load(R.drawable.logo).into(mainLogo)

        btn_newuser.setOnClickListener {
            val intent = Intent(applicationContext, EditCoworkerActivity::class.java)
            startActivity(intent)
        }
        btn_check.setOnClickListener {
            val intent1 = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            val file = File(Environment.getExternalStorageDirectory(),
                    "qwer.jpg")
            mOutputFileUri = Uri.fromFile(file)
            intent.putExtra(MediaStore.EXTRA_OUTPUT, mOutputFileUri)
            startActivityForResult(intent1, TAKE_PICTURE)
        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        val resultIntent = Intent(applicationContext, ResultActivity::class.java)
        startActivity(resultIntent)
    }
}
