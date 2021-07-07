package es.florit.android.speedruns

import android.app.Application
import android.content.Context
import android.content.res.Resources
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.HiltAndroidApp
import dagger.hilt.components.SingletonComponent

@HiltAndroidApp
class SpeedRunsApplication : Application()

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    fun provideContext(app: Application): Context = app.applicationContext

    @Provides
    fun provideResources(app: Application): Resources = app.resources
}



//@Module
//@InstallIn(SingletonComponent::class)
//abstract class SpeedRunsModule {
//
//    @Binds
//    @Singleton
//    abstract fun bindSpeedRunsRepository(c: SpeedRunsRepository): SpeedRunsRepositoryContract
//}