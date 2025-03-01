package com.am.kointraining.presentation

import androidx.lifecycle.ViewModel
import com.am.kointraining.domain.MainRepository

class MainViewModel (
    private val repository: MainRepository
) : ViewModel() {

    fun doNetworkCall () {
        repository.doNetworkCall()

    }

}