package com.marco.imcapp.calcular

import android.content.Context
import android.widget.Toast
import java.lang.NumberFormatException

class CalcularIMC {

    fun calcularIMC(peso: String, altura: String): String {

        try {
            val pesoConvertido = peso.toDouble()
            val alturaConvertida = altura.toDouble()
            val resultado = pesoConvertido / (alturaConvertida * alturaConvertida)

            if (alturaConvertida == 0.0) {
                return "Altura não pode ser zero."
            }

            val imcFormatada = "%.2f".format(resultado)

            return when (resultado) {
                in 0.0..18.4 -> "Peso Baixo \n IMC: ${imcFormatada}"
                in 18.5..24.9 -> "Peso Normal \n IMC: ${imcFormatada}"
                in 25.0..29.9 -> "Sobrepeso \n IMC: ${imcFormatada}"
                in 30.0..34.9 -> "Obesidade (Grau 1) \n IMC: ${imcFormatada}"
                in 35.0..39.9 -> "Obesidade Severa (Grau 2) \n IMC: ${imcFormatada}"
                else -> "Obesidade Mórbida \n IMC: ${imcFormatada}"
            }
        } catch (e: NumberFormatException) {
            return "Valores inválidos. Certifique-se de que peso e altura sejam números válidos."
        }
    }

    fun verificar(peso: String, altura: String, context: Context): String {
        return if (peso.isNotBlank() && altura.isNotBlank()) {
            calcularIMC(peso = peso, altura = altura)
        } else {
            Toast.makeText(context, "Preencha todos os campos", Toast.LENGTH_SHORT).show()
            ""
        }
    }

}