import javafx.scene.layout.GridPane
import javafx.stage.Stage

class SimulationEngine(private var tabDirections: Array<MoveDirection>, private var map: IWorldMap, private var tabVectors:Array<Vector2d>,private var grid:GuiElementBox):IEngine {
    override fun run() {
        for(position in tabVectors){
            map.place(Animal(map,position))
        }
        val tab=map.animals()
        var i =0
        var arrayDirections= arrayOf<Array<MoveDirection>>()
        for(index1 in 0..(tabVectors.size-1)){
            var index2=index1
            var row= arrayOf<MoveDirection>()
            while(index2<tabDirections.size){
                row+=tabDirections[index2]
                index2+=tabVectors.size
            }
            arrayDirections+=row
        }
        for(i in 0..(arrayDirections.size-1)){
            var Tanimal=ThreadAnimal(tab[i],arrayDirections[i],1000,grid)
            Tanimal.start()
        }
    }
}