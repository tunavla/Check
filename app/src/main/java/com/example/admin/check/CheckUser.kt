package com.example.admin.check

/**
 * Created by Admin on 19.02.2017.
 */
class CheckUser() {
    var fio="fio"
    var img_path="no path"
    var time_begin="00:00:00"
    var time_end="00:00:00"

    constructor(fio:String, img_path:String, time_begin:String, time_end:String) : this() {
        this.fio=fio
        this.img_path=img_path
        this.time_begin=time_begin
        this.time_end=time_end
    }

}