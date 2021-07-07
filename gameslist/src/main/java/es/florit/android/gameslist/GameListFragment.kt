package es.florit.android.gameslist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import dagger.hilt.android.AndroidEntryPoint
import es.florit.android.speedruns.databinding.GamelistFragmentBinding

@AndroidEntryPoint
class GameListFragment : Fragment() {

    companion object {
        fun newInstance() = GameListFragment()
    }

    private lateinit var binding: GamelistFragmentBinding
    private val viewModel: GameListViewModel by lazy { ViewModelProvider(this).get(GameListViewModel::class.java) }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = GamelistFragmentBinding.inflate(layoutInflater)

        viewModel.gamesList.observe(viewLifecycleOwner) { gamesList ->
            binding.message.text = gamesList[0].name
        }

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.loadGamesList()
    }
}