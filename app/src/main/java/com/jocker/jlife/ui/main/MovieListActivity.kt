package com.jocker.jlife.ui.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.databinding.DataBindingUtil
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import com.jocker.jlife.R
import com.jocker.jlife.databinding.MainActivityBinding


class MovieListActivity : AppCompatActivity() {
    private lateinit var mDrawerLayout: DrawerLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val mainActivityBinding = DataBindingUtil
                .setContentView<MainActivityBinding>(this, R.layout.main_activity)

//        设置 抽屉
        val navController = Navigation.findNavController(this, R.id.main_fragment)
        setSupportActionBar(mainActivityBinding.mainToolbar)
        mDrawerLayout = mainActivityBinding.mainDl
//        显示抽屉开关图标
        NavigationUI.setupActionBarWithNavController(this, navController, mDrawerLayout)
// 绑定 抽屉的菜单 item  。注意：fragment 中的 id 和 menu 中的 id 保持一致
        NavigationUI.setupWithNavController(mainActivityBinding.mainNavigationView, navController)

    }

    override fun onSupportNavigateUp(): Boolean {
        return NavigationUI.navigateUp(mDrawerLayout, Navigation.findNavController(this, R.id.main_fragment))
    }

    override fun onBackPressed() {
        if (mDrawerLayout.isDrawerOpen(GravityCompat.START)) {
            mDrawerLayout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }
}

