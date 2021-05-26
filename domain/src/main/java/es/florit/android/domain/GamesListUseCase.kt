package es.florit.android.domain

import es.florit.android.domain.base.BaseUseCase
import es.florit.android.domain.base.Result
import es.florit.android.domain.entity.GameDomain
import es.florit.android.domain.repository.SpeedRunsRepositoryContract
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GamesListUseCase @Inject constructor(
    var speedRunsRepo: SpeedRunsRepositoryContract
) : BaseUseCase<GamesListUseCase.GamesListParams, Result<List<GameDomain>, SpeedRunsRepositoryContract.ErrorUtils>> {


    override fun execute(with: GamesListParams): Flow<Result<List<GameDomain>, SpeedRunsRepositoryContract.ErrorUtils>> {
        return speedRunsRepo.getGamesList()
    }

    class GamesListParams
}