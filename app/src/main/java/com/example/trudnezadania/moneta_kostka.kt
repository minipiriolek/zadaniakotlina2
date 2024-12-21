import kotlin.random.Random

interface RollingTool {
    fun roll(): String
}
class Coin : RollingTool {
    override fun roll(): String {
        val result = (1..2).random()
        return if (result == 1) "Heads" else "Tails"
    }
}
class Dice : RollingTool {
    override fun roll(): String {
       return (1..6).random().toString()
    }
}fun main() {
    println("Wybierz, co chcesz rzucić:")
    println("1. Rzut monetą")
    println("2. Rzut kością")

    when (readLine()) {
        "1" -> {
            val coin = Coin()
            println("Wynik rzutu monetą: ${coin.roll()}")
        }
        "2" -> {
            val dice = Dice()
            println("Wynik rzutu kością: ${dice.roll()}")
        }
        else -> println("bład!")
    }
}


