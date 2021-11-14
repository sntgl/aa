import algorithms.*
import kotlinx.coroutines.*
import java.lang.management.ManagementFactory
import java.lang.management.ThreadMXBean

class AlgorithmTester(string1: String, string2: String, repeats_in: Int) {
    private var s1: String = string1
    private var s2: String = string2
    private val repeats: Int = repeats_in

    private fun testAlg(algorithm: Algorithm, needPrint: Boolean = true): Long {
        var nano: Long = 0
        if (needPrint) println(algorithm.name)
        algorithm.setData(s1, s2)
        val threadMXBean: ThreadMXBean = ManagementFactory.getThreadMXBean()
        threadMXBean.allThreadIds.forEach { id -> nano -= threadMXBean.getThreadCpuTime(id) }
        for (i in 0..repeats) algorithm.findDiff()
        threadMXBean.allThreadIds.forEach { id -> nano += threadMXBean.getThreadCpuTime(id) }
        nano /= repeats
        if (needPrint) println("\tAvg CPU time: ${nano}ns\n\tОтвет: ${algorithm.findDiff()}")
        return nano
    }

    fun timeTests() {
        println(
            """
            |Исходное слово - '$s1', конечное - '$s2'
            |Количество повторов - $repeats
        """.trimMargin()
        )
        algorithmArrayLev.forEach { algorithm: Algorithm ->
            testAlg(algorithm)
        }
        algorithmArrayDam.forEach { algorithm: Algorithm ->
            testAlg(algorithm)
        }
    }

    fun longWordsTimeTest() {
        val wordsIn = arrayOf(
            getRandomString(10),
            getRandomString(20),
            getRandomString(50),
            getRandomString(100)
        )
        val wordsOut = arrayOf(
            getRandomString(10),
            getRandomString(20),
            getRandomString(50),
            getRandomString(100)
        )
        print("Букв | ")
        (algorithmArrayDam + algorithmArrayLev).forEach { alg ->
            print("${alg.name} | ")
        }
        println()
        wordsIn.forEachIndexed { i: Int, s1_in: String ->
            s1 = s1_in
            s2 = wordsOut[i]
            print("${s1.length} | ")
            (algorithmArrayDam + algorithmArrayLev).forEach {  algorithm: Algorithm ->
                print(
                    if (!algorithm.name.contains("Рекурсивный")) "${testAlg(algorithm, false)} | "
                    else "- | "
                )
            }
            println()
        }
    }

    private fun getRandomString(length: Int): String {
        val allowedChars = ('A'..'Z') + ('a'..'z') + ('0'..'9')
        return (1..length)
            .map { allowedChars.random() }
            .joinToString("")
    }

    fun blackBoxTests() {
        algorithmArrayLev.forEach { algorithm: Algorithm ->
            blackBox.forEach { test: AlgTest ->
                algorithm.setData(test.s1, test.s2)
                test.checkLev(algorithm.findDiff())
            }
            println("${algorithm.name} blackbox tests passed!")
        }
        println("All Lev blackbox tests passed!")
        algorithmArrayDam.forEach { algorithm: Algorithm ->
            blackBox.forEach { test: AlgTest ->
                algorithm.setData(test.s1, test.s2)
                test.checkDam(algorithm.findDiff())
            }
            println("${algorithm.name} blackbox tests passed!")
        }
        println("All Dam blackbox tests passed!")
    }

    companion object {
        private val algorithmArrayLev: Array<Algorithm> = arrayOf(
            LevRecursionAlgorithm(),
            LevMatrixAlgorithm(),
//            LevIterAlgorithm()
        )
        private val algorithmArrayDam: Array<Algorithm> = arrayOf(
            DamRecursionAlgorithm(),
            DamMatrixAlgorithm(),
            DamIterAlgorithm()
        )
        val blackBox = arrayOf(
            AlgTest("кит", "кот", 1, 1),
            AlgTest("собака", "собачка", 1, 1),
            AlgTest("dija", "djia", 2, 1),
            AlgTest("kolbaska", "kollab", 4, 4),
            AlgTest("абв", "", 3, 3),
            AlgTest("", "абв", 3, 3),
            AlgTest("увлечение", "развлечения", 4, 4),
            AlgTest("", "", 0, 0),
        )
    }
}