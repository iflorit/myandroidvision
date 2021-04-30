package es.florit.android.domain

import es.florit.android.domain.base.BaseUseCase
import es.florit.android.domain.repository.SpeedRunsRepositoryContract

class GamesListUseCase : BaseUseCase<GamesListUseCase.GamesListParams> {

    lateinit var speedRunsRepo: SpeedRunsRepositoryContract

    override fun execute(with: GamesListParams) {
        TODO("Not yet implemented")
    }

    class GamesListParams
}