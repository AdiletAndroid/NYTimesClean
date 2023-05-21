package com.example.nytimesclean.most_popular.model

import com.example.nytimesclean.most_popular.api.model.ResponsePopular

object PopularArticleDataConverter {

    fun fromNetwork(response: ResponsePopular) = response.results.map { popularResponse ->
        PopularArticle(
            id = popularResponse.id,
            assetId = popularResponse.assetId,
            adxKeywords = popularResponse.adxKeywords,
            byline = popularResponse.byline,
            column = popularResponse.column.orEmpty(),
            etaId = popularResponse.etaId,
            nytdsection = popularResponse.nytdsection,
            publishedDate = popularResponse.publishedDate,
            section = popularResponse.section,
            source = popularResponse.source,
            subsection = popularResponse.subsection,
            title = popularResponse.title,
            type = popularResponse.type,
            updated = popularResponse.updated,
            uri = popularResponse.uri,
            url = popularResponse.url
        )
    }
}
