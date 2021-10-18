package tn.esprit.curriculumvitae.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import tn.esprit.curriculumvitae.R
import tn.esprit.curriculumvitae.adapters.ExperienceAdapter
import tn.esprit.curriculumvitae.data.Experience


class ExperienceFragment : Fragment() {

    lateinit var experienceRecyclerView: RecyclerView
    lateinit var experienceAdapter: ExperienceAdapter

    lateinit var experienceList : MutableList<Experience>

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val rootView = inflater.inflate(R.layout.fragment_experience, container, false)

        experienceRecyclerView = rootView.findViewById(R.id.recyclerExperience)
        fillData()

        experienceAdapter = ExperienceAdapter(experienceList)

        experienceRecyclerView.adapter = experienceAdapter

        experienceRecyclerView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL ,false)

        return rootView
    }

    fun fillData(){
        experienceList = ArrayList()
        experienceList.add(Experience(1,"AMAZON", "UNITED STATES", "01/09/2019","TODAY",R.drawable.ic_logo_amazon, getString(R.string.loremIpsum)))
        experienceList.add(Experience(2,"FACEBOOK", "FRANCE", "01/09/2018","31/08/2019",R.drawable.ic_logo_facebook, getString(R.string.loremIpsum)))
        experienceList.add(Experience(3,"GOOGLE", "GERMANY", "01/09/2017","31/08/2018",R.drawable.ic_logo_google, getString(R.string.loremIpsum)))
        experienceList.add(Experience(4,"LINKEDIN", "SPAIN", "01/09/2016","31/08/2017",R.drawable.ic_logo_linkedin, getString(R.string.loremIpsum)))
        experienceList.add(Experience(5,"MICROSOFT", "UNITED KINGDOM", "01/09/2015","31/08/2016",R.drawable.ic_logo_microsoft, getString(R.string.loremIpsum)))
        experienceList.add(Experience(6,"ESPRIT", "TUNISIA", "01/09/2013","31/08/2015",R.drawable.ic_logo_esprit, getString(R.string.loremIpsum)))
    }
}