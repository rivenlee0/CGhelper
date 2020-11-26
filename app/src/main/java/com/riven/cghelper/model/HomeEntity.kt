package com.riven.cghelper.model

import androidx.fragment.app.Fragment


data class HomeEntity(
    val title: String = "",
    val fragment: Fragment? = null,
    val selectImageResource: Int = 0,
    val unSelectImageResource: Int = 0,
)