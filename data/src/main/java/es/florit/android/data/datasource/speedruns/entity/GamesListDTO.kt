package es.florit.android.data.datasource.speedruns.entity

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class GamesListDTO(val data: List<GameDTO>) {

    @JsonClass(generateAdapter = true)
    data class GameDTO(val id: String, val names: GameName, val links: List<Link>) {

        @JsonClass(generateAdapter = true)
        data class GameName(val international: String)

        @JsonClass(generateAdapter = true)
        data class Link(val rel: String, val uri: String)

        val speedruns = links.filter { it.rel == "runs" }
    }
}
