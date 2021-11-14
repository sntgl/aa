class AlgTest(string1: String, string2: String, expectedLev: Int, expectedDam: Int) {
    val s1 = string1
    val s2 = string2
    private val rLev = expectedLev
    private val rDam = expectedDam
    public fun checkLev(result: Int) {
        if (rLev != result)
            throw ArithmeticException("Lev test '$s1' to '$s2' not passed! Expected $rLev, got $result")
    }
    public fun checkDam(result: Int) {
        if (rDam != result)
            throw ArithmeticException("Dam test '$s1' to '$s2' not passed! Expected $rDam, got $result")
    }
}