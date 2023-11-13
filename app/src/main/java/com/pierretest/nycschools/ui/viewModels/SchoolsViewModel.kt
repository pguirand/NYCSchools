package com.pierretest.nycschools.ui.viewModels

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pierretest.nycschools.data.models.AllSchoolsModel
import com.pierretest.nycschools.data.models.SingleSchoolModel
import com.pierretest.nycschools.data.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SchoolsViewModel @Inject constructor(
    private val repository: Repository
) : ViewModel(){

    private val _allSchoolsList = MutableStateFlow<List<SingleSchoolModel>>(emptyList())

    val allSchoolsList : StateFlow<List<SingleSchoolModel>> = _allSchoolsList

    init {
        getAllSchools()
    }

    fun getAllSchools() {
        viewModelScope.launch {
            try {
                val schoolsList = repository.getAllSchools()
                _allSchoolsList.value = schoolsList
            } catch (e : Exception) {
                Log.e("VIEWMODEL", e.message ?: "Unexpected Error")
            }
        }
    }

}