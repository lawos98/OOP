
fun toString(arg:MoveDirection):String{
    when (arg) {
        MoveDirection.FORWARD -> return "zwierzak idzie do przodu"
        MoveDirection.BACKWARD -> return "zwierzak idzie do tyłu"
        MoveDirection.RIGHT -> return "zwierzak skręca w prawo"
        MoveDirection.LEFT -> return "zwierzak skręca w lewo"
    }
}
fun main(args: Array<String>) {
//    var kon=Animal()
//    var way:Array<MoveDirection> =OptionsParser().parse("frf")
//    println(way.size)
//    for (i in way)
//    {
//        kon.move(i)
//        print(kon.showPlace())
//        println(convertToString(i))
//    }
}
