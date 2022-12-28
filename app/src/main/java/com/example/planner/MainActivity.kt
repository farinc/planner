package com.example.planner

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.material.icons.*
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.planner.ui.screens.*
import com.example.planner.ui.theme.PlannerTheme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            PlannerTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
                    val scope = rememberCoroutineScope()
                    val openDrawer = {
                        scope.launch {
                            drawerState.open()
                        }
                    }

                    ModalDrawer(
                        drawerState = drawerState,
                        gesturesEnabled = drawerState.isOpen,
                        drawerContent = {
                            Drawer(
                                onRouteSelect = { route ->

                                    // Close our drawer now that the option is selected
                                    scope.launch {
                                        drawerState.close()
                                    }

                                    // Tell the NavHost to switch navigation modes
                                    navController.navigate(route) {
                                        launchSingleTop = true
                                        popUpTo(id = navController.graph.startDestinationId)
                                    }
                                }
                            )
                        }
                    ) {
                        NavHost(navController = navController, startDestination = Screens.SCHEDULE.route) {
                            composable(Screens.SCHEDULE.route) {
                                ScheduleScreen(
                                    openDrawer = { openDrawer() }
                                )
                            }
                            composable(Screens.TASKS.route) {
                                TasksScreen(
                                    openDrawer = { openDrawer() }
                                )
                            }
                            composable(Screens.STATISTICS.route) {
                                StatisticsScreen(
                                    openDrawer = { openDrawer() }
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}

