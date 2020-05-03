package com.openclassrooms.realestatemanager.ui.photoFragment.adapter

import android.content.Context
import android.graphics.BitmapFactory
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.PagerAdapter
import com.openclassrooms.realestatemanager.R
import com.openclassrooms.realestatemanager.ui.propertyAdd.model.UiPropertyDetailsPhotoItem
import kotlinx.android.synthetic.main.item_photo_fullscreen.view.*

class PhotoFullScreenAdapter(context: Context?, private val photos: Array<UiPropertyDetailsPhotoItem>) :
    PagerAdapter() {
    private val inflater: LayoutInflater = LayoutInflater.from(context)

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View)
    }

    override fun getCount(): Int {
        return photos.size ?: 0
    }

    override fun instantiateItem(view: ViewGroup, position: Int): Any {
        val imageLayout = inflater.inflate(R.layout.item_photo_fullscreen, view, false)!!

        val item = photos[position]

        imageLayout.ivFullScreenPhoto.setImageBitmap(BitmapFactory.decodeFile(item.photo))
        imageLayout.tvFullScreenPhotoTitle.text = item.title

        view.addView(imageLayout, 0)

        return imageLayout
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view == `object`
    }


}
