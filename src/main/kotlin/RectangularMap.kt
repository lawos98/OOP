import java.util.LinkedList

class RectangularMap(var width: Int, var height: Int) : IWorldMap {
    private var animalList = LinkedList<Animal>()

    override fun canMoveTo(position: Vector2d): Boolean {
        if (!(position.follows(Vector2d(0, 0)) && position.precedes(Vector2d(width, height))) || isOccupied(position)) return false
        for (creature: Animal in animalList) {
            if (creature.isAt(position + Vector2d(0, 1)) ||
                creature.isAt(position + Vector2d(1, 0)) ||
                creature.isAt(position + Vector2d(0, -1)) ||
                creature.isAt(position + Vector2d(-1, 0))
            ) {
                return true
            }
        }
        return false
    }

    override fun place(animal: Animal): Boolean {
        for (creature: Animal in animalList) {
            if (animal.isAtAnimal(creature)) {
                return false
            }
        }
        animalList.add(animal)
        return true
    }

    override fun isOccupied(position: Vector2d): Boolean {
        for (creature: Animal in animalList) {
            if (creature.isAt(position)) return true
        }
        return false
    }

    override fun objectAt(position: Vector2d): Any? {
        for (creature: Animal in animalList) {
            if (creature.isAt(position)) return creature
        }
        return null
    }

    override fun animals(): List<Animal> {
        val tab: List<Animal> = emptyList()
        for (creature: Animal in animalList){
            tab.plus(creature)
        }
        return tab
    }
}

