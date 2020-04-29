package com.openclassrooms.realestatemanager.ui.propertyList.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.openclassrooms.realestatemanager.R
import com.openclassrooms.realestatemanager.ui.propertyList.model.UiProperty
import kotlinx.android.synthetic.main.item_property_list.view.*

class PropertyAdapter(val action: (String) -> (Unit)) :
    RecyclerView.Adapter<PropertyAdapter.DummyHolder>() {

    private var data = listOf<UiProperty>()

    fun setData(data: List<UiProperty>) {
        this.data = data
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DummyHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_property_list, parent, false)
        return DummyHolder(view)
    }

    override fun onBindViewHolder(holder: DummyHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount(): Int = data.size

    inner class DummyHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        fun bind(item: UiProperty) {

            view.run{
                tvPropertyType.text = item.type
                tvPropertyLocation.text = item.location
                tvPropertyPrice.text = item.price
                setOnClickListener {
                    action(item.id)
                }
            }
        }
    }
}
