package com.samuel.sisvita17.data.model.response

data class TestListResponse (
    val data :ArrayList<TestListData>,
    val message: String,
    val status:Int
)

data class TestListData(
    val prueba_id : Int,
    val titulo : String,
    val descripcion : String,
    val fecha_creacion : String
)