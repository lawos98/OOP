import java.lang.Double.NEGATIVE_INFINITY
import java.lang.Double.POSITIVE_INFINITY
import kotlin.math.sqrt
import kotlin.random.Random

class GrassField :IWorldMap,AbstractWorldMap(){
    override fun generateGrass(countGrass: Int){
        var count=0
        var x:Int
        var y:Int
        var rangeX:Int
        var rangeY:Int
        var cell:Field
        while (count<countGrass){
            rangeX=sqrt(20*countGrass.toDouble()).toInt()
            x= Random.nextInt(-rangeX,rangeX)
            rangeY=sqrt((20*countGrass-x*x).toDouble()).toInt()
            y = if(rangeY==0){
                0
            } else{
                Random.nextInt(-rangeY,rangeY)
            }
            if (fieldList.containsKey(Vector2d(x,y))){
                if(fieldList[Vector2d(x,y)]!!.isItGrass()){
                    continue
                }
                else{
                    count+=1
                    fieldList[Vector2d(x,y)]!!.placeGrass(Grass(Vector2d(x,y)))
                }
            }
            else{
                count+=1
                cell=Field()
                cell.placeGrass(Grass(Vector2d(x,y)))
                fieldList[Vector2d(x,y)] = cell
            }
        }
    }
    override fun canMoveTo(position: Vector2d): Boolean {
        if(isOccupied(position))return false
        return isOccupied(position+Vector2d(0,1))
                ||isOccupied(position+Vector2d(1,0))
                ||isOccupied(position+Vector2d(-1,0))
                ||isOccupied(position+Vector2d(0,-1))
        }

    override fun toString():String{
        var vectorMin=Vector2d(POSITIVE_INFINITY.toInt(),POSITIVE_INFINITY.toInt())
        var vectorMax=Vector2d(NEGATIVE_INFINITY.toInt(),NEGATIVE_INFINITY.toInt())
        for(key in fieldList.keys){
            vectorMin=vectorMin.lowerLeft(key)
            vectorMax=vectorMax.upperRight(key)
        }
        return MapVisualizer(this).draw(vectorMin,vectorMax)
    }
}