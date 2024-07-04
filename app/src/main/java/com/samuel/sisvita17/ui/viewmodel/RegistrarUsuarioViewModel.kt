package com.samuel.sisvita17.ui.viewmodel

import android.util.Patterns
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.samuel.sisvita17.data.model.response.RegistrarUsuarioResponse
import com.samuel.sisvita17.data.model.response.TituloData
import com.samuel.sisvita17.data.repository.EspecialistaRepository
import com.samuel.sisvita17.data.repository.UserRepository

class RegistrarUsuarioViewModel : ViewModel() {

    private val userRepository = UserRepository()
    private val especialistaRespository = EspecialistaRepository()

    private val _nombre = MutableLiveData("")
    val nombre: LiveData<String> get() = _nombre

    private val _apellidos = MutableLiveData("")
    val apellidos: LiveData<String> get() = _apellidos

    private val _correo = MutableLiveData("")
    val correo: LiveData<String> get() = _correo

    private val _contrasena = MutableLiveData("")
    val contrasena: LiveData<String> get() = _contrasena

    private val _confirmarContrasena = MutableLiveData("")
    val confirmarContrasena: LiveData<String> get() = _confirmarContrasena

    private val _correoValido = MutableLiveData(true)
    val correoValido: LiveData<Boolean> get() = _correoValido

    private val _ubigeo = MutableLiveData("")
    val ubigeo: LiveData<String> get() = _ubigeo

    private val _registrarResult = MutableLiveData<RegistrarUsuarioResponse?>()
    val registrarResult: LiveData<RegistrarUsuarioResponse?> get() = _registrarResult

    private val _mensajeResult = MutableLiveData("")
    val mensajeResult: LiveData<String> get() = _mensajeResult

    private val _contrasenaValido = MutableLiveData(false)
    val contrasenaValido: LiveData<Boolean> get() = _contrasenaValido

    private val _registroValido = MutableLiveData(false)
    val registroValido: LiveData<Boolean> get() = _registroValido

    private val _roles = listOf("Estudiante", "Especialista")
    val roles: List<String> get() = _roles

    private val _selectedRole = MutableLiveData(_roles[0])
    val selectedRole: LiveData<String> get() = _selectedRole

    private val _dropdownItems = MutableLiveData<List<TituloData>>(emptyList())
    val dropdownItems: LiveData<List<TituloData>> get() = _dropdownItems

    private val _selectedDropdownItem = MutableLiveData<TituloData?>()
    val selectedDropdownItem: LiveData<TituloData?> get() = _selectedDropdownItem

    fun iniciarTitulo() {
        especialistaRespository.getTitulos { response ->
            response?.data?.let { item ->
                _dropdownItems.postValue(item)
            }
        }
    }

    fun onSelectedDropdownItemChange(newItem: TituloData) {
        _selectedDropdownItem.value = newItem
    }

    fun onSelectedRoleChange(newRole: String) {
        _selectedRole.value = newRole
    }

    fun onRegistroValidoChange() {
        _registroValido.value = false
    }

    fun onNombreChange(newNombre: String) {
        _nombre.value = newNombre
    }

    fun onApellidoPaternoChange(newApellidos: String) {
        _apellidos.value = newApellidos
    }

    fun onCorreoChange(newCorreo: String) {
        _correo.value = newCorreo
        _correoValido.value = Patterns.EMAIL_ADDRESS.matcher(newCorreo).matches()
    }

    fun onContrasenaChange(newContrasena: String) {
        _contrasena.value = newContrasena
    }

    fun onConfirmarContrasenaChange(newConfirmarContrasena: String) {
        _confirmarContrasena.value = newConfirmarContrasena
        _contrasenaValido.value = _contrasena.value == _confirmarContrasena.value
    }

    fun onUbigeoChange(newUbigeo: String) {
        _ubigeo.value = newUbigeo
    }

