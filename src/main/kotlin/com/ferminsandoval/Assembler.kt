package main.kotlin.com.ferminsandoval

import main.kotlin.com.ferminsandoval.states.FindInstructionType
import main.kotlin.com.ferminsandoval.states.Finished
import main.kotlin.com.ferminsandoval.states.State
import main.kotlin.com.ferminsandoval.exceptions.InvalidInstructionException
import main.kotlin.com.ferminsandoval.models.Instruction
import main.kotlin.com.ferminsandoval.util.PreAssembler
import java.io.File
import java.nio.file.Files
import java.nio.file.Paths
import java.util.stream.Collectors


class Assembler(private val filePath: String) {
    private val binaryInstructions = ArrayList<Int>()
    private val instructions = ArrayList<Instruction>()

    private lateinit var rawInstructions: ArrayList<String>

    fun run() {
        loadIntoMemory()
        runPreAssembler()
        tokenizeInstructions()
        parseInstructions()
        writeInstructionsToFile()
//        writeToTestFile()
    }

    private fun loadIntoMemory() {
        rawInstructions = Files.lines(Paths.get(filePath)).collect(Collectors.toList()) as ArrayList<String>
    }

    private fun runPreAssembler() {
        rawInstructions = PreAssembler.run(rawInstructions) as ArrayList<String>
    }

    private fun writeToTestFile() {
        val testFilePath = Paths.get("").toAbsolutePath().toString() + "\\test.s"
        val str = rawInstructions.reduce { pre, new -> pre + "\n" + new }
        File(testFilePath)
            .writeText(str)
    }


    private fun writeInstructionsToFile() {
        val outputFile = Paths.get("").toAbsolutePath().toString() + "\\kernel7.img"
        val kernel7 = File(outputFile)
        var byteArray = ByteArray(binaryInstructions.size * 4)
        var index = 0

        binaryInstructions.forEach {
            byteArray[index++] = it.toByte()
            byteArray[index++] = it.shr(8).toByte()
            byteArray[index++] = it.shr(16).toByte()
            byteArray[index++] = it.shr(24).toByte()
        }

        kernel7.writeBytes(byteArray)
    }

    private fun tokenizeInstructions() {
        var currentFileLine = 0
        for (instruction in rawInstructions) {
            currentFileLine++
            if (instruction.isBlank()) continue

            val instructionTokens = instruction.split(Regex(" |, "))
                .filter(String::isNotBlank)

            if (instructionTokens.isEmpty())
                throw InvalidInstructionException("Invalid statement at line $currentFileLine")

            val parameters = instructionTokens.slice(IntRange(1, instructionTokens.size - 1))
            instructions.add(Instruction(instructionTokens[0], parameters, currentFileLine))
        }
    }

    private fun parseInstructions() {
        for (instruction in instructions) {
            var currentState: State = FindInstructionType()

            while (currentState !is Finished) {
                currentState = currentState.nextState(instruction)
            }

            binaryInstructions.add(instruction.encoded)
        }
    }
}












