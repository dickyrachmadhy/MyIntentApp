package com.example.biznetcustomercare

object AgentData {
        private val AgentName = arrayOf(
            "Ahmad Farhan",
            "Anesia Kinanti",
            "Ardiansyah",
            "Daniel Belsaber",
            "Dede Suhendar",
            "Dicky Rachmadi",
            "Fatma Rini Astuti",
            "Imam Choirudin",
            "M Abdul Alim Alami",
            "Usep Sutrisna"
        )

        private val AgentEmail = arrayOf(
            "ahmad_farhan@biznetnetworks.com",
            "anesia_kinanti@biznetnetworks.com",
            "ardiansyah@biznetnetworks.com",
            "daniel_belsaber@biznetnetworks.com",
            "dede_suhendar@biznetnetworks.com",
            "dicky_rachmadi@biznetnetworks.com",
            "fatma_astuti@biznetnetworks.com",
            "imam_choirudin@biznetnetworks.com",
            "abdul_alami@biznetnetworks.com",
            "usep_sutrisna@biznetnetworks.com"
        )

        private val AgentNoTlp = arrayOf(
            "085218239095",
            "085711339357",
            "087878200650",
            "082118853826",
            "081586539018",
            "087775760360",
            "083872272716",
            "08989658783",
            "085743408120",
            "08979666331"
        )

        private val AgentImage = intArrayOf(
            R.drawable.photo_ahmad_farhan,
            R.drawable.photo_anesia_kinanti,
            R.drawable.photo_ardiansyah,
            R.drawable.photo_daniel_belsaber,
            R.drawable.photo_dede_suhendar,
            R.drawable.photo_2,
            R.drawable.photo_fatma_astuti,
            R.drawable.photo_imam_choirudin,
            R.drawable.photo_abdul_alami,
            R.drawable.photo_usep_sutrisna
        )

        val listData: ArrayList<Agent>
            get() {
                val list = arrayListOf<Agent>()
                for (position in AgentName.indices){
                    val agent = Agent(
                    nama = AgentName[position],
                    email = AgentEmail[position],
                    no_tlp = AgentNoTlp[position],
                    photo = AgentImage[position])
                    list.add(agent)
                }
                return list
            }
}