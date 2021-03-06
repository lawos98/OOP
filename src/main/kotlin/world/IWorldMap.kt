package world

import worldElements.Animal
import worldElements.Field
import utilities.Vector2d
import java.util.concurrent.ConcurrentHashMap

/**
 * The interface responsible for interacting with the map of the world.
 * Assumes that Utilities.Vector2d and Utilities.MoveDirection classes are defined.
 *
 * @author apohllo
 */
interface IWorldMap {

    var fieldList:ConcurrentHashMap<Vector2d, Field>
    /**
     * Indicate if any object can move to the given position.
     *
     * @param position
     * The position checked for the movement possibility.
     * @return True if the object can move to that position.
     */
    fun canMoveTo(position: Vector2d): Boolean

    /**
     * Place a animal on the map.
     *
     * @param animal
     * The animal to place on the map.
     * @return True if the animal was placed. The animal cannot be placed if the map is already occupied.
     */
    fun place(animal: Animal)
    /**
     * Return true if given position on the map is occupied. Should not be
     * confused with canMove since there might be empty positions where the animal
     * cannot move.
     *
     * @param position
     * Position to check.
     * @return True if the position is occupied.
     */
    fun isOccupied(position: Vector2d): Boolean

    /**
     * Return an object at a given position.
     *
     * @param position
     * The position of the object.
     * @return Object or null if the position is not occupied.
     */
    fun objectAt(position: Vector2d): Any?

    /**
     * Return the collection of animals present on the map.
     *
     * @return List of animals.
     */
    fun animals(): List<Animal>

    fun changePosition(start: Vector2d, end: Vector2d)

    fun generateGrass(countGrass: Int)

    fun addToBoundary(v: Vector2d)

    fun changeBoundary(start: Vector2d, end: Vector2d)

    fun removeBoundary(v: Vector2d)

    fun leftCorner(): Vector2d

    fun rightCorner(): Vector2d


}