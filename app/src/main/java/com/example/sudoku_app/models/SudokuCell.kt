package com.example.sudoku_app.models

import kotlinx.serialization.Serializable
@Serializable
data class SudokuCell(
    val row: Int,
    val col: Int,
    var value: Int? = null,
    var isFixed: Boolean = false,
    var isCorrect: Boolean? = null,
    var notes: List<Int> = listOf()
) {
    fun getNotesAsSet(): MutableSet<Int> = notes.toMutableSet()
}