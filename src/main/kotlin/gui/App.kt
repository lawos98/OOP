package gui

import utilities.OptionsParser
import utilities.Vector2d
import world.GrassField
import world.IWorldMap
import javafx.application.Application
import javafx.geometry.Pos
import javafx.scene.Scene
import javafx.scene.control.Button
import javafx.scene.control.Label
import javafx.scene.control.TextField
import javafx.scene.layout.HBox
import javafx.scene.layout.VBox
import javafx.stage.Stage
import utilities.IEngine
import utilities.SimulationEngine


class App: Application(){
    override fun start(stage:Stage){
        try {
            val box=VBox()
            box.alignment= Pos.CENTER

            val buttonStart=Button("Start")
            buttonStart.isDisable=true
            buttonStart.minWidth=300.0
            buttonStart.minHeight=20.0
            box.children.add(buttonStart)

            val lDir=Label("Please set Directions")
            box.children.add(lDir)
            val inputDir=TextField("fbrlffrrffffffffbbbbbbbbbbb")
            inputDir.maxWidth=300.0
            box.children.add(inputDir)

            val lGrass=Label("Please set Grass")
            box.children.add(lGrass)
            val inputGrass=TextField("20")
            inputGrass.maxWidth=100.0
            box.children.add(inputGrass)

            val lSpeed=Label("Please set Move Speed")
            box.children.add(lSpeed)
            val inputSpeed=TextField("200")
            inputSpeed.maxWidth=100.0
            box.children.add(inputSpeed)

            val lAnimal=Label("Please set animal")
            box.children.add(lAnimal)
            val boxButtonsAnimal=HBox()
            val buttonAdd=Button("ADD")
            val buttonRemove=Button("Remove")
            boxButtonsAnimal.children.addAll(buttonAdd,buttonRemove)
            boxButtonsAnimal.alignment=Pos.CENTER
            box.children.add(boxButtonsAnimal)
            val boxAnimal=VBox()
            box.children.add(boxAnimal)
            buttonAdd.setOnAction {
                if(boxAnimal.children.isEmpty())buttonStart.isDisable=false
                val boxTemp=HBox()
                val inputAnimalVectorX=TextField()
                val inputAnimalVectorY=TextField()
                boxTemp.alignment=Pos.CENTER
                boxTemp.children.addAll(inputAnimalVectorX,inputAnimalVectorY)
                boxAnimal.children.add(boxTemp)
            }
            buttonRemove.setOnAction {
                if(!boxAnimal.children.isEmpty()){
                    boxAnimal.children.removeLast()
                    if(boxAnimal.children.isEmpty()){
                        buttonStart.isDisable=true
                    }
                }
            }

            val scene=Scene(box,1000.0,1000.0)
            stage.scene=scene
            stage.show()
            buttonStart.setOnAction {
                if (!boxAnimal.children.isEmpty()) {
                    val moveSpeed: Long = inputSpeed.text.toLong()
                    val directions = OptionsParser().convert(inputDir.text.toString())
                    val map: IWorldMap = GrassField()
                    map.generateGrass(inputGrass.text.toInt())
                    val positions = ArrayList<Vector2d>()
                    for (node in boxAnimal.children) {
                        if (node is HBox) {
                            val tab = ArrayList<Int>()
                            for (input in node.children) {
                                if (input is TextField) {
                                    tab.add(input.text.toInt())
                                }
                            }
                            positions.add(Vector2d(tab[0], tab[1]))
                        }
                    }
                    val grid = GuiGrid(map)
                    val mainScene = Scene(grid.returnGrid(), 1000.0, 1000.0)
                    stage.scene = mainScene
                    val engine: IEngine = SimulationEngine(directions, map, positions, grid, moveSpeed)
                    engine.run()
                }
            }
        }
        catch(exception:IllegalArgumentException){
            println("Error")
            println(exception.message)
        }
    }
}

