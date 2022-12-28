package com.example.planner.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable

@Composable
fun ScheduleScreen(openDrawer: () -> Unit) {
    Column {
        DefaultScreen(title = Screens.SCHEDULE.title, openDrawer = openDrawer, onSearchCallback = {
            //Search functionality
        })
        // rest of ui
    }
}