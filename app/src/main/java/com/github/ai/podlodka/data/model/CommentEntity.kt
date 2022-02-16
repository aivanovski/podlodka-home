package com.github.ai.podlodka.data.model

data class CommentEntity(
    val username: String,
    val userImageUrl: String,
    val timestamp: Long,
    val text: String
)