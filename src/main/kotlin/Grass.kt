import java.io.FileInputStream

class Grass(position: Vector2d):IMapElement, AbstractWorldMapElement(position) {
    override fun toString():String{
        return "ლ"
    }

    override fun getPath(): FileInputStream {
        return FileInputStream("src/main/kotlin/Resource/grass.png")
    }
}