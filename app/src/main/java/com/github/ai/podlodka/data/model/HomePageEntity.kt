package com.github.ai.podlodka.data.model

data class HomePageEntity(
    val title: String,
    val description: String,
    val reviewCount: Int,
    val reviewPoints: String,
    val imageUrl: String,
    val iconUrl: String,
    val videos: List<String>,
    val tags: List<String>,
    val comments: List<CommentEntity>
)