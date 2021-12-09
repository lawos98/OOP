import javafx.application.Application
import javafx.geometry.HPos
import javafx.geometry.Pos
import javafx.scene.Scene
import javafx.scene.control.Label
import javafx.scene.layout.ColumnConstraints
import javafx.scene.layout.GridPane
import javafx.scene.layout.RowConstraints
import javafx.stage.Stage
import kotlin.math.abs


class HelloApplication: Application(){
    override fun start(stage:Stage){
        fun addToGrid(text:String,grid:GridPane,indexX:Int,indexY:Int){
            val cellWidth=30.0
            val cellHeight=30.0
            val label=Label(text)
            label.minWidth=cellWidth
            label.minHeight=cellHeight
            label.alignment=Pos.CENTER
            GridPane.setHalignment(label, HPos.CENTER)
            grid.add(label,indexX,indexY)

        }
        try {
            val directions=OptionsParser().DoIT("fbrlffrrffffffff")
            val map:IWorldMap=GrassField()
            map.generateGrass(10)
            val positions= arrayOf(Vector2d(2,2),Vector2d(3,4))
            val engine:IEngine =SimulationEngine(directions,map,positions)
            engine.run()

            val grid=GridPane()
            var leftCorner=map.leftCorner()
            var rightCorner=map.rightCorner()
            if(map is RectangularMap){
                leftCorner=Vector2d(0,0)
                rightCorner=Vector2d(map.width,map.height)
            }

            grid.alignment=Pos.CENTER
            grid.isGridLinesVisible=true

            addToGrid("y/x",grid,0,0)

            for(i in leftCorner.x..rightCorner.x){
                addToGrid(i.toString(),grid,i-leftCorner.x+1,0)
            }
            for(i in leftCorner.y..rightCorner.y){
                addToGrid(i.toString(),grid,0,rightCorner.y-i+1)
            }
            for(key in map.fieldList.keys){
                addToGrid(map.fieldList[key].toString(),grid,key.x-leftCorner.x+1,rightCorner.y-key.y+1)
            }

            val scene=Scene(grid,35.0* abs(rightCorner.x-leftCorner.x),35.0* abs(rightCorner.y-leftCorner.y))
            stage.scene=scene
            stage.show()

        }
        catch(exception:IllegalArgumentException){
            println("Error")
            println(exception.message)
        }
    }
}
