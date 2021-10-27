import java.lang.NullPointerException

class Vector2d constructor(val x :Int, val y: Int){
    fun convertToString() :String {
        return "($x,$y)"
    }
    fun precedes(u: Vector2d) :Boolean
    {
        if (x <= u.x && y <= u.y)
        {
            return true
        }
        return false
    }
    fun follows(u: Vector2d) :Boolean
    {
        if (x >= u.x && y >= u.y)
        {
            return true
        }
        return false
    }
    fun uppperRight(u: Vector2d) :Vector2d
    {
        return Vector2d(maxOf(x,u.x),maxOf(y,u.y))
    }
    fun lowerLeft(u: Vector2d) :Vector2d
    {
        return Vector2d(minOf(x,u.x), minOf(y,u.y))
    }
    fun add(u: Vector2d) :Vector2d
    {
        return Vector2d(x+u.x,y+u.y)
    }
    fun subtract(u: Vector2d) :Vector2d
    {
        return Vector2d(x-u.x,y-u.y)
    }
    fun equals(u: Vector2d) :Boolean
    {
        if (x == u.x && y == u.y)
        {
            return true
        }
        return false
    }
    fun opposite() :Vector2d
    {
        return Vector2d(-x,-y)
    }
}
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

fun main(args: Array<String>) {
    println("Start!")
    val v1=Vector2d(1 ,2)
    println(v1.convertToString())
    val v2=Vector2d(-2,1)
    println(v2.convertToString())
    println(v1.add(v2).convertToString())
    run("ff gg bb rr flrb")


}
