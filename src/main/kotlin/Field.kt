class Field {
    private var inAnimal: Animal? = null
    private var inGrass: Grass? =null
    fun placeAnimal(creature:Animal){
        inAnimal=creature
    }
    fun placeGrass(grass: Grass){
        inGrass=grass
    }
    fun moveAnimal(): Animal? {
        val temp=inAnimal
        inAnimal=null
        return temp
    }
    fun removeGrass(){
        inGrass=null
    }
    fun isItAnimal():Boolean{
        return inAnimal!=null
    }
    fun isItGrass():Boolean{
        return inGrass!=null
    }
    fun getAnimal(): Animal? {
        return inAnimal
    }
    fun getGrass(): Grass? {
        return inGrass
    }
    fun getObject():Any?{
        if(inAnimal!=null)return inAnimal
        return inGrass
    }
    override fun toString():String{
        if(inAnimal!=null)return inAnimal.toString()
        if(inGrass!=null)return inGrass.toString()
        return ""
    }
}