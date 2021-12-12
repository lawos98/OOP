import javafx.animation.AnimationTimer
import javafx.scene.layout.GridPane

class MyTimer(val grid:GuiElementBox,val map: IWorldMap):AnimationTimer() {
    override fun handle(now: Long) {
        grid.clearGrid()
        var leftCorner=map.leftCorner()
        var rightCorner=map.rightCorner()
        if(map is RectangularMap){
            leftCorner=Vector2d(0,0)
            rightCorner=Vector2d(map.width,map.height)
        }
        grid.setGrid(leftCorner,rightCorner)
    }
}