package me.hgj.jetpackmvvm.callback.livedata.event

import com.riven.cghelper.callback.livedata.event.Event
import com.riven.cghelper.callback.livedata.event.EventBaseLiveData

class EventLiveData<T> : EventBaseLiveData<T> {
    /**
     * Creates a MutableLiveData initialized with the given `value`.
     *
     * @param value initial value
     */
    constructor(value: Event<T>?) : super(value!!) {}

    /**
     * Creates a MutableLiveData with no value assigned to it.
     */
    constructor() : super() {}

    public override fun postValue(value: Event<T>) {
        super.postValue(value)
    }

    fun postValue(value: T) {
        super.postValue(Event(value))
    }

    public override fun setValue(value: Event<T>) {
        super.setValue(value)
    }

    fun setValue(value: T) {
        super.postValue(Event(value))
    }
}