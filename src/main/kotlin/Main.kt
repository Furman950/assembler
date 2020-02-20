package main.kotlin

import main.kotlin.com.ferminsandoval.Assembler

fun main(args: Array<String>) {
    if (args.size != 1){
        println("Expected 1 argument, but got ${args.size}")
        return
    }

    Assembler(args[0]).run()
}