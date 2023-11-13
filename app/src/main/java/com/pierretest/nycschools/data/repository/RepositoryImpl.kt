package com.pierretest.nycschools.data.repository

import com.pierretest.nycschools.data.models.AllSchoolsModel
import com.pierretest.nycschools.data.models.SingleSchoolModel
import com.pierretest.nycschools.data.remote.ApiCall
import javax.inject.Inject

class RepositoryImpl @Inject constructor(
    val apiCall: ApiCall
) : Repository{
    override suspend fun getAllSchools(): List<SingleSchoolModel> {
        return apiCall.getAllSchools()
    }

    override suspend fun getSchoolByDbn(dbn: String): List<SingleSchoolModel> {

        return apiCall.filterSchoolsByDbn(dbn)
    }


}