package com.marco.imcapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.marco.imcapp.ui.theme.IMCAppTheme
import com.marco.imcapp.ui.view.CalculadoraIMC

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CalculadoraIMC()
        }
    }
}



