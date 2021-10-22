package com.example.myapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private lateinit var trueButton: Button
    private lateinit var falseButton: Button
    private lateinit var nextButton: Button
    private lateinit var questionText: TextView
    private val questionList = listOf(Question(R.string.question_australia,true),
        Question(R.string.math1,true),
        Question(R.string.math2,true),
        Question(R.string.math3,false))
    private var index = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        trueButton = findViewById(R.id.true_button)
        falseButton = findViewById(R.id.false_button)
        nextButton = findViewById(R.id.next)
        questionText = findViewById(R.id.questionTextView)

        trueButton.setOnClickListener { view:View ->
           checkAnswer(true)
        }
        falseButton.setOnClickListener{ view:View ->
            checkAnswer(false)
        }
        nextButton.setOnClickListener {
            index = (index+1) % questionList.size
            questionUpdate()
        }

    }
    private fun checkAnswer(userAns:Boolean){
        val ans = questionList[index].ans
       val message = if (ans==userAns)
            R.string.correct
        else
            R.string.incorrect
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show()
    }
    private fun questionUpdate(){
        val questionTextResId = questionList[index].textResId
        questionText.setText(questionTextResId)
    }
}