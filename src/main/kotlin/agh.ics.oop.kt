class Vector2d constructor(x :Int ,y: Int){
    var pos_1: Int =x
    var pos_2: Int =y
    fun toString(v: Vector2d)
    {
        val value: String ="("+v.pos_1.toString()+","+v.pos_2.toString()+")"
    }
}

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
    println("Start!")
    var v1: Vector2d(2,4)

}
