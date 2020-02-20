package main.kotlin.com.ferminsandoval.states

import main.kotlin.com.ferminsandoval.models.Instruction

interface State {
    fun nextState(instruction: Instruction): State
}