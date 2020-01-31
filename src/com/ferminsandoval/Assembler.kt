package com.ferminsandoval

import com.ferminsandoval.exceptions.InvalidStatementException
import com.ferminsandoval.models.Statement
import com.ferminsandoval.states.ErrorState
import com.ferminsandoval.states.FindInstructionType
import com.ferminsandoval.states.Finished
import com.ferminsandoval.states.State
import java.nio.file.Files
import java.nio.file.Paths


class Assembler {
    private lateinit var currentState: State
    lateinit var statements: MutableList<Statement>
    lateinit var currentStatement: Statement
    var currentLine = 1
    var binaryInstruction: Int = 0

    fun run(filePath: String) {
        statements = ArrayList()
        Files.lines(Paths.get(filePath))
            .forEach { x ->
                tokenizeInstructions(x)

                currentLine++
            }

        currentLine = 1
        statements.forEach {
            currentStatement = it
            parseInstructions()
            currentLine++
        }
    }

    private fun tokenizeInstructions(instruction: String) {
        if (instruction.isEmpty()) return

        val instructionTokens = instruction.split(Regex(" |, "))
            .filter(String::isNotBlank)

        if (instructionTokens.isEmpty())
            throw InvalidStatementException("Invalid statement at line $currentLine")

        val parameters = instructionTokens.slice(IntRange(1, instructionTokens.size - 1))
        statements.add(Statement(instructionTokens[0], parameters))
    }

    private fun parseInstructions() {
        currentState = FindInstructionType()
        while (currentState !is ErrorState && currentState !is Finished) {
            currentState = currentState.nextState(this)
        }
    }
}












