package com.openclassrooms.realestatemanager.ui.propertyAdd.adapter

import android.graphics.BitmapFactory
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.openclassrooms.realestatemanager.R
import kotlinx.android.synthetic.main.item_uri.view.*

class UriAdapter(val isDetails :Boolean = true,val action: ((Int) -> (Unit))? = null) :
    RecyclerView.Adapter<UriAdapter.UriHolder>() {

    private var data = listOf<String>()

    fun setData(data: List<String>) {
        this.data = data
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UriHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_uri, parent, false)
        return UriHolder(view)
    }

    override fun onBindViewHolder(holder: UriHolder, position: Int) {
        holder.bind(data[position], position)
    }

    override fun getItemCount(): Int = data.size

    inner class UriHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        fun bind(path: String, position: Int) {

            view.run{
                ivUri.setImageBitmap(BitmapFactory.decodeFile(path))
               if(isDetails){
                   ivDeleteUri.visibility = View.VISIBLE
                   ivDeleteUri.setOnClickListener {
                       action!!(position)
                   }
               }

            }
        }
    }
}