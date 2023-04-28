package com.example.myanywhereapplication.simpsons.model


import com.google.gson.annotations.SerializedName

data class APIResponse(
    @SerializedName("Abstract")
    var `abstract`: String? = "",
    @SerializedName("AbstractSource")
    var abstractSource: String? = "",
    @SerializedName("AbstractText")
    var abstractText: String? = "",
    @SerializedName("AbstractURL")
    var abstractURL: String? = "",
    @SerializedName("Answer")
    var answer: String? = "",
    @SerializedName("AnswerType")
    var answerType: String? = "",
    @SerializedName("Definition")
    var definition: String? = "",
    @SerializedName("DefinitionSource")
    var definitionSource: String? = "",
    @SerializedName("DefinitionURL")
    var definitionURL: String? = "",
    @SerializedName("Entity")
    var entity: String? = "",
    @SerializedName("Heading")
    var heading: String? = "",
    @SerializedName("Image")
    var image: String? = "",
    @SerializedName("ImageHeight")
    var imageHeight: Int? = 0,
    @SerializedName("ImageIsLogo")
    var imageIsLogo: Int? = 0,
    @SerializedName("ImageWidth")
    var imageWidth: Int? = 0,
    @SerializedName("Infobox")
    var infobox: String? = "",
    @SerializedName("meta")
    var meta: Meta? = Meta(),
    @SerializedName("Redirect")
    var redirect: String? = "",
    @SerializedName("RelatedTopics")
    var relatedTopicSimpsons: List<RelatedTopic>? = listOf(),
    @SerializedName("Results")
    var results: List<Any>? = listOf(),
    @SerializedName("Type")
    var type: String? = ""
)