package hr.algebra.mvvm.root

import android.app.Application
import dagger.Component
import dagger.Module
import dagger.Provides
import hr.algebra.mvvm.MainActivity
import hr.algebra.mvvm.data.MovieDao
import hr.algebra.mvvm.data.MovieDatabase
import hr.algebra.mvvm.data.MovieRepository

class App : Application( ) {
    var appComponent : AppComponent? = null
        private set

    override fun onCreate() {
        super.onCreate( )
        appComponent = DaggerAppComponent.builder( ).build( )
    }
}



@Component( modules = [MojModul::class])
interface AppComponent {
    fun inject( activity: MainActivity )
}



@Module
class MojModul( ) {

    @Provides
    fun provideRepository( dao : MovieDao ) : MovieRepository {
        return MovieRepository.getInstance( dao )
    }

    @Provides
    fun provideDAO( ) : MovieDao {
        return MovieDatabase.getInstance( ).movieDao
    }
/*
    @Provides
    fun provideRepository( ) : MovieRepository {
        return MovieRepository.getInstance( MovieDatabase.getInstance( ).movieDao )
    }
*/
}