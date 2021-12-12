import java.io.FileInputStream

class Animal(private var map: IWorldMap, position: Vector2d):IMapElement, AbstractWorldMapElement(position) {
    private var orientation: MapDirection = MapDirection.NORTH
    private var observers= mutableListOf<IPositionChangeObserver>()

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
    fun addObserver(Observer:IPositionChangeObserver){
        observers.add(Observer)
    }
    fun removeObserver(Observer:IPositionChangeObserver){
        observers.remove(Observer)
    }
    fun notifyObservers(start:Vector2d,end:Vector2d){
        for(obs in observers){
            obs.changePosition(start,end)
        }
    }

    override fun getPath(): FileInputStream {
        when(orientation){
            MapDirection.NORTH -> return FileInputStream("src/main/kotlin/Resource/up.png")
            MapDirection.SOUTH -> return FileInputStream("src/main/kotlin/Resource/down.png")
            MapDirection.EAST -> return FileInputStream("src/main/kotlin/Resource/right.png")
            MapDirection.WEST -> return FileInputStream("src/main/kotlin/Resource/left.png")
        }
    }
}