package com.samuel.sisvita17.ui.view

import android.annotation.SuppressLint
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.samuel.sisvita17.R
import com.samuel.sisvita17.navigation.AppScreen
import com.samuel.sisvita17.ui.viewmodel.LoginViewModel
import com.samuel.sisvita17.utils.UserManager
import compose.icons.AllIcons
import compose.icons.FontAwesomeIcons
import compose.icons.fontawesomeicons.Solid
import compose.icons.fontawesomeicons.solid.WindowClose

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Home(navController: NavController) {
    var showLogoutDialog by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = colorResource(id = R.color.background))
            .padding(1.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        InformationCard()
        Spacer(modifier = Modifier.height(20.dp))
        Image(
            painter = painterResource(id = R.mipmap.logo_sisvita),
            contentDescription = "Profile Icon",
            modifier = Modifier.size(256.dp)
        )
        Spacer(modifier = Modifier.height(20.dp))
        if (UserManager.getRol() == "Usuario") {
            Button(onClick = { navController.navigate(AppScreen.testHome.route) },
                modifier = Modifier.fillMaxWidth(),) {
                Text("Realizar Test")
            }
            Button(onClick = {/* TODO: Handle click */ },modifier = Modifier.fillMaxWidth()) {
                Text("Consultar Resultado")
            }
            Button(onClick = {/* TODO: Handle click */ },modifier = Modifier.fillMaxWidth()) {
                Text("Eliminar Usuario")
            }
            Button(onClick = { /* TODO: Handle click */ },modifier = Modifier.fillMaxWidth()) {
                Text("Actualizar datos")
            }
            Button(onClick = { UserManager.clearUser()
                navController.navigate(AppScreen.login.route) {
                    popUpTo(navController.graph.startDestinationId) {
                        inclusive = true
                    }
                } },
                modifier = Modifier.fillMaxWidth()) {
                Text("Cerrar sesión")
            }
        } else if (UserManager.getRol() == "Especialista") {
            Button(onClick = { },
                modifier = Modifier.fillMaxWidth()) {
                Text("Mapa De Calor")
            }
            Button(onClick = {},
                modifier = Modifier.fillMaxWidth()) {
                Text("Realizar Vigilancia")
            }
            Button(onClick = { UserManager.clearUser()
                navController.navigate(AppScreen.login.route) {
                    popUpTo(navController.graph.startDestinationId) {
                        inclusive = true
                    }
                } },
                modifier = Modifier.fillMaxWidth()) {
                Text("Cerrar sesión")
            }
        }
    }
}

@Composable
fun InformationCard(loginViewModel: LoginViewModel = viewModel()) {
    val email: String by loginViewModel.correo.observeAsState("")
    val user = UserManager.getUser()
    if (user != null) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.secondary,
            )
        ) {
            Text(
                text = "Bienvenido " + user.nombre + " "+ user.apellidos,
                color = Color.White,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
            )

            /*Column(
                modifier = Modifier
                    .background(MaterialTheme.colorScheme.secondary)
                    .padding(16.dp)
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.Start
            ) {
                Text(
                    text = user.nombre + " "+ user.apellidos,
                    color = Color.White
                )
            }*/
        }
    }
}