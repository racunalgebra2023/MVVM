package hr.algebra.mvvm

import androidx.lifecycle.ViewModel
import hr.algebra.mvvm.data.MovieRepository
import hr.algebra.mvvm.model.Movie

class MoviesViewModel( private val movieRepository: MovieRepository ) : ViewModel( ) {
    fun getMovies( ) = movieRepository.getMovies( )
    fun addMovie( movie : Movie) = movieRepository.addMovie( movie )
}