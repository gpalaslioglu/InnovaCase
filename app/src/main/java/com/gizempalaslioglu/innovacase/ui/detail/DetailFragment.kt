package com.gizempalaslioglu.innovacase.ui.detail

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.gizempalaslioglu.innovacase.databinding.FragmentDetailBinding
import com.gizempalaslioglu.innovacase.domain.model.LaunchItemDomainModel
import com.gizempalaslioglu.innovacase.ui.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailFragment : BaseFragment<FragmentDetailBinding>() {

    override val args: DetailFragmentArgs by navArgs()

    override fun getViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentDetailBinding {
        return FragmentDetailBinding.inflate(inflater, container, false)
    }

    override fun initUserInterface() {
        showData(args.launchItem)
    }

    private fun showData(item: LaunchItemDomainModel) {
        with (binding) {
            Glide.with(root)
                .load(item.image)
                .into(launchImage)
            launchName.text = item.name
            launchDate.isVisible = item.lastLaunchDate != null
            launchDate.text = item.lastLaunchDate
            launchDetails.isVisible = item.details != null
            launchDetails.text = item.details
            launchSuccessIcon.isVisible = item.success == true
        }
    }
}
