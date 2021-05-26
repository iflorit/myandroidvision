package es.florit.android.domain

import es.florit.android.domain.base.BaseUseCase
import es.florit.android.domain.entity.GameRunDomain
import es.florit.android.domain.repository.SpeedRunsRepositoryContract
import kotlinx.coroutines.flow.Flow

class GameRunUseCase : BaseUseCase<GameRunUseCase.GameRunParams, GameRunDomain> {

    lateinit var speedRunsRepo: SpeedRunsRepositoryContract

    override fun execute(with: GameRunParams): Flow<GameRunDomain>{
        return speedRunsRepo.getGameRun(with.gameId)
    }

    data class GameRunParams(val gameId: String)
}