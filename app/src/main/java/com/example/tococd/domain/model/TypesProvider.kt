package com.example.tococd.domain.model

import com.example.tococd.R

class TypesProvider {

    companion object{
        fun getAll(): List<TypesModel>{
            return typesList
        }

        private val typesList = listOf<TypesModel>(
            TypesModel(
                "https://pics.freeicons.io/uploads/icons/png/18667309301583900707-512.png",
                R.string.contamination_ocd,
                R.string.contamination_ocd_description,
                "https://www.gatewayocd.com/contamination-ocd-symptoms-and-treatment/#:~:text=Common%20Obsessions%20of%20Contamination%20OCD&text=An%20extreme%20fear%20of%20becoming,bodily%20fluids%2C%20feces%2C%20or%20urine"

            ),
            TypesModel(
                "https://pics.freeicons.io/uploads/icons/png/19362027081584408948-512.png",
                R.string.harm_ocd,
                R.string.harm_ocd_description,
                "https://www.treatmyocd.com/blog/what-is-harm-ocd-guide-to-ocd-subtype"
            ),
            TypesModel(
                "https://pics.freeicons.io/uploads/icons/png/5259486911548347813-512.png",
                R.string.relationship_ocd,
                R.string.relationship_ocd_description,
                "https://iocdf.org/expert-opinions/relationship-ocd/"
            ),
            TypesModel(
                "https://pics.freeicons.io/uploads/icons/png/6499028831535699800-512.png",
                R.string.pure_ocd,
                R.string.pure_ocd_description,
                "https://www.verywellmind.com/pure-o-primarily-obsessional-ocd-4159144"
            ),
            TypesModel(
                "https://pics.freeicons.io/uploads/icons/png/14069564021594722314-512.png",
                R.string.pedophilia_ocd,
                R.string.pedophilia_ocd_description,
                "https://www.treatmyocd.com/blog/your-complete-guide-to-pedophilia-ocd-pocd"
            ),
            TypesModel(
                "https://pics.freeicons.io/uploads/icons/png/158821631916377781037413-512.png",
                R.string.religious_ocd,
                R.string.relationship_ocd_description,
                "https://www.straighttalkcounseling.org/post/understanding-and-treating-religious-ocd#:~:text=What%20is%20Religious%20OCD%3F,thinking%2C%20or%20other%20intrusive%20thoughts."
            ),
            TypesModel(
                "https://pics.freeicons.io/uploads/icons/png/9159105411644559554-512.png",
                R.string.magical_thinking_ocd,
                R.string.magical_thinking_ocd_description,
                "https://www.treatmyocd.com/blog/what-is-magical-thinking-ocd"
            ),
            TypesModel(
                "https://pics.freeicons.io/uploads/icons/png/13117727621584408947-512.png",
                R.string.health_concern_ocd,
                R.string.health_concern_ocd_description,
                "https://www.gatewayocd.com/health-concern-ocd-symptoms-and-treatment/#:~:text=Health%20Concern%20Obsessive%2DCompulsive%20Disorder,to%20perform%20compulsions%20to%20cope."
            ),
            TypesModel(
                "https://pics.freeicons.io/uploads/icons/png/19347141911621352414-512.png",
                R.string.existential_ocd,
                R.string.existential_ocd_description,
                "https://iocdf.org/expert-opinions/to-be-or-not-to-be-that-is-the-obsession-existential-and-philosophical-ocd/#:~:text=Existential%20OCD%20involves%20intrusive%2C%20repetitive,or%20even%20one's%20own%20existence."
            ),
            TypesModel(
                "https://pics.freeicons.io/uploads/icons/png/8466646871637903641-512.png",
                R.string.suicidal_ocd,
                R.string.suicidal_ocd_description,
                "https://www.treatmyocd.com/blog/suicidal-ocd-2"
            ),
            TypesModel(
                "https://pics.freeicons.io/uploads/icons/png/8842634661579252551-512.png",
                R.string.false_memory_ocd,
                R.string.false_memory_ocd_description,
                "https://www.treatmyocd.com/blog/false-memory-ocd"
            )

        )
    }
}