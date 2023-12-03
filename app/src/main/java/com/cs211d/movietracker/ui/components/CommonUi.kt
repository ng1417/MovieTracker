package com.cs211d.movietracker.ui.components

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun NavigationButton(text: String, onClick : () -> Unit) {
    Button(
        onClick = onClick,
        modifier = Modifier
            .wrapContentHeight()
            .padding(vertical = 16.dp)
    ) {
        Text(
            text = (text),
            fontSize = 24.sp
        )
    }
}