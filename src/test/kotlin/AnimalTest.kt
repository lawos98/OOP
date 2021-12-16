//import org.junit.jupiter.api.Assertions.assertTrue
//import org.junit.jupiter.api.Test
//
//class AnimalTest {
//    fun makeSequence(animal: MapElements.Animal, way:Array<Utilities.MoveDirection>) {
//        for(i in way){
//            animal.move(i)
//        }
//
//    }
//    @Test
//    fun test1()
//    {
//        val kon= MapElements.Animal()
//        makeSequence(kon, Utilities.OptionsParser().parse("fffffffffffffffff"))
//        assertTrue(kon.isAt(Utilities.Vector2d(2, 4), Utilities.MapDirection.NORTH))
//    }
//    @Test
//    fun test2()
//    {
//        val kon= MapElements.Animal()
//        makeSequence(kon, Utilities.OptionsParser().parse("frflfrflfrflfrflfr"))
//        println(kon.toString())
//        assertTrue(kon.isAt(Utilities.Vector2d(4, 4), Utilities.MapDirection.EAST))
//    }
//    @Test
//    fun test3()
//    {
//        val kon= MapElements.Animal()
//        makeSequence(kon, Utilities.OptionsParser().parse("ffrffrffffrffffrffffrffrffrr"))
//        println(kon.toString())
//        assertTrue(kon.isAt(Utilities.Vector2d(2, 2), Utilities.MapDirection.NORTH))
//    }
//    @Test
//    fun test4()
//    {
//        val kon= MapElements.Animal()
//        makeSequence(kon, Utilities.OptionsParser().parse("bbrbbrbbbbrbbbbrbbbbrbbrbbrr"))
//        println(kon.toString())
//        assertTrue(kon.isAt(Utilities.Vector2d(2, 2), Utilities.MapDirection.NORTH))
//    }
//    @Test
//    fun test5(){
//        val kon= MapElements.Animal()
//        makeSequence(kon, Utilities.OptionsParser().parse("frfrffrffrfffrfffrffffrffffrffff"))
//        println(kon.toString())
//        assertTrue(kon.isAt(Utilities.Vector2d(0, 4), Utilities.MapDirection.NORTH))
//    }
//    @Test
//    fun test6(){
//        val kon= MapElements.Animal()
//        makeSequence(kon, Utilities.OptionsParser().parse("rrrrrrllll"))
//        println(kon.toString())
//        assertTrue(kon.isAt(Utilities.Vector2d(2, 2), Utilities.MapDirection.SOUTH))
//    }
//    @Test
//    fun test7(){
//        val kon= MapElements.Animal()
//        makeSequence(kon, Utilities.OptionsParser().parse("foka"))
//        println(kon.toString())
//        assertTrue(kon.isAt(Utilities.Vector2d(2, 3), Utilities.MapDirection.NORTH))
//    }
//    @Test
//    fun test8(){
//        val kon= MapElements.Animal()
//        makeSequence(kon, Utilities.OptionsParser().parse("programowanie_obiektowe"))
//        println(kon.toString())
//        assertTrue(kon.isAt(Utilities.Vector2d(2, 3), Utilities.MapDirection.SOUTH))
//    }
//
//
//}