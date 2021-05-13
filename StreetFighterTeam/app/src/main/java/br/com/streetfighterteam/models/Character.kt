package br.com.streetfighterteam.models

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Character(
    val name: String,
    val power: Int,
    val health: Int,
    @SerializedName("speed") val mobility: Int,
    @SerializedName("technique") val techniques: Int,
    @SerializedName("reach") val range: Int,
    val photo: String
):Serializable

