package hr.algebra.mvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import hr.algebra.mvvm.data.Movie
import hr.algebra.mvvm.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity( ) {

    val TAG = "MainActivity"
    private lateinit var binding : ActivityMainBinding

    override fun onCreate( savedInstanceState: Bundle?) {
        super.onCreate( savedInstanceState)
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
                Log.i( TAG, "Writing data to TextView" )
                binding.tvMovies.text = "${ binding.tvMovies.text.toString( ) }\n\n$movie"
                binding.etDirector.setText( "" )
                binding.etMovie.setText( "" )
                binding.etDirector.requestFocus( )
            }
        }
    }
}