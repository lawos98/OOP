package worldElements

import utilities.Vector2d
import java.io.FileInputStream

interface IMapElement {
    override fun toString():String

    fun getPositon(): Vector2d

    fun getPath():FileInputStream

}