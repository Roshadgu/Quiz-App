package com.lunar.quizapp

import android.graphics.Color
import android.graphics.Typeface
import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.core.content.ContextCompat
import org.w3c.dom.Text

class QuizQuestionsActivity : AppCompatActivity(), View.OnClickListener {
    private var mCurrentPosition: Int = 1
    private var mQuestionsList: ArrayList<Question>? = null
    private var mSelectedOptionPosition: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_questions)

        val tv_option_one = findViewById<TextView>(R.id.tv_choice_one)
        val tv_option_two = findViewById<TextView>(R.id.tv_choice_two)
        val tv_option_three = findViewById<TextView>(R.id.tv_choice_three)

        mQuestionsList = Constants.getQuestions()

        setQuestions()

        tv_option_one.setOnClickListener(this)
        tv_option_two.setOnClickListener(this)
        tv_option_three.setOnClickListener(this)


    }

    private fun setQuestions()
    {
        mCurrentPosition = 1
        val question = mQuestionsList!![mCurrentPosition - 1]

        defaultOptionsView()

        val progressBar = findViewById<ProgressBar>(R.id.progress_bar)
        val tv_progress = findViewById<TextView>(R.id.tv_progress)
        val tv_question = findViewById<TextView>(R.id.tv_question)
        val iv_image = findViewById<ImageView>(R.id.iv_image)
        val tv_option_one = findViewById<TextView>(R.id.tv_choice_one)
        val tv_option_two = findViewById<TextView>(R.id.tv_choice_two)
        val tv_option_three = findViewById<TextView>(R.id.tv_choice_three)

        progressBar.progress = mCurrentPosition
        tv_progress.text = "$mCurrentPosition" + "/" + progressBar.max
        tv_question.text = question!!.question
        iv_image.setImageResource(question.image)
        tv_option_one.text = question.option1
        tv_option_two.text = question.option2
        tv_option_three.text = question.option3
    }

    private fun defaultOptionsView()
    {
        val tv_option_one = findViewById<TextView>(R.id.tv_choice_one)
        val tv_option_two = findViewById<TextView>(R.id.tv_choice_two)
        val tv_option_three = findViewById<TextView>(R.id.tv_choice_three)

        val options = ArrayList<TextView>()
        options.add(0, tv_option_one)
        options.add(1, tv_option_two)
        options.add(1, tv_option_three)

        for(option in options)
        {
            option.setTextColor(Color.parseColor("#7A8089"))
            option.typeface = Typeface.DEFAULT
            option.background = ContextCompat.getDrawable(this, R.drawable.default_option_border_bg)
        }
    }

    override fun onClick(v: View?)
    {
        val tv_choice_one = findViewById<TextView>(R.id.tv_choice_one)
        val tv_choice_two = findViewById<TextView>(R.id.tv_choice_two)
        val tv_choice_three = findViewById<TextView>(R.id.tv_choice_three)

        when(v?.id)
        {
            R.id.tv_choice_one -> {
                selectedOptionView(tv_choice_one, 1)
            }

            R.id.tv_choice_two -> {
                selectedOptionView(tv_choice_two, 2)
            }

            R.id.tv_choice_three -> {
                selectedOptionView(tv_choice_three, 3)
            }
        }
    }

    private fun selectedOptionView(tv: TextView, selectedOptionNum: Int)
    {
        defaultOptionsView()
        mSelectedOptionPosition = selectedOptionNum

        tv.setTextColor(Color.parseColor("#363A43"))
        tv.setTypeface(tv.typeface, Typeface.BOLD)
        tv.background = ContextCompat.getDrawable(this, R.drawable.selected_option_border_bg)
    }
}