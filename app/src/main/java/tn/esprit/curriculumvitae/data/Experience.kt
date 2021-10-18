package tn.esprit.curriculumvitae.data

import androidx.annotation.DrawableRes

data class Experience (
    val id: Int,
    val companyName: String,
    val companyAddress: String,
    val startDate: String,
    val endDate: String,
    @DrawableRes
    val companyLogo: Int,
    val workDescription: String
)