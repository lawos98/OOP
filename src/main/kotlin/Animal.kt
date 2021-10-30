import kotlin.math.max
import kotlin.math.min

class Animal() {
    private var Orientation: MapDirection =MapDirection.NORTH
    private var Place: Vector2d = Vector2d(2,2)
    fun showPlace():String
    {
        return Place.convertToString()
    }
    fun isAt(arg: Vector2d,or:MapDirection):Boolean {
        if(Place.isequals(arg) && or==Orientation){
            return true
        }
        return false
    }
    fun move(arg:MoveDirection)
    {
        when(arg)
        {
            MoveDirection.FORWARD -> {
                Place=Place.add(Orientation.toUnitVector())
                if(Place.x>4)Place.x=4
                if(Place.x<0)Place.x=0
                if(Place.y>4)Place.y=4
                if(Place.y<0)Place.y=0
            }
            MoveDirection.BACKWARD -> {
                Place=Place.subtract(Orientation.toUnitVector())
                if(Place.x>4)Place.x=4
                if(Place.x<0)Place.x=0
                if(Place.y>4)Place.y=4
                if(Place.y<0)Place.y=0
            }
            MoveDirection.LEFT -> Orientation=Orientation.previous()
            MoveDirection.RIGHT -> Orientation=Orientation.next()

        }

    }
}