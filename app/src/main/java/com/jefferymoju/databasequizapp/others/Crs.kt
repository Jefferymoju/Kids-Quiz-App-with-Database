package com.jefferymoju.databasequizapp.others

import com.jefferymoju.databasequizapp.activities.Questions

// object class for the questions
object Crs {

    // function to get and set the questions
    fun getQuestions(): ArrayList<Questions>{
        val questionList = ArrayList<Questions>()

        // val for setting the question and identifying the correct answer
        val que1 = Questions(
            1, "What is the name of the man that betrayed Jesus Christ",
            "Judas Iscariot", "Philip",
            "John", "Job",
            1,
        )
        // add question 1 to the question list
        questionList.add(que1)

        val que2 = Questions(
            2, "How many soldiers did God ask Gideon to take to the battle?",
            "500","3000",
            "5000","300",
            4,
        )
        // add question 2 to the question list
        questionList.add(que2)

        val que3 = Questions(
            3,"What happened to the youths who laughed at Elisha's baldness?",
            "They became blind","Two bears killed 42 of them",
            "They turned into donkeys", "They turned into pillars of salt",
            2,
        )
        questionList.add(que3)

        val que4 = Questions(
            4, "What is the profession of David?",
            "hunter", "shepherd",
            "carpenter", "doctor",
            2
        )
        questionList.add(que4)

        val que5 = Questions(
            5,"What is the name of Samuel's father?",
            "Hannah","Joseph",
            "Elkanah", "David",
            3,
        )
        questionList.add(que5)

        val que6 = Questions(
            6, "Who did Elisha curse with leprosy because of greed",
            "Jehu","Gehazi",
            "Ahaziah","Joash",
            2,
        )
        questionList.add(que6)

        val que7 = Questions(
            7,"What was the sign Judas Iscariot gave to those who arrested Jesus?",
            "Hand Shake","A nod",
            "A smile","A kiss",
            4,
        )
        questionList.add(que7)

        val que8 = Questions(
            8, "The Feast Of Tabernacles was instituted by God to be celebrated by the Jews during the days of?",
            "Aaron","Joshua",
            "Moses","Jesus Christ",
            3,
        )
        questionList.add(que8)

        val que9 = Questions(
            9,"What was the name of Samuel's mother?",
            "Cynthia","Deborah",
            "Hannah","Jezebel",
            3,
        )
        questionList.add(que9)

        val que10 = Questions(
            10,"How many times did the Lord call Samuel before he responded?",
            "6","4",
            "5","3",
            4,
        )
        questionList.add(que10)

        val que11 = Questions(
            11, "How many Passover Feast did Jesus Christ celebrate after his baptism",
            "6","4",
            "3","2",
            2,
        )
        questionList.add(que11)

        val que12 = Questions(
            12, "Which people oppressed the Israelites when God sent Gideon to deliver them?",
            "Assyrians","Midianites",
            "Philistines", "Moabites",
            2,
        )
        questionList.add(que12)

        val que13 = Questions(
            13, "Samson did not take wine and alcohol, and did not cut his hair because he was a _____",
            "Jew","Warrior",
            "Nazarite","Judge",
            3,
        )
        questionList.add(que13)

        val que14 = Questions(
            14, "Blessed are the merciful, for they shall obtain___",
            "riches","mercy",
            "the bread of life","power",
            2,
        )
        questionList.add(que14)

        val que15 = Questions(
            15, "How many people passed by without rendering help to the wounded man in the story of the good Samaritan",
            "2","6",
            "3","1",
            1,
        )
        questionList.add(que15)

        val que16 = Questions(
            16, "Blessed are the pure in heart, for they shall____",
            "find joy", "gain power",
            "see God","inherit the earth",
            3,
        )
        questionList.add(que16)

        val que17 = Questions(
            17, "Where was the man journeying to in the story of the good Samaritan?",
            "Israel to Damascus", "Greece to London",
            "Lagos to Abuja","Jerusalem to Jericho",
            4,
        )
        questionList.add(que17)

        val que18 = Questions(
            18,"Elisha the Prophet cured ______ of leprosy",
            "Naaman","Gehazi",
            "Naboth","Jezebel",
            1,
        )
        questionList.add(que18)

        val que19 = Questions(
            19, "Elijah told Ahab to gather all the people and the prophet of Baal together on ______",
            "Mount Horeb","Mount Carmel",
            "Mount Zion","Mount Olives",
            2,
        )
        questionList.add(que19)

        val que20 = Questions(
            20, "To inherit God's Kingdom by God's grace, we should ______",
            "struggle with everyone", "Obey God's words always",
            "stop going to school","Keep God's laws until 50",
            2,
        )
        questionList.add(que20)

        val que21 = Questions(
            21, "The parable of the Prodigal son teaches us ______",
            "Forgiveness","Repentance",
            "Love","All of the above",
            4,
        )
        questionList.add(que21)

        val que22 = Questions(
            22,"Where did the Prodigal son go to waste his inheritance or money?",
            "Syria","Jericho",
            "A far country","A great country",
            3,
        )
        questionList.add(que22)

        val que23 = Questions(
            23, "Who helped the Philistines to capture Samson?",
            "Delilah","Manoah",
            "Jezebel","Peninah",
            1,
        )
        questionList.add(que23)

        val que24 = Questions(
            24, "Which two brothers were mending their net when Jesus Christ called them",
            "Peter & Paul","Joseph & Benjamin",
            "James & John","Esau & Jacob",
            3,
        )
        questionList.add(que24)

        val que25 = Questions(
            25,"What was the prize Judas collected for betraying Jesus Christ",
            "30 pieces of silver","30 pieces of gold",
            "2,000 naira","3,000 dollars",
            1,
        )
        questionList.add(que25)

        val que26 = Questions(
            26,"What was the end of Judas Iscariot?",
            "He bought a car","He became rich",
            "He was killed","He hanged himself",
            4,
        )
        questionList.add(que26)

        val que27 = Questions(
            27, "What did Jesus Christ see Simon called Peter and Andrew his brother doing when he called them?",
            "Fighting","Playing",
            "Fishing","Drinking",
            3,
        )
        questionList.add(que27)

        val que28 = Questions(
            28, "Who was the son of Abraham",
            "Jacob","Joseph",
            "Isaac","David",
            3
        )
        questionList.add(que28)

        val que29 = Questions(
            29,"What did God tell Abraham to do with his son?",
            "Kiss him","Give him money",
            "Give him out","Kill him",
            4,
        )
        questionList.add(que29)

        val que30 = Questions(
            30, "Blessed are the meek for they shall inherit ______",
            "God's blessing","the Earth",
            "Cars and Houses","The Heavens",
            2,
        )
        questionList.add(que30)

        return questionList
    }
}