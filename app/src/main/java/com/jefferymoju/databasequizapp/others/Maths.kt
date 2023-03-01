package com.jefferymoju.databasequizapp.others

import com.jefferymoju.databasequizapp.activities.Questions

object Maths {

    fun getQuestions(): ArrayList<Questions>{
        val questionsList = ArrayList<Questions>()
        
        val que1 = Questions(
            1,"What is the sum of 130 + 125 + 191 ?",
            "335","456",
            "446","426",
            3
        )
        questionsList.add(que1)

        val que2 = Questions(
            2, "If we minus 712 from 1500, how much do we get?",
            "788","778",
            "768","758",
            1
        )
        questionsList.add(que2)

        val que3 = Questions(
            3, "50 times of 8 is equal to",
            "80","400",
            "800","4000",
            2
        )
        questionsList.add(que3)

        val que4 = Questions(
            4, "110 divided by 10 is",
            "11","10",
            "5","None of the above",
            1
        )
        questionsList.add(que4)

        val que5 = Questions(
            5, "20+(90/2) is equal to",
            "50","55",
            "65","60",
            3
        )
        questionsList.add(que5)

        val que6 = Questions(
            6, "The product of 82 and 5 is",
            "400","410",
            "420","None of these",
            2
        )
        questionsList.add(que6)

        val que7 = Questions(
            7, "Find the missing terms in multiple of 3: 3, 6, 9, __, 15",
            "10","11",
            "12","13",
            3
        )
        questionsList.add(que7)

        val que8 = Questions(
            8, "Solve 24/8 + 2",
            "5","6",
            "8","12",
            1
        )
        questionsList.add(que8)

        val que9 = Questions(
            9,"300 - (150 x 2)",
            "150","100",
            "50","0",
            4
        )
        questionsList.add(que9)

        val que10 = Questions(
            10, "The product of 121 x 0 x 200x 25 is",
            "1500","0",
            "4000","None of these",
            2
        )
        questionsList.add(que10)

        val que11 = Questions(
            11, "What is the next prime number after 5?",
            "6","7",
            "9","11",
            2
            )
        questionsList.add(que11)

        return questionsList
    }
}