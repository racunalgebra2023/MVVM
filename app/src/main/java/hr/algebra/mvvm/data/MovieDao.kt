package hr.algebra.mvvm.data

class MovieDao {

    private val movieList = mutableListOf< Movie >()

    fun addMovie( movie: Movie ) {
        movieList.add( movie )
    }

    fun getMovies( ) = movieList
}