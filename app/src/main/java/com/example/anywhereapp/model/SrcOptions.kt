package com.example.myanywhereapplication.simpsons.model


import com.google.gson.annotations.SerializedName

data class SrcOptions(
    @SerializedName("directory")
    var directory: String? = "",
    @SerializedName("is_fanon")
    var isFanon: Int? = 0,
    @SerializedName("is_mediawiki")
    var isMediawiki: Int? = 0,
    @SerializedName("is_wikipedia")
    var isWikipedia: Int? = 0,
    @SerializedName("language")
    var language: String? = "",
    @SerializedName("min_abstract_length")
    var minAbstractLength: String? = "",
    @SerializedName("skip_abstract")
    var skipAbstract: Int? = 0,
    @SerializedName("skip_abstract_paren")
    var skipAbstractParen: Int? = 0,
    @SerializedName("skip_end")
    var skipEnd: String? = "",
    @SerializedName("skip_icon")
    var skipIcon: Int? = 0,
    @SerializedName("skip_image_name")
    var skipImageName: Int? = 0,
    @SerializedName("skip_qr")
    var skipQr: String? = "",
    @SerializedName("source_skip")
    var sourceSkip: String? = "",
    @SerializedName("src_info")
    var srcInfo: String? = ""
)