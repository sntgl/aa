package algorithms

class DamIterAlgorithm(): Algorithm() {
    override val name = "Итерационный алгоритм Дамерау-Левенштейна"
    override fun findDiff(): Int {
        val array = Array(3) { Array(s2.length + 1) { -1 } }
        array[0].forEachIndexed { index, _ -> array[0][index] = index }
        for (index in 1..s1.length) {
            var i = index
            if (index > 2) {
                array[0] = array[1]
                array[1] = array[2]
                array[2] = Array(s2.length + 1) { -1 }
                i = 2
            }
            array[1][0] = index - 1
            array[2][0] = index
            for (j in 1..s2.length) {
                val valueUp = array[i - 1][j] + 1
                val valueLeft = array[i][j - 1] + 1
                val diagMatch = if (s1[index - 1] == s2[j - 1]) 0 else 1
                val valueDiag = array[i - 1][j - 1] + diagMatch
                var result = minOf(valueUp, valueLeft, valueDiag)
                if (index > 1 && j > 1 && s1[index - 2] == s2[j - 1] && s1[index - 1] == s2[j - 2])
                    result = minOf(result, array[0][j - 2] + 1)
                array[i][j] = result
            }
        }
        if (s1.length > 2)
            return array[2][s2.length]
        else
            return array[s1.length][s2.length]
    }
}