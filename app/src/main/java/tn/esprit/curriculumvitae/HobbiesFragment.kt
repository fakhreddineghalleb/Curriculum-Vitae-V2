package tn.esprit.curriculumvitae

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import androidx.fragment.app.Fragment

class HobbiesFragment : Fragment() {

    private lateinit var cbSport : CheckBox
    private lateinit var cbMusic : CheckBox
    private lateinit var cbGames : CheckBox

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        var rootView :View = inflater.inflate(R.layout.fragment_hobbies, container, false)

        cbSport = rootView.findViewById(R.id.cbSport)
        cbMusic = rootView.findViewById(R.id.cbMusic)
        cbGames = rootView.findViewById(R.id.cbGames)

        cbSport.isEnabled = false
        cbMusic.isEnabled = false
        cbGames.isEnabled = false

        cbSport.isChecked = requireArguments().getBoolean(IS_SPORT,false)
        cbMusic.isChecked = requireArguments().getBoolean(IS_MUSIC,false)
        cbGames.isChecked = requireArguments().getBoolean(IS_GAMES,false)

        return rootView
    }

    companion object {
        @JvmStatic
        fun newInstance(isSport: Boolean, isMusic: Boolean, isGames: Boolean) = HobbiesFragment().apply {
            arguments = Bundle().apply {
                putBoolean(IS_SPORT, isSport)
                putBoolean(IS_MUSIC, isMusic)
                putBoolean(IS_GAMES, isGames)
            }
        }
    }
}