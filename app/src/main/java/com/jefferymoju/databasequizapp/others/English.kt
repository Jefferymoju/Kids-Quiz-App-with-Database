package com.jefferymoju.databasequizapp.others

import com.jefferymoju.databasequizapp.activities.Questions
import kotlin.concurrent.thread

object English {

    // function to add questions and set the correct answers
    fun getEnglishQuestions(): ArrayList<Questions>{
        val englishQuestionList = ArrayList<Questions>()

        val que1 = Questions(
            1, "What ______ when i called?","was you doing",
            "was you do", "were you doing","you were doing",
            3
        )
        englishQuestionList.add(que1)

        val que2 = Questions(
            2, "Nothing ________ done when the boss is away",
            "Becomes","Gets",
            "Been", "Got",
            2
        )
        englishQuestionList.add(que2)

        val que3 = Questions(
            3, "You can use my car _____ tomorrow",
            "Yet","Since",
            "Until", "Around",
            3
        )
        englishQuestionList.add(que3)

        val que4 = Questions(
            4, "What _____ your favorite food as a child",
            "will", "were",
            "would", "is",
            2
        )
        englishQuestionList.add(que4)

        val que5 = Questions(
            5, "______ you like? I like Grapes and Mango",
            "What kind of fruit", "What type of fruit do",
            "How many fruit do", "Types of fruit",
            2
        )
        englishQuestionList.add(que5)

        val que6 = Questions(
            6, "I will talk ______ Paul when i find him",
            "Around", "To",
            "At", "Towards",
            2
        )
        englishQuestionList.add(que6)

        val que7 = Questions(
            7, "When you end up in prison with no friends left, only then _____realise that" +
                    "all your thieving has been for nothing",
            "You could", "Will you",
            "They might","It will",
            2
        )
        englishQuestionList.add(que7)

        val que8 = Questions(
            8, "Hang _____! I'll be there with you an hour",
            "a little", "down here",
            "In there", "more",
            3
        )
        englishQuestionList.add(que8)

        val que9 = Questions(
            9, "My sister really gets a ____ out of dinging in public",
            "fun","buzz",
            "blush","pleasure",
            2
        )
        englishQuestionList.add(que9)

        val que10 = Questions(
            10, "I'm not sure if i shut down the computer. I can't really remember ______ it down",
            "have shut","shutting",
            "to shut", "i shut",
            2
        )
        englishQuestionList.add(que10)

        val que11 = Questions(
            11, "Joe showed me photos of his new car, ____ he bought last week",
            "which","that",
            "what","whom",
            1
        )
        englishQuestionList.add(que11)

        val que12 = Questions(
            12, "I'm afraid i ______ used to working in an open-plan office.",
            "haven't ever", "haven't",
            "haven't got", "have",
            3
        )
        englishQuestionList.add(que12)

        val que13 = Questions(
            13, "The guest room is quite small, but there should be enough space for you there." +
                    "you only have a few ______ and pieces.",
            "bits","clothes",
            "stuff","books",
            1
        )
        englishQuestionList.add(que13)

        val que14 = Questions(
            14, "My teacher had difficulty ______ my handwriting.",
            "to read", "for reading",
            "reading","to have read",
        3
        )
        englishQuestionList.add(que14)

        val que15 = Questions(
            15, "Our company receives hundreds of _____ emails every day.",
            "unstated","unsolicited",
            "unrequited","unkempt",
            2
        )
        englishQuestionList.add(que15)

        val que16 = Questions(
            16, "I'm sure he _____ being around my ex-husband",
            "won't get used","is used",
            "might be used to","will get used to",
            4
        )
        englishQuestionList.add(que16)

        val que17 = Questions(
            17, "When you are parted from your partner, you _______ to appreciate " +
                    "each other more.",
            "find","may",
            "become","grow",
            4
        )
        englishQuestionList.add(que17)

        val que18 = Questions(
            18, "I asked Jane about the accident, but she _____ a word",
            "didn't use to","wouldn't say",
            "shouldn't say", "refused",
            2
        )
        englishQuestionList.add(que18)

        val que19 = Questions(
            19, "When making beer, barley is _____ to bring out its sweetness",
            "germinated","malting",
            "growing","produced",
            1
        )
        englishQuestionList.add(que19)

        val que20 = Questions(
            20, "If he _______ phone, tell him to ring back later",
            "should","can",
            "might", "will",
            1
        )
        englishQuestionList.add(que20)

        return englishQuestionList
    }
}