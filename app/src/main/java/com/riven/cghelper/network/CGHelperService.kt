package com.riven.cghelper.network

import com.riven.cghelper.model.ApiResponse
import com.riven.cghelper.model.UserInfo
import retrofit2.http.*

/**
 * FileName: CGHelperService
 * Author: rivenLee
 * Date: 2020/11/24 14:12
 */
interface CGHelperService {

    companion object {
        const val SERVER_URL = "https://wanandroid.com/"
    }

    /**
     * 注册
     */
    @FormUrlEncoded
    @POST("user/register")
    suspend fun register(@Field("username") username: String, @Field("password") pwd: String, @Field("repassword") rpwd: String): ApiResponse<Nothing>

    /**
     * 登录
     */
    @FormUrlEncoded
    @POST("user/login")
    suspend fun login(@Field("username") username: String, @Field("password") pwd: String): ApiResponse<UserInfo>

}