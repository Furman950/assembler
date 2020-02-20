package main.kotlin.com.ferminsandoval.states

import main.kotlin.com.ferminsandoval.exceptions.InvalidInstructionException
import main.kotlin.com.ferminsandoval.models.Instruction
import main.kotlin.com.ferminsandoval.states.branch.b.B
import main.kotlin.com.ferminsandoval.states.branch.bl.BL
import main.kotlin.com.ferminsandoval.states.branch.blt.Blt
import main.kotlin.com.ferminsandoval.states.dataprocessing.add.Add
import main.kotlin.com.ferminsandoval.states.dataprocessing.cmp.Cmp
import main.kotlin.com.ferminsandoval.states.dataprocessing.mov.Mov
import main.kotlin.com.ferminsandoval.states.dataprocessing.or.Or
import main.kotlin.com.ferminsandoval.states.datatransfer.ldr.Ldr
import main.kotlin.com.ferminsandoval.states.datatransfer.pop.Pop
import main.kotlin.com.ferminsandoval.states.datatransfer.push.Push
import main.kotlin.com.ferminsandoval.states.datatransfer.str.Str
import main.kotlin.com.ferminsandoval.states.move.movt.Movt
import main.kotlin.com.ferminsandoval.states.move.movw.Movw
import main.kotlin.com.ferminsandoval.states.dataprocessing.mul.Mul

class FindInstructionType : State {
    override fun nextState(instruction: Instruction): State {
        return when (val label = instruction.label) {
            "MOVW" -> Movw()
            "MOVT" -> Movt()

            "ADD" -> Add()
            "MUL" -> Mul()
            "OR" -> Or()
            "CMP" -> Cmp()
            "MOV" -> Mov()

            "LDR" -> Ldr()
            "STR" -> Str()
            "PUSH" -> Push()
            "POP" -> Pop()

            "B" -> B()
            "BAL" -> B()
            "BLT" -> Blt()
            "BL" -> BL()
            else -> throw InvalidInstructionException("$label is not a valid instruction")
        }
    }
}