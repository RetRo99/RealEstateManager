package com.openclassrooms.realestatemanager.ui.photoFragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.openclassrooms.realestatemanager.R
import com.openclassrooms.realestatemanager.ui.photoFragment.adapter.PhotoFullScreenAdapter
import com.openclassrooms.realestatemanager.ui.propertyAdd.model.UiPropertyDetailsPhotoItem
import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.fragment_photo.*
import javax.inject.Inject

class PhotoFragment : DaggerFragment(), PhotoFragmentView {

    private val args: PhotoFragmentArgs by navArgs()

    @Inject
    lateinit var presenter: PhotoFragmentPresenter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_photo, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        presenter.onViewCreated(args.photos)
    }

    override fun setPhotos(photos: Array<UiPropertyDetailsPhotoItem>) {
        imageViewPager.adapter =  PhotoFullScreenAdapter(requireContext(), photos)
        indicator.setupWithViewPager(imageViewPager, true)
    }

}
