

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MapDirectionTest {
    @Test
    fun test_next()
    {
        assertEquals(MapDirection.NORTH.next(), MapDirection.EAST)
        assertEquals(MapDirection.SOUTH.next(), MapDirection.WEST)
        assertEquals(MapDirection.WEST.next(), MapDirection.NORTH)
        assertEquals(MapDirection.EAST.next(), MapDirection.SOUTH)
    }
    @Test
    fun test_previous()
    {
        assertEquals(MapDirection.NORTH.previous(), MapDirection.WEST)
        assertEquals(MapDirection.SOUTH.previous(), MapDirection.EAST)
        assertEquals(MapDirection.WEST.previous(), MapDirection.SOUTH)
        assertEquals(MapDirection.EAST.previous(), MapDirection.NORTH)
    }
}