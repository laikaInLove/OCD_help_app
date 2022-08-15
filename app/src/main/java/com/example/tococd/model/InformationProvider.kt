package com.example.tococd.model

import com.example.tococd.R

class InformationProvider {
    companion object {

        suspend fun getAll(): List<InformationModel> {
            return informationList
        }

        private val informationList = listOf<InformationModel>(
//            InformationModel(
//                1,
//                "Welcome to the information area, remember that the first step to improve is to be informed, here you will know the answers to the biggest questions that arise around OCD. This will be the first place to start learning about it.",
//                "",
//                ""
//            ),
            InformationModel(
                R.drawable.question,
                "What is the OCD?",
                "\uD83D\uDC49 OCD is a mental condition characterized by obsessive thoughts and compulsions that occupy at least an hour a day, but usually more, and cause significant distress.\n\n" +
                        "Obsessions are usually persistent and uncontrollable thoughts, images or ideas that appear intrusively, these obsessions are unwanted and cause a lot of discomfort.  These thoughts also cause anxiety and discomfort that significantly interfere with normal life. Following these thoughts, the person with OCD performs a series of actions in order to counteract the discomfort, which actually increases the symptoms of OCD. \n" +
                        "\n" + "\uD83D\uDC49 All people have intrusive thoughts throughout the day, but a person who does not have OCD is able to filter out recurring thoughts about germs, for example.  But people with OCD who are obsessed with germs cannot stop thinking about being contaminated and may even avoid entering public places.",
                "Touch to see"
            ),
            InformationModel(
                R.drawable.mind_work,
                "How works OCD?",
                "It is well known how OCD works within each patient, as you read above first begins with a thought, an idea or an image that appears intrusively and that clearly the person with OCD does not want it or identify with it, this whole situation generates a lot of stress, anxiety, insecurity and discomfort in the person, all this leads the person to perform a series of actions (or thoughts) called rituals which counteract for a short period of time these negative feelings of anxiety, but in reality in the long term these compulsions make the problem bigger, as they increase the symptoms of OCD.\n\n"
                        +
                        "\uD83D\uDC49 For example, a person with germ OCD has intrusive ideas, thoughts or images that everything is full of germs, so they will feel very insecure, anxious and uncomfortable, then to counteract these symptoms they will begin to wash their hands much more frequently and also stop going to certain places which they believe are contaminated, thus forming a cycle in which the person will not improve unless they stop doing these compulsions and confront their obsessions.",
                "Touch to see"
            ),
            InformationModel(
                R.drawable.confusion,
                "What are the symptoms?",
                "\uD83D\uDC49 It is very necessary to know that the obsessions represented by thoughts, ideas or images in OCD can have any theme, from excessive fear of germs, excessive fear of harming someone, among many other themes, so there are three symptoms that are always present in OCD:\n\n"
                        +
                        "\uD83D\uDD18 Intrusive thoughts, ideas and images that come to your mind suddenly and without your wanting it.\n\n" +
                        "\uD83D\uDD18 Degree of dissatisfaction, anxiety and discomfort due to the presence of these thoughts.\n\n" +
                        "\uD83D\uDD18 Actions or thoughts to counter these negative feelings\n\n",
                "Touch to see"
            ),
            InformationModel(
                R.drawable.age,
                "At what age does OCD appear?",
                "OCD equally affects men, women, and children of all races, ethnicities, and backgrounds. OCD can start at any time from preschool to adulthood.\n" +
                        "\n" +
                        "Although OCD can occur at any age, there are generally two age ranges when OCD tends to first appears:\n" +
                        "\n" +
                        "\uD83D\uDC49 Between the ages 8 and 12.\n" +
                        "\uD83D\uDC49 Between the late teen years and early adulthood.\n\n" +
                        "\uD83D\uDD18 International OCD Foundation (IOCDF)",
                "Touch to see"
            ),
            InformationModel(
                R.drawable.adult,
                "How many adults have OCD?",
                "Our best estimates are that about 1 in 100 adults — or between 2 to 3 million adults in the United States — currently have OCD.\n\n" +

                        "This is roughly the same number of people living in the city of Houston, Texas.\n\n" +
                        "\uD83D\uDD18 International OCD Foundation (IOCDF)",
                "Touch to see"
            ),
            InformationModel(
                R.drawable.childs,
                "How many children have OCD?",
                "\uD83D\uDC49 There are  at least 1 in 200  or 500,000 – kids and teens that have OCD. This is about the same number of kids who have diabetes.\n\n" +
                        "That means four or five kids with OCD are likely to be enrolled in any average size elementary school. In a medium to large high school, there could be 20 students struggling with the challenges caused by OCD.\n\n" +
                        "\uD83D\uDD18 International OCD Foundation (IOCDF)",
                "Touch to see"
            ),
            InformationModel(
                R.drawable.causes,
                "Causes of OCD?",
                "The cause of obsessive-compulsive disorder is not yet known. Factors such as genetics, brain biology and chemistry, along with the person's environment, may play an important role in the condition.",
                "Touch to see"
            ),
            InformationModel(
                R.drawable.diagnosis,
                "Diagnosis of OCD",
                "\uD83D\uDC49 There is no laboratory test that can identify OCD.  Mental health professionals often use different diagnostic techniques to determine the presence of OCD, as well as other tools that measure the severity of obsessions and compulsions, the most common of which is the Yale-Brown Obsessive Compulsive Compulsive Scale (Y-BOCS).\n\n" +
                        "For this reason, it is always recommended to consult a professional, even better if he/she is a specialist in OCD or has experience in this type of conditions.",
                "Touch to see"
            ),
            InformationModel(
                R.drawable.psychologist,
                "Treating OCD",
                "\uD83D\uDC69\u200D⚕️ What are the treatments for obsessive-compulsive disorder?\n" +
                        "The main treatments for obsessive-compulsive disorder are cognitive behavioral therapy with exposure and response prevention and medications.\n\n" +
                        "\uD83D\uDC49 Cognitive behavioral therapy (CBT) is a type of psychotherapy. Which teaches different ways of thinking, behaving and reacting to obsessions and compulsions. A specific type of CBT that can treat OCD is called exposure response prevention therapy, which is the most effective technique for treating OCD today, it involves gradually exposing the person with OCD to their fears and obsessions, learning healthy ways to deal with the anxiety caused by OCD.\n\n" +
                        "\uD83D\uDC8A OCD medications include certain types of antidepressants. For some people they work and for others they don't, also the side effects vary from person to person, so it is always recommended to consult a professional.",
                "Touch to see"
            ),
            InformationModel(
                R.drawable.works,
                "How can I tell if it’s OCD?",
                "Above in the question \"How works OCD?\" and in the question \"What are the symptoms of OCD?\" you can see how OCD works and how it manifests itself in people, but remember that it is very difficult and not recommended to self-diagnose, so it is always recommended to consult a professional.",
                "Touch to see"
            ),
            InformationModel(
                R.drawable.decision,
                "Which treatment to choose?",
                "\uD83D\uDC49 Getting relief from OCD is possible with the treatment that is available today. While there is no cure for OCD, the most effective and evidence-based treatment to effectively treat OCD is Cognitive Behavioral Therapy (CBT). This treatment is recommended by world-renowned institutions, such as the National Institutes of Mental Health, the Mayo Clinic and Harvard Medical School, among others.",
                "Touch to see"
            ),
            InformationModel(
                R.drawable.choose,
                "How to choose a specialist?",
                "✅ Even mental health professionals with impressive credentials and experience in other mental conditions may lack the proper training to effectively diagnose and treat OCD. Only a qualified cognitive behavioral therapist can provide effective CBT. Before committing to treatment with any therapist, it is essential to check if he or she is competent to administer CBT for OCD",
                "Touch to see",

            )
        )
    }
}