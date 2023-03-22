package hr.algebra.mvvm.model

data class Movie( val title : String, val director : String ) {
    override fun toString(): String {
        return "$director - $title"
    }

    fun notValid( ) : Boolean {
        return director.isEmpty() || title.isEmpty( )
    }
}