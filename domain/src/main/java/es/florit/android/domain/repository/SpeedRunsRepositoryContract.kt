package es.florit.android.domain.repository

import es.florit.android.domain.entity.GameDomain
import es.florit.android.domain.entity.GameRunDomain
import es.florit.android.domain.entity.PlayerDomain
import io.reactivex.rxjava3.core.Single

interface SpeedRunsRepositoryContract {

    fun getGamesList(): Single<List<GameDomain>>

    fun getGameRun(gameId: String): Single<GameRunDomain>

    fun getPlayer(playerId: String): Single<PlayerDomain>
}