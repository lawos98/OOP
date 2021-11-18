
class SimulationEngine(var tabDirections: Array<MoveDirection>,var map: IWorldMap,var tabVectors:Array<Vector2d>):IEngine {
    override fun run() {
        for(position in tabVectors){
            map.place(Animal(map,position))
        }
        val tab=map.animals()
        var i =0
        for(dir in tabDirections) {
            tab[i].move(dir)
            i=(i+1)%tab.size
        }
    }
}