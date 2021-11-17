//import org.junit.jupiter.api.Assertions.assertTrue
//import org.junit.jupiter.api.Test
//
//class AnimalTest {
//    fun makeSequence(animal: Animal, way:Array<MoveDirection>) {
//        for(i in way){
//            animal.move(i)
//        }
//
//    }
//    @Test
//    fun test1()
//    {
//        val kon= Animal()
//        makeSequence(kon, OptionsParser().parse("fffffffffffffffff"))
//        assertTrue(kon.isAt(Vector2d(2, 4), MapDirection.NORTH))
//    }
//    @Test
//    fun test2()
//    {
//        val kon= Animal()
//        makeSequence(kon, OptionsParser().parse("frflfrflfrflfrflfr"))
//        println(kon.toString())
//        assertTrue(kon.isAt(Vector2d(4, 4), MapDirection.EAST))
//    }
//    @Test
//    fun test3()
//    {
//        val kon= Animal()
//        makeSequence(kon, OptionsParser().parse("ffrffrffffrffffrffffrffrffrr"))
//        println(kon.toString())
//        assertTrue(kon.isAt(Vector2d(2, 2), MapDirection.NORTH))
//    }
//    @Test
//    fun test4()
//    {
//        val kon= Animal()
//        makeSequence(kon, OptionsParser().parse("bbrbbrbbbbrbbbbrbbbbrbbrbbrr"))
//        println(kon.toString())
//        assertTrue(kon.isAt(Vector2d(2, 2), MapDirection.NORTH))
//    }
//    @Test
//    fun test5(){
//        val kon= Animal()
//        makeSequence(kon, OptionsParser().parse("frfrffrffrfffrfffrffffrffffrffff"))
//        println(kon.toString())
//        assertTrue(kon.isAt(Vector2d(0, 4), MapDirection.NORTH))
//    }
//    @Test
//    fun test6(){
//        val kon= Animal()
//        makeSequence(kon, OptionsParser().parse("rrrrrrllll"))
//        println(kon.toString())
//        assertTrue(kon.isAt(Vector2d(2, 2), MapDirection.SOUTH))
//    }
//    @Test
//    fun test7(){
//        val kon= Animal()
//        makeSequence(kon, OptionsParser().parse("foka"))
//        println(kon.toString())
//        assertTrue(kon.isAt(Vector2d(2, 3), MapDirection.NORTH))
//    }
//    @Test
//    fun test8(){
//        val kon= Animal()
//        makeSequence(kon, OptionsParser().parse("programowanie_obiektowe"))
//        println(kon.toString())
//        assertTrue(kon.isAt(Vector2d(2, 3), MapDirection.SOUTH))
//    }
//
//
//}