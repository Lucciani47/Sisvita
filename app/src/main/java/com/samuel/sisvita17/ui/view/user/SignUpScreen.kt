package com.samuel.sisvita17.ui.view.user

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.samuel.sisvita17.R

@Composable
fun SignUpScreen(navController: NavController) {
    val viewModel: RegisterViewModel = viewModel()
    val userInput = viewModel.userInput.value
    val passwordInput = viewModel.passwordInput.value

    var expanded1 by remember{ mutableStateOf(true) }
    var expanded2 by remember{ mutableStateOf(false) }
    var expanded3 by remember{ mutableStateOf(false) }
    var expanded4 by remember{ mutableStateOf(false) }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF114B5F))
    )
    Column(
        modifier = Modifier
            .statusBarsPadding()
            .verticalScroll(rememberScrollState())
            .safeDrawingPadding()
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    Color(0xFFFFFFFF), shape = RoundedCornerShape(
                        topStartPercent = 0,
                        topEndPercent = 0,
                        bottomStartPercent = 0,
                        bottomEndPercent = 50
                    )
                ), contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(id = R.mipmap.logo_sisvita),
                contentDescription = "logo",
                modifier = Modifier.size(200.dp)
            )
        }
        Spacer(modifier = Modifier.padding(16.dp))
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
                    .background(Color(0xFFC6DABF), shape = RoundedCornerShape(12.dp))
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp), // Add padding if necessary
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    Row(
                        modifier = Modifier
                            .padding(vertical = 16.dp)
                            .background(Color(0xFF88D498), shape = RoundedCornerShape(12.dp))
                    ) {
                        Button(
                            onClick = {
                                navController.navigate("login")
                            },
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Text("Crear cuenta")
                        }
                        Spacer(modifier = Modifier.width(1.dp))
                        Button(
                            onClick = {
                            },
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Text("Crear cuenta")
                        }
                    }
                    if (expanded1) {
                        expanded1(viewModel = RegisterViewModel())
                    }
                    if (expanded2) {
                        expanded2(viewModel = RegisterViewModel())
                    }
                    if (expanded3) {
                        expanded3(viewModel = RegisterViewModel())
                    }
                    if (expanded4) {
                        expanded4(viewModel = RegisterViewModel())
                    }
                    Spacer(modifier = Modifier.height(15.dp))
                    Row(
                        modifier = Modifier.padding(vertical = 5.dp),
                        horizontalArrangement = Arrangement.SpaceEvenly
                    ) {
                        Box(
                            modifier = Modifier
                                .weight(1f)
                                .size(width = 80.dp, height = 40.dp)
                        ) {
                            /*CustomButton(
                                text = "1",
                                color = if (expanded1) Color(0xFF1A936F) else Color.Gray,
                                onClick = {
                                    expanded1 = true
                                    expanded2 = false
                                    expanded3 = false
                                    expanded4 = false
                                }
                            )*/
                        }
                        Spacer(modifier = Modifier.width(8.dp))
                        Box(
                            modifier = Modifier
                                .weight(1f)
                                .size(width = 80.dp, height = 40.dp)
                        ) {
                            /*CustomButton(
                                text = "2",
                                color = if (expanded2) Color(0xFF1A936F) else Color.Gray,
                                onClick = {
                                    expanded1 = false
                                    expanded2 = true
                                    expanded3 = false
                                    expanded4 = false
                                }
                            )*/
                        }
                        Spacer(modifier = Modifier.width(8.dp))
                        Box(
                            modifier = Modifier
                                .weight(1f)
                                .size(width = 80.dp, height = 40.dp)
                        ) {
                            /*CustomButton(
                                text = "3",
                                color = if (expanded3) Color(0xFF1A936F) else Color.Gray,
                                onClick = {
                                    expanded1 = false
                                    expanded2 = false
                                    expanded3 = true
                                    expanded4 = false
                                }
                            )*/
                        }
                        Spacer(modifier = Modifier.width(8.dp))
                        Box(
                            modifier = Modifier
                                .weight(1f)
                                .size(width = 80.dp, height = 40.dp)
                        ) {
                            /*CustomButton(
                                text = "4",
                                color = if (expanded4) Color(0xFF1A936F) else Color.Gray,
                                onClick = {
                                    expanded1 = false
                                    expanded2 = false
                                    expanded3 = false
                                    expanded4 = true
                                }
                            )*/
                        }
                    }
                    Spacer(modifier = Modifier.height(15.dp))
                    /*Button(
                        text = "Iniciar Sesión",
                        color = Color(0xFF88D498),
                        onClick = { getJwt(userInput, passwordInput, navController) }
                    )*/
                    Spacer(modifier = Modifier.height(15.dp))
                    Row {
                        Text(text = "¿Tienes una cuenta?")
                        Spacer(modifier = Modifier.width(1.dp))
                        Text(
                            text = "Iniciar Sesión",
                            modifier = Modifier.clickable { navController.navigate("login") },
                            color = Color(0xFF1A936F)
                        )
                    }
                    Spacer(modifier = Modifier.height(15.dp))
                }
            }
        }
    }
}

