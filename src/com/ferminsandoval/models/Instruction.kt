package com.ferminsandoval.models

data class Instruction(val label: String, val parameters: List<String>,  val positionInFile: Int, var encoded: Int = 0)