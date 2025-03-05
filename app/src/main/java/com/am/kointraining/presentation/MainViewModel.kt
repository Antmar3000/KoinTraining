package com.am.kointraining.presentation

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.am.kointraining.data.entity.RemoteEntity
import com.am.kointraining.domain.MainRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class MainViewModel (
    private val repository: MainRepository
) : ViewModel() {

    val dummyEntity : RemoteEntity = RemoteEntity(1, "", 0.0)

    val entityState = mutableStateOf(dummyEntity)

    private val _ktorProducts : MutableStateFlow<RemoteEntity> = MutableStateFlow(dummyEntity)
    val ktorProducts : StateFlow<RemoteEntity> = _ktorProducts

    fun doNetworkCall () {
        viewModelScope.launch {
            entityState.value = repository.doNetworkCall()
        }
    }

    fun doKtorCall () {
        viewModelScope.launch {
            repository.doKtorCall().fold(
                onSuccess = {products ->
                    _ktorProducts.update { products }
                }, onFailure = {}
            )
        }
        Log.d("myLog", "VMKtorCall")
    }

}