@Composable
fun expanded1(viewModel: RegisterViewModel){
    val userInput = viewModel.userInput.value
    val passwordInput = viewModel.passwordInput.value
    val correoInput = viewModel.correoInput.value

    /*EditTextField(
        label = R.string.username,
        keyboardOptions = KeyboardOptions.Default.copy(
            keyboardType = KeyboardType.Text, imeAction = ImeAction.Next
        ),
        value = viewModel.userInput.value,
        onValueChanged = { viewModel.setUserInput(it) }
    )

    EditTextField(
        label = R.string.password,
        keyboardOptions = KeyboardOptions.Default.copy(
            keyboardType = KeyboardType.Password, imeAction = ImeAction.Next
        ),
        value = viewModel.passwordInput.value,
        onValueChanged = { viewModel.setPasswordInput(it) }
    )
    EditTextField(
        label = R.string.correo,
        keyboardOptions = KeyboardOptions.Default.copy(
            keyboardType = KeyboardType.Email, imeAction = ImeAction.Next
        ),
        value = viewModel.correoInput.value,
        onValueChanged = { viewModel.setCorreoInput(it) }
    )*/
}

@Composable
fun expanded2(viewModel: RegisterViewModel){
    val nombreInput = viewModel.nombreInput.value
    val apellidoPaternoInput = viewModel.apellidoPaternoInput.value
    val apellidoMaternoInput = viewModel.apellidoMaternoInput.value


    /*EditTextField(
        label = R.string.nombre,
        keyboardOptions = KeyboardOptions.Default.copy(
            keyboardType = KeyboardType.Text, imeAction = ImeAction.Next
        ),
        value = viewModel.nombreInput.value,
        onValueChanged = { viewModel.setNombreInput(it) }
    )

    EditTextField(
        label = R.string.apellido_paterno,
        keyboardOptions = KeyboardOptions.Default.copy(
            keyboardType = KeyboardType.Text, imeAction = ImeAction.Next
        ),
        value = viewModel.apellidoPaternoInput.value,
        onValueChanged = { viewModel.setApellidoPaternoInput(it) }
    )

    EditTextField(
        label = R.string.apellido_materno,
        keyboardOptions = KeyboardOptions.Default.copy(
            keyboardType = KeyboardType.Text, imeAction = ImeAction.Next
        ),
        value = viewModel.apellidoMaternoInput.value,
        onValueChanged = { viewModel.setApellidoMaternoInput(it) }
    )*/


}

@Composable
fun expanded3(viewModel: RegisterViewModel){
    val documentoInput = viewModel.documentoInput.value
    val sexoInput = viewModel.sexoInput.value
    val fechaNacimientoInput = viewModel.fechaNacimientoInput.value
    val telefonoInput = viewModel.telefonoInput.value
/*
    EditTextField(
        label = R.string.documento,
        keyboardOptions = KeyboardOptions.Default.copy(
            keyboardType = KeyboardType.Text, imeAction = ImeAction.Next
        ),
        value = documentoInput,
        onValueChanged = {  viewModel.setDocumentoInput(it) },
    )

    EditTextField(
        label = R.string.sexo,
        keyboardOptions = KeyboardOptions.Default.copy(
            keyboardType = KeyboardType.Text, imeAction = ImeAction.Done
        ),
        value = viewModel.sexoInput.value,
        onValueChanged = { viewModel.setSexoInput(it) }
    )

    EditTextField(
        label = R.string.fecha_nacimiento,
        keyboardOptions = KeyboardOptions.Default.copy(
            keyboardType = KeyboardType.Number, imeAction = ImeAction.Next
        ),
        value = viewModel.fechaNacimientoInput.value,
        onValueChanged = { viewModel.setFechaNacimientoInput(it) }
    )

    EditTextField(
        label = R.string.telefono,
        keyboardOptions = KeyboardOptions.Default.copy(
            keyboardType = KeyboardType.Phone, imeAction = ImeAction.Next
        ),
        value = viewModel.telefonoInput.value,
        onValueChanged = { viewModel.setTelefonoInput(it) }
    )*/
}

