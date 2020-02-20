package main.kotlin.com.ferminsandoval.util

fun String.isLabel(): Boolean = this.matches(Regex("^[a-z]*:$"))
