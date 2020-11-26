package com.riven.cghelper.base

import android.app.Activity
import android.content.Context
import android.os.Bundle
import androidx.databinding.ViewDataBinding
import com.blankj.utilcode.util.KeyboardUtils
import com.riven.cghelper.ui.ProgressDialog

/**
 * FileName: BaseFragment
 * Author: rivenLee
 * Date: 2020/11/25 15:12
 */
abstract class BaseFragment<VM : BaseViewModel, DB : ViewDataBinding> : BaseVmDbFragment<VM, DB>() {

    private var dialog: ProgressDialog? = null
    private lateinit var activity: Activity

    override fun onAttach(context: Context) {
        super.onAttach(context)
        activity = context as Activity
    }
    /**
     * 当前Fragment绑定的视图布局
     */
    abstract override fun layoutId(): Int


    abstract override fun initView(savedInstanceState: Bundle?)

    /**
     * 懒加载 只有当前fragment视图显示时才会触发该方法
     */
    override fun lazyLoadData() {}

    /**
     * 创建LiveData观察者 Fragment执行onViewCreated后触发
     */
    override fun createObserver() {}


    /**
     * Fragment执行onViewCreated后触发
     */
    override fun initData() {

    }

    /**
     * 打开等待框
     */
    override fun showLoading(message: String) {
        if (dialog == null) {
            dialog = ProgressDialog(activity)
        }
        dialog?.setContext(message)
        dialog?.let {
            if (!it.isShowing) it.show()
        }
    }

    /**
     * 关闭等待框
     */
    override fun dismissLoading() {
        if (dialog?.isShowing == true) {
            dialog?.dismiss()
        }
    }

    override fun onPause() {
        super.onPause()
        KeyboardUtils.hideSoftInput(activity)
    }
}