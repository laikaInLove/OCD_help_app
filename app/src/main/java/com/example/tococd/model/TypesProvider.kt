package com.example.tococd.model

class TypesProvider {

    companion object{
        fun getAll(): List<TypesModel>{
            return typesList
        }

        private val typesList = listOf<TypesModel>(
            TypesModel(
                "https://pics.freeicons.io/uploads/icons/png/18667309301583900707-512.png",
                "Contamination OCD",
                "Pollution OCD is one of the most well-known types of obsessive-compulsive disorder. This type of OCD can lead a person to have obsessive thoughts and fear of being \"contaminated\".",
                "https://www.gatewayocd.com/contamination-ocd-symptoms-and-treatment/#:~:text=Common%20Obsessions%20of%20Contamination%20OCD&text=An%20extreme%20fear%20of%20becoming,bodily%20fluids%2C%20feces%2C%20or%20urine"

            ),
            TypesModel(
                "https://pics.freeicons.io/uploads/icons/png/19362027081584408948-512.png",
                "Harm OCD",
                "Harm OCD is a subtype of obsessive-compulsive disorder (OCD) that causes intrusive unwanted thoughts, images or urges to harm oneself or others.",
                "https://www.treatmyocd.com/blog/what-is-harm-ocd-guide-to-ocd-subtype"
            ),
            TypesModel(
                "https://pics.freeicons.io/uploads/icons/png/5259486911548347813-512.png",
                "Relationship OCD",
                "Relational OCD is a form of obsessive-compulsive disorder in which people experience intrusive thoughts and compulsive behaviors related to their relationship.",
                "https://iocdf.org/expert-opinions/relationship-ocd/"
            ),
            TypesModel(
                "https://pics.freeicons.io/uploads/icons/png/6499028831535699800-512.png",
                "Pure OCD",
                "Pure OCD, also known as purely obsessive OCD, is a form of OCD characterized by intrusive, unwanted and uncontrollable thoughts which have mostly mental rather than physical rituals.",
                "https://www.verywellmind.com/pure-o-primarily-obsessional-ocd-4159144"
            ),
            TypesModel(
                "https://pics.freeicons.io/uploads/icons/png/14069564021594722314-512.png",
                "Pedophilia OCD",
                "Pedophilia OCD is a subtype of obsessive-compulsive disorder characterized by obsessive thoughts, images and impulses and compulsive behaviors around sexual thoughts about children.",
                "https://www.treatmyocd.com/blog/your-complete-guide-to-pedophilia-ocd-pocd"
            ),
            TypesModel(
                "https://pics.freeicons.io/uploads/icons/png/158821631916377781037413-512.png",
                "Religious OCD",
                "People with religious OCD base their compulsions and obsessions in religious or morally thoughts. People with this OCD type have recurrent intrusive and unwanted \"blasphemous\" thoughts.",
                "https://www.straighttalkcounseling.org/post/understanding-and-treating-religious-ocd#:~:text=What%20is%20Religious%20OCD%3F,thinking%2C%20or%20other%20intrusive%20thoughts."
            ),
            TypesModel(
                "https://pics.freeicons.io/uploads/icons/png/9159105411644559554-512.png",
                "Magical thinking OCD",
                "Obsessive-compulsive disorder due to magical thinking is a subtype of OCD characterized by intrusive thoughts and compulsive behaviors around superstition or magical thinking to avoid negative experiences.",
                "https://www.treatmyocd.com/blog/what-is-magical-thinking-ocd"
            ),
            TypesModel(
                "https://pics.freeicons.io/uploads/icons/png/13117727621584408947-512.png",
                "Health concern OCD",
                "Health-related obsessive-compulsive disorder is a subtype of OCD that causes the person to have obsessive thoughts about developing a serious illness in themselves or others.",
                "https://www.gatewayocd.com/health-concern-ocd-symptoms-and-treatment/#:~:text=Health%20Concern%20Obsessive%2DCompulsive%20Disorder,to%20perform%20compulsions%20to%20cope."
            ),
            TypesModel(
                "https://pics.freeicons.io/uploads/icons/png/19347141911621352414-512.png",
                "Existential OCD",
                "Existential OCD consists of intrusive and repetitive thinking about unanswerable questions that may be philosophical or existentialist in nature, or both.",
                "https://iocdf.org/expert-opinions/to-be-or-not-to-be-that-is-the-obsession-existential-and-philosophical-ocd/#:~:text=Existential%20OCD%20involves%20intrusive%2C%20repetitive,or%20even%20one's%20own%20existence."
            ),
            TypesModel(
                "https://pics.freeicons.io/uploads/icons/png/8466646871637903641-512.png",
                "Suicidal OCD",
                "Suicidal obsessive-compulsive disorder (OCD) is an OCD subtype that includes unwanted thoughts, images, or impulses related to killing oneself.",
                "https://www.treatmyocd.com/blog/suicidal-ocd-2"
            ),
            TypesModel(
                "https://pics.freeicons.io/uploads/icons/png/8842634661579252551-512.png",
                "False memory OCD",
                "Obsessive-compulsive disorder (OCD) of false memory is a subtype of OCD characterized by continuous intrusive thoughts of doubt and compulsive behavior around a past event.",
                "https://www.treatmyocd.com/blog/false-memory-ocd"
            )

        )
    }
}