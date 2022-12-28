package com.example.planner.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable

@Composable
fun TasksScreen(openDrawer: () -> Unit) {
    Column {
        DefaultScreen(title = Screens.TASKS.title, openDrawer = openDrawer, onSearchCallback = {
            //Search functionality
        })
        // rest of ui
    }
}