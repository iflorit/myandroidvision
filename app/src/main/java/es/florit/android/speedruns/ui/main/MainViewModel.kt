package es.florit.android.speedruns.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import es.florit.android.domain.GamesListUseCase
import es.florit.android.speedruns.ui.main.entity.GameModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(var gamesListUseCase: GamesListUseCase): ViewModel() {

    private val games: MutableLiveData<List<GameModel>> by lazy {
        MutableLiveData<List<GameModel>>().also {
            loadGamesList()
        }
    }

    private val gamesList : LiveData<List<GameModel>> = games

    private fun loadGamesList() {
        // Do an asynchronous operation to fetch users.
        val a = gamesListUseCase.execute(GamesListUseCase.GamesListParams())

    }
}