package tn.esprit.curriculumvitae.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import tn.esprit.curriculumvitae.R
import tn.esprit.curriculumvitae.data.Education

class EducationAdapter(val educationList: MutableList<Education>) : RecyclerView.Adapter<EducationAdapter.EducationViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): EducationViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.education_single_row, parent, false)
        return EducationViewHolder(view)
    }

    override fun onBindViewHolder(holder: EducationViewHolder, position: Int) {
        val name = educationList[position].companyName
        val logo = educationList[position].companyLogo
        val address = educationList[position].companyAddress
        val startDate = educationList[position].startDate
        val endDate = educationList[position].endDate

        holder.companyLogo.setImageResource(logo)
        holder.companyName.text = name
        holder.companyAddress.text = address
        holder.startDate.text = startDate
        holder.endDate.text = endDate

    }

    override fun getItemCount(): Int = educationList.size

    class EducationViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val companyLogo = itemView.findViewById<ImageView>(R.id.companyLogo)
        val companyName = itemView.findViewById<TextView>(R.id.companyName)
        val companyAddress = itemView.findViewById<TextView>(R.id.companyAddress)
        val startDate = itemView.findViewById<TextView>(R.id.startDate)
        val endDate = itemView.findViewById<TextView>(R.id.endDate)
    }
}