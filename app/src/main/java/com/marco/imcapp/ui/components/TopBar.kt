package com.marco.imcapp.ui.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
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
fun TopApp(acao: () -> Unit) {
    TopAppBar(
        title = {
            Text(
                text = stringResource(id = R.string.app_name),
                color = Black
            )
        },
        colors = TopAppBarDefaults.smallTopAppBarColors(
            containerColor = White
        ),
        actions = {
            IconButton(onClick = {
                acao()
            }) {
                Icon(imageVector = Icons.Filled.Refresh, contentDescription = null)
            }
        }
    )
}