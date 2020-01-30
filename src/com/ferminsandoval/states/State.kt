package com.ferminsandoval.states

import com.ferminsandoval.Assembler

interface State {
    fun nextState(assembler: Assembler): State
}