enum class MapDirection() {
    NORTH {
        override fun convertTostring():String{
            return "Północ"
        }
        override fun next():MapDirection{
            return EAST
        }
        override fun previous():MapDirection{
            return WEST
        }
        override fun toUnitVector():Vector2d{
            return Vector2d(0,1)
        }
          },
    SOUTH{
        override fun convertTostring():String{
            return "Południe"
        }
        override fun next():MapDirection{
            return WEST
        }
        override fun previous():MapDirection{
            return EAST
        }
        override fun toUnitVector():Vector2d{
            return Vector2d(0,-1)
        }
    },
    WEST{
        override fun convertTostring():String{
            return "Zachód"
        }
        override fun next():MapDirection{
            return NORTH
        }
        override fun previous():MapDirection{
            return SOUTH
        }
        override fun toUnitVector():Vector2d{
            return Vector2d(-1,0)
        }
    },
    EAST{
        override fun convertTostring():String{
            return "Wschód"
        }
        override fun next():MapDirection{
            return SOUTH
        }
        override fun previous():MapDirection{
            return NORTH
        }
        override fun toUnitVector():Vector2d{
            return Vector2d(1,0)
        }
    };
    abstract fun convertTostring():String
    abstract fun next():MapDirection
    abstract fun previous():MapDirection
    abstract fun toUnitVector():Vector2d
}