package es.florit.android.data

import es.florit.android.data.datasource.speedruns.SpeedRunsAPI
import es.florit.android.domain.entity.GameDomain
import es.florit.android.domain.entity.GameRunDomain
import es.florit.android.domain.repository.SpeedRunsRepositoryContract
import io.reactivex.rxjava3.core.Single

class SpeedRunsRepository : SpeedRunsRepositoryContract {

    private val apiDatasource = SpeedRunsAPI.newInstance() // TODO inject

    override fun getGamesList() {
        apiDatasource.getGamesList()
    }

    /**
     * Extra actions: to download async. the game image this code will use other
     * mechanism (instead of use Glide as easy way).This is not required for this
     * example but provides us more scenarios to use other mechanisms (eg. Worker)
     */
    override fun getGameRun(gameId: String): Single<GameRunDomain> {
        return apiDatasource.getGameRuns(gameId)
            .flatMap { Single.just(it.data.first()) }
            .map { (runId, gameId) ->
                val gameRun = GameRunDomain(runId, gameId).apply {

                }

                return@map gameRun
            }
    }
}