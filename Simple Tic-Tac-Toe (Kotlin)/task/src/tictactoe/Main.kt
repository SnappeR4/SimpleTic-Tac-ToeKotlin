package tictactoe

fun main() {

    val grid = CharArray(9) { '_' }

    printGrid(grid)

    var currentPlayer = 'X'

    while (true) {

        while (true) {
            val input = readln().trim().split(Regex("\\s+"))

            val row = input.getOrNull(0)?.toIntOrNull()
            val col = input.getOrNull(1)?.toIntOrNull()

            if (row == null || col == null) {
                println("You should enter numbers!")
                continue
            }

            if (row !in 1..3 || col !in 1..3) {
                println("Coordinates should be from 1 to 3!")
                continue
            }

            val index = (row - 1) * 3 + (col - 1)

            if (grid[index] != '_') {
                println("This cell is occupied! Choose another one!")
                continue
            }

            grid[index] = currentPlayer
            break
        }

        printGrid(grid)

        if (winCheck(grid, currentPlayer)) {
            println("$currentPlayer wins")
            break
        }

        if ('_' !in grid) {
            println("Draw")
            break
        }

        currentPlayer = if (currentPlayer == 'X') 'O' else 'X'
    }
}

fun winCheck(grid: CharArray, player: Char): Boolean {

    val wins = listOf(
        listOf(0, 1, 2),
        listOf(3, 4, 5),
        listOf(6, 7, 8),
        listOf(0, 3, 6),
        listOf(1, 4, 7),
        listOf(2, 5, 8),
        listOf(0, 4, 8),
        listOf(2, 4, 6)
    )

    for (line in wins) {
        if (line.all { grid[it] == player }) {
            return true
        }
    }

    return false
}

fun printGrid(grid: CharArray) {
    hr()
    println("| ${grid[0]} ${grid[1]} ${grid[2]} |")
    println("| ${grid[3]} ${grid[4]} ${grid[5]} |")
    println("| ${grid[6]} ${grid[7]} ${grid[8]} |")
    hr()
}

fun hr() {
    println("---------")
}