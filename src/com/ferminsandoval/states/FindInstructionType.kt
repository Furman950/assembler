package com.ferminsandoval.states

import com.ferminsandoval.Assembler
import com.ferminsandoval.exceptions.InvalidStatementException
import com.ferminsandoval.models.branching
import com.ferminsandoval.models.dataProcessing
import com.ferminsandoval.models.dataTransfer
import com.ferminsandoval.models.moveInstructions
import com.ferminsandoval.states.branch.BranchingInstruction
import com.ferminsandoval.states.dataprocessing.DataProcessingInstruction
import com.ferminsandoval.states.datatransfer.DataTransferInstruction
import com.ferminsandoval.states.move.MoveInstruction

class FindInstructionType : State {
    override fun nextState(assembler: Assembler): State {
        val instruction = assembler.currentStatement
        val label = instruction.label

        when {
            moveInstructions.containsKey(label) -> {
                if (instruction.parameters.size < 2){
                    throw InvalidStatementException("Expected two parameters, but found ${instruction.parameters.size} on line ${assembler.currentLine}")
                }
                return MoveInstruction()
            }
            dataProcessing.containsKey(label) -> {
                if (instruction.parameters.size < 2){
                    throw InvalidStatementException("Expected three parameters, but found ${instruction.parameters.size} on line ${assembler.currentLine}")
                }

                return DataProcessingInstruction()
            }
            dataTransfer.containsKey(label) -> {
                if (instruction.parameters.size < 2){
                    throw InvalidStatementException("Expected two parameters, but found ${instruction.parameters.size} on line ${assembler.currentLine}")
                }

                return DataTransferInstruction()
            }
            branching.containsKey(label) -> {
                if (instruction.parameters.size != 1) {
                    throw InvalidStatementException("Expected one parameter, but found ${instruction.parameters.size} on line ${assembler.currentLine}")
                }
                return BranchingInstruction()
            }
            else -> throw InvalidStatementException("$label is not a valid instruction")
        }

    }
}