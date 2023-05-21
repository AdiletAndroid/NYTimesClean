package com.example.nytimesclean.popular.db.model

import com.example.nytimesclean.popular.model.PopularArticle

object PopularEntityConverter {

    fun fromEntity(entity: List<PopularEntity>): List<PopularArticle> {
        return entity.map { data ->
            PopularArticle(
                id = data.id,
                assetId = data.assetId,
                adxKeywords = data.adxKeywords,
                byline = data.byline,
                column = data.column,
                etaId = data.etaId,
                nytdsection = data.nytdsection,
                publishedDate = data.publishedDate,
                section = data.section,
                source = data.source,
                subsection = data.subsection,
                title = data.title,
                type = data.type,
                updated = data.updated,
                uri = data.uri,
                url = data.url
            )
        }
    }

    fun toEntity(data: List<PopularArticle>): List<PopularEntity> {
        return data.map { article ->
            PopularEntity(
                id = article.id,
                assetId = article.assetId,
                adxKeywords = article.adxKeywords,
                byline = article.byline,
                column = article.column,
                etaId = article.etaId,
                nytdsection = article.nytdsection,
                publishedDate = article.publishedDate,
                section = article.section,
                source = article.source,
                subsection = article.subsection,
                title = article.title,
                type = article.type,
                updated = article.updated,
                uri = article.uri,
                url = article.url
            )
        }
    }
}