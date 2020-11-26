package com.riven.cghelper.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.blankj.utilcode.util.ToastUtils
import com.google.android.material.tabs.TabLayoutMediator
import com.riven.cghelper.R
import com.riven.cghelper.base.BaseActivity
import com.riven.cghelper.databinding.ActivityMainBinding
import com.riven.cghelper.model.HomeEntity
import com.riven.cghelper.state.ResultState
import com.riven.cghelper.ui.main.fragment.ProfessionalFragment
import com.riven.cghelper.ui.main.home.HomeFragment
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.app_bar_main.*
import kotlinx.android.synthetic.main.include_toolbar.*
import kotlinx.android.synthetic.main.item_tab.view.*

@AndroidEntryPoint
class MainActivity : BaseActivity<MainViewModel, ActivityMainBinding>() {

    private val mainViewModel: MainViewModel by viewModels()
    override fun layoutId(): Int = R.layout.activity_main
    val homeItemData = arrayListOf<HomeEntity>().apply {
        add(HomeEntity(title = "职业", fragment = ProfessionalFragment.newInstance()))
        add(HomeEntity(title = "任务", fragment = HomeFragment.newInstance()))
        add(HomeEntity(title = "活动", fragment = HomeFragment.newInstance()))
        add(HomeEntity(title = "采集", fragment = HomeFragment.newInstance()))
        add(HomeEntity(title = "宠物", fragment = HomeFragment.newInstance()))
        add(HomeEntity(title = "职业", fragment = HomeFragment.newInstance()))
        add(HomeEntity(title = "首饰", fragment = HomeFragment.newInstance()))
        add(HomeEntity(title = "巧取", fragment = HomeFragment.newInstance()))
        add(HomeEntity(title = "模拟", fragment = HomeFragment.newInstance()))
        add(HomeEntity(title = "魔物", fragment = HomeFragment.newInstance()))
        add(HomeEntity(title = "地图", fragment = HomeFragment.newInstance()))
    }

    override fun initView(savedInstanceState: Bundle?) {
        toolbar.title = "魔力宝贝怀旧攻略"
        setSupportActionBar(toolbar)
        val actionBarDrawerToggle = ActionBarDrawerToggle(this, drawer_layout, toolbar,R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        actionBarDrawerToggle.syncState()
        fab.setOnClickListener {
            toolbar.title = "魔力宝贝怀旧攻略"
            mainViewModel.getData()
        }

        view_pager.adapter = object : FragmentStateAdapter(this){
            override fun getItemCount(): Int = homeItemData.size

            override fun createFragment(position: Int): Fragment {
                return homeItemData[position].fragment!!
            }
        }
        TabLayoutMediator(tab_layout, view_pager, true){ tab, position ->
            tab.customView = getTabView(position)
        }.attach()
    }

    private fun getTabView(position: Int): View {
        return LayoutInflater.from(this).inflate(R.layout.item_tab, null).apply {
            tv_tab.text = homeItemData[position].title
        }
    }

    override fun createObserver() {
        mainViewModel.loginResult.observe(this, Observer {
            when (it) {
                is ResultState.Loading -> {
                    ToastUtils.showLong("onLoading --> ${it.loadingMessage}")
                }
                is ResultState.Success -> {
                    ToastUtils.showLong("onSuccess")
                }
                is ResultState.Error -> {
                    ToastUtils.showLong("onFailed --> ${it.error.errorMsg}")
                }
            }
        })
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.host, menu)
        return true
    }

}