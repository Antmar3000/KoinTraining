package com.am.kointraining.data.entity

import kotlinx.serialization.Serializable

@Serializable
data class RemoteEntity (
    val id : Int,
    val title : String,
    val price : Double
)
