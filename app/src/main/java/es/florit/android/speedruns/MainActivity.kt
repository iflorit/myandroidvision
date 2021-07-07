package es.florit.android.speedruns

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import dagger.hilt.android.AndroidEntryPoint
import es.florit.android.gameslist.GamesListActivity

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
    }

    override fun onResume() {
        super.onResume()

        startActivity(Intent(this, GamesListActivity::class.java))
    }
}