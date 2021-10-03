package algorithms

class LevRecursionAlgorithm(): Algorithm() {
    override val name = "Рекурсивный алгоритм Левенштейна"
    override fun findDiff(): Int {
        return findDiff(s1.length, s2.length)
    }
    private fun findDiff(l1: Int, l2: Int): Int {
        if (l1 == 0) return l2
        if (l2 == 0) return l1
        val match: Int = if (s1[l1 - 1] == s2[l2 - 1]) 0 else 1
        val insertion: Int = findDiff(l1 - 1, l2) + 1
        val deletion: Int = findDiff(l1, l2 - 1) + 1
        val substitution: Int = findDiff(l1 - 1, l2 - 1) + match
        return minOf(insertion, deletion, substitution)
    }
}