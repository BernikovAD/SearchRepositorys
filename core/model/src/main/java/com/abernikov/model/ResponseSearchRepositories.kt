package com.abernikov.model

import com.google.gson.annotations.SerializedName


data class ResponseSearchRepositories(
    @SerializedName("total_count") var totalCount: Int,
    @SerializedName("items") var items: ArrayList<Items> = arrayListOf()
)