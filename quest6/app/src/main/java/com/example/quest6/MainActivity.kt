package com.example.quest6

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.*
import com.example.quest6.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    //appbar설치
    private lateinit var appbarc: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val nhf = supportFragmentManager.findFragmentById(R.id.fragment) as NavHostFragment

       // appbarc = AppBarConfiguration(nhf.navController.graph)

        val topDest = setOf(R.id.homeFragment, R.id.page1Fragment, R.id.page2Fragment)
        appbarc = AppBarConfiguration(topDest, binding.drawerLayout)
        setupActionBarWithNavController(nhf.navController, appbarc)
        // binding.navigationView.setupWithNavController(nhf.navController)
        binding.navigationView.setNavigationItemSelectedListener {
            binding.drawerLayout.close()
            when (it.itemId)
            {
                R.id.callAction -> {
                    startActivity(Intent().setAction(Intent.ACTION_DIAL))
                    true
                }
                else -> {
                    it.onNavDestinationSelected(nhf.navController)
                }
            }
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        return findNavController(R.id.fragment).navigateUp(appbarc) || super.onSupportNavigateUp()
    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        //메뉴 등록! 메뉴.xml에 있는 것을 등록한다.
        menuInflater.inflate(R.menu.nav_menu, menu)
        return true
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // 메뉴의 있는 것들을 사용하기 위함
        when(item.itemId){
            //프레그먼트로 이동
            R.id.homeFragment -> item.onNavDestinationSelected(findNavController(R.id.fragment))
            R.id.page1Fragment -> item.onNavDestinationSelected(findNavController(R.id.fragment))
            R.id.page2Fragment -> item.onNavDestinationSelected(findNavController(R.id.fragment))
            else -> return super.onOptionsItemSelected(item)
        }
        return true
    }
}