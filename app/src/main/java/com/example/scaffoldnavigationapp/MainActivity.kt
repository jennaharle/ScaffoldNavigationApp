package com.example.scaffoldnavigationapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.scaffoldnavigationapp.ui.theme.ScaffoldNavigationAppTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Settings

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ScaffoldNavigationAppTheme {
                ScaffoldApp()
            }
        }
    }
}

@Composable
fun ScaffoldApp() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "main") {
        composable("main") { MainScreen(navController) }
        composable("info") { InfoScreen(navController) }
        composable("settings") { SettingsScreen(navController) }
    }
}

@Composable
fun MainTopBar(navController: NavHostController) {
    TopAppBar(
        title = { Text(text = "Main Screen") },
        actions = {
            IconButton(onClick = { navController.navigate("info") }) {
                Icon(Icons.Default.Info, contentDescription = "Info")
            }
            IconButton(onClick = { navController.navigate("settings") }) {
                Icon(Icons.Default.Settings, contentDescription = "Settings")
            }
        }
    )
}

@Composable
fun ScreenTopBar(title: String, navController: NavHostController) {
    TopAppBar(
        title = { Text(text = title) },
        navigationIcon = {
            IconButton(onClick = { navController.popBackStack() }) {
                Icon(Icons.Default.ArrowBack, contentDescription = "Back")
            }
        }
    )
}

@Composable
fun MainScreen(navController: NavHostController) {
    Scaffold(
        topBar = { MainTopBar(navController) }
    ) {
        Text("This is the Main Screen")
    }
}

@Composable
fun InfoScreen(navController: NavHostController) {
    Scaffold(
        topBar = { ScreenTopBar("Info Screen", navController) }
    ) {
        Text("This is the Info Screen")
    }
}

@Composable
fun SettingsScreen(navController: NavHostController) {
    Scaffold(
        topBar = { ScreenTopBar("Settings Screen", navController) }
    ) {
        Text("This is the Settings Screen")
    }
}