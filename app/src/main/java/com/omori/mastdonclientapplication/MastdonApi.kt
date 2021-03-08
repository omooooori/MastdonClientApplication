package com.omori.mastdonclientapplication

import android.telecom.Call

interface MastdonApi {

    @GET("api/vl/timeline/public")
    fun fetchPublicTimeLine() : Call<ResponseBody>
}