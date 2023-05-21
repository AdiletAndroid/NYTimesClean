package com.example.nytimesclean.main_page.model

import com.example.nytimesclean.main_page.api.model.ResponseArticles

object ArticleDataConverter {
    fun fromNetwork(response: ResponseArticles) = response.response.docs.map { articleResponse ->
        Article(
            id = articleResponse.id,
            documentType = articleResponse.documentType,
            leadParagraph = articleResponse.leadParagraph,
            imageUrl = articleResponse.multimedia.firstOrNull()?.url.orEmpty(),
            newsDesk = articleResponse.newsDesk,
            pubDate = articleResponse.pubDate,
            sectionName = articleResponse.sectionName,
            snippet = articleResponse.snippet,
            source = articleResponse.source,
            subsectionName = articleResponse.subsectionName.orEmpty(),
            typeOfMaterial = articleResponse.typeOfMaterial,
            uri = articleResponse.uri,
            webUrl = articleResponse.webUrl,
            wordCount = articleResponse.wordCount
        )
    }
}