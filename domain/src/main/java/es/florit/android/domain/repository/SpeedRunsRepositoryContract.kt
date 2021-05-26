package es.florit.android.domain.repository

import es.florit.android.domain.base.Result
import es.florit.android.domain.entity.GameDomain
import es.florit.android.domain.entity.GameRunDomain
import es.florit.android.domain.entity.PlayerDomain
import kotlinx.coroutines.flow.Flow

interface SpeedRunsRepositoryContract {

    fun getGamesList(): Flow<Result<List<GameDomain>, ErrorUtils>>

    fun getGameRun(gameId: String): Flow<GameRunDomain>

    fun getPlayer(playerId: String): Flow<PlayerDomain>

    class ErrorUtils(val result: String) {

        companion object {
            fun parseError(code: Any) = ""
        }
    }
}