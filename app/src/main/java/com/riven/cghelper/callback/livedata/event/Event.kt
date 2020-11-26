package com.riven.cghelper.callback.livedata.event

/**
 * 配合 MutableLiveData & EventViewModel 的使用
 */
class Event<T>(private val content: T) {
    private var hasHandled = false
    fun getContent(): T? {
        if (hasHandled) {
            return null
        }
        hasHandled = true
        return content
    }

}