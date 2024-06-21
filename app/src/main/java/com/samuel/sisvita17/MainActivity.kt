package com.samuel.sisvita17

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.samuel.sisvita17.ui.theme.Sisvita17Theme
import com.samuel.sisvita17.ui.view.LogInScreen
import com.samuel.sisvita17.ui.view.user.DoTestScreen
import com.samuel.sisvita17.ui.view.user.SignUpScreen
import com.samuel.sisvita17.ui.view.user.UserMenuScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Sisvita17Theme {
                LogInScreen(navController = rememberNavController())
                Sisvita171()
            }
        }
    }
}

@Composable
fun Sisvita171() {
    val navController = rememberNavController()
    //getResponse()
    NavHost(navController = navController, startDestination = "login") {
        composable("LogIn") { LogInScreen(navController) }
        composable("Menu") { UserMenuScreen(navController) }
        composable("SignUp") { SignUpScreen(navController) }
        composable("DoTest") { DoTestScreen(navController) }
    }
}