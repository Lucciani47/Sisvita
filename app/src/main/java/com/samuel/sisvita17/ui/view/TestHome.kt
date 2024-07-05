package com.samuel.sisvita17.ui.view

import android.annotation.SuppressLint
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.samuel.sisvita17.utils.DateUtils
import com.samuel.sisvita17.R
import com.samuel.sisvita17.data.model.response.TestListData
import com.samuel.sisvita17.navigation.AppScreen
import com.samuel.sisvita17.ui.viewmodel.TestHomeViewModel

@RequiresApi(Build.VERSION_CODES.O)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TestHome(navController: NavController, testHomeViewModel: TestHomeViewModel = viewModel()) {
    val testResult by testHomeViewModel.testResult.observeAsState()
    testHomeViewModel.getTests()
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .background(color = colorResource(id = R.color.background))
            .padding(16.dp)
    ) {
        Image(
            painter = painterResource(id = R.mipmap.logo_sisvita),
            contentDescription = "Logo",
            modifier = Modifier.size(256.dp)
        )
        Spacer(modifier = Modifier.height(8.dp))
        LazyColumn(
            //contentPadding = it
            modifier = Modifier.background(color = colorResource(id = R.color.background))
        ) {
            testResult?.let { it1 ->
                items(it1.data) {
                    TestItem(
                        test = it,
                        modifier = Modifier.padding(16.dp),
                        navController = navController
                    )
                }
            }
        }
        if (testResult == null) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(color = colorResource(id = R.color.background))
                    .padding(16.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(text = "No hay test")
            }
        }
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun TestItem(
    test: TestListData,
    modifier: Modifier = Modifier,
    navController: NavController
) {
    var expanded by remember { mutableStateOf(false) }
    Column(modifier = modifier.padding(16.dp)) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.secondary,
            )
        ) {
            Text(
                text = test.titulo,
                style = MaterialTheme.typography.bodyMedium,
            )
            Column(
                modifier = Modifier
                    .background(MaterialTheme.colorScheme.primary)
                    .padding(16.dp)
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.Start
            ) {
                Text(
                    text = "Descripcion: " + test.descripcion
                            + "\nFecha : " + DateUtils.formatDateTime(test.fecha_creacion),
                    style = MaterialTheme.typography.labelMedium
                )
                Button(onClick = {  navController.navigate("realizarTest/"+test.prueba_id.toString())},
                    modifier = Modifier
                        .fillMaxWidth(),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = MaterialTheme.colorScheme.secondary
                    )) {
                    Text("Iniciar Test")
                }
            }
        }/*
        Text(text = preguntas.textopregunta, style = MaterialTheme.typography.bodyMedium)
        preguntas.opciones.forEach { opcion ->
            Row(verticalAlignment = Alignment.CenterVertically) {
                RadioButton(
                    selected = opcion.opcion_id == selectedOptionId?.get(preguntas.pregunta_id),
                    onClick = { viewModel.selectOption(preguntas.pregunta_id, opcion.opcion_id) },
                )
                Text(
                    text = opcion.nombre,
                    modifier = Modifier.padding(start = 8.dp)
                )
            }
        }*/
    }/*
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.secondary,
        )
    ) {
        Text(
            text = test.titulo,
            style = MaterialTheme.typography.bodyMedium,
        )
        Column(
            modifier = Modifier.padding(
                start = 16.dp,
                top = 8.dp,
                bottom = 16.dp,
                end = 8.dp
            )
        ) {

            Text(
                text = "Descripcion: " + test.descripcion
                        + "\nFecha : " + DateUtils.formatDateTime(test.fecha_creacion),
                style = MaterialTheme.typography.labelMedium
            )
        }
    }*/

    /*
    Card(
        modifier = modifier,
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.primary,
        )
    ) {
        Column(
            modifier = Modifier
                .animateContentSize(
                    animationSpec = spring(
                        dampingRatio = Spring.DampingRatioNoBouncy,
                        stiffness = Spring.StiffnessMedium
                    )
                )
        ) {
            Row(

                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = test.titulo,
                    style = MaterialTheme.typography.bodyMedium,
                )
                Spacer(Modifier.weight(1f))
                IconButton(
                    onClick = { expanded = !expanded },
                ) {
                    Icon(
                        imageVector = if (expanded) Icons.Filled.KeyboardArrowDown else Icons.Filled.KeyboardArrowUp,
                        contentDescription = "",
                        tint = Color(255, 255, 255)
                    )
                }

            }
            if (expanded) {
                Column(
                    modifier = Modifier.padding(
                        start = 16.dp,
                        top = 8.dp,
                        bottom = 16.dp,
                        end = 8.dp
                    )
                ) {

                    Text(
                        text = "Descripcion: " + test.descripcion
                                + "\nFecha : " + DateUtils.formatDateTime(test.fecha_creacion),
                        style = MaterialTheme.typography.labelMedium
                    )
                }

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    horizontalArrangement = Arrangement.End
                ) {
                    Button(onClick = {  navController.navigate("realizarTest/"+test.prueba_id.toString())},
                        modifier = Modifier
                            .fillMaxWidth(),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = MaterialTheme.colorScheme.secondary
                        )) {
                        Text("Iniciar Test")
                    }
                }
            }
        }
    }*/

}