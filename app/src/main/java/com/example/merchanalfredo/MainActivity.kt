package com.example.merchanalfredo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.merchanalfredo.navigation.GestionNavegacion
import com.example.merchanalfredo.ui.theme.MerchanAlfredoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MerchanAlfredoTheme {
                GestionNavegacion()
            }
        }
    }
}