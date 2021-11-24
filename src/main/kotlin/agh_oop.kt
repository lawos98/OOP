import kotlin.math.sqrt

//
//fun toString(arg:MoveDirection):String{
//    when (arg) {
//        MoveDirection.FORWARD -> return "zwierzak idzie do przodu"
//        MoveDirection.BACKWARD -> return "zwierzak idzie do tyłu"
//        MoveDirection.RIGHT -> return "zwierzak skręca w prawo"
//        MoveDirection.LEFT -> return "zwierzak skręca w lewo"
//    }
//}
fun main(args: Array<String>) {
    val directions=OptionsParser().parse(args.joinToString())
    val map:IWorldMap=GrassField(5)
    val positions= arrayOf(Vector2d(2,2),Vector2d(3,4))
    val engine:IEngine =SimulationEngine(directions,map,positions)
    engine.run()
    println(map.toString())
}
