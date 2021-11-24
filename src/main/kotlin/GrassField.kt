import java.util.*
import kotlin.math.sqrt
import kotlin.random.Random

class GrassField(countGrass:Int) :IWorldMap,AbstractWorldMap(){
    private var grassList = placeGrass(countGrass)

    private fun placeGrass(countGrass: Int):LinkedList<Grass> {
        fun checkGrass(grassList:LinkedList<Grass>,position: Vector2d): Boolean {
            for (grassBlock: Grass in grassList) {
                if (grassBlock.getPositon()==position) return false
            }
            return true
        }

        val grassList = LinkedList<Grass>()
        var count =0
        var x:Int
        var y:Int
        var rangeX:Int
        var rangeY:Int
        while (count<countGrass){
            rangeX=sqrt(20*countGrass.toDouble()).toInt()
            x= Random.nextInt(-rangeX,rangeX)
            rangeY=sqrt((20*countGrass-x*x).toDouble()).toInt()
            if(rangeY==0)continue
            y= Random.nextInt(-rangeY,rangeY)
            if (checkGrass(grassList,Vector2d(x,y))){
                count+=1
                grassList.addLast(Grass(Vector2d(x,y)))
            }
        }
        return grassList

    }

    override fun canMoveTo(position: Vector2d): Boolean {
        if (isOccupied(position)) return false
        return checkNear(position)
    }

    override fun objectAt(position: Vector2d): Any? {
        for (creature: Animal in animalList) {
            if (creature.isAt(position)) return creature
        }
        for (grassBlock: Grass in grassList) {
            if (grassBlock.getPositon()==position) return grassBlock
        }
        return null
    }

    override fun toString():String{
        var (vectorMin,vectorMax)=edgesAnimals()
        for(grassBlock:Grass in grassList){
            vectorMin=vectorMin.lowerLeft(grassBlock.getPositon())
            vectorMax=vectorMax.upperRight(grassBlock.getPositon())
        }
        return MapVisualizer(this).draw(vectorMin,vectorMax)
    }
}