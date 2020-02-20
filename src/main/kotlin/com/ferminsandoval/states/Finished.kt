package main.kotlin.com.ferminsandoval.states

import main.kotlin.com.ferminsandoval.models.Instruction

class Finished : State {
    override fun nextState(instruction: Instruction): State = this
}