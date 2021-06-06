import java.io.File
import kotlin.math.min

fun main() {
    val inputFileName = "src/main/resources/IntegerArray.txt"
    val outputFileName = "src/main/resources/ConteoInversionesOutputArray.txt"
    val input = readFileAsLinesUsingBufferedReader(inputFileName).map { it.toInt() }.toIntArray()
    val pair = sortAndCount(input)
    val outputFile = File(outputFileName).printWriter()
    outputFile.use { out ->
        out.println("Operations: ${pair.first}")
        out.println("==========================")
        out.println(pair.second.contentToString())
    }
}

/**
 * Read file
 *
 * @param fileName Read file
 * @return List of strings read
 */
fun readFileAsLinesUsingBufferedReader(fileName: String): List<String> = File(fileName).bufferedReader().readLines()

/**
 * Main method to sort arrays using SortAndCount
 *
 * @param L any array
 * @return Sorted array
 */
fun sortAndCount(L: IntArray): Pair<Long, IntArray> {
    return if (L.size == 1) {
        Pair(0, L)
    } else {
        val half = L.size / 2
        val A = L.slice(0 until half).toIntArray()
        val B = L.slice(half until L.size).toIntArray()
        val arrayA = sortAndCount(A)
        val arrayB = sortAndCount(B)
        val result = mergeAndCount(arrayA.second, arrayB.second)
        Pair(result.first + arrayA.first + arrayB.first, result.second)
    }
}

/**
 * Merge and count inversions
 *
 * @param A Sorted array
 * @param B Sorted array
 * @return Pair of results <Counter, SortedArray>
 */
fun mergeAndCount(A: IntArray, B: IntArray): Pair<Int, IntArray> {
    val C = mutableListOf<Int>()
    var count = 0
    var i = 0
    var j = 0
    var result = mutableListOf<Int>()

    while (i < A.size && j < B.size) {
        C.add(min(A[i], B[j]))
        if (B[j] < A[i]) {
            result = A.slice(i until A.size).toMutableList()
            count += result.size
            j++
        } else {
            i++
        }
    }
    if (i >= A.size)
        result = B.sliceArray(j until B.size).toMutableList()
    else if (j >= B.size)
        result = A.sliceArray(i until A.size).toMutableList()
    C.addAll(result)
    return Pair(count, C.toIntArray())
}