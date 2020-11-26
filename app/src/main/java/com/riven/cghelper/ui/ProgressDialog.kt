package com.riven.cghelper.ui

import android.app.Dialog
import android.content.Context
import android.view.View
import com.riven.cghelper.R
import kotlinx.android.synthetic.main.dialog_progress.*

class ProgressDialog(mContext: Context, text: String? = null) :
    Dialog(mContext, R.style.dialog_progress) {
    init {
        setContentView(R.layout.dialog_progress)
        setCanceledOnTouchOutside(false)
        text?.let { txt_load.text = it }
    }

    fun setContext(text: String?){
        text?.let {
            txt_load.text = it
            txt_load.visibility = View.VISIBLE
        }
    }
}