    fun registrarUsuario() {
        val nombre = _nombre.value ?: ""
        val apellidos = _apellidos.value ?: ""
        val correo = _correo.value ?: ""
        val contrasena = _contrasena.value ?: ""
        val confirmarContrasena = _confirmarContrasena.value ?: ""
        val ubigeo = _ubigeo.value?.toIntOrNull()

        if (nombre.isEmpty() || apellidos.isEmpty() ||
            correo.isEmpty() || contrasena.isEmpty() || confirmarContrasena.isEmpty() || ubigeo == null) {
            _registroValido.postValue(false)
            _mensajeResult.postValue("Complete todos los campos")
            return
        }

        if (_correoValido.value == false) {
            _mensajeResult.postValue("Correo invalido")
        } else if (_contrasenaValido.value == false) {
            _mensajeResult.postValue("Contrasenas no conciden")
        } else {

            if(_selectedRole.value == "Estudiante"){
                userRepository.registrarUsuario(
                    nombre = nombre, apellidos = apellidos,
                    correo = correo, contrasena = contrasena, ubigeo = ubigeo
                ) { response ->
                    _registrarResult.postValue(response)
                    if (response?.message == "Nuevo Usuario creado") {
                        _registroValido.postValue(true)
                        _mensajeResult.postValue("")
                    } else if (response?.message == "Datos incompletos") {
                        _registroValido.postValue(false)
                        _mensajeResult.postValue("Complete todos los campos")
                    } else if (response?.message == "Correo electrónico ya registrado") {
                        _registroValido.postValue(false)
                        _mensajeResult.postValue("Correo electrónico ya registrado")
                    } else {
                        _registroValido.postValue(false)
                        _mensajeResult.postValue("Error al crear el usuario")
                    }
                }
            }/*
            else if (_selectedRole.value == "Especialista"){
                if(selectedDropdownItem.value == null){
                    _registroValido.postValue(false)
                    _mensajeResult.postValue("Escoge un titulo")
                    return
                }
                especialistaRespository.registrarEspecialista(
                    nombre = nombre, apellidos = apellidos,
                    correo = correo, contrasena = contrasena, ubigeo = ubigeo,
                    titulo_id = selectedDropdownItem.value!!.titulo_id
                ){ response ->
                    _registrarResult.postValue(response)
                    if (response?.message == "Nuevo Especialista creado") {
                        _registroValido.postValue(true)
                        _mensajeResult.postValue("")
                    } else if (response?.message == "Datos incompletos") {
                        _registroValido.postValue(false)
                        _mensajeResult.postValue("Complete todos los campos")
                    } else if (response?.message == "Correo electrónico ya registrado") {
                        _registroValido.postValue(false)
                        _mensajeResult.postValue("Correo electrónico ya registrado")
                    } else {
                        _registroValido.postValue(false)
                        _mensajeResult.postValue("Error al crear el especialista")
                    }
                }
            }*/
        }
    }

    fun registrarEspecialista() {
        val nombre = _nombre.value ?: ""
        val apellidos = _apellidos.value ?: ""
        val correo = _correo.value ?: ""
        val contrasena = _contrasena.value ?: ""
        val confirmarContrasena = _confirmarContrasena.value ?: ""
        val ubigeo = _ubigeo.value?.toIntOrNull()

        if (nombre.isEmpty() || apellidos.isEmpty() ||
            correo.isEmpty() || contrasena.isEmpty() || confirmarContrasena.isEmpty() || ubigeo == null) {
            _registroValido.postValue(false)
            _mensajeResult.postValue("Complete todos los campos")
            return
        }

        if (_correoValido.value == false) {
            _mensajeResult.postValue("Correo invalido")
        } else if (_contrasenaValido.value == false) {
            _mensajeResult.postValue("Contrasenas no conciden")
        } else {

            if(_selectedRole.value == "Estudiante"){
                if(selectedDropdownItem.value == null){
                    _registroValido.postValue(false)
                    _mensajeResult.postValue("Escoge un titulo")
                    return
                }
                especialistaRespository.registrarEspecialista(
                    nombre = nombre, apellidos = apellidos,
                    correo = correo, contrasena = contrasena, ubigeo = ubigeo,
                    titulo_id = selectedDropdownItem.value!!.titulo_id
                ){ response ->
                    _registrarResult.postValue(response)
                    if (response?.message == "Nuevo Especialista creado") {
                        _registroValido.postValue(true)
                        _mensajeResult.postValue("")
                    } else if (response?.message == "Datos incompletos") {
                        _registroValido.postValue(false)
                        _mensajeResult.postValue("Complete todos los campos")
                    } else if (response?.message == "Correo electrónico ya registrado") {
                        _registroValido.postValue(false)
                        _mensajeResult.postValue("Correo electrónico ya registrado")
                    } else {
                        _registroValido.postValue(false)
                        _mensajeResult.postValue("Error al crear el especialista")
                    }
                }
            }/*
            else if (_selectedRole.value == "Especialista"){
                if(selectedDropdownItem.value == null){
                    _registroValido.postValue(false)
                    _mensajeResult.postValue("Escoge un titulo")
                    return
                }
                especialistaRespository.registrarEspecialista(
                    nombre = nombre, apellidos = apellidos,
                    correo = correo, contrasena = contrasena, ubigeo = ubigeo,
                    titulo_id = selectedDropdownItem.value!!.titulo_id
                ){ response ->
                    _registrarResult.postValue(response)
                    if (response?.message == "Nuevo Especialista creado") {
                        _registroValido.postValue(true)
                        _mensajeResult.postValue("")
                    } else if (response?.message == "Datos incompletos") {
                        _registroValido.postValue(false)
                        _mensajeResult.postValue("Complete todos los campos")
                    } else if (response?.message == "Correo electrónico ya registrado") {
                        _registroValido.postValue(false)
                        _mensajeResult.postValue("Correo electrónico ya registrado")
                    } else {
                        _registroValido.postValue(false)
                        _mensajeResult.postValue("Error al crear el especialista")
                    }
                }

            }
*/
        }
    }
}
