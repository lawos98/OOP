class Animal() {
    private var Orientation: MapDirection =MapDirection.NORTH
    private var Position: Vector2d = Vector2d(2,2)
    fun showPlace():String
    {
        return Position.convertToString()
    }
    fun isAt(arg: Vector2d,or:MapDirection):Boolean {
        return Position==arg && or==Orientation
    }
    fun move(arg:MoveDirection)
    {
        when(arg)
        {
            MoveDirection.FORWARD -> {
                if((Position+Orientation.toUnitVector()).precedes(Vector2d(4,4)) && (Position+Orientation.toUnitVector()).follows(Vector2d(0,0))) {
                    Position = Position + Orientation.toUnitVector()
                }
            }
            MoveDirection.BACKWARD -> {
                if((Position-Orientation.toUnitVector()).precedes(Vector2d(4,4)) && (Position-Orientation.toUnitVector()).follows(Vector2d(0,0))) {
                    Position = Position - Orientation.toUnitVector()
                }
            }
            MoveDirection.LEFT -> Orientation=Orientation.previous()
            MoveDirection.RIGHT -> Orientation=Orientation.next()

        }

    }
}