package es.florit.android.gameslist

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import es.florit.android.speedruns.R

class GamesListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_games_list)

        if(savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.root_container, GameListFragment.newInstance())
                .commitAllowingStateLoss()
        }
    }

}