import java.io.File
import kotlin.math.min

fun main(args: Array<String>) {
    val input = readFileAsLinesUsingBufferedReader("src/main/resources/IntegerArray.txt").map { it.toInt() }.toIntArray()
    val pair = sortAndCount(input);
    println("Operations = ${pair.first}")
    println("==========================")
    pair.second.map { println(it) }
}

fun readFileAsLinesUsingBufferedReader(fileName: String): List<String>
        = File(fileName).bufferedReader().readLines()

fun sortAndCount(L: IntArray): Pair<Long, IntArray>{
    return if(L.size == 1) {
        Pair(0, intArrayOf())
    }
    else{
        val half = L.size / 2
        val A = L.slice(0 until half).toIntArray()
        val B = L.slice(half until L.size).toIntArray()
        val arrayA = sortAndCount(A)
        val arrayB = sortAndCount(B)
        val result = mergeAndCount(A, B)
        Pair(result.first + arrayA.first + arrayB.first, result.second)
    }
}

fun mergeAndCount(A: IntArray, B: IntArray): Pair<Int, IntArray> {
    val C = mutableListOf<Int>()
    val tempA = A.toMutableList()
    val tempB = B.toMutableList()
    var count = 0
    var i = 0
    var j = 0
    var result = mutableListOf<Int>()

    while (i < A.size && j < B.size){
        C.add(min(A[i], B[j]))
        if(B[j] < A[i]) {
            result = A.slice(i until A.size).toMutableList()
            count += result.size
            j++
        }
        else {
            i++
        }
    }
    if(i >= A.size)
        result = B.sliceArray(j until B.size).toMutableList()
    else if(j >= B.size)
        result = A.sliceArray(i until A.size).toMutableList()
    C.addAll(result)
    return Pair(count, C.toIntArray())
}