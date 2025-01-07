package com.gizempalaslioglu.innovacase.ui.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.NavArgs
import androidx.navigation.fragment.findNavController
import androidx.viewbinding.ViewBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

abstract class BaseFragment<B : ViewBinding> : Fragment() {

    protected lateinit var binding: B

    protected open val args: NavArgs? = null

    protected val navController by lazy {
        findNavController()
    }

    protected abstract fun getViewBinding(inflater: LayoutInflater, container: ViewGroup?): B

    protected abstract fun initUserInterface()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = getViewBinding(inflater, container)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initUserInterface()
    }

    protected fun <T> Flow<T>.collectIn(
        owner: LifecycleOwner = viewLifecycleOwner,
        lifecycleState: Lifecycle.State = Lifecycle.State.STARTED,
        action: suspend CoroutineScope.(T) -> Unit
    ) {
        owner.lifecycleScope.launch {
            owner.repeatOnLifecycle(lifecycleState) {
                collect { action(it) }
            }
        }
    }
}
