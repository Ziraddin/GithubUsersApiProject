package com.zireddinismayilov.githubusersapiproject.data

import com.google.gson.annotations.SerializedName

data class RepositoryDTO(
    val items: MutableList<Repos>
)

data class Repos(
    val id: Int, val name: String, val description: String?, val owner: Owner, @SerializedName("stargazers_count") val stargazerscount: Int
)

data class Owner(
    val login: String, @SerializedName("avatar_url") val avatarurl: String
)