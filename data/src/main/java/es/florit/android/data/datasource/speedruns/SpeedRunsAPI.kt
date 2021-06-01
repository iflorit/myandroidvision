package es.florit.android.data.datasource.speedruns

import es.florit.android.data.datasource.speedruns.entity.GamePlayerDTO
import es.florit.android.data.datasource.speedruns.entity.GameRunsListDTO
import es.florit.android.data.datasource.speedruns.entity.GamesListDTO
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query


interface SpeedRunsAPI {

    @GET("games")
    suspend fun getGamesList(): Response<GamesListDTO>

    @GET("runs")
    suspend fun getGameRuns(@Query("game") gameId: String): Response<GameRunsListDTO>

    @GET("users/{id}")
    suspend fun getGamePlayer(@Path("id") playerId: String): Response<GamePlayerDTO>

    companion object {
        private lateinit var instance: SpeedRunsAPI

        fun newInstance(): SpeedRunsAPI {
            if (!this::instance.isInitialized) {
                val httpClient = OkHttpClient.Builder().apply {
                    addInterceptor(HttpLoggingInterceptor().apply {
                        level = HttpLoggingInterceptor.Level.BODY
                    })
                }

                val retrofit = Retrofit.Builder()
                    .baseUrl("https://www.speedrun.com/api/v1/") // TODO move to config
                    .addConverterFactory(MoshiConverterFactory.create())
                    .client(httpClient.build())
                    .build()
                instance = retrofit.create(SpeedRunsAPI::class.java)
            }

            return instance
        }
    }
}
