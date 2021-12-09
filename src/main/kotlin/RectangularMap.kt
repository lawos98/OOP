import kotlin.random.Random

class RectangularMap(var width: Int,var height: Int):AbstractWorldMap() {

    override fun canMoveTo(position: Vector2d): Boolean {
        if(isOccupied(position))return false
        return (position.follows(Vector2d(0, 0)) && position.precedes(Vector2d(width, height)))
                &&(isOccupied(position+Vector2d(0,1))
                || isOccupied(position+Vector2d(1,0))
                || isOccupied(position+Vector2d(-1,0))
                || isOccupied(position+Vector2d(0,-1)))
    }

    override fun generateGrass(countGrass: Int){
        var count=0
        var x:Int
        var y:Int
        var cell:Field
        while (count<countGrass){
            x= Random.nextInt(0,width)
            y=Random.nextInt(0,height)
            if (fieldList.containsKey(Vector2d(x,y))){
                if(fieldList[Vector2d(x,y)]!!.isItGrass()){
                    continue
                }
                else{
                    count+=1
                    fieldList[Vector2d(x,y)]!!.placeGrass(Grass(Vector2d(x,y)))
                    this.addToBoundary(Vector2d(x,y))
                }
            }
            else{
                count+=1
                cell=Field()
                cell.placeGrass(Grass(Vector2d(x,y)))
                fieldList[Vector2d(x,y)] = cell
                this.addToBoundary(Vector2d(x,y))
            }
        }
    }

    override fun toString():String{
        return MapVisualizer(this).draw(Vector2d(0,0),Vector2d(width,height))
    }
}

