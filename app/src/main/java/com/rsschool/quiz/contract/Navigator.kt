package com.rsschool.quiz.contract

import androidx.fragment.app.Fragment

fun Fragment.navigator(): Navigator {
    return requireActivity() as Navigator
}

interface Navigator {
    fun goToFragmentQuizFirst()

    fun goToFragmentQuizTwo()

    fun goToFragmentQuizThree()

    fun goToFragmentQuizFour()

    fun goToFragmentQuizFive()

    fun goToFragmentResult()

    fun goBack()

    fun add(i: Int, str: String)

    fun printResult():String

    fun restart()
}