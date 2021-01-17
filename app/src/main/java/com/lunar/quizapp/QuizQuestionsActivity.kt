package com.lunar.quizapp

import android.graphics.Color
import android.graphics.Typeface
import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import androidx.core.content.ContextCompat
import org.w3c.dom.Text
import android.content.Intent as Intent

class QuizQuestionsActivity : AppCompatActivity(), View.OnClickListener {
    private var mCurrentPosition: Int = 1
    private var mQuestionsList: ArrayList<Question>? = null
    private var mSelectedOptionPosition: Int = 0
    private var mCorrectAnswers: Int = 0
    private var mUserName: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_questions)

        mUserName = intent.getStringExtra(Constants.USER_NAME)

        val tv_option_one = findViewById<TextView>(R.id.tv_choice_one)
        val tv_option_two = findViewById<TextView>(R.id.tv_choice_two)
        val tv_option_three = findViewById<TextView>(R.id.tv_choice_three)
        val btn_submit = findViewById<Button>(R.id.btn_sumbit)

        mQuestionsList = Constants.getQuestions()

        setQuestions()

        tv_option_one.setOnClickListener(this)
        tv_option_two.setOnClickListener(this)
        tv_option_three.setOnClickListener(this)
        btn_submit.setOnClickListener(this)
    }

    private fun setQuestions() {
        val question = mQuestionsList!![mCurrentPosition - 1]
        val btn_submit = findViewById<Button>(R.id.btn_sumbit)

        defaultOptionsView()

        if(mCurrentPosition == mQuestionsList!!.size) {
            btn_submit.text = "Finish"
        }
        else {
            btn_submit.text = "Submit"
        }

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

    private fun defaultOptionsView() {
        val tv_option_one = findViewById<TextView>(R.id.tv_choice_one)
        val tv_option_two = findViewById<TextView>(R.id.tv_choice_two)
        val tv_option_three = findViewById<TextView>(R.id.tv_choice_three)

        val options = ArrayList<TextView>()
        options.add(0, tv_option_one)
        options.add(1, tv_option_two)
        options.add(1, tv_option_three)

        for(option in options) {
            option.setTextColor(Color.parseColor("#7A8089"))
            option.typeface = Typeface.DEFAULT
            option.background = ContextCompat.getDrawable(this, R.drawable.default_option_border_bg)
        }
    }

    override fun onClick(v: View?) {
        val tv_choice_one = findViewById<TextView>(R.id.tv_choice_one)
        val tv_choice_two = findViewById<TextView>(R.id.tv_choice_two)
        val tv_choice_three = findViewById<TextView>(R.id.tv_choice_three)
        val btn_submit = findViewById<Button>(R.id.btn_sumbit)

        when(v?.id) {
            R.id.tv_choice_one -> {
                selectedOptionView(tv_choice_one, 1)
            }

            R.id.tv_choice_two -> {
                selectedOptionView(tv_choice_two, 2)
            }

            R.id.tv_choice_three -> {
                selectedOptionView(tv_choice_three, 3)
            }

            R.id.btn_sumbit -> {
                if(mSelectedOptionPosition == 0) {
                    mCurrentPosition++

                    when {
                        mCurrentPosition <= mQuestionsList!!.size -> {
                            setQuestions()
                        }
                        else -> {
                           val intent = Intent(this, ResultActivity::class.java)
                            intent.putExtra(Constants.USER_NAME, mUserName)
                            intent.putExtra(Constants.CORRECT_ANSWERS, mCorrectAnswers)
                            intent.putExtra(Constants.TOTAL_QUESTIONS, mQuestionsList!!.size)
                            startActivity(intent)
                            finish()
                        }
                    }
                }
                else {
                    val question = mQuestionsList?.get(mCurrentPosition - 1)
                    if(question!!.correctAnswer != mSelectedOptionPosition) {
                        answerView(mSelectedOptionPosition, R.drawable.wrong_option_border_bg)
                    }
                    else{
                        mCorrectAnswers++
                    }

                    answerView(question.correctAnswer, R.drawable.correct_option_border_bg)

                    if(mCurrentPosition == mQuestionsList!!.size) {
                        btn_submit.text = "Finish"
                    }
                    else {
                        btn_submit.text = "Go to next question"
                    }

                    mSelectedOptionPosition = 0
                }
            }
        }
    }

    private fun answerView(answer:Int, drawableView: Int) {
        val tv_choice_one = findViewById<TextView>(R.id.tv_choice_one)
        val tv_choice_two = findViewById<TextView>(R.id.tv_choice_two)
        val tv_choice_three = findViewById<TextView>(R.id.tv_choice_three)

        when(answer) {
            1 -> {
                tv_choice_one.background = ContextCompat.getDrawable(this, drawableView)
            }

            2 -> {
                tv_choice_two.background = ContextCompat.getDrawable(this, drawableView)
            }

            3 -> {
                tv_choice_three.background = ContextCompat.getDrawable(this, drawableView)
            }
        }
    }

    private fun selectedOptionView(tv: TextView, selectedOptionNum: Int) {
        defaultOptionsView()
        mSelectedOptionPosition = selectedOptionNum

        tv.setTextColor(Color.parseColor("#363A43"))
        tv.setTypeface(tv.typeface, Typeface.BOLD)
        tv.background = ContextCompat.getDrawable(this, R.drawable.selected_option_border_bg)
    }
}