package es.florit.android.data.datasource.speedruns.entity

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class GamePlayerDTO(val data: PlayerDTO) {

    @JsonClass(generateAdapter = true)
    data class PlayerDTO(val id: String, val name: PlayerName) {

        @JsonClass(generateAdapter = true)
        data class PlayerName(val international: String)
    }
}