
class Animal(private var map: IWorldMap, position: Vector2d):IMapElement, AbstractWorldMapElement(position) {
    private var orientation: MapDirection = MapDirection.NORTH
    override fun toString(): String {
        return when (orientation) {
            MapDirection.NORTH -> ("⮝")
            MapDirection.WEST -> ("⮜")
            MapDirection.SOUTH -> ("⮟")
            MapDirection.EAST -> ("⮞")
        }
    }
    fun move(arg: MoveDirection) {
        when (arg) {
            MoveDirection.FORWARD -> {
                if (map.canMoveTo(position + orientation.toUnitVector())) {
                    map.changePosition(position,position + orientation.toUnitVector())
                    position += orientation.toUnitVector()
                }
            }
            MoveDirection.BACKWARD -> {
                if (map.canMoveTo(position - orientation.toUnitVector())) {
                    map.changePosition(position,position - orientation.toUnitVector())
                    position -= orientation.toUnitVector()
                }
            }
            MoveDirection.LEFT -> orientation = orientation.previous()
            MoveDirection.RIGHT -> orientation = orientation.next()

        }
    }
}