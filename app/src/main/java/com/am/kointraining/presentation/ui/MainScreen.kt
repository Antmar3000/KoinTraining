package com.am.kointraining.presentation.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.am.kointraining.presentation.MainViewModel

@Composable
fun MainScreen (viewModel: MainViewModel) {

    val ktorEntityState = viewModel.ktorProducts.collectAsState()

    Scaffold {innerPadding ->
        Column (modifier = Modifier.padding(innerPadding)) {
            Text(text = viewModel.entityState.value.id.toString())
            Text(text = viewModel.entityState.value.title)
            Text(text = viewModel.entityState.value.price.toString())

            HorizontalDivider(thickness = 30.dp)

            Text(text = ktorEntityState.value.price.toString())

        }
    }
}