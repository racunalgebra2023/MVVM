package hr.algebra.mvvm.data

import hr.algebra.mvvm.model.Movie

class MovieDao {

    private val movieList = mutableListOf<Movie>()

    fun addMovie( movie: Movie) {
        movieList.add( movie )
    }

    fun getMovies( ) = movieList
}