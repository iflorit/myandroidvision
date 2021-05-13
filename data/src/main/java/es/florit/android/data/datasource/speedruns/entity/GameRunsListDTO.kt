package es.florit.android.data.datasource.speedruns.entity

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class GameRunsListDTO(val data: List<GameRunDTO>) {

    @JsonClass(generateAdapter = true)
    data class GameRunDTO(
        @Json(name = "id") val runId: String,
        @Json(name = "game") val gameId: String,
        val times: GameRunTimes,
        val players: List<GameRunPlayer>
    )

    @JsonClass(generateAdapter = true)
    data class GameRunTimes(@Json(name = "primary_t") val seconds: Int)

    @JsonClass(generateAdapter = true)
    data class GameRunPlayer(val id: String?, val name: String?)
}
