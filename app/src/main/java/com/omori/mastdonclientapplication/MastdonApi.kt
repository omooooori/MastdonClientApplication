package com.omori.mastdonclientapplication

import okhttp3.ResponseBody
import retrofit2.http.GET

interface MastdonApi {

    @GET("api/v1/timelines/public")
    suspend fun fetchPublicTimeLine(
    ) : ResponseBody

}