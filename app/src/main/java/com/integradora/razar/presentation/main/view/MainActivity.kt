package com.integradora.razar.presentation.main.view

import android.os.Bundle
import com.google.android.material.tabs.TabLayoutMediator
import com.integradora.razar.R
import com.integradora.razar.base.BaseActivity
import kotlinx.android.synthetic.main.main_activity.*

class MainActivity : BaseActivity() {

    private val adapter by lazy { ViewPagerAdapter(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.AppTheme)
        super.onCreate(savedInstanceState)
        pager.adapter = adapter
        val tabLayoutMediator = TabLayoutMediator(
            tab_layout,
            pager,
            TabLayoutMediator.TabConfigurationStrategy { tab, position ->
                when (position) {
                    0 -> {
                        tab.setIcon(R.drawable.ic_home_white)
                    }
                    1 -> {
                        tab.setIcon(R.drawable.ic_list)
                    }
                    2 -> {
                        tab.setIcon(R.drawable.ic_favorite)
                    }
                    3 -> {
                        tab.setIcon(R.drawable.ic_settings)
                    }
                }
            })
        tabLayoutMediator.attach()
    }

    override fun getLayout(): Int {
        return R.layout.main_activity
    }


}