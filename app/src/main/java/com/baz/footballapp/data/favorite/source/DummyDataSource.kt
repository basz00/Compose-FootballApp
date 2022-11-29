package com.baz.footballapp.data.favorite.source

import com.baz.footballapp.data.favorite.model.FavoriteTeam

object DummyDataSource {
    val dummyFavoriteTeams = listOf(
        FavoriteTeam(
            1,
            "Arsenal",
            "https://upload.wikimedia.org/wikipedia/en/thumb/5/53/Arsenal_FC.svg/800px-Arsenal_FC.svg.png",
        ),
        FavoriteTeam(
            2,
            "Aston Villa",
            "https://upload.wikimedia.org/wikipedia/en/thumb/f/f9/Aston_Villa_FC_crest_%282016%29.svg/800px-Aston_Villa_FC_crest_%282016%29.svg.png",
        ),
        FavoriteTeam(
            3,
            "Bournemouth",
            "https://upload.wikimedia.org/wikipedia/en/thumb/e/e5/AFC_Bournemouth_%282013%29.svg/800px-AFC_Bournemouth_%282013%29.svg.png",
        ),
    )
}