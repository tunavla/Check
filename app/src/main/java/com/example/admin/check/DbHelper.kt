package com.example.admin.check

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import java.util.*

/**
 * Created by Admin on 19.02.2017.
 */
class DbHelper private constructor(context:Context):SQLiteOpenHelper(context, DB_NAME, null, DB_VERSION){


    override fun onCreate(db: SQLiteDatabase?) {

    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
      //  throw UnsupportedOperationException("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    companion object{
         private var dbHelper:DbHelper?=null
         private var db:SQLiteDatabase?=null

        private val DB_NAME = "Test"
        private val DB_VERSION = 1

        private val DB_TABLE_CHECK_USER="checkuser"
        private val DB_COLUM_FIO="fio"
        private val DB_COLUM_TIME_BEGIN="time_begin"
        private val DB_COLUM_TIME_END="time_end"
        private val DB_COLUM_PATH_PIC="path_pic"

        private val DB_CREATE_QUERY="CREATE TABLE "+ DB_TABLE_CHECK_USER+" (_id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                                                     DB_COLUM_FIO+" TEXT, "+
                                                     DB_COLUM_PATH_PIC +  " TEXT, "+
                                                     DB_COLUM_TIME_BEGIN+ " TEXT, "+
                                                     DB_COLUM_TIME_END + " TEXT )"


    }

    public  fun initDbHelper(context: Context){
        if(dbHelper==null){
            dbHelper = DbHelper(context)
            db= dbHelper!!.writableDatabase
             }
         else{
            db= dbHelper!!.readableDatabase
        }


        fun getCheckUser():ArrayList<CheckUser>{

             var result=ArrayList<CheckUser>()
             var  sqlQuery= db!!.rawQuery("SELECT * FROM " + DB_TABLE_CHECK_USER , null)

             while(sqlQuery.moveToNext()) {

                 result.add(CheckUser(sqlQuery.getString(sqlQuery.getColumnIndex(DB_COLUM_FIO)), sqlQuery.getString(sqlQuery.getColumnIndex(DB_COLUM_PATH_PIC)),
                         sqlQuery.getString(sqlQuery.getColumnIndex(DB_COLUM_TIME_BEGIN)), sqlQuery.getString(sqlQuery.getColumnIndex(DB_COLUM_TIME_END))))

             }
         return result
         }

        fun addUser(arr:ArrayList<CheckUser>){

            for (tk in arr){
                var cv=ContentValues()
                cv.put(DB_COLUM_FIO, tk.fio)
                cv.put(DB_COLUM_PATH_PIC, tk.img_path)
                cv.put(DB_COLUM_TIME_BEGIN,tk.time_begin)
                cv.put(DB_COLUM_TIME_END, tk.fio)

                db!!.insert(DB_TABLE_CHECK_USER, null, cv)


            }

        }

    }

}