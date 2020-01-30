package com.ferminsandoval

import com.ferminsandoval.models.Instruction
import com.ferminsandoval.states.FindInstructionType
import com.ferminsandoval.states.Finished
import com.ferminsandoval.states.State
import java.nio.file.Files
import java.nio.file.Paths

class Assembler {
    private lateinit var currentState: State
    lateinit var instructions: MutableList<Instruction>
    lateinit var currentInstruction: Instruction
    var currentLine = 1
    var binaryInstruction: Int = 0

    fun run(filePath: String) {
        instructions = ArrayList()
        Files.lines(Paths.get(filePath))
            .forEach{x ->
                if (x.isNotBlank()){
                    tokenizeInstructions(x)
                }
            }

        currentLine = 1
        instructions.forEach{
            currentInstruction = it
            parseInstructions()
            currentLine++
        }
    }

    private fun tokenizeInstructions(instruction: String) {
        val instructionTokens = instruction.split(Regex(" |, "))

        if (instructionTokens.isEmpty())
            throw IllegalArgumentException("Invalid instruction at line ${currentLine++}")

        val parameters = instructionTokens.slice(IntRange(1, instructionTokens.size - 1))
        instructions.add(Instruction(instructionTokens[0], parameters))
    }

    private fun parseInstructions() {
        currentState = FindInstructionType()
        while (currentState !is Error && currentState !is Finished) {
            currentState = currentState.nextState(this)
        }
    }
}












