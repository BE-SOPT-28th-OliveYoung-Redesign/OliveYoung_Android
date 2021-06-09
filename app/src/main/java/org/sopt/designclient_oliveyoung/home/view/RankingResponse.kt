package org.sopt.designclient_oliveyoung.home.view

data class RankingResponse(
    val `data`: List<Data>
) {
    data class Data(
        val _id: String,
        val rank: Int,
        val brandLabel: String,
        val listLabel: String,
        val mainImageView: String,
        val reviewLabel: String
    )
}