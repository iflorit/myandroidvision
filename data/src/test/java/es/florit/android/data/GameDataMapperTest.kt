package es.florit.android.data

import com.squareup.moshi.Moshi
import es.florit.android.data.datasource.speedruns.entity.GameRunsListDTO
import es.florit.android.data.datasource.speedruns.entity.GamesListDTO
import es.florit.android.domain.entity.GameDomain
import es.florit.android.domain.entity.GameRunDomain
import org.junit.Assert.assertEquals
import org.junit.Test

/**
 * Every mapping test should include all those fields that will be used
 * anytime into this project to ensure any value is missing
 */
internal class SpeedRunsJSONMapperTest {

    @Test
    fun testGamesListJSONMapping() {
        val gamesListJSON = """
{
  "data": [
    {
      "id": "k6qqkx6g",
      "names": {
        "international": "! Fishy !",
        "japanese": null,
        "twitch": "! Fishy !"
      },
      "abbreviation": "fishy",
      "weblink": "https://www.speedrun.com/fishy",
      "released": 2003,
      "release-date": "2003-02-02",
      "ruleset": {
        "show-milliseconds": false,
        "require-verification": true,
        "require-video": true,
        "run-times": [
          "realtime"
        ],
        "default-time": "realtime",
        "emulators-allowed": false
      },
      "romhack": false,
      "gametypes": [
        
      ],
      "platforms": [
        "o7e25xew"
      ],
      "regions": [
        
      ],
      "genres": [
        
      ],
      "engines": [
        "mg1j4w1r"
      ],
      "developers": [
        "veg7rpe0"
      ],
      "publishers": [
        
      ],
      "moderators": {
        "mkj9nw84": "super-moderator"
      },
      "created": "2016-05-28T23:21:12Z",
      "assets": {
        "logo": {
          "uri": "https://www.speedrun.com/themes/fishy/logo.png",
          "width": 180,
          "height": 22
        },
        "cover-tiny": {
          "uri": "https://www.speedrun.com/themes/fishy/cover-32.png",
          "width": 45,
          "height": 32
        },
        "cover-small": {
          "uri": "https://www.speedrun.com/themes/fishy/cover-64.png",
          "width": 90,
          "height": 64
        },
        "cover-medium": {
          "uri": "https://www.speedrun.com/themes/fishy/cover-128.png",
          "width": 180,
          "height": 128
        },
        "cover-large": {
          "uri": "https://www.speedrun.com/themes/fishy/cover-256.png",
          "width": 360,
          "height": 256
        },
        "icon": {
          "uri": "https://www.speedrun.com/themes/fishy/favicon.png",
          "width": 32,
          "height": 32
        },
        "trophy-1st": {
          "uri": "https://www.speedrun.com/themes/fishy/1st.png",
          "width": 16,
          "height": 15
        },
        "trophy-2nd": {
          "uri": "https://www.speedrun.com/themes/fishy/2nd.png",
          "width": 16,
          "height": 15
        },
        "trophy-3rd": {
          "uri": "https://www.speedrun.com/themes/fishy/3rd.png",
          "width": 16,
          "height": 15
        },
        "trophy-4th": null,
        "background": {
          "uri": "https://www.speedrun.com/themes/fishy/background.png",
          "width": 1391,
          "height": 787
        },
        "foreground": {
          "uri": "https://www.speedrun.com/themes/fishy/foreground.png",
          "width": 200,
          "height": 74
        }
      },
      "links": [
        {
          "rel": "self",
          "uri": "https://www.speedrun.com/api/v1/games/k6qqkx6g"
        },
        {
          "rel": "runs",
          "uri": "https://www.speedrun.com/api/v1/runs?game=k6qqkx6g"
        },
        {
          "rel": "levels",
          "uri": "https://www.speedrun.com/api/v1/games/k6qqkx6g/levels"
        },
        {
          "rel": "categories",
          "uri": "https://www.speedrun.com/api/v1/games/k6qqkx6g/categories"
        },
        {
          "rel": "variables",
          "uri": "https://www.speedrun.com/api/v1/games/k6qqkx6g/variables"
        },
        {
          "rel": "records",
          "uri": "https://www.speedrun.com/api/v1/games/k6qqkx6g/records"
        },
        {
          "rel": "series",
          "uri": "https://www.speedrun.com/api/v1/series/yr4gon12"
        },
        {
          "rel": "derived-games",
          "uri": "https://www.speedrun.com/api/v1/games/k6qqkx6g/derived-games"
        },
        {
          "rel": "romhacks",
          "uri": "https://www.speedrun.com/api/v1/games/k6qqkx6g/derived-games"
        },
        {
          "rel": "leaderboard",
          "uri": "https://www.speedrun.com/api/v1/leaderboards/k6qqkx6g/category/rklgq3rd"
        }
      ]
    },
    {
      "id": "3dx2pk41",
      "names": {
        "international": "!findseed the map",
        "japanese": null,
        "twitch": "!findseed the map"
      },
      "abbreviation": "findseed",
      "weblink": "https://www.speedrun.com/findseed",
      "released": 2020,
      "release-date": "2020-02-22",
      "ruleset": {
        "show-milliseconds": true,
        "require-verification": true,
        "require-video": true,
        "run-times": [
          "realtime",
          "ingame"
        ],
        "default-time": "realtime",
        "emulators-allowed": true
      },
      "romhack": true,
      "gametypes": [
        "4xm721op"
      ],
      "platforms": [
        "8gej2n93",
        "mx6ppw63",
        "5neg7key"
      ],
      "regions": [
        
      ],
      "genres": [
        
      ],
      "engines": [
        
      ],
      "developers": [
        
      ],
      "publishers": [
        
      ],
      "moderators": {
        "v8lvq4jm": "moderator",
        "v8192kpx": "moderator",
        "e8e793px": "super-moderator",
        "v817g1q8": "moderator",
        "x354op2j": "moderator",
        "8e9n26oj": "moderator",
        "jn39g1qx": "moderator"
      },
      "created": "2020-02-26T01:39:35Z",
      "assets": {
        "logo": {
          "uri": "https://www.speedrun.com/images/logo.png",
          "width": 1897,
          "height": 121
        },
        "cover-tiny": {
          "uri": "https://www.speedrun.com/themes/findseed/cover-32.png",
          "width": 32,
          "height": 32
        },
        "cover-small": {
          "uri": "https://www.speedrun.com/themes/findseed/cover-64.png",
          "width": 64,
          "height": 64
        },
        "cover-medium": {
          "uri": "https://www.speedrun.com/themes/findseed/cover-128.png",
          "width": 128,
          "height": 128
        },
        "cover-large": {
          "uri": "https://www.speedrun.com/themes/findseed/cover-256.png",
          "width": 256,
          "height": 256
        },
        "icon": {
          "uri": "https://www.speedrun.com/images/favicon.png",
          "width": 414,
          "height": 360
        },
        "trophy-1st": {
          "uri": "https://www.speedrun.com/themes/mc/1st.png",
          "width": 64,
          "height": 64
        },
        "trophy-2nd": {
          "uri": "https://www.speedrun.com/themes/mc/2nd.png",
          "width": 64,
          "height": 64
        },
        "trophy-3rd": {
          "uri": "https://www.speedrun.com/themes/mc/3rd.png",
          "width": 64,
          "height": 64
        },
        "trophy-4th": null,
        "background": null,
        "foreground": null
      },
      "links": [
        {
          "rel": "self",
          "uri": "https://www.speedrun.com/api/v1/games/3dx2pk41"
        },
        {
          "rel": "runs",
          "uri": "https://www.speedrun.com/api/v1/runs?game=3dx2pk41"
        },
        {
          "rel": "levels",
          "uri": "https://www.speedrun.com/api/v1/games/3dx2pk41/levels"
        },
        {
          "rel": "categories",
          "uri": "https://www.speedrun.com/api/v1/games/3dx2pk41/categories"
        },
        {
          "rel": "variables",
          "uri": "https://www.speedrun.com/api/v1/games/3dx2pk41/variables"
        },
        {
          "rel": "records",
          "uri": "https://www.speedrun.com/api/v1/games/3dx2pk41/records"
        },
        {
          "rel": "series",
          "uri": "https://www.speedrun.com/api/v1/series/y71gezl7"
        },
        {
          "rel": "base-game",
          "uri": "https://www.speedrun.com/api/v1/games/j1npme6p"
        },
        {
          "rel": "game",
          "uri": "https://www.speedrun.com/api/v1/games/j1npme6p"
        },
        {
          "rel": "derived-games",
          "uri": "https://www.speedrun.com/api/v1/games/3dx2pk41/derived-games"
        },
        {
          "rel": "romhacks",
          "uri": "https://www.speedrun.com/api/v1/games/3dx2pk41/derived-games"
        },
        {
          "rel": "leaderboard",
          "uri": "https://www.speedrun.com/api/v1/leaderboards/3dx2pk41/category/zd3wr1rk"
        }
      ]
    }
    ]
}
    
        """
        val attestation = arrayOf(
            GameDomain("k6qqkx6g", "! Fishy !"),
            GameDomain("3dx2pk41", "!findseed the map")
        )

        val gamesList: GamesListDTO = Moshi.Builder().build().adapter(GamesListDTO::class.java)
            .fromJson(gamesListJSON) as GamesListDTO

        gamesList.data.forEachIndexed { index, game ->
            val (id, name) = attestation[index]

            assertEquals(id, game.id)
            assertEquals(name, game.names.international)
        }
    }

