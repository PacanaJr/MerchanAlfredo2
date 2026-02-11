package com.example.merchanalfredo.model

import com.google.firebase.firestore.DocumentId

data class Jugador(
    @DocumentId
    var id: String = "",
    var nombre: String = "",
    var numero: Int = 0,
    var nacionalidad: String = "",
    var posicion: String = "",
    var imagen: String = ""
)