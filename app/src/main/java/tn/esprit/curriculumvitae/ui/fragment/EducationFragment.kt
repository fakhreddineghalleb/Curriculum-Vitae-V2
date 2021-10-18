package tn.esprit.curriculumvitae.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import tn.esprit.curriculumvitae.R
import tn.esprit.curriculumvitae.adapters.EducationAdapter
import tn.esprit.curriculumvitae.data.Education

class EducationFragment : Fragment() {

    lateinit var educationRecyclerView: RecyclerView
    lateinit var educationAdapter: EducationAdapter

    lateinit var educationList : MutableList<Education>

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val rootView = inflater.inflate(R.layout.fragment_education, container, false)

        educationRecyclerView = rootView.findViewById(R.id.recyclerEducation)
        fillData()

        educationAdapter = EducationAdapter(educationList)

        educationRecyclerView.adapter = educationAdapter

        educationRecyclerView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL ,false)

        return rootView
    }

    fun fillData(){
        educationList = ArrayList()
        educationList.add(Education(1,"MASSACHUSETTS", "UNITED STATES", "01/09/2020","TODAY",R.drawable.ic_logo_massachusetts))
        educationList.add(Education(2,"OXFORD", "UNITED KINGDOM", "01/09/2018","31/08/2020",R.drawable.ic_logo_oxford))
        educationList.add(Education(3,"STANFORD", "UNITED STATES", "01/09/2016","31/08/2018",R.drawable.ic_logo_stanford))
        educationList.add(Education(4,"CAMBRIDGE", "UNITED KINGDOM", "01/09/2014","31/08/2016",R.drawable.ic_logo_cambridge))
        educationList.add(Education(5,"HARVARD", "UNITED STATES", "01/09/2012","31/08/2014",R.drawable.ic_logo_harvard))
        educationList.add(Education(6,"ESPRIT", "TUNISIA", "01/09/2009","31/08/2012",R.drawable.ic_logo_esprit))
    }

}