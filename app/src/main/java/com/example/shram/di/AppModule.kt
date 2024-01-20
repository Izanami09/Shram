package com.example.shram.di

import android.util.Log
import com.example.shram.data.NetworkShramApiImplementation
import com.example.shram.network.ShramApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideShramApiService(): ShramApiService {
        val baseURl = "http://100.101.3.162:3000/"

        //show Network information in to the logcat
        val interceptor = HttpLoggingInterceptor().apply {
            this.level = HttpLoggingInterceptor.Level.BODY
        }


        Log.d("Interceptor", interceptor.toString())

        val client = OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
            .build()

        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl(baseURl)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val retrofitService by lazy { retrofit.create(ShramApiService::class.java) }
        return retrofitService
    }

    @Provides
    @Singleton
    fun provideNetworkApiShramRepo(shramApiService: ShramApiService) : NetworkShramApiImplementation{
        return NetworkShramApiImplementation(shramApiService)
    }
}