package es.florit.android.data.datasource.speedruns

import android.util.Log
import es.florit.android.data.datasource.speedruns.entity.GamePlayerDTO
import es.florit.android.data.datasource.speedruns.entity.GameRunsListDTO
import es.florit.android.data.datasource.speedruns.entity.GamesListDTO
import es.florit.android.domain.base.Failure
import es.florit.android.domain.base.Result
import es.florit.android.domain.base.Success
import es.florit.android.domain.repository.SpeedRunsRepositoryContract
import retrofit2.Response

class SpeedRunsDatasource {

    suspend fun getGamePlayer(playerId: String): Result<GamePlayerDTO, SpeedRunsRepositoryContract.ErrorUtils> {
        return getResponse(
            request = { SpeedRunsAPI.newInstance().getGamePlayer(playerId) },
            defaultErrorMessage = SpeedRunsRepositoryContract.ErrorUtils("Error fetching Movie list")
        )
    }

    suspend fun getGameRuns(gameId: String): Result<GameRunsListDTO, SpeedRunsRepositoryContract.ErrorUtils> {
        return getResponse(
            request = { SpeedRunsAPI.newInstance().getGameRuns(gameId) },
            defaultErrorMessage = SpeedRunsRepositoryContract.ErrorUtils("Error fetching Movie list")
        )
    }

    suspend fun getGamesList(): Result<GamesListDTO, SpeedRunsRepositoryContract.ErrorUtils> {
        return getResponse(
            request = { SpeedRunsAPI.newInstance().getGamesList() },
            defaultErrorMessage = SpeedRunsRepositoryContract.ErrorUtils("Error fetching Movie list")
        )
    }

    @Suppress("UNCHECKED_CAST")
    private suspend fun <T, E> getResponse(
        request: suspend () -> Response<T>,
        defaultErrorMessage: E
    ): Result<T, E> {
        return try {
            val result = request.invoke()
            if (result.isSuccessful) {
                return Success(result.body() as T) as Result<T, E>
            } else {
                val errorResponse: String =
                    SpeedRunsRepositoryContract.ErrorUtils.parseError(result)
                return Failure(SpeedRunsRepositoryContract.ErrorUtils(errorResponse) as E) as Result<T, E>
            }
        } catch (e: Throwable) {
            Log.d("ISMAEL", e.toString())
            return Failure(SpeedRunsRepositoryContract.ErrorUtils("Unknown: "+e.toString()) as E) as Result<T, E>
        }
    }
}