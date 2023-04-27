package com.example.nytimesclean.mostPopular.model

import com.example.nytimesclean.mostPopular.api.model.PopularResponse

object PopularArticleDataConverter {

    fun fromNetwork(response: PopularResponse) = response.results.map { popularResponse ->
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
