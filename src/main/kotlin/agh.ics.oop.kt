
fun convert(arg: Char):String {
    when (arg) {
        'f' -> return "FORWARD"
        'b' -> return "BACKWARD"
        'r' -> return "RIGHT"
        else -> return "LEFT"
    }
}

fun run(path: String) {
    for (i in path) {
        if (i == 'f' || i == 'b' || i == 'r' || i == 'l') {
            val value = MoveDirection.valueOf(convert(i))
            when (value) {
                MoveDirection.FORWARD -> println("zwierzak idzie do przodu")
                MoveDirection.BACKWARD -> println("zwierzak idzie do tyłu")
                MoveDirection.RIGHT -> println("zwierzak skręca w prawo")
                MoveDirection.LEFT -> println("zwierzak skręca w lewo")
            }
        }
    }
}
fun main(args:String) {
    println("Start!")
    run(args)


}
