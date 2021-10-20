fun run(direction: String){
    for (i in direction) {
        when (i) {
            'f' -> println("zwierzak idzie do przodu")
            'b' -> println("zwierzak idzie do tyłu")
            'r' -> println("zwierzak skręca w prawo")
            'l' -> println("zwierzak skręca w lewo")
        }
    }
}

fun main(args: Array<String>) {
    println("Start")
    var path= readLine().toString()
    run(path)
    println("Stop")
}
