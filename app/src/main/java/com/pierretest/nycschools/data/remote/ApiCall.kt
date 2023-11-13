package com.pierretest.nycschools.data.remote

import com.pierretest.nycschools.common.ApiDetails
import com.pierretest.nycschools.data.models.AllSchoolsModel
import com.pierretest.nycschools.data.models.SingleSchoolModel
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiCall {

    @GET(ApiDetails.ALL_SCHOOLS)
    suspend fun getAllSchools() : List<SingleSchoolModel>

    @GET(ApiDetails.FILTERED_SCHOOLS)
    suspend fun filterSchoolsByDbn(@Query("dbn")dbn:String) : List<SingleSchoolModel>

}