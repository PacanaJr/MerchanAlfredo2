package com.example.merchanalfredo.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.merchanalfredo.ui.components.JugadorCard
import com.example.merchanalfredo.viewmodel.JugadoresViewModel

@Composable
fun HomeScreen(
    jugadoresViewModel: JugadoresViewModel,
    onNuevoJugador: () -> Unit
) {
    val jugadores by jugadoresViewModel.jugadores

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(12.dp)
    ) {

        Text(
            text = "Plantilla temporada 25/26",
            style = MaterialTheme.typography.titleLarge
        )

        Spacer(modifier = Modifier.height(10.dp))

        LazyColumn(
            modifier = Modifier.weight(1f),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            items(jugadores) { jugador ->
                JugadorCard(
                    jugador = jugador,
                    onEliminar = { jugadoresViewModel.eliminarJugador(jugador.id) }
                )
            }
        }

        Button(
            onClick = onNuevoJugador,
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF27D21F))
        ) {
            Text("Nuevo jugador", color = Color.Black)
        }

    }
}