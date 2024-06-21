package com.samuel.sisvita17

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.samuel.sisvita17.ui.theme.Sisvita17Theme
//import com.samuel.sisvita17.network.getResponse

import com.samuel.sisvita17.ui.view.LoginScreen
import com.samuel.sisvita17.ui.view.user.Menu
import com.samuel.sisvita17.ui.view.user.SignUpScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Sisvita17Theme {
                LoginScreen(navController = rememberNavController())
                SisvitaApp()
            }
        }
    }
}

@Composable
fun SisvitaApp(){
    val navController = rememberNavController()
    //getResponse()
    NavHost(navController = navController, startDestination = "login") {
        composable("login") { LoginScreen(navController) }
        composable("menu") { Menu(navController) }
        composable("SignUp") { SignUpScreen(navController) }
    }
}