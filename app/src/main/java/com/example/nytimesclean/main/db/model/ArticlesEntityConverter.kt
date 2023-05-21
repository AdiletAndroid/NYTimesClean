package com.example.nytimesclean.main.db.model

import com.example.nytimesclean.main.model.Article

object ArticlesEntityConverter {

    fun fromEntity(entity: List<ArticleEntity>): List<Article> {
        return entity.map { data ->
            Article(
                id = data.id,
                documentType = data.documentType,
                leadParagraph = data.leadParagraph,
                imageUrl = data.imageUrl,
                newsDesk = data.newsDesk,
                pubDate = data.pubDate,
                sectionName = data.sectionName,
                snippet = data.snippet,
                source = data.source,
                subsectionName = data.subsectionName,
                typeOfMaterial = data.typeOfMaterial,
                uri = data.uri,
                webUrl = data.webUrl,
                wordCount = data.wordCount
            )
        }
    }

    fun toEntity(data: List<Article>): List<ArticleEntity> {
        return data.map { article ->
            ArticleEntity(
                id = article.id,
                documentType = article.documentType,
                leadParagraph = article.leadParagraph,
                imageUrl = article.imageUrl,
                newsDesk = article.newsDesk,
                pubDate = article.pubDate,
                sectionName = article.sectionName,
                snippet = article.snippet,
                source = article.source,
                subsectionName = article.subsectionName,
                typeOfMaterial = article.typeOfMaterial,
                uri = article.uri,
                webUrl = article.webUrl,
                wordCount = article.wordCount
            )
        }
    }
}