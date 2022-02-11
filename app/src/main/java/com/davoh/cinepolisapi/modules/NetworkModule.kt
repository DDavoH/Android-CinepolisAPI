package com.davoh.cinepolisapi.modules

import com.davoh.cinepolisapi.framework.retrofit.ApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {
    
    @Provides
    fun providesApiService( client : OkHttpClient): ApiService {
        return Retrofit.Builder()
            .baseUrl("https://stage-api.cinepolis.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .client(client)
            .build()
            .create(ApiService::class.java)
    }
    
    @Provides
    fun provideUnsafeOkHttpClient(): OkHttpClient {
        return provideUnsafeOkHttpClientTimeOut(550000L)
    }
    
    private fun provideUnsafeOkHttpClientTimeOut(milliseconds: Long?): OkHttpClient {
        return try {
            val builder = OkHttpClient.Builder()
            val interceptor = HttpLoggingInterceptor()
            interceptor.level = HttpLoggingInterceptor.Level.BODY
            builder.addInterceptor(interceptor)
            builder
                .callTimeout(milliseconds!!, TimeUnit.MILLISECONDS)
                .connectTimeout(milliseconds, TimeUnit.MILLISECONDS)
                .readTimeout(milliseconds, TimeUnit.MILLISECONDS)
                .writeTimeout(milliseconds, TimeUnit.MILLISECONDS)
                .build()
        } catch (e: Exception) {
            throw RuntimeException(e)
        }
    }
    
    
    
    
}