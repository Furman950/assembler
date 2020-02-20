package main.kotlin.com.ferminsandoval.util

import main.kotlin.com.ferminsandoval.exceptions.InvalidRegisterException

fun getRegisterNumber(register: String) : Int {
    val registerStringValue = register.substring(1)
    val registerNumber = registerStringValue.toInt()

    if (registerNumber < 0 || registerNumber > 16){
        throw InvalidRegisterException("Register $registerNumber is out of range!")
    }

    return registerNumber
}