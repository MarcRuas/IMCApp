package com.marco.imcapp.ui.components

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.marco.imcapp.R
import com.marco.imcapp.ui.theme.Black
import com.marco.imcapp.ui.theme.White

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopApp() {
    TopAppBar(
        title = {
            Text(
                text = stringResource(id = R.string.app_name),
                color = Black
            )
        },
        colors = TopAppBarDefaults.smallTopAppBarColors(
            containerColor = White
        )
    )
}