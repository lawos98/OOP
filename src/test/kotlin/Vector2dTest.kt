import utilities.Vector2d
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Test

class Vector2dTest {
    @Test
    fun test_isequals()
    {
        assertTrue(Vector2d(2, 4) == (Vector2d(2, 4)))
        assertTrue(Vector2d(3, 5) ==(Vector2d(3, 5)))
        assertFalse(Vector2d(2, 5) ==(Vector2d(2, 3)))
        assertFalse(Vector2d(3, 4) ==(Vector2d(2, 4)))
    }
    @Test
    fun test_convertToString()
    {
        assertEquals(Vector2d(2, 4).toString(),"(2,4)")
        assertEquals(Vector2d(3, 1).toString(),"(3,1)")
        assertEquals(Vector2d(-1, -1).toString(),"(-1,-1)")
        assertEquals(Vector2d(-5, 5).toString(),"(-5,5)")
    }
    @Test
    fun test_procedes()
    {
        assertTrue(Vector2d(1, 1).precedes(Vector2d(2, 2)))
        assertTrue(Vector2d(1, 1).precedes(Vector2d(1, 2)))
        assertFalse(Vector2d(5, 1).precedes(Vector2d(3, 3)))
        assertFalse(Vector2d(1, 5).precedes(Vector2d(3, 3)))
    }
    @Test
    fun test_follows()
    {
        assertTrue(Vector2d(3, 3).follows(Vector2d(2, 2)))
        assertTrue(Vector2d(1, 3).follows(Vector2d(1, 2)))
        assertFalse(Vector2d(5, 1).follows(Vector2d(3, 3)))
        assertFalse(Vector2d(1, 5).follows(Vector2d(3, 3)))
    }
    @Test
    fun test_upperRight()
    {
        assertTrue(Vector2d(2, 4).upperRight(Vector2d(4, 4))== Vector2d(4, 4))
        assertTrue(Vector2d(3, 3).upperRight(Vector2d(3, 3))== Vector2d(3, 3))
        assertTrue(Vector2d(1, 5).upperRight(Vector2d(5, 1))== Vector2d(5, 5))
        assertTrue(Vector2d(-1, -1).upperRight(Vector2d(1, 1))== Vector2d(1, 1))
    }
    @Test
    fun test_lowerLeft()
    {
        assertTrue(Vector2d(2, 4).lowerLeft(Vector2d(4, 4))== Vector2d(2, 4))
        assertTrue(Vector2d(3, 3).lowerLeft(Vector2d(3, 3))== Vector2d(3, 3))
        assertTrue(Vector2d(1, 5).lowerLeft(Vector2d(5, 1))== Vector2d(1, 1))
        assertTrue(Vector2d(-1, -1).lowerLeft(Vector2d(1, 1))== Vector2d(-1, -1))
    }
    @Test
    fun test_add()
    {
        assertTrue(Vector2d(2, 4) + (Vector2d(4, 4)) == (Vector2d(6, 8)))
        assertTrue(Vector2d(3, 3) + (Vector2d(3, 3)) == (Vector2d(6, 6)))
        assertTrue(Vector2d(1, 5) + (Vector2d(5, 1)) == (Vector2d(6, 6)))
        assertTrue(Vector2d(-1, -1) + (Vector2d(1, 1)) == (Vector2d(0, 0)))
    }
    @Test
    fun test_subtract()
    {
        assertTrue(Vector2d(2, 4) -(Vector2d(4, 4))==(Vector2d(-2, 0)))
        assertTrue(Vector2d(3, 3) -(Vector2d(3, 3))==(Vector2d(0, 0)))
        assertTrue(Vector2d(1, 5) -(Vector2d(5, 1))==(Vector2d(-4, 4)))
        assertTrue(Vector2d(-1, -1) -(Vector2d(1, 1))==(Vector2d(-2, -2)))
    }
    @Test
    fun test_opposite()
    {
        assertTrue(Vector2d(2, 4).opposite()==(Vector2d(-2, -4)))
        assertTrue(Vector2d(3, 3).opposite()==(Vector2d(-3, -3)))
        assertTrue(Vector2d(1, 5).opposite()==(Vector2d(-1, -5)))
        assertTrue(Vector2d(-1, -1).opposite()==(Vector2d(1, 1)))
    }
}