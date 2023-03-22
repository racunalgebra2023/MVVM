package hr.algebra.mvvm.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import hr.algebra.mvvm.model.Movie

class MovieDao {

    private val movieList = mutableListOf< Movie >( )
    private val movies    = MutableLiveData< List< Movie > >( )

    init {
        movies.value = movieList
    }

    fun addMovie( movie: Movie) {
        movieList.add( movie )
        movies.value = movieList
    }

    fun getMovies( ) = movies as LiveData< List< Movie > >
}