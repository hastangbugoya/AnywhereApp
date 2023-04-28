package com.example.myanywhereapplication.simpsons.model


import com.google.gson.annotations.SerializedName

data class RelatedTopic(
    @SerializedName("FirstURL")
    var firstURL: String? = "",
    @SerializedName("Icon")
    var icon: Icon? = Icon(),
    @SerializedName("Result")
    var result: String? = "",
    @SerializedName("Text")
    var text: String? = ""
)