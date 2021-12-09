import org.junit.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class EngineTest {

    @Test
    fun test1()
    {
        try{
        val directions=OptionsParser().DoIT("fbrlffrrffffffff")
        val map:IWorldMap=RectangularMap(10,5)
        val positions= arrayOf(Vector2d(2,2),Vector2d(3,4))
        val engine:IEngine =SimulationEngine(directions,map,positions)
        engine.run()
        println(map.toString())
        assertTrue(map.isOccupied(Vector2d(2,0)))
        assertTrue(map.canMoveTo(Vector2d(2,1)))
        assertTrue(map.isOccupied(Vector2d(3,5)))
        assertTrue(map.canMoveTo(Vector2d(4,5)))
        }
        catch (exception:IllegalArgumentException){
            println("Error")
            println(exception.message)
        }
    }
    @Test
    fun test2()
    {
        try{
        val directions=OptionsParser().DoIT("fffrrrfffrrrfffrrr")
        val map:IWorldMap=RectangularMap(10,5)
        val positions= arrayOf(Vector2d(2,2),Vector2d(3,4),Vector2d(0,0))
        val engine:IEngine =SimulationEngine(directions,map,positions)
        engine.run()
        println(map.toString())
        assertTrue(map.isOccupied(Vector2d(1,0)))
        assertTrue(map.canMoveTo(Vector2d(0,0)))
        assertTrue(map.isOccupied(Vector2d(3,2)))
        assertTrue(map.canMoveTo(Vector2d(3,3)))
        assertTrue(map.isOccupied(Vector2d(4,4)))
        assertFalse(map.canMoveTo(Vector2d(5,5)))
        }
        catch (exception:IllegalArgumentException){
            println("Error")
            println(exception.message)
        }
    }
    @Test
    fun test3()
    {
        try{
        val directions=OptionsParser().DoIT("fbrlbfrlbfrblfrlblfrlblrb")
        val map:IWorldMap=RectangularMap(10,5)
        val positions= arrayOf(Vector2d(2,2),Vector2d(3,4),Vector2d(0,0),Vector2d(10,5))
        val engine:IEngine =SimulationEngine(directions,map,positions)
        engine.run()
        println(map.toString())
        assertTrue(map.isOccupied(Vector2d(1,3)))
        assertTrue(map.canMoveTo(Vector2d(0,3)))
        assertTrue(map.isOccupied(Vector2d(3,5)))
        assertTrue(map.isOccupied(Vector2d(3,2)))
        assertTrue(map.isOccupied(Vector2d(10,5)))
        assertFalse(map.canMoveTo(Vector2d(11,5)))
        assertFalse(map.canMoveTo(Vector2d(20,20)))
        }
        catch (exception:IllegalArgumentException){
            println("Error")
            println(exception.message)
        }
    }
    @Test
    fun test4()
    {
        try{
        val directions=OptionsParser().DoIT("fbrlbrlb")
        val map:IWorldMap=RectangularMap(10,10)
        val positions= arrayOf(Vector2d(2,2))
        val engine:IEngine =SimulationEngine(directions,map,positions)
        engine.run()
        println(map.toString())
        assertTrue(map.isOccupied(Vector2d(2,0)))
        assertTrue(map.canMoveTo(Vector2d(2,1)))
        assertFalse(map.canMoveTo(Vector2d(2,-1)))
        assertFalse(map.canMoveTo(Vector2d(2,2)))
        }
        catch (exception:IllegalArgumentException){
            println("Error")
            println(exception.message)
        }
    }
    @Test
    fun test5()
    {
        try{
        val directions=OptionsParser().DoIT("fbrlbrlbflrflrlfrlflrffrlfrlflrlffrlflrflrlflrrrffllflflrfr")
        val map:IWorldMap=RectangularMap(15,15)
        val positions= arrayOf(Vector2d(2,2),Vector2d(5,2),Vector2d(8,12),Vector2d(15,3),Vector2d(3,13),Vector2d(11,11),Vector2d(5,10))
        val engine:IEngine =SimulationEngine(directions,map,positions)
        engine.run()
        println(map.toString())
        assertTrue(map.isOccupied(Vector2d(1,2)))
        assertTrue(map.canMoveTo(Vector2d(1,1)))
        assertTrue(map.isOccupied(Vector2d(9,12)))
        assertTrue(map.canMoveTo(Vector2d(10,12)))
        assertTrue(map.isOccupied(Vector2d(8,12)))
        assertTrue(map.canMoveTo(Vector2d(7,12)))
        assertTrue(map.isOccupied(Vector2d(14,3)))
        assertTrue(map.canMoveTo(Vector2d(15,3)))
        assertTrue(map.isOccupied(Vector2d(5,14)))
        assertTrue(map.canMoveTo(Vector2d(5,15)))
        assertTrue(map.isOccupied(Vector2d(5,1)))
        assertTrue(map.canMoveTo(Vector2d(5,2)))
        assertTrue(map.isOccupied(Vector2d(3,15)))
        assertTrue(map.canMoveTo(Vector2d(3,14)))
        assertFalse(map.canMoveTo(Vector2d(-3,-3)))
        }
        catch (exception:IllegalArgumentException){
            println("Error")
            println(exception.message)
        }
    }
    @Test
    fun test1_Grass()
    {
        try{
        val directions=OptionsParser().DoIT("fbrlffrrffffffff")
        val map:IWorldMap=GrassField()
        map.generateGrass(10)
        val positions= arrayOf(Vector2d(2,2),Vector2d(3,4))
        val engine:IEngine =SimulationEngine(directions,map,positions)
        engine.run()
        println(map.toString())
        assertTrue(map.isOccupied(Vector2d(3,7)))
        assertTrue(map.canMoveTo(Vector2d(2,0)))
        assertTrue(map.isOccupied(Vector2d(2,-1)))
        assertTrue(map.canMoveTo(Vector2d(4,7)))
        assertFalse(map.canMoveTo(Vector2d(5,10)))
        }
        catch (exception:IllegalArgumentException){
            println("Error")
            println(exception.message)
        }
    }
    @Test
    fun test2_Grass()
    {
        try{
        val directions=OptionsParser().DoIT("fffrrrfffrrrfffrrr")
        val map:IWorldMap=GrassField()
        map.generateGrass(10)
        val positions= arrayOf(Vector2d(2,2),Vector2d(3,4),Vector2d(0,0))
        val engine:IEngine =SimulationEngine(directions,map,positions)
        engine.run()
        println(map.toString())
        assertTrue(map.isOccupied(Vector2d(1,0)))
        assertTrue(map.canMoveTo(Vector2d(0,0)))
        assertTrue(map.isOccupied(Vector2d(3,2)))
        assertTrue(map.canMoveTo(Vector2d(3,3)))
        assertTrue(map.isOccupied(Vector2d(4,4)))
        assertTrue(map.canMoveTo(Vector2d(4,5)))
        assertFalse(map.canMoveTo(Vector2d(5,10)))
        }
        catch (exception:IllegalArgumentException){
            println("Error")
            println(exception.message)
        }
    }
    @Test
    fun test3_Grass()
    {
        try{
        val directions=OptionsParser().DoIT("fbrlbfrlbfrblfrlblfrlblr")
        val map:IWorldMap=GrassField()
        map.generateGrass(10)
        val positions= arrayOf(Vector2d(2,2),Vector2d(3,4),Vector2d(0,0),Vector2d(10,5))
        val engine:IEngine =SimulationEngine(directions,map,positions)
        engine.run()
        assertTrue(map.isOccupied(Vector2d(1,2)))
        assertTrue(map.canMoveTo(Vector2d(2,2)))
        assertTrue(map.isOccupied(Vector2d(3,5)))
        assertTrue(map.canMoveTo(Vector2d(3,6)))
        assertTrue(map.isOccupied(Vector2d(3,1)))
        assertTrue(map.canMoveTo(Vector2d(3,0)))
        assertTrue(map.isOccupied(Vector2d(10,6)))
        assertTrue(map.canMoveTo(Vector2d(10,5)))
        assertFalse(map.canMoveTo(Vector2d(5,10)))
        }
        catch (exception:IllegalArgumentException){
            println("Error")
            println(exception.message)
        }
    }
    @Test
    fun test4_Grass()
    {
        try{
        val directions=OptionsParser().DoIT("fbrlbrlb")
        val map:IWorldMap=GrassField()
        map.generateGrass(10)
        val positions= arrayOf(Vector2d(2,2))
        val engine:IEngine =SimulationEngine(directions,map,positions)
        engine.run()
        println(map.toString())
        assertTrue(map.isOccupied(Vector2d(2,0)))
        assertTrue(map.canMoveTo(Vector2d(2,-1)))
        assertTrue(map.canMoveTo(Vector2d(2,1)))
        assertTrue(map.canMoveTo(Vector2d(1,0)))
        assertTrue(map.canMoveTo(Vector2d(3,0)))
        assertFalse(map.canMoveTo(Vector2d(5,10)))
        }
        catch (exception:IllegalArgumentException){
            println("Error")
            println(exception.message)
        }
    }
    @Test
    fun test5_Grass()
    {
        try{
        val directions=OptionsParser().DoIT("fbrlbrlbflrflrlfrlflrffrlfrlflrlffrlflrflrlflrrrffllflflrfr")
        val map:IWorldMap=GrassField()
        map.generateGrass(10)
        val positions= arrayOf(Vector2d(2,2),Vector2d(5,2),Vector2d(8,12),Vector2d(15,3),Vector2d(3,13),Vector2d(11,11),Vector2d(5,10))
        val engine:IEngine =SimulationEngine(directions,map,positions)
        engine.run()
        println(map.toString())
        assertTrue(map.isOccupied(Vector2d(1,2)))
        assertTrue(map.canMoveTo(Vector2d(2,2)))
        assertTrue(map.isOccupied(Vector2d(9,12)))
        assertTrue(map.canMoveTo(Vector2d(10,12)))
        assertTrue(map.isOccupied(Vector2d(8,12)))
        assertTrue(map.canMoveTo(Vector2d(8,13)))
        assertTrue(map.isOccupied(Vector2d(4,10)))
        assertTrue(map.canMoveTo(Vector2d(4,11)))
        assertTrue(map.isOccupied(Vector2d(3,17)))
        assertTrue(map.canMoveTo(Vector2d(3,18)))
        assertTrue(map.isOccupied(Vector2d(15,5)))
        assertTrue(map.canMoveTo(Vector2d(16,5)))
        assertTrue(map.isOccupied(Vector2d(5,1)))
        assertTrue(map.canMoveTo(Vector2d(5,2)))
        assertFalse(map.canMoveTo(Vector2d(25,10)))
        }
        catch (exception:IllegalArgumentException){
            println("Error")
            println(exception.message)
        }
    }
}