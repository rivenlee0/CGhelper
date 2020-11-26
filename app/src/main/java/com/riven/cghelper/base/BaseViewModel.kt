package com.riven.cghelper.base

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import com.riven.cghelper.callback.livedata.SingleLiveEvent

/**
 * FileName: BaseViewModel
 * Author: rivenLee
 * Date: 2020/11/24 8:39
 */
open class BaseViewModel : ViewModel(){

    val loadingChange: UiLoadingChange by lazy { UiLoadingChange() }

    inner class UiLoadingChange {
        //显示加载框
        val showDialog by lazy { SingleLiveEvent<String>() }
        //隐藏
        val dismissDialog by lazy { SingleLiveEvent<Void>() }
    }

}