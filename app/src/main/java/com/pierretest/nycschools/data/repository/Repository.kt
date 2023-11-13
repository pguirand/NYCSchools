package com.pierretest.nycschools.data.repository

import com.pierretest.nycschools.data.models.AllSchoolsModel
import com.pierretest.nycschools.data.models.SingleSchoolModel

interface Repository {

    suspend fun getAllSchools() : List<SingleSchoolModel>

    suspend fun getSchoolByDbn(dbn:String) : List<SingleSchoolModel>


}