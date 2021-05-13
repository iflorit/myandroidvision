package es.florit.android.domain

import es.florit.android.domain.base.BaseUseCase
import es.florit.android.domain.entity.GameDomain
import es.florit.android.domain.repository.SpeedRunsRepositoryContract
import io.reactivex.rxjava3.core.Single

class GamesListUseCase : BaseUseCase<GamesListUseCase.GamesListParams, List<GameDomain>> {

    lateinit var speedRunsRepo: SpeedRunsRepositoryContract

    override fun execute(with: GamesListParams): Single<List<GameDomain>> {
        return speedRunsRepo.getGamesList()
    }

    class GamesListParams
}