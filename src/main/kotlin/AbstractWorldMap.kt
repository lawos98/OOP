import java.util.*
import java.util.concurrent.ConcurrentHashMap
import kotlin.collections.HashMap

abstract class AbstractWorldMap:IWorldMap,IPositionChangeObserver{
    override var fieldList=ConcurrentHashMap<Vector2d,Field>()
    val listXMin=PriorityQueue(ComparatorXMin)
    val listXMax=PriorityQueue(ComparatorXMax)
    val listYMax=PriorityQueue(ComparatorYMin)
    val listYMin=PriorityQueue(ComparatorYMax)

    override fun addToBoundary(v:Vector2d){
        listXMin.add(v)
        listXMax.add(v)
        listYMin.add(v)
        listYMax.add(v)
    }
    override fun changeBoundary(start:Vector2d,end:Vector2d){
        removeBoundary(start)
        addToBoundary(end)
    }

    override fun removeBoundary(v: Vector2d) {
        listXMin.remove(v)
        listXMax.remove(v)
        listYMin.remove(v)
        listYMax.remove(v)
    }

    override fun leftCorner():Vector2d{
        return Vector2d(listXMin.peek().x,listYMin.peek().y)
    }
    override fun rightCorner():Vector2d {
        return Vector2d(listXMax.peek().x,listYMax.peek().y)
    }

    override fun place(animal: Animal){
        val vAnimal=animal.getPositon()
        if (fieldList.containsKey(vAnimal)){
            val field = fieldList[vAnimal]
            if(field != null) {
                if(field.isItAnimal()) {
                    throw IllegalArgumentException(vAnimal.toString() + "at position can't place animal")
                } else {
                    if (field.isItGrass()){
                        this.removeBoundary(animal.getPositon())
                        field.removeGrass()
                    }
                    field.placeAnimal(animal)
                    this.addToBoundary(animal.getPositon())
                }
            }
        }
        val cell=Field()
        cell.placeAnimal(animal)
        fieldList[vAnimal] = cell
        this.addToBoundary(animal.getPositon())
    }

    override fun objectAt(position: Vector2d): Any? {
        if (fieldList.containsKey((position))) {
            val field = fieldList[position]
            if (field != null) {
                if (field.isItAnimal()) return field.getAnimal()
                return field.getGrass()
            }
        }
        return null
    }

    override fun isOccupied(position: Vector2d): Boolean {
        if(fieldList.containsKey(position)){
            val field=fieldList[position]
            if(field!=null){
                return field.isItAnimal()
            }
        }
        return false
    }
    override fun changePosition(start:Vector2d, end:Vector2d) {
        if (fieldList.containsKey(start)){
            val fieldStart=fieldList[start]
            if (fieldStart!=null) {
                val creature=fieldStart.moveAnimal()
                if (!fieldStart.isItGrass()) {
                    fieldList.remove(start)
                }
                if (fieldList.containsKey(end)) {
                    val fieldEnd=fieldList[end]
                    if(fieldEnd!=null){
                        if (creature != null) {
                            fieldEnd.placeAnimal(creature)
                            this.changeBoundary(start,end)
                        }
                        if(fieldEnd.isItGrass()){
                            fieldEnd.removeGrass()
                            generateGrass(1)
                        }
                    }
                }
                else {
                    val cell = Field()
                    if (creature != null) {
                        cell.placeAnimal(creature)
                    }
                    fieldList[end] = cell
                    this.addToBoundary(start)
                }
            }
        }
        }

    override fun animals(): List<Animal> {
        fun checkAnimal(any: Any?):Animal?{
            if(fieldList.containsKey(any)) {
                val field = fieldList[any]
                if(field!=null){
                    if(field.isItAnimal())
                        return field.getAnimal()
                }
            }
            return null
        }
        val tab= arrayListOf<Animal>()
        var animalToAdd: Animal?
        for (key in fieldList.keys){
            animalToAdd=checkAnimal(key)
            if(animalToAdd!=null){
                tab.add(animalToAdd)
            }
        }
        return tab
    }
}