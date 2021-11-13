class OptionsParser {
    fun parse(path : String):Array<MoveDirection>
    {
        var tab= arrayOf<MoveDirection>()
        var value:String
        for (i in path)
        {
            if(i=='f'|| i=='b' || i=='r' || i=='l')
            {
                value = when(i) {
                    'f' -> "FORWARD"
                    'b' -> "BACKWARD"
                    'r' -> "RIGHT"
                    else -> "LEFT"
                }
                tab+=MoveDirection.valueOf(value)
            }
        }
        return tab
    }
}
