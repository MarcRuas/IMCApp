package com.marco.imcapp.ui.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.marco.imcapp.calcular.CalcularIMC
import com.marco.imcapp.ui.components.OutlinedText
import com.marco.imcapp.ui.components.TopApp
import com.marco.imcapp.ui.theme.Light_Blue
import com.marco.imcapp.ui.theme.White

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CalculadoraIMC() {

    var peso by rememberSaveable {
        mutableStateOf("")
    }

    var altura by rememberSaveable {
        mutableStateOf("")
    }

    var resultado by rememberSaveable {
        mutableStateOf("")
    }

    Scaffold(
        topBar = {
            Surface(
                shadowElevation = 18.dp
            ) {
                TopApp(acao = {
                    peso = ""
                    altura = ""
                    resultado = ""
                })
            }
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize()
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Calcular IMC",
                fontSize = 25.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(50.dp)
            )

            OutlinedText(
                value = peso,
                onValueChanged = {
                    peso = it },
                label = "Peso em (Kg)"
            )

            Spacer(modifier = Modifier.height(10.dp))

            OutlinedText(
                value = altura,
                onValueChanged = {
                    altura = it
                },
                label = "Altura"
            )

            Button(
                onClick = {
                    resultado =
                        CalcularIMC().calcularIMC(peso = peso, altura = altura)
                }, modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Light_Blue,
                    contentColor = White
                )
            ) {
                Text(
                    text = "Calcular IMC",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                )
            }
            Text(
                text = resultado,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}