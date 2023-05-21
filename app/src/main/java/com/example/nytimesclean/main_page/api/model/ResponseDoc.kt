package com.example.nytimesclean.main_page.api.model


import com.google.gson.annotations.SerializedName

data class ResponseDoc(
    @SerializedName("_id")
    val id: String,
    @SerializedName("abstract")
    val `abstract`: String,
    @SerializedName("byline")
    val byline: ResponseByline,
    @SerializedName("document_type")
    val documentType: String,
    @SerializedName("headline")
    val headline: ResponseHeadline,
    @SerializedName("keywords")
    val keywords: List<ResponseKeyword>,
    @SerializedName("lead_paragraph")
    val leadParagraph: String,
    @SerializedName("multimedia")
    val multimedia: List<ResponseMultimedia>,
    @SerializedName("news_desk")
    val newsDesk: String,
    @SerializedName("pub_date")
    val pubDate: String,
    @SerializedName("section_name")
    val sectionName: String,
    @SerializedName("snippet")
    val snippet: String,
    @SerializedName("source")
    val source: String,
    @SerializedName("subsection_name")
    val subsectionName: String?,
    @SerializedName("type_of_material")
    val typeOfMaterial: String,
    @SerializedName("uri")
    val uri: String,
    @SerializedName("web_url")
    val webUrl: String,
    @SerializedName("word_count")
    val wordCount: Int
)
