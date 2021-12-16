package world

import worldElements.Field
import worldElements.Grass
import utilities.MapVisualizer
import utilities.Vector2d
import kotlin.math.sqrt
import kotlin.random.Random

class GrassField : AbstractWorldMap(){

    override fun generateGrass(countGrass: Int){
        var count=0
        var x:Int
        var y:Int
        var rangeX:Int
        var rangeY:Int
        var cell: Field
        while (count<countGrass){
            rangeX=sqrt(2*countGrass.toDouble()).toInt()
            x= Random.nextInt(-rangeX,rangeX)
            rangeY=sqrt((2*countGrass-x*x).toDouble()).toInt()
            y = if(rangeY==0){
                0
            } else{
                Random.nextInt(-rangeY,rangeY)
            }
            if (fieldList.containsKey(Vector2d(x, y))){
                if(fieldList[Vector2d(x, y)]!!.isItGrass()){
                    continue
                }
                else{
                    count+=1
                    fieldList[Vector2d(x, y)]!!.placeGrass(Grass(Vector2d(x, y)))
                    this.addToBoundary(Vector2d(x, y))
                }
            }
            else{
                count+=1
                cell= Field()
                cell.placeGrass(Grass(Vector2d(x, y)))
                fieldList[Vector2d(x, y)] = cell
                this.addToBoundary(Vector2d(x, y))
            }
        }
    }
    override fun canMoveTo(position: Vector2d): Boolean {
        return isOccupied(position)
    }

    override fun toString():String{
        val vectorMin=leftCorner()
        val vectorMax=rightCorner()
        return MapVisualizer(this).draw(vectorMin,vectorMax)
    }

    override fun leftCorner(): Vector2d {
        return Vector2d(listXMin.peek().x, listYMin.peek().y)
    }
    override fun rightCorner(): Vector2d {
        return Vector2d(listXMax.peek().x, listYMax.peek().y)
    }
}

