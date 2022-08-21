package com.example.tococd.domain.model

import com.example.tococd.R

object InformationProvider {
    val informationList = listOf(
//            InformationModel(
//                1,
//                "Welcome to the information area, remember that the first step to improve is to be informed, here you will know the answers to the biggest questions that arise around OCD. This will be the first place to start learning about it.",
//                "",
//                ""
//            ),
        InformationModel(
            R.drawable.question,
            R.string.what_is_the_OCD,
            R.string.question_info
        ),
        InformationModel(
            R.drawable.mind_work,
            R.string.howWorks,
            R.string.hWDescription
        ),
        InformationModel(
            R.drawable.confusion,
            R.string.what_symptoms,
            R.string.what_symptoms_description
        ),
        InformationModel(
            R.drawable.age,
            R.string.age_ocd,
            R.string.age_ocd_description
        ),
        InformationModel(
            R.drawable.adult,
            R.string.adults_ocd,
            R.string.adults_ocd_description
        ),
        InformationModel(
            R.drawable.childs,
            R.string.children_ocd,
            R.string.children_ocd_description

        ),
        InformationModel(
            R.drawable.causes,
            R.string.causes_ocd,
            R.string.causes_ocd_description

        ),
        InformationModel(
            R.drawable.diagnosis,
            R.string.diagnostic_is_ocd,
            R.string.diagnosis_ocd_description

        ),
        InformationModel(
            R.drawable.psychologist,
            R.string.treating_ocd,
            R.string.treating_ocd_description

        ),
        InformationModel(
            R.drawable.works,
            R.string.doubt_ocd,
            R.string.doubt_ocd_description

        ),
        InformationModel(
            R.drawable.decision,
            R.string.treating_ocd,
            R.string.treating_ocd_description

        ),
        InformationModel(
            R.drawable.choose,
            R.string.specialist_ocd,
            R.string.specialist_ocd_description,
        )
    )
}