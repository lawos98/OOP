import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class EngineTest {

    @Test
    fun test1()
    {
        val directions=OptionsParser().parse("fbrlffrrffffffff")
        val map:IWorldMap=RectangularMap(10,5)
        val positions= arrayOf(Vector2d(2,2),Vector2d(3,4))
        val engine:IEngine =SimulationEngine(directions,map,positions)
        engine.run()
        assertTrue(map.isOccupied(Vector2d(2,0)))
        assertTrue(map.isOccupied(Vector2d(3,5)))
    }
    @Test
    fun test2()
    {
        val directions=OptionsParser().parse("fffrrrfffrrrfffrrr")
        val map:IWorldMap=RectangularMap(10,5)
        val positions= arrayOf(Vector2d(2,2),Vector2d(3,4),Vector2d(0,0))
        val engine:IEngine =SimulationEngine(directions,map,positions)
        engine.run()
        assertTrue(map.isOccupied(Vector2d(1,0)))
        assertTrue(map.isOccupied(Vector2d(3,2)))
        assertTrue(map.isOccupied(Vector2d(4,4)))
    }
    @Test
    fun test3()
    {
        val directions=OptionsParser().parse("fbrlbfrlbfrblfrlblfrlblrb")
        val map:IWorldMap=RectangularMap(10,5)
        val positions= arrayOf(Vector2d(2,2),Vector2d(3,4),Vector2d(0,0),Vector2d(10,5))
        val engine:IEngine =SimulationEngine(directions,map,positions)
        engine.run()
        println(map.toString())
        assertTrue(map.isOccupied(Vector2d(0,1)))
        assertTrue(map.isOccupied(Vector2d(3,2)))
        assertTrue(map.isOccupied(Vector2d(4,5)))
        assertTrue(map.isOccupied(Vector2d(10,5)))
    }
    @Test
    fun test4()
    {
        val directions=OptionsParser().parse("fbrlbrlb")
        val map:IWorldMap=RectangularMap(10,10)
        val positions= arrayOf(Vector2d(2,2))
        val engine:IEngine =SimulationEngine(directions,map,positions)
        engine.run()
        println(map.toString())
        assertTrue(map.isOccupied(Vector2d(2,0)))
    }
    @Test
    fun test5()
    {
        val directions=OptionsParser().parse("fbrlbrlbflrflrlfrlflrffrlfrlflrlffrlflrflrlflrrrffllflflrfr")
        val map:IWorldMap=RectangularMap(15,15)
        val positions= arrayOf(Vector2d(2,2),Vector2d(5,2),Vector2d(8,12),Vector2d(15,3),Vector2d(3,13),Vector2d(11,11),Vector2d(5,10))
        val engine:IEngine =SimulationEngine(directions,map,positions)
        engine.run()
        println(map.toString())
        assertTrue(map.isOccupied(Vector2d(1,2)))
        assertTrue(map.isOccupied(Vector2d(3,3)))
        assertTrue(map.isOccupied(Vector2d(14,3)))
        assertTrue(map.isOccupied(Vector2d(5,9)))
        assertTrue(map.isOccupied(Vector2d(8,12)))
        assertTrue(map.isOccupied(Vector2d(11,13)))
        assertTrue(map.isOccupied(Vector2d(3,15)))
    }
}