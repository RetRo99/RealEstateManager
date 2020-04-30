package com.openclassrooms.realestatemanager.ui.propertyList.adapter

import android.graphics.BitmapFactory
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.openclassrooms.realestatemanager.R
import com.openclassrooms.realestatemanager.ui.propertyList.model.UiProperty
import kotlinx.android.synthetic.main.item_property.view.*

class PropertyAdapter(val action: (Int) -> (Unit)) :
    RecyclerView.Adapter<PropertyAdapter.PropertyHolder>() {

    private var data = listOf<UiProperty>()

    fun setData(data: List<UiProperty>) {
        this.data = data
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PropertyHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_property, parent, false)
        return PropertyHolder(view)
    }

    override fun onBindViewHolder(holder: PropertyHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount(): Int = data.size

    inner class PropertyHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        fun bind(item: UiProperty) {

            view.run{
                item.run {
                    tvPropertyType.text = type
                    tvPropertyLocation.text = location
                    tvPropertyPrice.text = price
                    ivProperty.setImageBitmap(BitmapFactory.decodeFile(photo))
                }
                setOnClickListener {
                    action(item.id)
                }
            }
        }
    }
}
