package es.florit.android.data

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import es.florit.android.data.datasource.speedruns.CacheDatasource
import es.florit.android.data.datasource.speedruns.SpeedRunsDatasource
import es.florit.android.data.datasource.speedruns.entity.GamesListDTO
import es.florit.android.domain.base.Failure
import es.florit.android.domain.base.Result
import es.florit.android.domain.base.Success
import es.florit.android.domain.entity.GameDomain
import es.florit.android.domain.entity.GameRunDomain
import es.florit.android.domain.entity.PlayerDomain
import es.florit.android.domain.repository.SpeedRunsRepositoryContract
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject
import javax.inject.Singleton

class SpeedRunsRepository @Inject constructor() : SpeedRunsRepositoryContract {

    private val apiDatasource = SpeedRunsDatasource() // TODO inject
    private val cache = CacheDatasource

    override fun getGamesList(): Flow<Result<List<GameDomain>, SpeedRunsRepositoryContract.ErrorUtils>> {
        /*
        return apiDatasource.getGamesList()
            .flatMap { cache.cacheGamesList(it) }
            .map(SpeedRunsDataMapper::gamesListToDomain)
*/
        return flow {
            // emit(Result.loading())
            when (val res = apiDatasource.getGamesList()) {
                is Failure<*> -> {
                    println(res)
                }
                is Success<*> -> {
                    val success= Success(SpeedRunsDataMapper.gamesListToDomain(res.value as GamesListDTO))
                    emit(success as Result<List<GameDomain>, SpeedRunsRepositoryContract.ErrorUtils> )
                }
            }
            //.flatMap { cache.cacheGamesList(it) }
            //.map(SpeedRunsDataMapper::gamesListToDomain)
        }
            .flowOn(Dispatchers.IO)
    }

    /**
     * Extra actions: to download async. the game image this code will use other
     * mechanism (instead of use Glide as easy way).This is not required for this
     * example but provides us more scenarios to use other mechanisms (eg. Worker)
     */
    override fun getGameRun(gameId: String): Flow<GameRunDomain> {
        // TODO datasource to take the runs should be get from the last call...

        return flow {
            GameRunDomain("","")
        }
/*
        return apiDatasource.getGameRuns(gameId)
            .flatMap { Flow.just(it.data.first()) }
            .map(SpeedRunsDataMapper::gameToDomain)
            */

    }

    override fun getPlayer(playerId: String): Flow<PlayerDomain> {
        return flow {
            PlayerDomain("", "")
        }
        /*
        return apiDatasource.getGamePlayer(playerId)
            .map(SpeedRunsDataMapper::playerToDomain)

         */
    }

}
