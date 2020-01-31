package com.ferminsandoval.states

import com.ferminsandoval.Assembler
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

        if (moveInstructions.containsKey(label)){
            if (instruction.parameters.size < 2){
                return ErrorState("Expected two parameters, but found ${instruction.parameters.size} on line ${assembler.currentLine}")
            }
            return MoveInstruction()
        }

        else if (dataProcessing.containsKey(label)) {
            if (instruction.parameters.size < 3){
                return ErrorState("Expected three parameters, but found ${instruction.parameters.size} on line ${assembler.currentLine}")
            }

            return DataProcessingInstruction()
        }

        else if (dataTransfer.containsKey(label)){
            if (instruction.parameters.size < 2){
                return ErrorState("Expected two parameters, but found ${instruction.parameters.size} on line ${assembler.currentLine}")
            }

            return DataTransferInstruction()
        }

        else if (branching.containsKey(label)) {
            if (instruction.parameters.size != 1) {
                return ErrorState("Expected one parameter, but found ${instruction.parameters.size} on line ${assembler.currentLine}")
            }
            return BranchingInstruction()
        }

        return ErrorState("$label is not a valid instruction")
    }
}