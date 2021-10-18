package tn.esprit.curriculumvitae.data

import androidx.annotation.DrawableRes

data class Education (
    val id: Int,
    val companyName: String,
    val companyAddress: String,
    val startDate: String,
    val endDate: String,
    @DrawableRes
    val companyLogo: Int
)