package worldElements

import utilities.Vector2d

abstract class AbstractWorldMapElement(var position: Vector2d): IMapElement {
    override fun getPositon(): Vector2d {
        return position
    }
}