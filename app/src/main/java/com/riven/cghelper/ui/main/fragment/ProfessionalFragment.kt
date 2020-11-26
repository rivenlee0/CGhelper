package com.riven.cghelper.ui.main.fragment

import android.os.Bundle
import androidx.fragment.app.viewModels
import com.riven.cghelper.R
import com.riven.cghelper.base.BaseFragment
import com.riven.cghelper.databinding.ProfessionalFragmentBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ProfessionalFragment : BaseFragment<ProfessionalViewModel, ProfessionalFragmentBinding>() {

    private val viewModel: ProfessionalViewModel by viewModels()

    companion object {
        fun newInstance() = ProfessionalFragment()
    }

    override fun layoutId(): Int = R.layout.professional_fragment

    override fun initView(savedInstanceState: Bundle?) {

    }

}