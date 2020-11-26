package com.riven.cghelper.ui.main

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.riven.cghelper.base.BaseViewModel
import com.riven.cghelper.ext.request
import com.riven.cghelper.repository.MainRepository
import com.riven.cghelper.state.ResultState
import com.riven.cghelper.state.paresException
import com.riven.cghelper.state.paresResult
import kotlinx.coroutines.launch

/**
 * FileName: MainViewModel
 * Author: rivenLee
 * Date: 2020/11/24 14:34
 */
class MainViewModel @ViewModelInject constructor(
    private val mainRepository: MainRepository
) : BaseViewModel(){

    var loginResult = MutableLiveData<ResultState<Nothing>>()

    fun getData(){
//        loadingChange.showDialog.call()
//        viewModelScope.launch {
//            runCatching {
//                loginResult.value = ResultState.onAppLoading("注册中....")
//                mainRepository.register()
//            }.onSuccess {
//                loadingChange.dismissDialog.call()
//                loginResult.paresResult(it)
//            }.onFailure {
//                loadingChange.dismissDialog.call()
//                loginResult.paresException(it)
//            }
//        }

        request({ mainRepository.register() }, loginResult, true, "注册中。。。。")
    }
}