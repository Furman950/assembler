package com.ferminsandoval.states

import com.ferminsandoval.Assembler
import com.ferminsandoval.models.moveInstructions
import com.ferminsandoval.states.move.MoveInstruction

class FindInstructionType : State {
    override fun nextState(assembler: Assembler): State {
        val instruction = assembler.currentInstruction
        val label = instruction.label

        if (moveInstructions.containsKey(label)){
            if (instruction.parameters.size < 2){
                return Error("Expected two parameters, but found ${assembler.currentLine}")
            }
            return MoveInstruction()
        }

        return Error("$label is not a valid instruction")
    }
}