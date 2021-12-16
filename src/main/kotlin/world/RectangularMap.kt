package world

import worldElements.Field
import worldElements.Grass
import utilities.MapVisualizer
import utilities.Vector2d
import kotlin.random.Random

class RectangularMap(private var width: Int, private var height: Int): AbstractWorldMap() {

    override fun canMoveTo(position: Vector2d): Boolean {
        return isOccupied(position)&&position.precedes(Vector2d(width,height))&&position.follows(Vector2d(0,0))
    }

    override fun generateGrass(countGrass: Int){
        var count=0
        var x:Int
        var y:Int
        var cell: Field
        while (count<countGrass){
            x= Random.nextInt(0,width)
            y=Random.nextInt(0,height)
            if (fieldList.containsKey(Vector2d(x, y))){
                val field=fieldList[Vector2d(x,y)]
                if(field!=null) {

                    if (field.isItGrass()) {
                        continue
                    } else {
                        count += 1
                        field.placeGrass(Grass(Vector2d(x, y)))
                        this.addToBoundary(Vector2d(x, y))
                    }
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

    override fun leftCorner(): Vector2d {
        return Vector2d(0, 0)
    }
    override fun rightCorner(): Vector2d {
        return Vector2d(width, height)
    }

    override fun toString():String{
        return MapVisualizer(this).draw(Vector2d(0, 0), Vector2d(width, height))
    }
}

