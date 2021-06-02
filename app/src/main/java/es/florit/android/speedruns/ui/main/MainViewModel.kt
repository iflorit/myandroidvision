package es.florit.android.speedruns.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import es.florit.android.domain.GamesListUseCase
import es.florit.android.domain.base.Success
import es.florit.android.speedruns.ui.main.entity.GameModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(var gamesListUseCase: GamesListUseCase) : ViewModel() {

    private val games: MutableLiveData<List<GameModel>> by lazy {
        MutableLiveData<List<GameModel>>().also {
            loadGamesList()
        }
    }

    private val gamesList: LiveData<List<GameModel>> = games

    private  fun loadGamesList() {
        runBlocking {
            launch {
                gamesListUseCase.execute(GamesListUseCase.GamesListParams()).collect {
                    (it as? Success)?.value?.let {

                    }
                }
            }
        }
    }
}