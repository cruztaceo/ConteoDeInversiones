import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class MainKtTest{

    @Test
    fun sortAndCount() {
        val array = intArrayOf(1,3,5,2,4,6)
        val result = sortAndCount(array)
        assertEquals(3, result.first)
        assertTrue(intArrayOf(1,2,3,4,5,6).contentEquals(result.second))
    }

    @Test
    fun sortAndCountTens() {
        val array = intArrayOf(11230,32150,3165450,252150,51540,260)
        val result = sortAndCount(array)
        result.second.map { println(it) }
        assertEquals(8, result.first)
        assertTrue(intArrayOf(260,11230,32150,51540,252150,3165450).contentEquals(result.second))
    }
}