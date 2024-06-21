package com.samuel.sisvita17.ui.view.user

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.samuel.sisvita17.R
import com.samuel.sisvita17.ui.theme.BackgroundColor

@Composable
fun UserMenuScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(BackgroundColor)
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        Spacer(modifier = Modifier.height(32.dp))
        Image(
            painter = painterResource(id = R.mipmap.logo_sisvita),
            contentDescription = "Logo",
            modifier = Modifier.size(288.dp)
        )
        Spacer(modifier = Modifier.height(32.dp))
        Button(
            onClick = { navController.navigate("DoTest") },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("REALIZAR TEST")
        }
        Button(
            onClick = {  },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("CONSULTAR RESULTADOS")
        }
        Button(
            onClick = {  },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("ACTUALIZAR DATOS")
        }
        Button(
            onClick = { navController.navigate("LogIn") },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Volver")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewMenu() {
    UserMenuScreen(navController = rememberNavController())
}