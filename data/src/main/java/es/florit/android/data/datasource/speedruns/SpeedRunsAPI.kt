package es.florit.android.data.datasource.speedruns

import es.florit.android.data.datasource.speedruns.entity.GamePlayerDTO
import es.florit.android.data.datasource.speedruns.entity.GameRunsListDTO
import es.florit.android.data.datasource.speedruns.entity.GamesListDTO
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface SpeedRunsAPI {

    @GET("games")
    fun getGamesList(): Response<GamesListDTO>

    @GET("runs")
    fun getGameRuns(@Query("game") gameId: String): Response<GameRunsListDTO>

    @GET("users/{id}")
    fun getGamePlayer(@Path("id") playerId: String): Response<GamePlayerDTO>

    companion object {
        private lateinit var instance: SpeedRunsAPI

        fun newInstance(): SpeedRunsAPI {
            if (!this::instance.isInitialized) {
                val retrofit = Retrofit.Builder()
                    .baseUrl("https://www.speedrun.com/api/v1/") // TODO move to config
                    .addConverterFactory(MoshiConverterFactory.create())
                    .build()
                instance = retrofit.create(SpeedRunsAPI::class.java)
            }

            return instance
        }
    }
}
