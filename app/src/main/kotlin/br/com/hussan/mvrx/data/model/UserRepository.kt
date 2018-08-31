package br.com.hussan.mvrx.data.model

import com.google.gson.annotations.SerializedName

data class UserRepository(
        val id: Int = 0,
        @SerializedName("name")
        val name: String? = null,
        @SerializedName("full_name")
        val fullName: String? = null)
