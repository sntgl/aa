package algorithms

class LevIterAlgorithm(): Algorithm() {
    override val name = "Итерационный алгоритм Левенштейна"
    override val isDam = false
    override fun findDiff(): Int {
        val array = Array(2) { Array(s2.length + 1) { -1 } }
        array[0].forEachIndexed { index, _ -> array[0][index] = index }
        for (index in 1..s1.length) {
            val i = 1
            if (index > 1) {
                array[0] = array[1]
                array[1] = Array(s2.length + 1) { -1 }
            }
            array[1][0] = index
            for (j in 1..s2.length) {
                val valueUp = array[i - 1][j] + 1
                val valueLeft = array[i][j - 1] + 1
                val diagMatch = if (s1[index - 1] == s2[j - 1]) 0 else 1
                val valueDiag = array[i - 1][j - 1] + diagMatch
                array[i][j] = minOf(valueUp, valueLeft, valueDiag)
            }
        }
        return array[1][s2.length]
    }
}