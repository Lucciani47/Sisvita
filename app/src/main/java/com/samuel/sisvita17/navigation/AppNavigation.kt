package com.samuel.sisvita17.navigation
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.samuel.sisvita17.ui.view.EvaluarTest
import com.samuel.sisvita17.ui.view.Home
import com.samuel.sisvita17.ui.view.Login
import com.samuel.sisvita17.ui.view.RealizarTest
import com.samuel.sisvita17.ui.view.RegistrarEspecialista
import com.samuel.sisvita17.ui.view.RegistrarEstudiante
import com.samuel.sisvita17.ui.view.RegistrarUsuario
import com.samuel.sisvita17.ui.view.TestHome
import com.samuel.sisvita17.ui.view.Vigilancia

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun AppNavigation(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = AppScreen.login.route){

        composable(route = AppScreen.login.route){
            Login(navController)
        }
        composable(route= AppScreen.home.route){
            Home(navController)
        }
        composable(route = AppScreen.registrarUsuario.route){
            RegistrarUsuario(navController)
        }
        composable(route = AppScreen.registrarEstudiante.route){
            RegistrarEstudiante(navController)
        }
        composable(route = AppScreen.registrarEspecialista.route){
            RegistrarEspecialista(navController)
        }
        composable(route = AppScreen.testHome.route){
            TestHome(navController)
        }
        composable(
            route = AppScreen.realizarTest.route + "/{testId}",
            arguments = listOf(navArgument("testId") { type = NavType.IntType })
        ) { backStackEntry ->
            RealizarTest(backStackEntry.arguments?.getInt("testId") ?: 0, navController)
        }
        composable(AppScreen.vigilancia.route){
            Vigilancia(navController)
        }
        composable(AppScreen.evaluarTest.route){
            EvaluarTest(navController)
        }
    }

}