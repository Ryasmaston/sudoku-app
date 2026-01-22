package com.example.sudoku_app.viewmodel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

data class GameUIState(
    val selectedIndex: Int? = null,
    var columnIndexList: List<Int> = emptyList(),
    val squareIndex: List<Int> = emptyList(),
    val rowIndexList: List<Int> = emptyList(),

    )

class SudokuViewModel : ViewModel() {


    private val _uiState = MutableStateFlow(GameUIState())

    val uiState: StateFlow<GameUIState> = _uiState.asStateFlow()

    fun generateColumn(index: Int) {
        val remainder = index % 9

        val columnIndices = (0 until 9).map { i -> (9 * i) + remainder }

        _uiState.value = _uiState.value.copy(
            columnIndexList = columnIndices
        )
    }

    fun generateRow(index: Int) {
        val remainder = index % 9
        val rowStart = index - (remainder)

        val rowIndices = (0 until 9).map { i -> rowStart + i }

        _uiState.value = _uiState.value.copy(
            rowIndexList = rowIndices
        )
    }

    fun onSelectedIndex(index: Int) {
        if (_uiState.value.selectedIndex == null) {
            _uiState.value = _uiState.value.copy(
                selectedIndex = index
            )
            generateColumn(index)
            generateRow(index)
        } else if (_uiState.value.selectedIndex != index) {

            _uiState.value = _uiState.value.copy(
                selectedIndex = index
            )
            generateColumn(index)
            generateRow(index)
        } else {
            _uiState.value = _uiState.value.copy(
                selectedIndex = null,
                columnIndexList = emptyList(),
                rowIndexList = emptyList()

            )
        }
    }

}