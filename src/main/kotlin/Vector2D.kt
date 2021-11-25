
class Vector2d (var x :Int, var y: Int){
    override fun toString() :String {
        return "($x,$y)"
    }
    fun precedes(u: Vector2d) :Boolean {
        return x <= u.x && y <= u.y
    }
    fun follows(u: Vector2d) :Boolean {
        return x >= u.x && y >= u.y
    }
    fun upperRight(u: Vector2d) :Vector2d {
        return Vector2d(maxOf(x,u.x),maxOf(y,u.y))
    }
    fun lowerLeft(u: Vector2d) :Vector2d {
        return Vector2d(minOf(x,u.x), minOf(y,u.y))
    }
    operator fun plus(u: Vector2d) :Vector2d {
        return Vector2d(x+u.x,y+u.y)
    }
    operator fun minus(u: Vector2d) :Vector2d {
        return Vector2d(x-u.x,y-u.y)
    }
    override operator fun equals(other: Any?): Boolean {
        if(other !is Vector2d)
            return false
        return x == other.x && y == other.y
    }
    fun opposite() :Vector2d {
        return Vector2d(-x,-y)
    }

    override fun hashCode(): Int {
        var result = x
        result = 31 * result + y
        return result
    }
}