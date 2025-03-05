package com.am.kointraining

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.am.kointraining.data.api.RemoteApi
import com.am.kointraining.data.entity.MockEntity
import com.am.kointraining.presentation.MainViewModel
import com.am.kointraining.presentation.ui.MainScreen
import com.am.kointraining.presentation.ui.theme.KoinTrainingTheme
import org.koin.android.ext.android.inject
import org.koin.android.scope.AndroidScopeComponent
import org.koin.androidx.compose.koinViewModel
import org.koin.androidx.scope.activityRetainedScope
import org.koin.androidx.scope.activityScope
import org.koin.androidx.viewmodel.ext.android.getViewModel
import org.koin.core.qualifier.named
import org.koin.core.scope.Scope

class MainActivity : ComponentActivity(), AndroidScopeComponent {

    /**
     * by activityScope = destroyed when activity is destroyed
     * by activityRetainedScope = lives when activity is recreated similar to viewModelScope
     */

    override val scope : Scope by activityScope()
    private val hello by inject<String>(named("hello"))
    private val bye by inject<String> (named("bye"))
    private val mockEntity by inject<MockEntity> (named("entity"))

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("myLog", hello)
        Log.d("myLog", bye)
        Log.d("myLog", mockEntity.toString())
        enableEdgeToEdge()
        setContent {
            KoinTrainingTheme {

                val viewModel = koinViewModel<MainViewModel>()

                viewModel.doNetworkCall()

                viewModel.doKtorCall()

                MainScreen(viewModel)

            }
        }
    }
}
