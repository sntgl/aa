package algorithms

class DamRecursionAlgorithm(): Algorithm() {
    override val name = "Рекурсивный алгоритм Дамерау-Левенштейна"
    override fun findDiff(): Int {
        return findDiff(s1.length, s2.length)
    }
    private fun findDiff(l1: Int, l2: Int): Int {
        if (l1 == 0) return l2
        if (l2 == 0) return l1
        val match: Int = if (s1[l1 - 1] == s2[l2 - 1]) 0 else 1
        val insertion: Int = findDiff(l1 - 1, l2) + 1
        val deletion: Int = findDiff(l1, l2 - 1) + 1
        var substitution: Int = findDiff(l1 - 1, l2 - 1) + match
        var result: Int = minOf(insertion, deletion, substitution)
        if (l1 > 1 && l2 > 1 && s1[l1 - 1] == s2[l2 - 2] && s1[l1 - 2] == s2[l2 - 1])
            result = minOf(findDiff(l1 - 2, l2 - 2) + 1, result)
        return result
    }
}