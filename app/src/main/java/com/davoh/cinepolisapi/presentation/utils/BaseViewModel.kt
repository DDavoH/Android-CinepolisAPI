package com.davoh.cinepolisapi.presentation.utils

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

open class BaseViewModel : ViewModel() {
    
    val isLoading = MutableLiveData<Boolean>()
    
}