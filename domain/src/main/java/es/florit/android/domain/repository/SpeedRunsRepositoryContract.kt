package es.florit.android.domain.repository

import es.florit.android.domain.entity.GameRunDomain
import io.reactivex.rxjava3.core.Single

interface SpeedRunsRepositoryContract {

    fun getGamesList()

    fun getGameRun(gameId: String): Single<GameRunDomain>
}