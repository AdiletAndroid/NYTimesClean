package com.example.nytimesclean.mainPage.model

import com.example.nytimesclean.mainPage.api.model.ArticlesResponse

object ArticleDataConverter {
    fun fromNetwork(response: ArticlesResponse) = response.response.docs.map { articleResponse ->
        Article(
            abstract = articleResponse.abstract,
            documentType = articleResponse.documentType,
            id = articleResponse.id,
            leadParagraph = articleResponse.leadParagraph,
            imageUrl = articleResponse.multimedia.first().url,
            newsDesk = articleResponse.newsDesk,
            pubDate = articleResponse.pubDate,
            sectionName = articleResponse.sectionName,
            snippet = articleResponse.snippet,
            source = articleResponse.source,
            subsectionName = articleResponse.subsectionName,
            typeOfMaterial = articleResponse.typeOfMaterial,
            uri = articleResponse.uri,
            webUrl = articleResponse.webUrl,
            wordCount = articleResponse.wordCount
        )
    }
}