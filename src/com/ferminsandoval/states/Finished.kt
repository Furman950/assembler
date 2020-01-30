package com.ferminsandoval.states;

import com.ferminsandoval.Assembler

class Finished : State {
    override fun nextState(assembler: Assembler): State {
        return this
    }
}