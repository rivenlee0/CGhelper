package com.riven.cghelper.network.manager

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import com.blankj.utilcode.util.NetworkUtils
import com.blankj.utilcode.util.ToastUtils

/**
 * 描述　: 网络变化接收器
 */
class NetworkStateReceive : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent) {
        if (intent.action == ConnectivityManager.CONNECTIVITY_ACTION) {
            if (!NetworkUtils.isAvailable()) {
                //收到没有网络时判断之前的值是不是有网络，如果有网络才提示通知 ，防止重复通知
                NetworkStateManager.instance.mNetworkStateCallback.value?.let {
                    if(it.isSuccess){
                        ToastUtils.showShort("网络不给力啊")
                        NetworkStateManager.instance.mNetworkStateCallback.postValue(NetState(isSuccess = false))
                    }
                }
            }else{
                //收到有网络时判断之前的值是不是没有网络，如果没有网络才提示通知 ，防止重复通知
                NetworkStateManager.instance.mNetworkStateCallback.value?.let {
                    if(!it.isSuccess){
                        NetworkStateManager.instance.mNetworkStateCallback.postValue(NetState(isSuccess = true))
                    }
                }
            }
        }
    }
}