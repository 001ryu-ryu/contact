package com.devdroid.roomlibrary.nav

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.devdroid.roomlibrary.ui.screen.AddContact
import com.devdroid.roomlibrary.ui.screen.HomeScreen

@Composable
fun NavApp(){

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "home"
    ){
        composable<Routes.Home>{
            HomeScreen(navController = navController)
        }
        composable<Routes.AddContact>{
            AddContact(navController = navController)
        }

    }

}