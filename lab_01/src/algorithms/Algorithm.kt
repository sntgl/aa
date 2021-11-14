package algorithms

abstract class Algorithm() {
    open val name: String = "Abstract Algorithms.Algorithm"
    protected var s1: String = ""
    protected var s2: String = ""
    public open val isDam: Boolean = false
    public abstract fun findDiff(): Int
    public fun setData(str1: String, str2: String) {
        s1 = str1
        s2 = str2
    }
}