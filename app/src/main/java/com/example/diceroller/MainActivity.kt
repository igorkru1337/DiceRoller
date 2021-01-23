package com.example.diceroller

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.util.*


class MainActivity : AppCompatActivity() {
    lateinit var diceImage: ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val rollButton: Button = findViewById(R.id.roll_button)

        var countAgain = 0
        var previousRoll = 0
        rollButton.setOnClickListener {
            val randomInt = rollDice()
            if (randomInt == previousRoll) {
                countAgain++
                Toast.makeText(this, "$randomInt fell again $countAgain times!!!", Toast.LENGTH_SHORT).show()
            } else {
                countAgain = 0
            }
            previousRoll = randomInt

        }
    }

    private fun rollDice(): Int {
        diceImage = findViewById(R.id.dice_image)
        val randomInt = Random().nextInt(6) + 1
        diceImage.setImageResource(
                when (randomInt) {
                    1 -> R.drawable.dice_1
                    2 -> R.drawable.dice_2
                    3 -> R.drawable.dice_3
                    4 -> R.drawable.dice_4
                    5 -> R.drawable.dice_5
                    else -> R.drawable.dice_6
                }
        )
        return randomInt
    }
}