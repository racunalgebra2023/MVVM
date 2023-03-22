package hr.algebra.mvvm.data

import hr.algebra.mvvm.model.Movie

class MovieRepository private constructor( private val modieDao : MovieDao ) {

    fun addMovie( movie : Movie) {
        modieDao.addMovie( movie )
    }

    fun getMovies( ) = modieDao.getMovies( )

    companion object {
        @Volatile
        private var instance : MovieRepository? = null

        fun getInstance( modieDao : MovieDao ) = instance ?: synchronized( this ){
            instance ?: MovieRepository( modieDao ).also { instance = it }
        }
    }
}