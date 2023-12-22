package com.example.millionaire

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast


class MainActivity : AppCompatActivity() {
    private var currentRound = 0

    private lateinit var tvQuestion: TextView
    private lateinit var button: Button
    private lateinit var button2: Button
    private lateinit var button3: Button
    private lateinit var button4: Button
    private lateinit var tvValue: TextView
    private val rounds = mutableListOf<Round>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tvQuestion: TextView = findViewById(R.id.tvQuestion)

        tvQuestion.text = "Тут будет первый вопрос"
        button = findViewById(R.id.button)
        button2 = findViewById(R.id.button2)
        button3 = findViewById(R.id.button3)
        button4 = findViewById(R.id.button4)
    }

    private fun fillRounds() {
        rounds.run {
            add(Round("Что такое Луна?", "Звезда", "Планета", "Спутник", "Круг сыра", 3, 100))
            add(
                Round(
                    "B каком году запущен первый спутник?",
                    "1957",
                    "1961",
                    "1965",
                    "1969",
                    1,
                    1_000
                )
            )
            add(Round("Сколько спутников у Марса?", "0", "1", "2", "4", 3, 10_000))
            add(
                Round(
                    "Как называется спутник Плутона?",
                    "Нет спутников",
                    "Харон",
                    "Энцелад",
                    "Ио",
                    2,
                    100_000
                )
            )
            add(
                Round(
                    "Какой крупнейший спутник у Юпитера?",
                    "Европа",
                    "Каллисто",
                    "Титан",
                    "Ганимед",
                    4,
                    1_000_000
                )
            )
        }
    }

    private fun updateUI() {
        tvQuestion.text = rounds[currentRound].question
        tvValue.text=rounds [currentRound].value.toString()
        button2.text=rounds[currentRound].answer1
        button3.text=rounds[currentRound].answer2
        button4.text=rounds[currentRound].answer3
        button4.text=rounds[currentRound].answer4
    }
    private fun checkAnswer(givenId: Int)=(givenId==rounds[currentRound].rightId)

    private fun goNextRound():Boolean{
        if(currentRound>=rounds.size-1) return false
        currentRound++
        updateUI()
        return true
    }

    private fun processRound(givenId: Int){
        if(checkAnswer(givenId)){
            if(!goNextRound()){
                Toast.makeText(this,"ТЫ ВЫИГРАЛ! :)", Toast.LENGTH_SHORT).show()
                finish()
            }
        }else{
            Toast.makeText(this,"ТЫ ПРОИГРАЛ! :)", Toast.LENGTH_SHORT).show()
        }
    }
}