package com.davoh.cinepolisapi.presentation.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.davoh.cinepolisapi.presentation.utils.BaseViewModel
import com.davoh.cinepolisapi.repository.LoginRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(private val loginRepository: LoginRepository) : BaseViewModel() {
    
    private val _loginSuccess = MutableLiveData<Boolean>()
    val loginSuccess : LiveData<Boolean> = _loginSuccess
    
    fun login(userName:String, password:String){
        loginRepository.login(userName, password)
            .doOnSubscribe { isLoading.postValue(true) }
            .subscribe({ response->
            _loginSuccess.postValue(true)
                isLoading.postValue(false)
        },{error->
            _loginSuccess.postValue(false)
                isLoading.postValue(false)
        })
    }
    
}