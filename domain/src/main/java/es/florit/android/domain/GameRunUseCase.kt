package es.florit.android.domain

import es.florit.android.domain.base.BaseUseCase
import es.florit.android.domain.repository.SpeedRunsRepositoryContract

class GameRunUseCase : BaseUseCase<GameRunUseCase.GameRunParams> {

    lateinit var speedRunsRepo: SpeedRunsRepositoryContract

    override fun execute(with: GameRunParams) {
        TODO("Not yet implemented")
    }

    data class GameRunParams(val gameId: String)
}