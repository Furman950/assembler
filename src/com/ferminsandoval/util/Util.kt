package com.ferminsandoval.util

import com.ferminsandoval.exceptions.InvalidRegisterException

fun getRegisterNumber(register: String) : Int {
    val registerStringValue = register.substring(1)
    val registerNumber = registerStringValue.toInt()

    if (registerNumber < 0 || registerNumber > 16){
        throw InvalidRegisterException("Register $registerNumber is out of range!")
    }

    return registerNumber
}