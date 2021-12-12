import javafx.scene.layout.GridPane
import javafx.stage.Stage
import java.lang.Exception

class ThreadAnimal(var creature:Animal, var tabDirection:Array<MoveDirection>, var moveSpeed:Long,var grid:GuiElementBox):Thread() {
    override fun run() {
        for(dir in tabDirection){
            creature.move(dir)
            try{
                Thread.sleep(moveSpeed)

            }
            catch (e:Exception){
                println(e.message)
            }
        }

    }
}