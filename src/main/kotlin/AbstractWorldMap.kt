import kotlin.Double.Companion.POSITIVE_INFINITY
import kotlin.Double.Companion.NEGATIVE_INFINITY
import java.util.*

abstract class AbstractWorldMap:IWorldMap {
    protected var animalList = LinkedList<Animal>()

    override fun place(animal: Animal): Boolean {
        for (creature: Animal in animalList) {
            if (animal.isAtAnimal(creature)) {
                return false
            }
        }
        animalList.addLast(animal)
        return true
    }
    override fun isOccupied(position: Vector2d): Boolean {
        for (creature: Animal in animalList) {
            if (creature.isAt(position)) return true
        }
        return false
    }
    override fun animals(): List<Animal> {
        val tab= arrayListOf<Animal>()
        for (creature: Animal in animalList){
            tab.add(creature)
        }
        return tab
    }
    fun checkNear(position: Vector2d):Boolean{
        for(creature: Animal in animalList) {
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
    fun edgesAnimals():Array<Vector2d>{
        var vectorMin=Vector2d(POSITIVE_INFINITY.toInt(),POSITIVE_INFINITY.toInt())
        var vectorMax=Vector2d(NEGATIVE_INFINITY.toInt(),NEGATIVE_INFINITY.toInt())
        for(creature:Animal in animalList){
            vectorMin=vectorMin.lowerLeft(creature.position)
            vectorMax=vectorMax.upperRight(creature.position
            )
        }
        return arrayOf(vectorMin,vectorMax)
    }
}