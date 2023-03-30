package net.gostartups.myapplication

data class Country(
    var name: String,
    var capital: String,
    var flags: Flags
)

data class Flags(
    var svg: String,
    var png: String
)

data class CountryDetailed(
    var name: String,
    var capital: String,
    var flags: Flags,
    var region: String,
    var population: Int,
    var area: Int
)