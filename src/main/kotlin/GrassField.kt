import java.util.*
import kotlin.math.sqrt
import kotlin.random.Random

class GrassField(countGrass:Int) :IWorldMap,AbstractWorldMap(){
    private var grassList = generateGrassField(countGrass)

//    fun removeGrass(position: Vector2d){
//        var i:Int=0
//        for (grassBlock: Grass in grassList) {
//            if (grassBlock.getPosition()==position){
//                grassList.removeAt(i)
//            }
//            i+=1
//        }
//    }
//
//    fun placeGrass(){
//        var x:Int
//        var y:Int
//        var rangeX:Int
//        var rangeY:Int
//        while(true){
//            rangeX=sqrt(20*countGrass.toDouble()).toInt()
//            x= Random.nextInt(-rangeX,rangeX)
//            rangeY=sqrt((20*countGrass-x*x).toDouble()).toInt()
//            if(rangeY==0)continue
//            y= Random.nextInt(-rangeY,rangeY)
//            if (objectAt(Vector2d(x,y))==null){
//                grassList.addLast(Grass(Vector2d(x,y)))
//                return
//            }
//        }
//    }

    private fun generateGrassField(countGrass: Int):LinkedList<Grass> {
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
            if(rangeY==0){
                y=0
            }
            else{
                y= Random.nextInt(-rangeY,rangeY)
            }
            if (checkGrass(grassList,Vector2d(x,y))){
                count+=1
                grassList.addLast(Grass(Vector2d(x,y)))
            }
        }
        return grassList
    }

    override fun canMoveTo(position: Vector2d): Boolean {
        if (isOccupied(position)) return false
        if(checkNear(position)){
//            if(grassList.size>0){
////                removeGrass(position)
////                placeGrass()
//            }
            return true
        }
        return false
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
        val (vectorMinAnimal,vectorMaxAnimal)=edgesMapAnimal(animalList)
        val (vectorMinGrass,vectorMaxGrass)=edgesMapGrass(grassList)
        val vectorMin=vectorMinAnimal.lowerLeft(vectorMinGrass)
        val vectorMax=vectorMaxAnimal.upperRight(vectorMaxGrass)
        return MapVisualizer(this).draw(vectorMin,vectorMax)
    }
}