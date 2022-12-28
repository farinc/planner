package com.example.planner.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable

@Composable
fun StatisticsScreen(openDrawer: () -> Unit) {
    Column {
        DefaultScreen(title = Screens.STATISTICS.title, openDrawer = openDrawer, onSearchCallback = {
            //Search functionality
        })
        // rest of ui
    }
}