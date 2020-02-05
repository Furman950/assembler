package com.ferminsandoval.models


val instructionSet = hashMapOf(
    "MOVW" to 0xE300_0000.toInt(),
    "MOVT" to 0xE340_0000.toInt(),

    "ADD" to 0xE080_0000.toInt(),
    "OR" to 0xE380_0000.toInt(),
    "CMP" to 0xE150_0000.toInt(),
    "MOV" to 0xE1A0_0000.toInt(),

    "LDR" to 0xE590_0000.toInt(),
    "STR" to 0xE580_0000.toInt(),
    "PUSH" to 0xE5ad0004.toInt(),
    "POP" to 0xE43d0004.toInt(),

    "BLT" to 0xBA00_0000.toInt(),
    "BAL" to 0xEA00_0000.toInt(),
    "B" to 0xEA00_0000.toInt(),
    "BL" to 0xEB00_0000.toInt()

)
