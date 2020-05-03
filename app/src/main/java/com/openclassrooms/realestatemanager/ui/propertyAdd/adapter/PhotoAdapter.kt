package com.openclassrooms.realestatemanager.ui.propertyAdd.adapter

import android.graphics.BitmapFactory
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.openclassrooms.realestatemanager.R
import com.openclassrooms.realestatemanager.ui.propertyAdd.model.UiPropertyDetailsPhotoItem
import kotlinx.android.synthetic.main.item_photo.view.*

class PhotoAdapter(private val isDetails :Boolean = true, private val action: ((Int) -> (Unit))? = null) :
    RecyclerView.Adapter<PhotoAdapter.PhotoHolder>() {

    private var data = listOf<UiPropertyDetailsPhotoItem>()

    fun setData(data: List<UiPropertyDetailsPhotoItem>) {
        this.data = data
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_photo, parent, false)
        return PhotoHolder(view)
    }


    override fun onBindViewHolder(holder: PhotoHolder, position: Int) {
        holder.bind(data[position], position)
    }

    override fun getItemCount(): Int = data.size

    inner class PhotoHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        fun bind(item: UiPropertyDetailsPhotoItem, position: Int) {

            view.run{
                ivUri.setImageBitmap(BitmapFactory.decodeFile(item.photo))
                tvPhotoTitle.text = item.title
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
