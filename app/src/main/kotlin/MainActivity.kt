package com.phanupan.greenmoons_test

import android.os.Bundle
import androidx.annotation.IdRes
import androidx.annotation.NavigationRes
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import com.phanupan.greenmoons.test.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        navigationSetGraph(
            navHostId = R.id.container,
            navigationGraph = navigation.R.navigation.navigation_movie,
            startDestId = navigation.R.id.movieFragment,
            bundle = null
        )
    }


    private fun navigationSetGraph(
        @IdRes navHostId: Int,
        @NavigationRes navigationGraph: Int,
        startDestId: Int,
        bundle: Bundle? = null,
    ) {
        val navHostFragment = supportFragmentManager.findFragmentById(navHostId) as NavHostFragment
        val inflater = navHostFragment.navController.navInflater
        val graph = inflater.inflate(navigationGraph)
        graph.setStartDestination(startDestId)
        val navController = navHostFragment.navController
        navController.setGraph(graph, bundle)
    }


}