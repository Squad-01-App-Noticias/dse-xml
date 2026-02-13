package com.example.dse_xml_lib.model

data class NewsArticle(
    val id: String = "",
    val coverImage: String = "",
    val title: String = "",
    val date: String = "",
    val author: String = "",
    val content: String = "",
    val summary: String = "",
    val isRead: Boolean = false
)
