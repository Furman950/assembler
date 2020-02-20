package main.kotlin.com.ferminsandoval.states.dataprocessing.mul

import main.kotlin.com.ferminsandoval.exceptions.InvalidInstructionException
import main.kotlin.com.ferminsandoval.models.Instruction
import main.kotlin.com.ferminsandoval.models.instructionSet
import main.kotlin.com.ferminsandoval.states.State

class Mul : State {
    override fun nextState(instruction: Instruction): State {
        val bitMask = instructionSet[instruction.label]!!
        instruction.encoded = instruction.encoded.or(bitMask);

        if (!valid(instruction))
            throw InvalidInstructionException("Invalid MUL instruction");

        return EncodeDestinationRegister();

    }

    private fun valid(instruction: Instruction): Boolean {
        if (instruction.parameters.size != 3) {
            return false;
        }

        val map = HashSet<String>();
        for(param in instruction.parameters){
            if (!map.add(param)) {
                return false;
            }
        }

        return true;
    }
}