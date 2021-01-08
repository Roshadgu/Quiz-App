package com.lunar.quizapp

import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView

class QuizQuestionsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_questions)

        val questionList = Constants.getQuestions()
        Log.i("Questions Size", "${questionList.size}")

        val currentPosition = 1
        val question: Question? = questionList[currentPosition - 1]

        val progressBar = findViewById<ProgressBar>(R.id.progress_bar)
        val tv_progress = findViewById<TextView>(R.id.tv_progress)
        val tv_question = findViewById<TextView>(R.id.tv_question)
        val iv_image = findViewById<ImageView>(R.id.iv_image)
        val tv_option_one = findViewById<TextView>(R.id.tv_choice_one)
        val tv_option_two = findViewById<TextView>(R.id.tv_choice_two)
        val tv_option_three = findViewById<TextView>(R.id.tv_choice_three)

        progressBar.progress = currentPosition
        tv_progress.text = "$currentPosition" + "/" + progressBar.max
        tv_question.text = question!!.question
        iv_image.setImageResource(question.image)
        tv_option_one.text = question.option1
        tv_option_two.text = question.option2
        tv_option_three.text = question.option3
    }
}