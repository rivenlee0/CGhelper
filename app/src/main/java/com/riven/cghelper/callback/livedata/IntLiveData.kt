package com.riven.cghelper.callback.livedata


/**
 * 描述　:自定义的Boolean类型 MutableLiveData  做了防止数据倒灌处理 提供了默认值，避免取值的时候还要判空
 */
class IntLiveData(value: Int = 0) : UnPeekNotNullLiveData<Int>(value) {

}