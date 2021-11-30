abstract class AbstractWorldMap:IWorldMap {
    var fieldList=HashMap<Vector2d,Field>()

    override fun printList(){
        for(key in fieldList.keys) {
            print(key.x)
            print(" ")
            print(key.y)
            print(" zwierze: ")
            print(fieldList[key]!!.isItAnimal())
            print(" trawa: ")
            println(fieldList[key]!!.isItGrass())
        }
    }
    override fun place(animal: Animal): Boolean {
        val vAnimal=animal.getPositon()
        if (fieldList.containsKey(vAnimal)){
            return if(fieldList[vAnimal]!!.isItAnimal()) {
                false
            } else{
                if(fieldList[vAnimal]!!.isItGrass()){
                    fieldList[vAnimal]!!.removeGrass()
                }
                fieldList[vAnimal]!!.placeAnimal(animal)
                true
            }
        }
        else{
            val cell=Field()
            cell.placeAnimal(animal)
            fieldList[vAnimal] = cell
            return true
        }
    }

    override fun objectAt(position: Vector2d): Any? {
        if (fieldList.containsKey((position))){
            if(fieldList[position]!!.isItAnimal()){
                return fieldList[position]!!.getAnimal()
            }
            return fieldList[position]!!.getGrass()
        }
        return null
    }

    override fun isOccupied(position: Vector2d): Boolean {
        if(fieldList.containsKey(position)){
            return fieldList[position]!!.isItAnimal()
        }
        return false
    }
    override fun changePosition(start:Vector2d, end:Vector2d){
        val creature=fieldList[start]!!.getAnimal()
        fieldList[start]?.moveAnimal()
        println(creature?.getPositon().toString())
        if(!fieldList[start]!!.isItGrass()) {
            fieldList.remove(start)
        }
        if(fieldList.containsKey(end)){
            if (creature != null) {
                fieldList[end]!!.placeAnimal(creature)
            }
            if(fieldList[end]!!.isItGrass()){
                fieldList[end]!!.removeGrass()
                generateGrass(1)
            }
        }
        else {
            val cell = Field()
            if (creature != null) {
                cell.placeAnimal(creature)
            }
            fieldList[end] = cell
        }
    }

    override fun animals(): List<Animal> {
        val tab= arrayListOf<Animal>()
        for (key in fieldList.keys){
            if(fieldList[key]!!.isItAnimal()){
                fieldList[key]?.getAnimal()?.let { tab.add(it) }
            }
        }
        return tab
    }
}