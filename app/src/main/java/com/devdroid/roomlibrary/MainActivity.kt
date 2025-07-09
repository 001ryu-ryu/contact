package com.devdroid.roomlibrary

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.devdroid.roomlibrary.nav.NavApp
import com.devdroid.roomlibrary.ui.screen.HomeScreen
import com.devdroid.roomlibrary.ui.theme.RoomLibraryTheme
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            RoomLibraryTheme {

                   NavApp()
            }
        }
    }
}

