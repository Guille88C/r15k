package com.glacialware.r15k.view.views.main

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import com.glacialware.r15k.view.R

/**
 * Created by Guille on 07/07/2017.
 */
class MenuAdapter(context : Context,private var items : Array<MenuItem>) : ArrayAdapter<MenuItem>(context, R.layout.view_main_drawer_menu_item) {

    private class ViewHolder {
        lateinit var nameOption : TextView
        lateinit var image : ImageView
    }

    override fun getCount(): Int {
        return this.items.size
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view : View?
        val item : MenuItem = this.items[position]

        val viewHolder : ViewHolder
        if (convertView == null) {
            viewHolder = ViewHolder()
            view = LayoutInflater.from(this.context).inflate(R.layout.view_main_drawer_menu_item, parent, false)
            if (view != null) {
                viewHolder.nameOption = view.findViewById(R.id.drawer_menu_main_row_name_option_tv)
                viewHolder.image = view.findViewById(R.id.imageView)
                view.tag = viewHolder
            }
        }
        else {
            view = convertView
            viewHolder = view.tag as ViewHolder
        }

        viewHolder.nameOption.text = item.nameOption
        viewHolder.image.setImageResource(item.icon)

        return view as View
    }
}