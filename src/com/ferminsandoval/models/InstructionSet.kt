package com.ferminsandoval.models


val moveInstructions = hashMapOf(
    "MOVW" to 0xE300_0000.toInt(),
    "MOVT" to 0xE340_0000.toInt()
)
//    "ADD",
//    "LDR",
//    "OR",
//    "ORR",
//    "STR",
//    "CMP",
//    "BLT",
//    "B"

val dataProcessing = hashMapOf(
    "ADD" to 0xE080_0000.toInt()
)

val dataTransfer = hashMapOf(
    "LDR" to 0xE590_0000.toInt(),
    "STR" to 0xE580_0000.toInt()
)
