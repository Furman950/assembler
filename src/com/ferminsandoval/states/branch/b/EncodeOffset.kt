package com.ferminsandoval.states.branch.b

import com.ferminsandoval.models.Instruction
import com.ferminsandoval.states.Finished
import com.ferminsandoval.states.State

class EncodeOffset : State {
    override fun nextState(instruction: Instruction): State {
        var offset = instruction.parameters[0]
        if (offset.startsWith("0x")) {
            offset = offset.removePrefix("0x")
        }

        val offsetMask = Integer.parseInt(offset, 16)

        instruction.encoded = instruction.encoded.or(offsetMask)

        return Finished()
    }

}
