package com.myprojects.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AppCompatDelegate
import com.myprojects.calculator.databinding.ActivityMainBinding
import net.objecthunter.exp4j.ExpressionBuilder

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var isCalculating = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            ac.setOnClickListener {
                if (isCalculating) {
                    ac.text = "C"
                    val clearTxt = inputText.length()
                    if (clearTxt > 0)
                        inputText.text = inputText.text.substring(0 , clearTxt -1)
                } else {
                    ac.text = "AC"
                    inputText.text = ""
                    total.text = ""
                }
            }
            zero.setOnClickListener { inputText.append("0") }

            one.setOnClickListener { inputText.append("1") }

            two.setOnClickListener { inputText.append("2") }

            three.setOnClickListener { inputText.append("3") }

            four.setOnClickListener { inputText.append("4") }

            five.setOnClickListener { inputText.append("5") }

            six.setOnClickListener { inputText.append("6") }

            seven.setOnClickListener { inputText.append("7") }

            eight.setOnClickListener { inputText.append("8") }

            nine.setOnClickListener { inputText.append("9") }

            plus.setOnClickListener { inputText.append("+") }

            minus.setOnClickListener { inputText.append("-") }

            multiply.setOnClickListener { inputText.append("*") }

            divide.setOnClickListener { inputText.append("/") }

            dot.setOnClickListener { inputText.append(".") }

            startBracket.setOnClickListener { inputText.append("(") }

            endBracket.setOnClickListener { inputText.append(")") }

            equals.setOnClickListener{
                val expression = ExpressionBuilder(inputText.text.toString()).build()
                val result = expression.evaluate()
                val longResult = result.toLong()

                if (result == longResult.toDouble()){

                    total.text = longResult.toString()

                }else{
                    total.text = result.toString()
                }
            }

            btnSwitch.setOnClickListener {
                if (btnSwitch.isChecked) {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                } else {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
                }
            }
        }
    }
}