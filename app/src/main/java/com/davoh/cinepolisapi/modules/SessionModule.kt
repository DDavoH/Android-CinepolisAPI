package com.davoh.cinepolisapi.modules

import com.davoh.cinepolisapi.data.SessionData
import com.davoh.cinepolisapi.framework.sharedPreferences.SessionPreferences
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
class SessionModule {
    
    @Provides
    fun providesSessionEntity(sessionPreferences: SessionPreferences): SessionData {
        return sessionPreferences.getSession()
    }
}