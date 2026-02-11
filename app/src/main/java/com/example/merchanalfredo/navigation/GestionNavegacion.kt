package com.example.merchanalfredo.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation3.runtime.NavEntry
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.ui.NavDisplay
import com.example.merchanalfredo.ui.screens.HomeScreen
import com.example.merchanalfredo.ui.screens.LoginScreen
import com.example.merchanalfredo.ui.screens.NuevoJugadorScreen
import com.example.merchanalfredo.viewmodel.AuthViewModel
import com.example.merchanalfredo.viewmodel.JugadoresViewModel


@Composable
fun GestionNavegacion() {
    val authViewModel: AuthViewModel = viewModel()
    val jugadoresViewModel: JugadoresViewModel = viewModel()

    val startRoute = if (authViewModel.userEmail.value != null) Routes.Home else Routes.Login
    val backStack = rememberNavBackStack(startRoute)

    NavDisplay(
        backStack = backStack,
        onBack = { backStack.removeLastOrNull() },
        entryProvider = { key ->
            when (key) {
                is Routes.Login -> NavEntry(key) {
                    LoginScreen(
                        authViewModel = authViewModel,
                        onLoginSuccess = {
                            while (backStack.isNotEmpty()) backStack.removeLastOrNull()
                            backStack.add(Routes.Home)
                        }
                    )
                }

                is Routes.Home -> NavEntry(key) {
                    HomeScreen(
                        jugadoresViewModel = jugadoresViewModel,
                        onNuevoJugador = { backStack.add(Routes.NuevoJugador) }
                    )
                }

                is Routes.NuevoJugador -> NavEntry(key) {
                    NuevoJugadorScreen(
                        jugadoresViewModel = jugadoresViewModel,
                        onVolver = { backStack.removeLastOrNull() }
                    )
                }

                else -> NavEntry(key) {}

            }
            }
    )
}

