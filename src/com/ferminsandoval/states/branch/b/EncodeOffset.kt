package com.ferminsandoval.states.branch.b

import com.ferminsandoval.models.Instruction
import com.ferminsandoval.states.Finished
import com.ferminsandoval.states.State
import java.lang.Long

class EncodeOffset : State {
    override fun nextState(instruction: Instruction): State {
        var offset = instruction.parameters[0]
        if (offset.startsWith("0x")) {
            offset = offset.removePrefix("0x")
        }

        val offsetMask = Long.parseLong(offset, 16).toInt().shl(8)
            .ushr(8)

        instruction.encoded = instruction.encoded.or(offsetMask)

        return Finished()
    }

}
