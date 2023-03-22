package hr.algebra.mvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import hr.algebra.mvvm.data.MovieDatabase
import hr.algebra.mvvm.data.MovieRepository
import hr.algebra.mvvm.model.Movie
import hr.algebra.mvvm.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity( ) {

    val TAG = "MainActivity"
    private lateinit var binding : ActivityMainBinding
    private lateinit var repository : MovieRepository

    override fun onCreate( savedInstanceState: Bundle?) {
        super.onCreate( savedInstanceState)

        repository = MovieRepository.getInstance( MovieDatabase.getInstance( ).movieDao )

        binding = ActivityMainBinding.inflate( layoutInflater )
        setContentView( binding.root )
        setupListeners( )
    }

    private fun setupListeners( ) {
        Log.i( TAG, "Setting the listener." )
        binding.bSave.setOnClickListener {
            val movie = Movie( binding.etMovie.text.toString( ).trim( ), binding.etDirector.text.toString( ).trim( ) )
            if( movie.notValid( ) )
                Toast
                    .makeText( this, "Please write Director and Movie..", Toast.LENGTH_LONG )
                    .show( )
            else {
                repository.addMovie( movie )
                val sb = StringBuilder( "" )
                repository.getMovies( ).forEach {
                    sb.append( "$it\n\n" )
                }
                binding.tvMovies.text = sb.toString( )
                binding.etDirector.setText( "" )
                binding.etMovie.setText( "" )
                binding.etDirector.requestFocus( )
            }
        }
    }
}