enum class MapDirection() {
    NORTH,
    SOUTH,
    WEST,
    EAST;
    fun convertTostring(obj: MapDirection):String
    {
        when (obj) {
            NORTH -> return "Północ"
            SOUTH -> return "Południe"
            WEST  -> return "Zachód"
            EAST -> return "Wschód"
        }
    }
    fun next(obj: MapDirection):MapDirection
    {
        when (obj) {
            NORTH -> return EAST
            SOUTH -> return WEST
            WEST  -> return NORTH
            EAST -> return SOUTH
        }
    }
    fun previous(obj: MapDirection):MapDirection
    {
        when (obj) {
            NORTH -> return WEST
            SOUTH -> return EAST
            WEST  -> return SOUTH
            EAST -> return NORTH
        }
    }
    fun toUnitVector(obj: MapDirection):Vector2d
    {
        when (obj) {
            NORTH -> return Vector2d(0,1)
            SOUTH -> return Vector2d(0,-1)
            WEST  -> return Vector2d(-1,0)
            EAST -> return Vector2d(1,0)
        }
    }
}