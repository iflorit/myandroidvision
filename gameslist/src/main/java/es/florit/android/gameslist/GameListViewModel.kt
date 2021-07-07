package es.florit.android.gameslist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import es.florit.android.domain.GamesListUseCase
import es.florit.android.domain.base.Success
import es.florit.android.gameslist.entity.GameModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import javax.inject.Inject

@HiltViewModel
class GameListViewModel @Inject constructor(private var gamesListUseCase: GamesListUseCase) :
    ViewModel() {

    private var games = MutableLiveData<List<GameModel>>()
    val gamesList: LiveData<List<GameModel>> = games

    fun loadGamesList() = runBlocking {
        launch {
            gamesListUseCase.execute(GamesListUseCase.GamesListParams()).collect { result ->
                games.postValue((result as? Success)?.value?.map { GameModel(it.name) }
                    ?: listOf())
            }
        }
    }

}