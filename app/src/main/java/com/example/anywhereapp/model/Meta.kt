package com.example.myanywhereapplication.simpsons.model


import com.google.gson.annotations.SerializedName

data class Meta(
    @SerializedName("attribution")
    var attribution: Any? = Any(),
    @SerializedName("blockgroup")
    var blockgroup: Any? = Any(),
    @SerializedName("created_date")
    var createdDate: Any? = Any(),
    @SerializedName("description")
    var description: String? = "",
    @SerializedName("designer")
    var designer: Any? = Any(),
    @SerializedName("dev_date")
    var devDate: Any? = Any(),
    @SerializedName("dev_milestone")
    var devMilestone: String? = "",
    @SerializedName("developer")
    var developer: List<Developer>? = listOf(),
    @SerializedName("example_query")
    var exampleQuery: String? = "",
    @SerializedName("id")
    var id: String? = "",
    @SerializedName("is_stackexchange")
    var isStackexchange: Any? = Any(),
    @SerializedName("js_callback_name")
    var jsCallbackName: String? = "",
    @SerializedName("live_date")
    var liveDate: Any? = Any(),
    @SerializedName("maintainer")
    var maintainer: Maintainer? = Maintainer(),
    @SerializedName("name")
    var name: String? = "",
    @SerializedName("perl_module")
    var perlModule: String? = "",
    @SerializedName("producer")
    var producer: Any? = Any(),
    @SerializedName("production_state")
    var productionState: String? = "",
    @SerializedName("repo")
    var repo: String? = "",
    @SerializedName("signal_from")
    var signalFrom: String? = "",
    @SerializedName("src_domain")
    var srcDomain: String? = "",
    @SerializedName("src_id")
    var srcId: Int? = 0,
    @SerializedName("src_name")
    var srcName: String? = "",
    @SerializedName("src_options")
    var srcOptions: SrcOptions? = SrcOptions(),
    @SerializedName("src_url")
    var srcUrl: Any? = Any(),
    @SerializedName("status")
    var status: String? = "",
    @SerializedName("tab")
    var tab: String? = "",
    @SerializedName("topic")
    var topic: List<String>? = listOf(),
    @SerializedName("unsafe")
    var unsafe: Int? = 0
)