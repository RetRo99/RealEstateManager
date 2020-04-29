package com.openclassrooms.realestatemanager.ui.propertyList.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.openclassrooms.realestatemanager.R
import com.openclassrooms.realestatemanager.ui.propertyList.model.DummyContent.DummyItem
import kotlinx.android.synthetic.main.item_property_list.view.*

class PropertyAdapter(val action: (String) -> (Unit)) :
    RecyclerView.Adapter<PropertyAdapter.DummyHolder>() {

    private var data = listOf<DummyItem>()

    fun setData(data: List<DummyItem>) {
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
        fun bind(item: DummyItem) {
            view.content.text = item.content
            view.item_number.text = item.id
            view.setOnClickListener {
                action(item.id)
            }
        }
    }
}
