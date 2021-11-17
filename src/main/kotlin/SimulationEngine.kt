import java.io.Console

class SimulationEngine(var tabDirections: Array<MoveDirection>,var map: IWorldMap,var tabVectors:Array<Vector2d>):IEngine {
    override fun run() {
        for(position in tabVectors){
            map.place(Animal(map,position))
        }
        var tab=map.animals()
        var i:Int=0
        println(tabDirections.size)
        for(dir in tabDirections) {
            tab[i].move(dir)
            i=(i+1)%tab.size
            println(map.toString())
        }
    }
}