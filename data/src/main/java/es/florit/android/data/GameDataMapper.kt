package es.florit.android.data

import es.florit.android.data.datasource.speedruns.entity.GameRunsListDTO
import es.florit.android.data.datasource.speedruns.entity.GamesListDTO
import es.florit.android.domain.entity.GameDomain
import es.florit.android.domain.entity.GameRunDomain

class GameDataMapper {
    companion object {
        /**
         * Maps only the required domain fields
         */
        fun toDomain(api: GameRunsListDTO.GameRunDTO) = GameRunDomain(
            api.runId,
            api.gameId
        )
    }
}