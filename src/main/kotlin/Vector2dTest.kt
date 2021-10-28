import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Test

class Vector2dTest {
    @Test
    fun test_isequals()
    {
        assertTrue(Vector2d(2,4).isequals(Vector2d(2,4)))
        assertTrue(Vector2d(3,5).isequals(Vector2d(3,5)))
        assertFalse(Vector2d(2,5).isequals(Vector2d(2,3)))
        assertFalse(Vector2d(3,4).isequals(Vector2d(2,4)))
    }
    @Test
    fun test_convertToString()
    {
        assertEquals(Vector2d(2,4).convertToString(),"(2,4)")
        assertEquals(Vector2d(3,1).convertToString(),"(3,1)")
        assertEquals(Vector2d(-1,-1).convertToString(),"(-1,-1)")
        assertEquals(Vector2d(-5,5).convertToString(),"(-5,5)")
    }
    @Test
    fun test_procedes()
    {
        assertTrue(Vector2d(1,1).precedes(Vector2d(2,2)))
        assertTrue(Vector2d(1,1).precedes(Vector2d(1,2)))
        assertFalse(Vector2d(5,1).precedes(Vector2d(3,3)))
        assertFalse(Vector2d(1,5).precedes(Vector2d(3,3)))
    }
    @Test
    fun test_follows()
    {
        assertTrue(Vector2d(3,3).follows(Vector2d(2,2)))
        assertTrue(Vector2d(1,3).follows(Vector2d(1,2)))
        assertFalse(Vector2d(5,1).follows(Vector2d(3,3)))
        assertFalse(Vector2d(1,5).follows(Vector2d(3,3)))
    }
    @Test
    fun test_upperRight()
    {
        assertTrue(Vector2d(2,4).uppperRight(Vector2d(4,4)).isequals(Vector2d(4,4)))
        assertTrue(Vector2d(3,3).uppperRight(Vector2d(3,3)).isequals(Vector2d(3,3)))
        assertTrue(Vector2d(1,5).uppperRight(Vector2d(5,1)).isequals(Vector2d(5,5)))
        assertTrue(Vector2d(-1,-1).uppperRight(Vector2d(1,1)).isequals(Vector2d(1,1)))
    }
    @Test
    fun test_lowerLeft()
    {
        assertTrue(Vector2d(2,4).lowerLeft(Vector2d(4,4)).isequals(Vector2d(2,4)))
        assertTrue(Vector2d(3,3).lowerLeft(Vector2d(3,3)).isequals(Vector2d(3,3)))
        assertTrue(Vector2d(1,5).lowerLeft(Vector2d(5,1)).isequals(Vector2d(1,1)))
        assertTrue(Vector2d(-1,-1).lowerLeft(Vector2d(1,1)).isequals(Vector2d(-1,-1)))
    }
    @Test
    fun test_add()
    {
        assertTrue(Vector2d(2,4).add(Vector2d(4,4)).isequals(Vector2d(6,8)))
        assertTrue(Vector2d(3,3).add(Vector2d(3,3)).isequals(Vector2d(6,6)))
        assertTrue(Vector2d(1,5).add(Vector2d(5,1)).isequals(Vector2d(6,6)))
        assertTrue(Vector2d(-1,-1).add(Vector2d(1,1)).isequals(Vector2d(0,0)))
    }
    @Test
    fun test_subtract()
    {
        assertTrue(Vector2d(2,4).subtract(Vector2d(4,4)).isequals(Vector2d(-2,0)))
        assertTrue(Vector2d(3,3).subtract(Vector2d(3,3)).isequals(Vector2d(0,0)))
        assertTrue(Vector2d(1,5).subtract(Vector2d(5,1)).isequals(Vector2d(-4,4)))
        assertTrue(Vector2d(-1,-1).subtract(Vector2d(1,1)).isequals(Vector2d(-2,-2)))
    }
    @Test
    fun test_opposite()
    {
        assertTrue(Vector2d(2,4).opposite().isequals(Vector2d(-2,-4)))
        assertTrue(Vector2d(3,3).opposite().isequals(Vector2d(-3,-3)))
        assertTrue(Vector2d(1,5).opposite().isequals(Vector2d(-1,-5)))
        assertTrue(Vector2d(-1,-1).opposite().isequals(Vector2d(1,1)))
    }
}