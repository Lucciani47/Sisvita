package com.samuel.sisvita17.ui.view

import android.os.Build
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.annotation.RequiresApi
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
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.samuel.sisvita17.R
import com.samuel.sisvita17.data.model.response.TestAllPreguntas
import com.samuel.sisvita17.data.model.response.TestResponse
import com.samuel.sisvita17.navigation.AppScreen
import com.samuel.sisvita17.ui.viewmodel.RealizarTestViewModel
import com.samuel.sisvita17.data.model.request.TestRequest

@RequiresApi(Build.VERSION_CODES.O)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RealizarTest(
    id: Int,
    navController: NavController,
    realizarTestViewModel: RealizarTestViewModel = viewModel()
) {
    val testResult by realizarTestViewModel.testResult.observeAsState(null)
    val testMensaje by realizarTestViewModel.testMensaje.observeAsState("")
    val context = LocalContext.current
    val testGuardado by realizarTestViewModel.testGuardado.observeAsState(null)
    var showResultDialog by remember { mutableStateOf(false) }

    realizarTestViewModel.getTestById(id)
    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .background(color = colorResource(id = R.color.background))
    ) {
        Spacer(modifier = Modifier.height(100.dp))
        LazyColumn(contentPadding = it) {
            testResult?.data?.get(0)?.let { testData ->
                /*item {
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(16.dp),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = testData.titulo,
                            style = MaterialTheme.typography.headlineLarge
                        )
                    }
                }*/
                items(testData.preguntas) {
                    PreguntasItems(
                        preguntas = it,
                        viewModel = realizarTestViewModel,
                        modifier = Modifier
                            .fillMaxSize()
                    )
                }

                item {
                    if (testMensaje != "Respuesta Guardada") {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(16.dp),
                            horizontalArrangement = Arrangement.End
                        ) {
                            Text(text = testMensaje, color = MaterialTheme.colorScheme.error)
                        }
                    }
                    Row(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(16.dp),
                        horizontalArrangement = Arrangement.End
                    ) {
                        Button(
                            onClick = {
                                realizarTestViewModel.submitAnswers()
                            },
                            colors = ButtonDefaults.buttonColors(
                                containerColor = MaterialTheme.colorScheme.primary
                            )
                        ) {
                            Text("Finalizar test")
                        }
                    }
                }
            }
        }


        if (testGuardado != null && showResultDialog) {
            ResultDialog(
                testGuardado = testGuardado!!,
                onDismiss = {
                    showResultDialog = false
                    realizarTestViewModel.onChangeMensaje("")
                    navController.navigate(AppScreen.testHome.route)
                },
                onConfirm = {
                    showResultDialog = false
                    realizarTestViewModel.onChangeMensaje("")
                    navController.navigate(AppScreen.testHome.route)
                }
            )
        }

        if (testResult == null) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(text = "No hay test")
            }
        }
    }

    LaunchedEffect(testGuardado) {
        if (testGuardado != null) {
            showResultDialog = true
        }
    }
}

@Composable
fun SemaforoIndicator(level: String) {
    val color = when (level) {
        "Rojo" -> Color.Red
        "Amarillo" -> Color.Yellow
        "Verde" -> Color.Green
        else -> Color.Gray
    }


    Text(text = "Nivel de estres: $level", color = color, fontWeight = FontWeight.Bold)

}

@Composable
fun ResultDialog(testGuardado: TestResponse, onDismiss: () -> Unit, onConfirm: () -> Unit) {
    AlertDialog(
        onDismissRequest = onDismiss,
        title = {
            Text(text = "Resultados del Test", style = MaterialTheme.typography.headlineMedium)
        },
        text = {
            Column {
                Text(text = "Puntuación: ${testGuardado.puntuacion}", style = MaterialTheme.typography.bodyLarge)
                Spacer(modifier = Modifier.height(16.dp))
                SemaforoIndicator(level = testGuardado.semaforo ?: "Desconocido")
            }
        },
        confirmButton = {
            Button(
                onClick = {
                    onConfirm()
                    onDismiss()
                }
            ) {
                if (testGuardado.semaforo == "Amarillo" || testGuardado.semaforo == "Rojo") {
                    Text("Agendar cita")
                } else {
                    Text("Confirmar")
                }
            }
        },
        dismissButton = {
            Button(onClick = onDismiss) {
                Text("Cancelar")
            }
        }
    )
}

@Composable
fun PreguntasItems(
    preguntas: TestAllPreguntas,
    viewModel: RealizarTestViewModel,
    modifier: Modifier = Modifier,
) {
    val selectedOptionId by viewModel.selectedOptions.observeAsState()

    Column(modifier = modifier.padding(16.dp)) {
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
        }
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Preview(showBackground = true)
@Composable
fun RealizarTestPreview() {
    RealizarTest(
        id = 1, // Usa un ID de ejemplo para la vista previa
        navController = rememberNavController(),
        realizarTestViewModel = viewModel() // Simula el ViewModel
    )
}
