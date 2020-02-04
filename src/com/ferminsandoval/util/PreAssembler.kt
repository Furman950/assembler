package com.ferminsandoval.util

class PreAssembler {
    companion object {
        val labelLocations = hashMapOf<String, Int>()

        fun run(rawInstructions: List<String>): List<String> {
            getLabelLocations(rawInstructions)
            return process(rawInstructions)
        }

        private fun process(rawInstructions: List<String>): List<String> {
            var currentInstructionIndex = 1
            var index = 0
            val size = rawInstructions.size
            val newInstructions = ArrayList<String>()
            var newInstruction = ""

            while (index < size) {
                if (rawInstructions[index].isEmpty() || rawInstructions[index].isLabel()) {
                    newInstructions.add("")
                    index++
                    continue
                }

                newInstruction = rawInstructions[index]
                for (key in labelLocations.keys) {
                    if (rawInstructions[index].contains(key)) {
                        newInstruction = rawInstructions[index]
                            .replace(key, getOffsetInHexString(currentInstructionIndex, labelLocations[key]!!))
                        break
                    }
                }

                newInstruction = newInstruction.run {
                    replace("PC", "R15")
                }.run {
                    replace("LR", "R14")
                }

                currentInstructionIndex++
                index++
                newInstructions.add(newInstruction)
            }

            return newInstructions
        }

        private fun getOffsetInHexString(currentInstructionLine: Int, i: Int): String {
            var currentLine = if (currentInstructionLine < i) currentInstructionLine + 2
            else
                currentInstructionLine -2
            val offset = i - currentLine
            return String.format("0x%x", offset)
        }

        private fun getLabelLocations(rawInstructions: List<String>) {
            var currentInstructionIndex = 0
            var index = 0
            var size = rawInstructions.size

            while (index < size){
                if (rawInstructions[index].isEmpty()){
                    index++
                    continue
                }

                if (rawInstructions[index].isLabel()) {
                    labelLocations[rawInstructions[index].removeSuffix(":")] = currentInstructionIndex + 1
                    index++
                    continue
                }

                currentInstructionIndex++
                index++
            }
        }
    }
}