import javafx.scene.image.Image
import java.io.FileInputStream

abstract class AbstractWorldMapElement(var position: Vector2d):IMapElement {
    override fun getPositon():Vector2d{
        return position
    }
}