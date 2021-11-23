package com.example.myapp

import android.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private lateinit var trueButton: Button // true button
    private lateinit var falseButton: Button// false button
    private lateinit var nextButton: Button // next button
    private lateinit var questionText: TextView
    private lateinit var alert: AlertDialog
    private val questionList = listOf(Question(R.string.question_australia,true),// here is the list of all of our questions
        Question(R.string.math1,true),
        Question(R.string.math2,true),
        Question(R.string.math3,false))
    private var index = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)//this will be our view

        trueButton = findViewById(R.id.true_button)//add the buttons to the view
        falseButton = findViewById(R.id.false_button)
        nextButton = findViewById(R.id.next)
        questionText = findViewById(R.id.questionTextView)

        trueButton.setOnClickListener { view:View ->//this will be our action listener that will perform an action when the button is clicked
            checkAnswer(true)
            questionUpdate()
        }
        falseButton.setOnClickListener{ view:View ->
            checkAnswer(false)
            questionUpdate()
        }
        nextButton.setOnClickListener {//button when clicked will update to the next question

            questionUpdate()
        }

    }
    private fun checkAnswer(userAns:Boolean){// this method will perform the logic to check our answers
        val ans = questionList[index].ans
       val message = if (ans==userAns)
            R.string.correct
        else
            R.string.incorrect
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show()
    }
    private fun questionUpdate(){//method that will be called when we want the question to be updated
        index = (index+1) % questionList.size
        val questionTextResId = questionList[index].textResId
        questionText.setText(questionTextResId)
        if(index==questionList.size){


        }
    }
}