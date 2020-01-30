package com.ferminsandoval.states

import com.ferminsandoval.Assembler

class Error(val message: String) : State {

    override fun nextState(assembler: Assembler): State {
        return this
    }
}