package tn.esprit.curriculumvitae.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import tn.esprit.curriculumvitae.R
import tn.esprit.curriculumvitae.data.Experience

class ExperienceAdapter (val experienceList: MutableList<Experience>) : RecyclerView.Adapter<ExperienceAdapter.ExperienceViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ExperienceViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.experience_single_row, parent, false)
        return ExperienceViewHolder(view)
    }

    override fun onBindViewHolder(holder: ExperienceViewHolder, position: Int) {
        val name = experienceList[position].companyName
        val logo = experienceList[position].companyLogo
        val address = experienceList[position].companyAddress
        val startDate = experienceList[position].startDate
        val endDate = experienceList[position].endDate
        val description = experienceList[position].workDescription

        holder.companyLogo.setImageResource(logo)
        holder.companyName.text = name
        holder.companyAddress.text = address
        holder.startDate.text = startDate
        holder.endDate.text = endDate
        holder.companyDescription.text = description

    }

    override fun getItemCount(): Int = experienceList.size

    class ExperienceViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val companyLogo = itemView.findViewById<ImageView>(R.id.companyLogo)
        val companyName = itemView.findViewById<TextView>(R.id.companyName)
        val companyAddress = itemView.findViewById<TextView>(R.id.companyAddress)
        val startDate = itemView.findViewById<TextView>(R.id.startDate)
        val endDate = itemView.findViewById<TextView>(R.id.endDate)
        val companyDescription = itemView.findViewById<TextView>(R.id.workDescription)
    }
}