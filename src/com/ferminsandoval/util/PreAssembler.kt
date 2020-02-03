package com.ferminsandoval.util

class PreAssembler {
    companion object{
        val labelLocations = hashMapOf<String, Int>()

        fun run(rawInstructions: List<String>) : List<String> {
            getLabelLocations(rawInstructions)
            return process(rawInstructions)
        }

        private fun process(rawInstructions: List<String>): List<String> {
            var currentInstructionLine = 0
            var currentFileLine = 0
            val size = rawInstructions.size
            val newInstructions = ArrayList<String>()
            var newInstruction = ""

            while (currentFileLine < size) {
                if (rawInstructions[currentFileLine].isEmpty() || rawInstructions[currentFileLine].isLabel()){
                    newInstructions.add("")
                    currentFileLine++
                    continue
                }

                newInstruction = rawInstructions[currentFileLine]
                for(key in labelLocations.keys){
                    if (rawInstructions[currentFileLine].contains(key)){
                        newInstruction = rawInstructions[currentFileLine]
                            .replace(key, getOffsetInHexString(currentInstructionLine, labelLocations[key]!!))
                        break
                    }
                }

                currentInstructionLine++
                currentFileLine++
                newInstructions.add(newInstruction)
            }

            return newInstructions
        }

        private fun getOffsetInHexString(currentInstructionLine: Int, i: Int): String {
            var currentLine = currentInstructionLine + 2
            val offset = i - currentLine
            return String.format("0x%x", offset).toUpperCase()
        }

        private fun getLabelLocations(rawInstructions: List<String>) {
            var currentInstructionLine = 0
            var currentFileLine = 0
            val size = rawInstructions.size
            while(currentFileLine < size) {
                if (rawInstructions[currentFileLine].isEmpty()){
                    currentFileLine++
                    continue
                }

                if (rawInstructions[currentFileLine].isLabel()){
                    labelLocations[rawInstructions[currentFileLine].removeSuffix(":")] = ++currentInstructionLine
                }
                currentInstructionLine++
                currentFileLine++
            }
        }
    }
}