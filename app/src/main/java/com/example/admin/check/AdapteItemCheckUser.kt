package com.example.admin.check

import android.net.Uri
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import android.widget.ImageView
import android.widget.TextView
import java.security.acl.Group
import java.util.*

/**
 * Created by Admin on 19.02.2017.
 */
class AdapteItemCheckUser(arr:ArrayList<CheckUser>):RecyclerView.Adapter<AdapteItemCheckUser.ViewHolder>() {

    public var mData=arr


    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int):ViewHolder {
        var view = LayoutInflater.from(parent!!.context).inflate(R.layout.item_check_user, null,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return mData.size
    }

    override fun onBindViewHolder(holder:ViewHolder, position: Int) {
        holder.tvFIO.text=mData[position].fio
        holder.ivLogo.setImageURI(Uri.parse(mData[position].img_path))


    }


    class ViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){

        var ivLogo:ImageView
        var tvFIO:TextView

        var view:View

        init{
            view=itemView
            ivLogo=itemView.findViewById(R.id.img_avatar) as ImageView
            tvFIO=itemView.findViewById(R.id.text_item_FIO)as TextView

        }


     }


}

