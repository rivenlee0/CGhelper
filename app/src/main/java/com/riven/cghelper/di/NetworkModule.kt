package com.riven.cghelper.di

import com.google.gson.GsonBuilder
import com.riven.cghelper.APPContext
import com.riven.cghelper.network.CGHelperService
import com.riven.cghelper.network.interceptor.CacheInterceptor
import com.riven.cghelper.network.interceptor.HeaderInterceptor
import com.riven.cghelper.network.interceptor.LogInterceptor
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Cache
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.File
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

/**
 * FileName: NetworkModule
 * Author: rivenLee
 * Date: 2020/11/24 13:11
 */
@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .cache(Cache((File(APPContext.cacheDir, "CGHelper_cache")), 10 * 1024 * 1024))
            .addInterceptor(HeaderInterceptor())
            .addInterceptor(CacheInterceptor())
            .addInterceptor(LogInterceptor())
            .connectTimeout(15, TimeUnit.SECONDS)
            .readTimeout(10, TimeUnit.SECONDS)
            .writeTimeout(10, TimeUnit.SECONDS)
            .build()
    }

    @Provides
    @Singleton
    fun providerRetrofit(okHttpClient: OkHttpClient): Retrofit {
        return  Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl(CGHelperService.SERVER_URL)
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            .build()
    }

    @Provides
    @Singleton
    fun providerCGHelperService(retrofit: Retrofit): CGHelperService {
        return retrofit.create(CGHelperService::class.java)
    }


}