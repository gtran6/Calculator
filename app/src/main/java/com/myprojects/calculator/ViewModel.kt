package com.myprojects.calculator

import androidx.lifecycle.ViewModel

class ViewModel : ViewModel() {
    var inputText: String = ""
    var totalText: String = ""
    val calculationHistory = mutableListOf<Calculation>()

    data class Calculation(val input: String, val output: String)
}