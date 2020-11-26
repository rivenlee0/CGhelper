package com.riven.cghelper.callback.livedata


/**
 * 描述　:自定义的Boolean类型 UnPeekNotNullLiveData 做了防止数据倒灌处理 提供了默认值，避免取值的时候还要判空
 */
class BooleanLiveData(value: Boolean = false) : UnPeekNotNullLiveData<Boolean>(value)

