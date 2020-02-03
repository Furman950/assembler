package com.ferminsandoval.states

import com.ferminsandoval.models.Instruction

interface State {
    fun nextState(instruction: Instruction): State
}