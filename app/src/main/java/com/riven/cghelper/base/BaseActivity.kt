package com.riven.cghelper.base

import android.content.res.Resources
import android.os.Bundle
import androidx.databinding.ViewDataBinding
import com.riven.cghelper.ui.ProgressDialog
import me.jessyan.autosize.AutoSizeCompat


/**
 * FileName: BaseActivity
 * Author: rivenLee
 * Date: 2020/11/24 15:36
 */
abstract class BaseActivity<VM: BaseViewModel, DB: ViewDataBinding> : BaseVmDbActivity<VM, DB>(){

    private var dialog: ProgressDialog? = null

    abstract override fun layoutId(): Int

    abstract override fun initView(savedInstanceState: Bundle?)

    override fun createObserver() {}

    override fun showLoading(message: String) {
        if (dialog == null) {
            dialog = ProgressDialog(this)
        }
        dialog?.setContext(message)
        dialog?.let {
            if (it.isShowing) it.show()
        }
    }

    override fun dismissLoading() {
        if (dialog?.isShowing == true) {
            dialog?.dismiss()
        }
    }

    override fun getResources(): Resources {
        AutoSizeCompat.autoConvertDensityOfGlobal(super.getResources())
        return super.getResources()
    }
}