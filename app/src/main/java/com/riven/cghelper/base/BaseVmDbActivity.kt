package com.riven.cghelper.base

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding

/**
 * FileName: BaseVmDbActivity
 * Author: rivenLee
 * Date: 2020/11/25 10:04
 */
abstract class BaseVmDbActivity <VM: BaseViewModel, DB: ViewDataBinding>: BaseVmActivity<VM>(){

    lateinit var mDataBinding: DB

    override fun onCreate(savedInstanceState: Bundle?) {
        userDataBinding(true)
        super.onCreate(savedInstanceState)
    }

    override fun initDataBind() {
        mDataBinding = DataBindingUtil.setContentView(this, layoutId())
        mDataBinding.lifecycleOwner = this
    }
}