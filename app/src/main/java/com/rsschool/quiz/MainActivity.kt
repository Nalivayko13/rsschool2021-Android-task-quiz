package com.rsschool.quiz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.rsschool.quiz.contract.Navigator
import com.rsschool.quiz.databinding.*

class MainActivity : AppCompatActivity(), Navigator {
    private lateinit var binding: ActivityMainBinding
    private var selecredAnswers: Array<String> = arrayOf("","","","","")
    private val correctAncwers=arrayOf("остров", "54", "дисперсия света", "Грогу", "7")
    private var count=0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater).also { setContentView(it.root) }

        if (savedInstanceState == null) {
            val fragment =
                FragmentQuizOne.newInstance(
                    question = "Котлин - это..",
                            answer1 = "остров", answer2 ="язык программирования", answer3 = "суп",answer4 = "имя", answer5 = "бренд пива"
                )
            supportFragmentManager.beginTransaction().add(R.id.flFragment, fragment).commit()
        }

    }

    private fun launchFragment (fragment: Fragment){
        supportFragmentManager
            .beginTransaction()
            .addToBackStack(null)
            .replace(R.id.flFragment, fragment)
            .commit()
    }

    override fun add(i: Int, str: String) {
        selecredAnswers[i]= str
    }

    override fun restart() {
        count = 0
    }

    override fun printResult() : String{
        for(i in 0..4){
            if(selecredAnswers[i]==correctAncwers[i]){count++}
            println(selecredAnswers[i])
        }
        return "правильно $count из 5"
    }

    override fun goToFragmentQuizTwo() {
        launchFragment(Fragment_Quiz_Two.newInstance(question = "сколько лет киркорову?", answer1 = "63", answer2 ="51", answer3 = "58",answer4 = "49", answer5 = "54"))
    }

    override fun goToFragmentQuizThree() {
        launchFragment(Fragment_Quiz_Three.newInstance(question = "радуга - это..", answer1 = "магия", answer2 ="дисперсия света", answer3 = "диффракция света",answer4 = "интереференция света", answer5 = "имя пегаса из мультфильма MyLittlePony"))
    }

    override fun goToFragmentQuizFour() {
        launchFragment(Fragment_Quiz_Four.newInstance(question = "как зовут малыша йоду?", answer1 = "Василий", answer2 ="Йода", answer3 = "Айсард",answer4 = "Грогу", answer5 = "Бэндон"))
    }

    override fun goToFragmentQuizFive() {
        launchFragment(Fragment_Quiz_Five.newInstance(question = "сколько корейцев в группе BTS", answer1 = "4", answer2 ="5", answer3 = "7",answer4 = "8", answer5 = "11" ))
    }


    override fun goToFragmentResult() {
        launchFragment(FragmentResult.newInstance(gratitude = "gabella"))
    }

    override fun goToFragmentQuizFirst() {
        launchFragment(FragmentQuizOne.newInstance(question = "Котлин - это..",answer1 = "остров", answer2 ="язык программирования", answer3 = "суп",answer4 = "имя", answer5 = "бренд пива"))
    }

    override fun goBack() {
        onBackPressed()
    }




}

