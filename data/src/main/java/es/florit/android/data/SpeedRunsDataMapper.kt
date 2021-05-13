package es.florit.android.data

import es.florit.android.data.datasource.speedruns.entity.GamePlayerDTO
import es.florit.android.data.datasource.speedruns.entity.GameRunsListDTO
import es.florit.android.data.datasource.speedruns.entity.GamesListDTO
import es.florit.android.domain.entity.GameDomain
import es.florit.android.domain.entity.GameRunDomain
import es.florit.android.domain.entity.PlayerDomain

class SpeedRunsDataMapper {

    companion object {
        fun gamesListToDomain(dto: GamesListDTO): List<GameDomain> {
            return dto.data.map {
                GameDomain(it.id, it.names.international)
            }
        }

        fun gameToDomain(api: GameRunsListDTO.GameRunDTO) = GameRunDomain(
            api.runId,
            api.gameId
        )

        fun playerToDomain(api: GamePlayerDTO) = PlayerDomain(
            api.data.id,
            api.data.name.international
        )
    }
}
