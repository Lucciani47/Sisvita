package com.samuel.sisvita17.ui.view.user

import androidx.compose.foundation.Image
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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.samuel.sisvita17.R

@Composable
fun Menu(navController: NavController) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize().padding(16.dp)
    ) {
        Spacer(modifier = Modifier.height(32.dp))

        // Logo
        Image(
            painter = painterResource(id = R.mipmap.logo_sisvita),
            contentDescription = "Logo",
            modifier = Modifier.size(120.dp),
            contentScale = ContentScale.Crop
        )

        Spacer(modifier = Modifier.height(32.dp))

        Button(
            onClick = { navController.navigate("RealizarTestScreen") },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("REALIZAR TEST")
        }

        Button(
            onClick = {
                      //navController.navigate("")
                      },
            modifier = Modifier.fillMaxWidth()

        ) {
            Text("2")
        }

        Button(
            onClick = {
                //navController.navigate("")
            },
            modifier = Modifier.fillMaxWidth()

        ) {
            Text("3")
        }

        Button(
            onClick = {
                //navController.navigate("")
            },
            modifier = Modifier.fillMaxWidth()

        ) {
            Text("4")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewMenu() {
    Menu(navController = rememberNavController())
}