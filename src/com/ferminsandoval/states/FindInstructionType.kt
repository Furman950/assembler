package com.ferminsandoval.states

import com.ferminsandoval.exceptions.InvalidInstructionException
import com.ferminsandoval.models.Instruction
import com.ferminsandoval.states.branch.b.B
import com.ferminsandoval.states.branch.bl.BL
import com.ferminsandoval.states.branch.blt.Blt
import com.ferminsandoval.states.dataprocessing.add.Add
import com.ferminsandoval.states.dataprocessing.cmp.Cmp
import com.ferminsandoval.states.dataprocessing.mov.Mov
import com.ferminsandoval.states.dataprocessing.or.Or
import com.ferminsandoval.states.datatransfer.ldr.Ldr
import com.ferminsandoval.states.datatransfer.str.Str
import com.ferminsandoval.states.move.movt.Movt
import com.ferminsandoval.states.move.movw.Movw

class FindInstructionType : State {
    override fun nextState(instruction: Instruction): State {
        return when (val label = instruction.label) {
            "MOVW" -> Movw()
            "MOVT" -> Movt()

            "ADD" -> Add()
            "OR" -> Or()
            "CMP" -> Cmp()
            "MOV" -> Mov()

            "LDR" -> Ldr()
            "STR" -> Str()

            "B" -> B()
            "BAL" -> B()
            "BLT" -> Blt()
            "BL" -> BL()
            else -> throw InvalidInstructionException("$label is not a valid instruction")
        }
    }
}