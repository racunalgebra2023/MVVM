package hr.algebra.mvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import hr.algebra.mvvm.data.MovieRepository
import hr.algebra.mvvm.model.Movie
import hr.algebra.mvvm.databinding.ActivityMainBinding
import hr.algebra.mvvm.root.App
import javax.inject.Inject

class MainActivity : AppCompatActivity( ) {

    val TAG = "MainActivity"
    private lateinit var binding : ActivityMainBinding

    @Inject
    lateinit var repository : MovieRepository

    override fun onCreate( savedInstanceState: Bundle?) {
        ( applicationContext as App ).appComponent?.inject(this)
        super.onCreate( savedInstanceState)

        binding = ActivityMainBinding.inflate( layoutInflater )
        setContentView( binding.root )
        setupListeners( )
    }

    private fun setupListeners( ) {
        val factory = MoviesViewModelFactory( repository )
        val viewModel = ViewModelProvider( this, factory )[ MoviesViewModel::class.java ]

        viewModel.getMovies( ).observe(this ) { movies ->
            val sb = StringBuilder("")
            movies.forEach {
                sb.append( "$it\n\n" )
            }
            binding.tvMovies.text = sb.toString( )
        }

        binding.bSave.setOnClickListener {
            val movie = Movie( binding.etMovie.text.toString( ).trim( ), binding.etDirector.text.toString( ).trim( ) )
            if( movie.notValid( ) )
                Toast
                    .makeText( this, "Please write Director and Movie..", Toast.LENGTH_LONG )
                    .show( )
            else {
                viewModel.addMovie( movie )
                binding.etDirector.setText( "" )
                binding.etMovie.setText( "" )
                binding.etDirector.requestFocus( )
            }
        }
    }
}