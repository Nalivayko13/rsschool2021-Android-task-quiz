package com.rsschool.quiz

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.rsschool.quiz.contract.navigator
import com.rsschool.quiz.databinding.FragmentQuiz5Binding
import com.rsschool.quiz.databinding.FragmentResultBinding
import kotlin.system.exitProcess

class FragmentResult: Fragment() {
    private lateinit var binding: FragmentResultBinding


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentResultBinding.inflate(inflater, container, false)
        binding.restart.setOnClickListener {
            navigator().goToFragmentQuizFirst()
            navigator().restart()
        }
        binding.gratitude.text = requireArguments().getString(FragmentResult.ARG_QUESTION_VALUE)!!
        binding.exit.setOnClickListener{
            exitProcess(-1)
        }

        var str = navigator().printResult()

        binding.gratitude.text = str

        //binding.gratitude.text= navigator().printResult()
        
        binding.root
        return binding.root
    }

    companion object {

        @JvmStatic
        fun newInstance(gratitude: String): FragmentResult {
            val args = Bundle().apply {
                putString(ARG_QUESTION_VALUE, gratitude)

            }
            val fragment = FragmentResult()
            fragment.arguments = args
            return fragment
        }

        const val ARG_QUESTION_VALUE = "Any_Question"
    }
}