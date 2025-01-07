package com.gizempalaslioglu.innovacase.ui.list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gizempalaslioglu.innovacase.domain.model.LaunchItemDomainModel
import com.gizempalaslioglu.innovacase.domain.usecase.GetLaunchListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ListViewModel @Inject constructor(
    private val getLaunchListUseCase: GetLaunchListUseCase
) : ViewModel() {

    private var allLaunches: List<LaunchItemDomainModel> = emptyList()

    private val _launches: MutableStateFlow<List<LaunchItemDomainModel>> = MutableStateFlow(emptyList())
    val launches: StateFlow<List<LaunchItemDomainModel>> = _launches
        .onStart { fetchLaunches() }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.Lazily,
            initialValue = emptyList()
        )

    private val _years: MutableStateFlow<List<String>> = MutableStateFlow(emptyList())
    val years: StateFlow<List<String>> = _years.asStateFlow()

    private val _filtered: MutableStateFlow<Boolean> = MutableStateFlow(false)
    val filtered: StateFlow<Boolean> = _filtered.asStateFlow()

    private fun fetchLaunches() {
        viewModelScope.launch(
            CoroutineExceptionHandler { _, throwable ->
                onFetchError(throwable)
            }
        ) {
            val uiModel = getLaunchListUseCase()
            allLaunches = uiModel.launches
            _launches.value = allLaunches
            _years.value = uiModel.years
        }
    }

    private fun onFetchError(throwable: Throwable) {
        /* no-op */
    }

    fun filterLaunches(year: String?) {
        _filtered.value = year != null
        if (year == null) {
            _launches.value = allLaunches

            return
        }

        _launches.value = allLaunches.filter { item ->
            item.launchYear?.startsWith(year) == true
        }
    }
}
