package com.example.merchanalfredo.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.merchanalfredo.model.Jugador
import com.google.firebase.firestore.FirebaseFirestore

class JugadoresViewModel : ViewModel() {

    private val db = FirebaseFirestore.getInstance()
    private val jugadoresCollection = db.collection("jugadores")

    private val _jugadores = mutableStateOf<List<Jugador>>(emptyList())
    val jugadores: State<List<Jugador>> = _jugadores

    init {
        escucharJugadores()
    }

    private fun escucharJugadores() {
        jugadoresCollection.addSnapshotListener { snapshot, error ->
            if (error == null && snapshot != null) {
                _jugadores.value = snapshot.toObjects(Jugador::class.java)
            }
        }
    }

    fun agregarJugador(
        nombre: String,
        numero: Int,
        nacionalidad: String,
        posicion: String,
        imagen: String
    ) {
        val jugadorMap = hashMapOf(
            "nombre" to nombre,
            "numero" to numero,
            "nacionalidad" to nacionalidad,
            "posicion" to posicion,
            "imagen" to imagen
        )
        jugadoresCollection.add(jugadorMap)
    }

    fun eliminarJugador(id: String) {
        jugadoresCollection.document(id).delete()
    }
}