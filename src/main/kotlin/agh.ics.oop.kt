fun run(path: String){
    for (i in path){
        if(!(i.isWhitespace())) {
            val value = Direction.valueOf(i.toString())
            when (value) {
                Direction.f -> println("zwierzak idzie do przodu")
                Direction.b -> println("zwierzak idzie do tyłu")
                Direction.r -> println("zwierzak skręca w prawo")
                Direction.l -> println("zwierzak skręca w lewo")
            }
        }
    }
}

fun main(args: Array<String>) {
    println("Start")
    val path= readLine().toString()
    run(path)
    println("Stop")
}
