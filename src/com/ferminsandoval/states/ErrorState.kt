package com.ferminsandoval.states

import com.ferminsandoval.Assembler

class ErrorState(val message: String) : State {

    override fun nextState(assembler: Assembler): State {
        return this
    }
}