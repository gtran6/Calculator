package com.myprojects.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatDelegate
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.myprojects.calculator.databinding.ActivityMainBinding
import net.objecthunter.exp4j.ExpressionBuilder

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val viewModel: ViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Set up the RecyclerView
        val calculationsRecyclerView = binding.rcv
        calculationsRecyclerView.layoutManager = LinearLayoutManager(this)
        calculationsRecyclerView.addItemDecoration(DividerItemDecoration(this, LinearLayoutManager.VERTICAL))
        val adapter = CalculationAdapter(viewModel.calculationHistory)
        calculationsRecyclerView.adapter = adapter


        binding.apply {
            inputText.text = viewModel.inputText
            total.text = viewModel.totalText
        }

        binding.apply {

            ac.setOnClickListener {
                inputText.text = ""
                total.text = ""
                viewModel.calculationHistory.add(
                    ViewModel.Calculation(
                        inputText.text.toString(),
                        total.text.toString()
                    )
                )
            }

            clear.setOnClickListener {
                val clearTxt = inputText.length()
                if (clearTxt > 0)
                    inputText.text = inputText.text.substring(0 , clearTxt -1)
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

                } else {
                    total.text = result.toString()
                }

                viewModel.inputText = binding.inputText.text.toString()
                viewModel.totalText = binding.total.text.toString()

            }

            btnSwitch.setOnClickListener {
                if (btnSwitch.isChecked) {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                } else {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
                }
                recreate()
            }
        }
    }
}