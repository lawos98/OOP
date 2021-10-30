class OptionsParser() {
    fun parse(path : String):Array<MoveDirection>
    {
        var Tab= arrayOf<MoveDirection>()
        var value:String
        for (i in path)
        {
            if(i=='f'|| i=='b' || i=='r' || i=='l')
            {
                when (i) {
                    'f' -> value="FORWARD"
                    'b' -> value="BACKWARD"
                    'r' -> value="RIGHT"
                    else ->value="LEFT"
                }
                Tab+=MoveDirection.valueOf(value)
            }
        }
        return Tab
    }
}
