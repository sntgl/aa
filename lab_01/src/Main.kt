
fun main() {
//
//    AlgorithmTester("aaa", "bbb", 10).test()
//    val a = Algorithms.LevIterAlgorithm()
//    a.setData("kosdt", "skadat")
//    println(a.findDiff())
//    AlgorithmTester.blackBoxTests()

//    val levRecursionAlgorithm = LevRecursionAlgorithm()
//    levRecursionAlgorithm.setData("увлечение", "развлечения")
//    println("${levRecursionAlgorithm.findDiff()}")

//    launch {
//
//    }
//    val algorithmTester = AlgorithmTester("", "", 1000)
//    algorithmTester.blackBoxTests()
    while (true) {
        print("Word A: ")
        val a: String = readLine()!!
        print("Word B: ")
        val b: String = readLine()!!
        AlgorithmTester(a, b, 1000).timeTests()
    }
//    algorithmTester.test()
}