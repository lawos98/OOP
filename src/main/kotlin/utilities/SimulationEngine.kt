package utilities

import worldElements.Animal
import kotlinx.coroutines.*
import kotlinx.coroutines.javafx.JavaFx


class SimulationEngine(private var tabDirections: Array<MoveDirection>, private var map:world.IWorldMap, private var tabVectors:ArrayList<Vector2d>, private var grid:gui.GuiGrid,private var moveSpeed:Long):IEngine {
    override fun run() {
        GlobalScope.launch(Dispatchers.JavaFx) {
            for (position in tabVectors) {
                map.place(Animal(map, position))
            }
            val tab = map.animals()
            var i = 0
            for (dir in tabDirections) {
                if(i%tab.size==0) {
                    delay(moveSpeed)
                    grid.setGrid()
                }
                tab[i].move(dir)
                i = (i + 1) % tab.size
            }
        }
    }
}
