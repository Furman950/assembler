package com.ferminsandoval.states

import com.ferminsandoval.Assembler
import com.ferminsandoval.models.dataProcessing
import com.ferminsandoval.models.moveInstructions
import com.ferminsandoval.states.dataprocessing.DataProcessingInstruction
import com.ferminsandoval.states.move.MoveInstruction

class FindInstructionType : State {
    override fun nextState(assembler: Assembler): State {
        val instruction = assembler.currentInstruction
        val label = instruction.label

        if (moveInstructions.containsKey(label)){
            if (instruction.parameters.size < 2){
                return Error("Expected two parameters, but found ${instruction.parameters.size} on line ${assembler.currentLine}")
            }
            return MoveInstruction()
        }

        else if (dataProcessing.containsKey(label)) {
            if (instruction.parameters.size < 3){
                return Error("Expected three parameters, but found ${instruction.parameters.size} on line ${assembler.currentLine}")
            }

            return DataProcessingInstruction()
        }

        return Error("$label is not a valid instruction")
    }
}