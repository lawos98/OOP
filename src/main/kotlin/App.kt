import javafx.animation.AnimationTimer
import javafx.application.Application
import javafx.scene.Scene
import javafx.scene.layout.GridPane
import javafx.stage.Stage
import kotlin.math.abs


class App: Application(){
    override fun start(stage:Stage){
        try {
            val directions=OptionsParser().DoIT("fbrlffrrffffffff")
            val map:IWorldMap=GrassField()
            map.generateGrass(10)
            val positions= arrayOf(Vector2d(2,2),Vector2d(3,4))
            val grid=GuiElementBox(map,stage)
            val engine:IEngine =SimulationEngine(directions,map,positions,grid)
            engine.run()
            val myTimer=MyTimer(grid,map)
            myTimer.start()
            val scene=Scene(grid.returnGrid(),1000.0,1000.0)
            stage.scene=scene
            stage.show()

        }
        catch(exception:IllegalArgumentException){
            println("Error")
            println(exception.message)
        }
    }
}
