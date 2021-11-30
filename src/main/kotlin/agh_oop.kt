import java.util.HashMap

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
    val directions=OptionsParser().parse("ffffffffffffffffffffffff")
    val map:IWorldMap=RectangularMap(10,5)
    val positions= arrayOf(Vector2d(2,0),Vector2d(3,0),Vector2d(0,0),Vector2d(10,0))
    val engine:IEngine =SimulationEngine(directions,map,positions)
    engine.run()

}
