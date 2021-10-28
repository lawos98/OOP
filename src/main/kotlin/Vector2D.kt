class Vector2d constructor(val x :Int, val y: Int){
    fun convertToString() :String {
        return "($x,$y)"
    }
    fun precedes(u: Vector2d) :Boolean {
        if (x <= u.x && y <= u.y) {
            return true
        }
        return false
    }
    fun follows(u: Vector2d) :Boolean {
        if (x >= u.x && y >= u.y) {
            return true
        }
        return false
    }
    fun uppperRight(u: Vector2d) :Vector2d {
        return Vector2d(maxOf(x,u.x),maxOf(y,u.y))
    }
    fun lowerLeft(u: Vector2d) :Vector2d {
        return Vector2d(minOf(x,u.x), minOf(y,u.y))
    }
    fun add(u: Vector2d) :Vector2d {
        return Vector2d(x+u.x,y+u.y)
    }
    fun subtract(u: Vector2d) :Vector2d {
        return Vector2d(x-u.x,y-u.y)
    }
    fun isequals(u: Vector2d) :Boolean {
        if (x == u.x && y == u.y) {
            return true
        }
        return false
    }
    fun opposite() :Vector2d {
        return Vector2d(-x,-y)
    }
}