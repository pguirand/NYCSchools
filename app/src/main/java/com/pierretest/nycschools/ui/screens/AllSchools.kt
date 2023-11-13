package com.pierretest.nycschools.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.ViewModel
import coil.compose.rememberAsyncImagePainter
import com.pierretest.nycschools.data.models.SingleSchoolModel
import com.pierretest.nycschools.ui.viewModels.SchoolsViewModel
import dagger.hilt.android.lifecycle.HiltViewModel


@Composable
fun AllSchoolsScreen(viewModel: SchoolsViewModel = hiltViewModel()) {
    
    LaunchedEffect(Unit) {
        viewModel.allSchoolsList
    }
    
    val allSchoolList by viewModel.allSchoolsList.collectAsState()

    //testing
    if (allSchoolList?.isEmpty() == true) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Gray)
        ) {
            CircularProgressIndicator(
                modifier = Modifier
                    .background(Color.Gray)
                    .align(Alignment.Center),
                color = Color.Red
            )
        }
    } else {
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            items(allSchoolList) {school ->
                SchoolItem(singleSchool = school)
            }
        }
    }
    
}

@Composable
fun SchoolItem(singleSchool : SingleSchoolModel) {
    
    Card(
        modifier = Modifier
            .padding(8.dp, 4.dp)
            .fillMaxWidth()
            .height(140.dp),
        shape = RoundedCornerShape(8.dp)
    ) {
        Surface(
            
        ) {
            Row(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.Cyan)
            ) {
//                Image(
//                    modifier = Modifier
//                        .size(150.dp)
//                        .fillMaxHeight()
//                        .weight(0.4f),
//                    painter = rememberAsyncImagePainter(model = ),
//                    contentDescription = )

                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(10.dp)
                        .weight(0.6f)
                ) {
                    Text(
                        text = singleSchool.dbn.toString(),
                        style = MaterialTheme.typography.headlineMedium,
                        textAlign = TextAlign.Center
                    )
                    Text(
                        text = singleSchool.schoolName.toString(),
                        style = MaterialTheme.typography.bodyMedium,
                        textAlign = TextAlign.Center
                    )

                    Text(
                        text = singleSchool.overviewParagraph.toString(),
                        style = MaterialTheme.typography.bodyMedium,
                        maxLines = 3,
                        overflow = TextOverflow.Ellipsis,
                        textAlign = TextAlign.Justify
                    )
                }
            }
            
        }
    }
    
}