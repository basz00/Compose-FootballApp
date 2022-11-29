package com.baz.footballapp.data.team.model

data class Team(
    val id: Int,
    val name: String,
    val logoUrl: String,
    val founded: Int,
    val venue: String,
    val venueAddress: String,
    val venueCapacity: Int,
    val venueImageUrl: String,
    val headCoach: String,
    val headCoachImageUrl: String,
    val headCoachAge: Int,
    val headCoachNationality: String,
)