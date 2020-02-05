package com.ferminsandoval.states

import com.ferminsandoval.models.Instruction

class Finished : State{
    override fun nextState(instruction: Instruction): State = this
}