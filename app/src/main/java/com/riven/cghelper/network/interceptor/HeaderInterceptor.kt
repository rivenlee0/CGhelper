package com.riven.cghelper.network.interceptor

import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject
import javax.inject.Singleton

/**
 * FileName: HeadInterceptor
 * Author: rivenLee
 * Date: 2020/11/24 13:23
 */
class HeaderInterceptor : Interceptor {

    @Throws()
    override fun intercept(chain: Interceptor.Chain): Response {
        val builder = chain.request().newBuilder()
        builder.addHeader("token", "token123456").build()
        builder.addHeader("device", "Android").build()
        return chain.proceed(builder.build())
    }
}