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

//    @Test
//    fun sortAndCountTens() {
//        val array = intArrayOf(10,30,50,20,40,60)
//        val result = sortAndCount(array)
//        result.second.map { println(it) }
//        assertEquals(3, result.first)
//        assertTrue(intArrayOf(1,2,3,4,5,6).contentEquals(result.second))
//    }
}