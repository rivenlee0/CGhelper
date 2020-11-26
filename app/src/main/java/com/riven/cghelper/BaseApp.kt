package com.riven.cghelper

import android.app.Application
import android.content.ContextWrapper
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStore
import androidx.lifecycle.ViewModelStoreOwner

/**
 * FileName: BaseApp
 * Author: rivenLee
 * Date: 2020/11/24 9:47
 */

private lateinit var INSTANCE: Application
object APPContext: ContextWrapper(INSTANCE)

open class BaseApp : Application(), ViewModelStoreOwner{

    private lateinit var mAppViewModelStore: ViewModelStore
    private var mFactory: ViewModelProvider.Factory? = null

    override fun onCreate() {
        super.onCreate()
        INSTANCE = this
        mAppViewModelStore = ViewModelStore()
    }
    override fun getViewModelStore(): ViewModelStore = mAppViewModelStore

    /**
     * 获取一个全局的ViewModel
     */
    fun getAppViewModelProvider(): ViewModelProvider {
        return ViewModelProvider(this, this.getAppFactory())
    }

    private fun getAppFactory(): ViewModelProvider.Factory {
        if (mFactory == null) {
            mFactory = ViewModelProvider.AndroidViewModelFactory.getInstance(this)
        }
        return mFactory as ViewModelProvider.Factory
    }
}