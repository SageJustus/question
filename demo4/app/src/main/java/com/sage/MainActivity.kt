package com.sage

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.selection.toggleable
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.Stable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import com.sage.ui.theme.Demo4Theme

class MainActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContent {
      Demo4Theme {
        // A surface container using the 'background' color from the theme
        Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
          ArticleScreen()
        }
      }
    }
  }
}
@Stable
class ArticleState(
  val orderModalState: SageSheetState,
  val filterModalState: DrawerState
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun rememberSageSheetState(
  state: SageSheetState = SageSheetState(
    coroutineScope = rememberCoroutineScope(), sheetState = rememberSheetState()
  )): SageSheetState {
  return remember { state }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun rememberArticleState(
  orderModalState: SageSheetState = rememberSageSheetState(),
  filterModalState: DrawerState = rememberDrawerState(DrawerValue.Closed)
): ArticleState {

  return remember {
    ArticleState(
      orderModalState = orderModalState,
      filterModalState = filterModalState
    )
  }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ArticleScreen(
  state: ArticleState = rememberArticleState()
) {

  Column {
    Text("${state.orderModalState.sheetState.currentValue}")
    Text("${state.orderModalState.sheetState.isVisible}")
    Text("${state.orderModalState.sheetState.targetValue}")
    Button(onClick = { state.orderModalState.showModal() }) {
      Text("Show Modal")
    }
  }
  Modal(
    modalState = state.orderModalState,
  )
}

@OptIn(ExperimentalMaterial3Api::class)
class SageSheetState(
  private val coroutineScope: CoroutineScope,
  val sheetState: SheetState,
  openBottomSheet: Boolean = false
) {
  var openBottomSheet by mutableStateOf(openBottomSheet)
    private set


  fun showModal() {
    coroutineScope.launch {
      openBottomSheet = true
      sheetState.collapse()
    }
  }

  fun closeModal() {
    coroutineScope.launch {
      sheetState.hide()
      openBottomSheet = false
    }
  }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Modal(
  modalState: SageSheetState
) {

  DisposableEffect(modalState.openBottomSheet) {
    onDispose { }
  }

// Sheet content
  if (modalState.openBottomSheet) {
    ModalBottomSheet(
      onDismissRequest = { modalState.closeModal() },
      sheetState = modalState.sheetState,
    ) {
      Text("Hello")
    }
  }
}
