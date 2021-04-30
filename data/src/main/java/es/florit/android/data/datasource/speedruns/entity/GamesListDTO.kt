package es.florit.android.data.datasource.speedruns.entity

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class GamesListDTO(val data: List<GameDTO>) {

    @JsonClass(generateAdapter = true)
    data class GameDTO(val id: String, val names: GameName) {

        @JsonClass(generateAdapter = true)
        data class GameName(val international: String)
    }
}
