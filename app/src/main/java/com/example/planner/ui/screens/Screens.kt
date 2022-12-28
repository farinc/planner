package com.example.planner.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

enum class Screens(val title: String, val route: String) {
    TASKS("Tasks", "tasks"),
    SCHEDULE("Scheduling", "schedule"),
    STATISTICS("Statistics", "statistics")
}

@Composable
fun DefaultScreen(title: String, openDrawer: () -> Unit, onSearchCallback: () -> Unit) {
    TopAppBar(
        title = { Text(text = title) },
        actions = {
            IconButton(onClick = onSearchCallback) {
                Icon(imageVector = Icons.Filled.Search, contentDescription = "TODO")
            }
        },
        modifier = Modifier.fillMaxHeight(0.1f),
        backgroundColor = MaterialTheme.colors.background,
        navigationIcon = {
            IconButton(onClick = openDrawer) {
                Icon(imageVector = Icons.Filled.Menu, contentDescription = "TODO")
            }
        }
    )
}

@Composable
fun Drawer(
    modifier: Modifier = Modifier,
    onRouteSelect: (route: String) -> Unit
) {
    Column(
        modifier
            .fillMaxSize()
            .padding(start = 24.dp, top = 48.dp)
    ) {
        Screens.values().forEach { screen ->
            Spacer(Modifier.height(24.dp))
            Text(text = screen.title, style = MaterialTheme.typography.h5, modifier = Modifier.clickable { onRouteSelect(screen.route) }.padding(12.dp))
        }
    }
}