package utilities

/**
 * The interface responsible for managing the moves of the animals.
 * Assumes that Utilities.Vector2d and Utilities.MoveDirection classes are defined.
 *
 * @author apohllo
 */
interface IEngine {
    /**
     * Move the animal on the map according to the provided move directions. Every
     * n-th direction should be sent to the n-th animal on the map.
     *
     */
    fun run()
}