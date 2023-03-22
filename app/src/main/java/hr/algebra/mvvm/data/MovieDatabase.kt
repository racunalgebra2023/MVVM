package hr.algebra.mvvm.data

class MovieDatabase private constructor( ) {

    var movieDao = MovieDao( )
        private set

    companion object {
        private var instance : MovieDatabase? = null

        fun getInstance( ) = instance ?: synchronized( this ) {
            instance ?: MovieDatabase( ).also { instance = it }
        }
    }
}