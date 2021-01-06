package com.lunar.quizapp

object Constants
{
    fun getQuestions(): ArrayList<Question>
    {
        val qustionsList = ArrayList<Question>()
        val question1 = Question(
            1,
            "What type of flag is waved to mark the end of a NASCAR race?", R.drawable.ic_flag_of_argentina,
            "Checkered",
            "Polka Dot",
            "Swedish",
            1)

        qustionsList.add(question1)

        val question2 = Question(
            2,
            "An old saying tells us not to cry over spilled what?", R.drawable.ic_flag_of_argentina,
            "Milk",
            "Hot liquid magma",
            "Tears",
            1)

        qustionsList.add(question2)

        val question3 = Question(
            3,
            "Which of these destinations is legally allowed to bill iself as " + "\"" + "The Happiest Place on Earth" + "\"" +"?", R.drawable.ic_flag_of_argentina,
            "Maryland",
            "Orlando",
            "Disneyland",
            3)

        qustionsList.add(question3)

        val question4 = Question(
            4,
            "In math, what is one way to write "+ "\"" + "x over y" + "\""+"?", R.drawable.ic_flag_of_argentina,
            "x^y",
            "x*y",
            "x/y",
            3)

        qustionsList.add(question4)

        val question5 = Question(
            5,
            "A truck without any walls or roof on its rear portion is known as what?", R.drawable.ic_flag_of_argentina,
            "Longtable",
            "Flatbed",
            "Roundchair",
            2)

        qustionsList.add(question5)

        val question6 = Question(
            6,
            "Which of these is device designed to help measure the speed of the wind?", R.drawable.ic_flag_of_argentina,
            "Anemometer",
            "Odometer",
            "Kilometer",
            1)

        qustionsList.add(question6)

        val question7 = Question(
            7,
            "What type of creature is Harry Potter's pet Hedwig?", R.drawable.ic_flag_of_argentina,
            "Hedgehog",
            "Rabbit",
            "Owl",
            3)

        qustionsList.add(question7)

        val question8 = Question(
            8,
            "Which of these is an example of a conjunction?", R.drawable.ic_flag_of_argentina,
            "Also",
            "With",
            "nor",
            3)

        qustionsList.add(question8)

        val question9 = Question(
            9,
            "Which of these stars has recieved Oscar nominations in the greatest number of different categories?", R.drawable.ic_flag_of_argentina,
            "Clint Eastwood",
            "Barbra Streissand",
            "George Clooney",
            3)

        qustionsList.add(question9)

        val question10 = Question(
            10,
            "Which of these Asian cities is closest to the South Pole?", R.drawable.ic_flag_of_argentina,
            "Shanghai",
            "Jakarta",
            "Delhi",
            2)

        qustionsList.add(question10)

        val question11 = Question(
            11,
            "The "+"\"" + "Cry From the Town of Saints" + "\"" + "was an act of independence from Spain by the people of which country?", R.drawable.ic_flag_of_argentina,
            "Portugal",
            "Panama",
            "Mexico",
            2)

        qustionsList.add(question11)

        val question12 = Question(
            12,
            "What company did Steve Jobs purchase for $5M after being ousted from Apple in 1985?", R.drawable.ic_flag_of_argentina,
            "Microsoft",
            "Pixar",
            "Applebees",
            2)

        qustionsList.add(question12)

        return qustionsList
    }
}