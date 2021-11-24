
class RectangularMap(private var width: Int, private var height: Int):IWorldMap,AbstractWorldMap() {

    override fun canMoveTo(position: Vector2d): Boolean {
        if (!(position.follows(Vector2d(0, 0)) && position.precedes(Vector2d(width, height))) || isOccupied(position)) return false
        return checkNear(position)
    }

    override fun objectAt(position: Vector2d): Any? {
        for (creature: Animal in animalList) {
            if (creature.isAt(position)) return creature
        }
        return null
    }
    override fun toString():String{
        return MapVisualizer(this).draw(Vector2d(0,0),Vector2d(width,height))
    }
}

