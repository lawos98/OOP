class Animal(var map: IWorldMap,initialPosition: Vector2d) {
    private var orientation: MapDirection = MapDirection.NORTH
    private var position: Vector2d = initialPosition
    override fun toString(): String {
        return when (orientation) {
            MapDirection.NORTH -> ("⮝")
            MapDirection.WEST -> ("⮜")
            MapDirection.SOUTH -> ("⮟")
            MapDirection.EAST -> ("⮞")
        }
    }

    fun isAt(arg: Vector2d): Boolean {
        return position == arg
    }

    fun isAtAnimal(creature: Animal): Boolean {
        return position == creature.position
    }

    fun move(arg: MoveDirection) {
        when (arg) {
            MoveDirection.FORWARD -> {
                if (map.canMoveTo(position + orientation.toUnitVector())) {
                    position += orientation.toUnitVector()
                }
            }
            MoveDirection.BACKWARD -> {
                if (map.canMoveTo(position - orientation.toUnitVector())) {
                    position -= orientation.toUnitVector()
                }
            }
            MoveDirection.LEFT -> orientation = orientation.previous()
            MoveDirection.RIGHT -> orientation = orientation.next()

        }
    }
}