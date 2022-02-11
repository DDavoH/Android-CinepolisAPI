package com.davoh.cinepolisapi.presentation.profile

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.davoh.cinepolisapi.framework.retrofit.responses.ProfileResponse
import com.davoh.cinepolisapi.presentation.utils.BaseViewModel
import com.davoh.cinepolisapi.repository.ProfileRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject


@HiltViewModel
class ProfileViewModel @Inject constructor(private val profileRepository: ProfileRepository) : BaseViewModel() {
    
    val profileData = MutableLiveData<ProfileResponse>()

    fun getProfile() {
        profileRepository.getProfile()
            .doOnSubscribe { isLoading.postValue(true) }
            .subscribe({
            profileData.postValue(it)
                isLoading.postValue(false)
        },{
                isLoading.postValue(false)
        })
    }
    
}