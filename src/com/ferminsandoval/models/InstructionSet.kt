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
    "ADD" to 0xE080_0000.toInt(),
    "OR" to 0xE380_0000.toInt(),
    "CMP" to 0xE150_0000.toInt()
)

val dataTransfer = hashMapOf(
    "LDR" to 0xE590_0000.toInt(),
    "STR" to 0xE580_0000.toInt()
)

val branching = hashMapOf(
    "BLT" to 0xBA00_0000.toInt(),
    "BAL" to 0xEA00_0000.toInt(),
    "B" to 0xEA00_0000.toInt()
)
