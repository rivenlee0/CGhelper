package com.riven.cghelper.ui.main.fragment

import androidx.hilt.lifecycle.ViewModelInject
import com.riven.cghelper.base.BaseViewModel
import com.riven.cghelper.repository.ProfessionalRepository

class ProfessionalViewModel @ViewModelInject constructor(
    private val repository: ProfessionalRepository
) : BaseViewModel() {

}