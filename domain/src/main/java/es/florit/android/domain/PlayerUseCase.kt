package es.florit.android.domain

import es.florit.android.domain.base.BaseUseCase
import es.florit.android.domain.entity.PlayerDomain
import es.florit.android.domain.repository.SpeedRunsRepositoryContract
import kotlinx.coroutines.flow.Flow

class PlayerUseCase : BaseUseCase<PlayerUseCase.PlayerParams, PlayerDomain> {

    lateinit var speedRunsRepo: SpeedRunsRepositoryContract

    override fun execute(with: PlayerParams): Flow<PlayerDomain> {
        return speedRunsRepo.getPlayer(with.playerId)
    }

    data class PlayerParams(val playerId: String)
}