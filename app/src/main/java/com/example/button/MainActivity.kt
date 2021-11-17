package com.example.button

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val buttonClique: Button = findViewById(R.id.buttonClique)
        buttonClique.setOnClickListener { rollDice() }

        // Para já começar com um dado aleatorio
        rollDice()
    }

    // Lance os dados e atualize a tela com o resultado
    private fun rollDice() {
        //Crie um novo objeto de Dados com 6 lados e role-o
        val dice = Dice(6)
        val diceRoll = dice.roll()

        // Para puxar a imagem
        val diceImage: ImageView = findViewById(R.id.imageView2)

        // When para sortear os lados
        val recurso = when (diceRoll) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }

        // Atualizando o ID
        diceImage.setImageResource(recurso)

        // Atualizando a descrição para texto
        diceImage.contentDescription = diceRoll.toString()
    }

    class Dice(private val numSides: Int) {

        fun roll(): Int {
            return (1..numSides).random()
        }
    }
}