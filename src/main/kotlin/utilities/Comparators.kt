package utilities

class ComparatorXMin{
    companion object : Comparator<Vector2d> {
        override fun compare(V: Vector2d, U: Vector2d): Int {
            if (V.x != U.x) return V.x - U.x
            return V.y - U.y
        }
    }
}
class ComparatorXMax {
    companion object : Comparator<Vector2d> {
        override fun compare(V: Vector2d, U: Vector2d): Int {
            if (V.x != U.x) return U.x - V.x
            return U.y - V.y
        }
    }
}
class ComparatorYMin{
    companion object : Comparator<Vector2d> {
        override fun compare(V: Vector2d, U: Vector2d):Int {
            if (V.y != U.y) return U.y - V.y
            return U.x - V.x
        }
    }
}
class ComparatorYMax{
    companion object : Comparator<Vector2d> {
        override fun compare(V: Vector2d, U: Vector2d): Int {
            if (U.y != V.y) return V.y - U.y
            return V.x - U.x
        }
    }
}