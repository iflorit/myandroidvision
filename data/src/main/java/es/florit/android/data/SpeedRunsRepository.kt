package es.florit.android.data

import es.florit.android.data.datasource.speedruns.CacheDatasource
import es.florit.android.data.datasource.speedruns.SpeedRunsAPI
import es.florit.android.domain.entity.GameDomain
import es.florit.android.domain.entity.GameRunDomain
import es.florit.android.domain.entity.PlayerDomain
import es.florit.android.domain.repository.SpeedRunsRepositoryContract
import io.reactivex.rxjava3.core.Single

class SpeedRunsRepository : SpeedRunsRepositoryContract {

    private val apiDatasource = SpeedRunsAPI.newInstance() // TODO inject
    private val cache = CacheDatasource

    override fun getGamesList(): Single<List<GameDomain>> {
        return apiDatasource.getGamesList()
            .flatMap { cache.cacheGamesList(it) }
            .map(SpeedRunsDataMapper::gamesListToDomain)
    }

    /**
     * Extra actions: to download async. the game image this code will use other
     * mechanism (instead of use Glide as easy way).This is not required for this
     * example but provides us more scenarios to use other mechanisms (eg. Worker)
     */
    override fun getGameRun(gameId: String): Single<GameRunDomain> {
        // TODO datasource to take the runs should be get from the last call...

        return apiDatasource.getGameRuns(gameId)
            .flatMap { Single.just(it.data.first()) }
            .map(SpeedRunsDataMapper::gameToDomain)
    }

    override fun getPlayer(playerId: String): Single<PlayerDomain> {
        return apiDatasource.getGamePlayer(playerId)
            .map(SpeedRunsDataMapper::playerToDomain)
    }
}