package com.example.admin.check

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso

/**
 * Created by Admin on 18.02.2017.
 */
class EnterActivity: Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        View.SYSTEM_UI_FLAG_FULLSCREEN
        setContentView(R.layout.activity_enter)

        var img=findViewById(R.id.img_icon) as ImageView
        var etLogin=findViewById(R.id.et_login) as EditText
        var etPass=findViewById(R.id.et_pass) as EditText
        var btnEnter=findViewById(R.id.in_btn) as Button
        var tvErrorPass=findViewById(R.id.error_pass_text) as TextView

        Picasso.with(applicationContext).load(R.drawable.logo).into(img)


        btnEnter.setOnClickListener {
            var flag=1
            //подключение к БД и проверка логина пароля и получения разрешения
            // отправка логина пароля
            //проверка в БД

            if(flag==1){
                var intent=Intent(applicationContext,MainActivity::class.java)
                startActivity(intent)

            }else{
                tvErrorPass.text="Не верный логин или пароль"
            }
        }


    }
}