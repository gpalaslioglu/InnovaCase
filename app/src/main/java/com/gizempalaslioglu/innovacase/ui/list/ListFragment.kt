package com.gizempalaslioglu.innovacase.ui.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import com.gizempalaslioglu.innovacase.R
import com.gizempalaslioglu.innovacase.databinding.FragmentListBinding
import com.gizempalaslioglu.innovacase.domain.model.LaunchItemDomainModel
import com.gizempalaslioglu.innovacase.ui.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ListFragment : BaseFragment<FragmentListBinding>() {

    private val viewModel: ListViewModel by viewModels()

    override fun getViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentListBinding {
        return FragmentListBinding.inflate(inflater, container, false)
    }

    override fun initUserInterface() {
        setObservers()
        setClickListeners()
    }

    private fun setObservers() {
        viewModel.launches.collectIn { launches ->
            setAdapter(launches)
        }

        viewModel.years.collectIn { years ->
            if (years.isNotEmpty()) {
                setAppBarMenu(years)
            }
        }

        viewModel.filtered.collectIn { filtered ->
            binding.clearFilterText.isVisible = filtered
        }
    }

    private fun setAdapter(launches: List<LaunchItemDomainModel>) {
        binding.launchesRecyclerView.adapter = LaunchesAdapter(
            items = launches,
            onItemClick = { launchItem ->
                navController.navigate(
                    ListFragmentDirections.actionListFragmentToDetailFragment(launchItem)
                )
            }
        )
    }

    private fun setAppBarMenu(years: List<String>) {
        binding.toolbar.inflateMenu(R.menu.list_menu)
        binding.toolbar.setOnMenuItemClickListener {
            when (it.itemId) {
                R.id.actionFilter -> {
                    showFilterDialog(years)
                    true
                }
                else -> false
            }
        }
    }

    private fun showFilterDialog(years: List<String>) {
        val builder = AlertDialog.Builder(requireContext())

        builder.setTitle(resources.getString(R.string.filter_title))
        builder.setItems(years.toTypedArray()) { _, position ->
            val selectedYear = years[position]
            viewModel.filterLaunches(selectedYear)
        }
        builder.show()
    }

    private fun setClickListeners() {
        binding.clearFilterText.setOnClickListener {
            viewModel.filterLaunches(null)
        }
    }
}
