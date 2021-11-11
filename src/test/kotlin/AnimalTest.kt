import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class AnimalTest {
    fun makeSequence(animal: Animal, way:Array<MoveDirection>) {
        for(i in way){
            animal.move(i)
        }

    }
    @Test
    fun test1()
    {
        var kon= Animal()
        makeSequence(kon, OptionsParser().parse("fffffffffffffffff"))
        assertTrue(kon.isAt(Vector2d(2, 4), MapDirection.NORTH))
    }
    @Test
    fun test2()
    {
        var kon= Animal()
        makeSequence(kon, OptionsParser().parse("frflfrflfrflfrflfr"))
        println(kon.showPlace())
        assertTrue(kon.isAt(Vector2d(4, 4), MapDirection.EAST))
    }
    @Test
    fun test3()
    {
        var kon= Animal()
        makeSequence(kon, OptionsParser().parse("ffrffrffffrffffrffffrffrffrr"))
        println(kon.showPlace())
        assertTrue(kon.isAt(Vector2d(2, 2), MapDirection.NORTH))
    }
    @Test
    fun test4()
    {
        var kon= Animal()
        makeSequence(kon, OptionsParser().parse("bbrbbrbbbbrbbbbrbbbbrbbrbbrr"))
        println(kon.showPlace())
        assertTrue(kon.isAt(Vector2d(2, 2), MapDirection.NORTH))
    }
    @Test
    fun test5(){
        var kon= Animal()
        makeSequence(kon, OptionsParser().parse("frfrffrffrfffrfffrffffrffffrffff"))
        println(kon.showPlace())
        assertTrue(kon.isAt(Vector2d(0, 4), MapDirection.NORTH))
    }
    @Test
    fun test6(){
        var kon= Animal()
        makeSequence(kon, OptionsParser().parse("rrrrrrllll"))
        println(kon.showPlace())
        assertTrue(kon.isAt(Vector2d(2, 2), MapDirection.SOUTH))
    }
    @Test
    fun test7(){
        var kon= Animal()
        makeSequence(kon, OptionsParser().parse("foka"))
        println(kon.showPlace())
        assertTrue(kon.isAt(Vector2d(2, 3), MapDirection.NORTH))
    }
    @Test
    fun test8(){
        var kon= Animal()
        makeSequence(kon, OptionsParser().parse("programowanie_obiektowe"))
        println(kon.showPlace())
        assertTrue(kon.isAt(Vector2d(2, 3), MapDirection.SOUTH))
    }


}