    @Test
    fun testGameRunJSONMapping() {
        val fishyRunsJSON = """
{
  "data": [
    {
      "id": "7z0nvdem",
      "weblink": "https://www.speedrun.com/fishy/run/7z0nvdem",
      "game": "k6qqkx6g",
      "level": null,
      "category": "rklgq3rd",
      "videos": {
        "links": [
          {
            "uri": "https://youtu.be/-Vesbd8uJzE"
          }
        ]
      },
      "comment": null,
      "status": {
        "status": "verified",
        "examiner": "mkj9nw84",
        "verify-date": "2016-05-29T00:31:08Z"
      },
      "players": [
        {
          "rel": "user",
          "id": "mkj9nw84",
          "uri": "https://www.speedrun.com/api/v1/users/mkj9nw84"
        }
      ],
      "date": "2016-05-24",
      "submitted": "2016-05-29T00:31:08Z",
      "times": {
        "primary": "PT7M15S",
        "primary_t": 435,
        "realtime": "PT7M15S",
        "realtime_t": 435,
        "realtime_noloads": null,
        "realtime_noloads_t": 0,
        "ingame": null,
        "ingame_t": 0
      },
      "system": {
        "platform": "o7e25xew",
        "emulated": false,
        "region": null
      },
      "splits": null,
      "values": {
        
      },
      "links": [
        {
          "rel": "self",
          "uri": "https://www.speedrun.com/api/v1/runs/7z0nvdem"
        },
        {
          "rel": "game",
          "uri": "https://www.speedrun.com/api/v1/games/k6qqkx6g"
        },
        {
          "rel": "category",
          "uri": "https://www.speedrun.com/api/v1/categories/rklgq3rd"
        },
        {
          "rel": "platform",
          "uri": "https://www.speedrun.com/api/v1/platforms/o7e25xew"
        },
        {
          "rel": "examiner",
          "uri": "https://www.speedrun.com/api/v1/users/mkj9nw84"
        }
      ]
    },
    {
      "id": "oy2jl25z",
      "weblink": "https://www.speedrun.com/fishy/run/oy2jl25z",
      "game": "k6qqkx6g",
      "level": null,
      "category": "rklgq3rd",
      "videos": {
        "links": [
          {
            "uri": "https://youtu.be/G3vC6x7CTSI"
          }
        ]
      },
      "comment": "Game can be found here: http://www.fishygame.org",
      "status": {
        "status": "verified",
        "examiner": "mkj9nw84",
        "verify-date": "2016-05-29T00:35:39Z"
      },
      "players": [
        {
          "rel": "guest",
          "name": "MrBlie",
          "uri": "https://www.speedrun.com/api/v1/guests/MrBlie"
        }
      ],
      "date": "2014-01-05",
      "submitted": "2016-05-29T00:35:39Z",
      "times": {
        "primary": "PT11M9S",
        "primary_t": 669,
        "realtime": "PT11M9S",
        "realtime_t": 669,
        "realtime_noloads": null,
        "realtime_noloads_t": 0,
        "ingame": null,
        "ingame_t": 0
      },
      "system": {
        "platform": "o7e25xew",
        "emulated": false,
        "region": null
      },
      "splits": null,
      "values": {
        
      },
      "links": [
        {
          "rel": "self",
          "uri": "https://www.speedrun.com/api/v1/runs/oy2jl25z"
        },
        {
          "rel": "game",
          "uri": "https://www.speedrun.com/api/v1/games/k6qqkx6g"
        },
        {
          "rel": "category",
          "uri": "https://www.speedrun.com/api/v1/categories/rklgq3rd"
        },
        {
          "rel": "platform",
          "uri": "https://www.speedrun.com/api/v1/platforms/o7e25xew"
        },
        {
          "rel": "examiner",
          "uri": "https://www.speedrun.com/api/v1/users/mkj9nw84"
        }
      ]
    }
  ]
}
        """
        val attestation = arrayOf(
            GameRunDomain(runId = "7z0nvdem", gameId = "k6qqkx6g"),
            GameRunDomain(runId = "oy2jl25z", gameId = "k6qqkx6g")
        )

        val fishyRunsList: GameRunsListDTO =
            Moshi.Builder().build().adapter(GameRunsListDTO::class.java)
                .fromJson(fishyRunsJSON) as GameRunsListDTO

        fishyRunsList.data.forEachIndexed { index, game ->
            val (runId, gameId) = attestation[index]

            assertEquals(runId, game.runId)
            assertEquals(gameId, game.gameId)
        }
    }
}