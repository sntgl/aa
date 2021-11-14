package algorithms

class LevMatrixAlgorithm(): Algorithm() {
    override val isDam = false
    override val name = "Алгоритм Левенштейна с матрицей"

    var array: Array<Array<Int>>? = null
    override fun findDiff(): Int {
        array = Array(s1.length + 1) { Array(s2.length + 1) { -1 } }
        return findDiff(s1.length, s2.length)
    }
    private fun findDiff(l1: Int, l2: Int): Int {
        if (array!![l1][l2] != -1)
            return array!![l1][l2]
        if (l1 == 0) return l2
        if (l2 == 0) return l1
        val match: Int = if (s1[l1 - 1] == s2[l2 - 1]) 0 else 1
        val insertion: Int = findDiff(l1 - 1, l2) + 1
        val deletion: Int = findDiff(l1, l2 - 1) + 1
        val substitution: Int = findDiff(l1 - 1, l2 - 1) + match
        val result = minOf(insertion, deletion, substitution)
        array!![l1][l2] = result
        return result
    }
}