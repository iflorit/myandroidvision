package es.florit.android.domain

import es.florit.android.domain.base.BaseUseCase
import es.florit.android.domain.entity.PlayerDomain
import es.florit.android.domain.repository.SpeedRunsRepositoryContract
import io.reactivex.rxjava3.core.Single

class PlayerUseCase : BaseUseCase<PlayerUseCase.PlayerParams, PlayerDomain> {

    lateinit var speedRunsRepo: SpeedRunsRepositoryContract

    override fun execute(with: PlayerParams): Single<PlayerDomain> {
        return speedRunsRepo.getPlayer(with.playerId)
    }

    data class PlayerParams(val playerId: String)
}