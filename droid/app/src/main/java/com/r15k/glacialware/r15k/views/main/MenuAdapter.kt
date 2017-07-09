package com.r15k.glacialware.r15k.views.main

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import com.r15k.glacialware.r15k.R

/**
 * Created by Guille on 07/07/2017.
 */
class MenuAdapter(context : Context, private var resource : Int, private var list : ArrayList<MenuItem>) : ArrayAdapter<MenuItem>(context, resource) {

    private class ViewHolder {
        var nameOption : TextView? = null
    }

    override fun getCount(): Int {
        return this.list.count()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view : View?
        val item : MenuItem = this.list[position]

        val viewHolder : ViewHolder
        if (convertView == null) {
            viewHolder = ViewHolder()
            view = LayoutInflater.from(this.context).inflate(this.resource, parent, false)
            if (view != null) {
                viewHolder.nameOption = view.findViewById(R.id.drawer_menu_main_row_name_option_tv)
                view.tag = viewHolder
            }
        }
        else {
            view = convertView
            viewHolder = view.tag as ViewHolder
        }

        if (viewHolder.nameOption != null) {
            (viewHolder.nameOption as TextView).text = item.nameOption
        }

        return view as View
    }
}