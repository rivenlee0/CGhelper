package com.riven.cghelper.repository

import com.riven.cghelper.network.CGHelperService
import javax.inject.Inject

/**
 * FileName: MainRepository
 * Author: rivenLee
 * Date: 2020/11/24 14:39
 */
class MainRepository @Inject constructor(private val service: CGHelperService) : Repository {
    suspend fun register() = service.register("rivenlee", "aa123456", "aa123456")
}