@Composable
fun expanded4(viewModel: RegisterViewModel){
    val departamentoInput = viewModel.departamentoInput.value
    val provinciaInput = viewModel.provinciaInput.value
    val distritoInput = viewModel.distritoInput.value
/*
    EditTextField(
        label = R.string.departamento,
        keyboardOptions = KeyboardOptions.Default.copy(
            keyboardType = KeyboardType.Text, imeAction = ImeAction.Next
        ),
        value = departamentoInput,
        onValueChanged = {  viewModel.setDepartamentoInput(it) },
    )

    EditTextField(
        label = R.string.provincia,
        keyboardOptions = KeyboardOptions.Default.copy(
            keyboardType = KeyboardType.Text, imeAction = ImeAction.Next
        ),
        value = provinciaInput,
        onValueChanged = {  viewModel.setProvinciaInput(it) },
    )

    EditTextField(
        label = R.string.distrito,
        keyboardOptions = KeyboardOptions.Default.copy(
            keyboardType = KeyboardType.Text, imeAction = ImeAction.Next
        ),
        value = distritoInput,
        onValueChanged = {  viewModel.setDistritoInput(it) },
    )*/
}

class RegisterViewModel : ViewModel() {
    private val _userInput = mutableStateOf("")
    val userInput: State<String> = _userInput

    private val _passwordInput = mutableStateOf("")
    val passwordInput: State<String> = _passwordInput

    private val _nombreInput = mutableStateOf("")
    val nombreInput: State<String> = _nombreInput

    private val _apellidoPaternoInput = mutableStateOf("")
    val apellidoPaternoInput: State<String> = _apellidoPaternoInput

    private val _apellidoMaternoInput = mutableStateOf("")
    val apellidoMaternoInput: State<String> = _apellidoMaternoInput

    private val _correoInput = mutableStateOf("")
    val correoInput: State<String> = _correoInput

    private val _fechaNacimientoInput = mutableStateOf("")
    val fechaNacimientoInput: State<String> = _fechaNacimientoInput

    private val _telefonoInput = mutableStateOf("")
    val telefonoInput: State<String> = _telefonoInput

    private val _sexoInput = mutableStateOf("")
    val sexoInput: State<String> = _sexoInput

    private val _departamentoInput = mutableStateOf("")
    val departamentoInput: State<String> = _departamentoInput

    private val _provinciaInput = mutableStateOf("")
    val provinciaInput: State<String> = _provinciaInput

    private val _distritoInput = mutableStateOf("")
    val distritoInput: State<String> = _distritoInput

    private val _documentoInput = mutableStateOf("")
    val documentoInput: State<String> = _documentoInput

    fun setUserInput(value: String) {
        _userInput.value = value
    }

    fun setPasswordInput(value: String) {
        _passwordInput.value = value
    }

    fun setNombreInput(value: String) {
        _nombreInput.value = value
    }

    fun setApellidoPaternoInput(value: String) {
        _apellidoPaternoInput.value = value
    }

    fun setApellidoMaternoInput(value: String) {
        _apellidoMaternoInput.value = value
    }

    fun setCorreoInput(value: String) {
        _correoInput.value = value
    }

    fun setFechaNacimientoInput(value: String) {
        _fechaNacimientoInput.value = value
    }

    fun setTelefonoInput(value: String) {
        _telefonoInput.value = value
    }

    fun setSexoInput(value: String) {
        _sexoInput.value = value
    }

    fun setDepartamentoInput(value: String) {
        _departamentoInput.value = value
    }

    fun setProvinciaInput(value: String) {
        _provinciaInput.value = value
    }

    fun setDistritoInput(value: String) {
        _distritoInput.value = value
    }

    fun setDocumentoInput(value: String) {
        _documentoInput.value = value
    }
}
