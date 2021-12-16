package gui

import worldElements.Field
import world.IWorldMap
import javafx.geometry.Pos
import javafx.scene.control.Label
import javafx.scene.image.Image
import javafx.scene.image.ImageView
import javafx.scene.layout.BorderPane
import javafx.scene.layout.GridPane

class GuiGrid(private var map: IWorldMap) {
    private var grid = GridPane()
    init {
        grid.alignment = Pos.CENTER
        grid.isGridLinesVisible = true
    }

    private fun addToGrid(text: String, indexX: Int, indexY: Int) {
        val label = Label(text)
        label.minWidth = 30.0
        label.minHeight = 30.0
        label.alignment = Pos.CENTER
        grid.add(label, indexX, indexY)
    }

    fun returnGrid(): GridPane {
        return grid
    }

    private fun placeImage(indexX: Int, indexY: Int, field: Field) {
        val creature = field.getAnimal()
        val plant = field.getGrass()
        if (creature != null) {
            val image = Image(creature.getPath())
            val view = ImageView(image)
            view.fitWidth = 20.0
            view.fitHeight = 20.0
            val pane = BorderPane()
            pane.setPrefSize(20.0, 20.0)
            pane.center = view
            grid.add(pane, indexX, indexY)
        } else if (plant != null) {
            val image = Image(plant.getPath())
            val view = ImageView(image)
            view.fitWidth = 20.0
            view.fitHeight = 20.0
            val pane = BorderPane()
            pane.setPrefSize(20.0, 20.0)
            pane.center = view
            grid.add(pane, indexX, indexY)
        }
    }
    fun setGrid(){
        val leftCorner=map.leftCorner()
        val rightCorner=map.rightCorner()
        this.clearGrid()
        this.addToGrid("y/x",0,0)
        for(i in leftCorner.x..rightCorner.x){
            this.addToGrid(i.toString(),i-leftCorner.x+1,0)
        }
        for(i in leftCorner.y..rightCorner.y){
            this.addToGrid(i.toString(),0,rightCorner.y-i+1)
        }
        for(key in map.fieldList.keys){
            val field=map.fieldList[key]
            if(field!=null){
                this.placeImage(key.x-leftCorner.x+1,rightCorner.y-key.y+1,field)
            }
        }
    }
    private fun clearGrid(){
        grid.isGridLinesVisible = false
        grid.children.clear()
        grid.isGridLinesVisible = true
    }
}