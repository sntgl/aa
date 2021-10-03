//fun main() {
//    GlobalScope.launch { // запуск новой сопрограммы в фоне
//        delay(1000L) // неблокирующая задержка на 1 секунду
//        println("World!") // вывод результата после задержки
//    }
//    println("Hello,") // пока сопрограмма проводит вычисления, основной поток продолжает свою работу
//    Thread.sleep(2000L) // блокировка основного потока на 2 секунды, чтобы сопрограмма успела произвести вычисления
//}

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
    val algorithmTester = AlgorithmTester("увлечение", "развлечения", 1000)
    algorithmTester.longWordsTimeTest()
//    algorithmTester.test()
}