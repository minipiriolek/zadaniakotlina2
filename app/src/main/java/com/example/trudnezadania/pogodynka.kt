import kotlin.random.Random
interface Weather {
    fun displayForecast(): String
}
class Sunny : Weather {
    override fun displayForecast(): String = "Słonecznie i ciepło."
}
class Rainy : Weather {
    override fun displayForecast(): String = "Deszczowo, weź parasol."
}
class Cloudy : Weather {
    override fun displayForecast(): String = "Pochmurno, bez opadów."
}
data class City(val name: String, val weather: Weather)
fun main() {
    val cities = listOf(
        City("Warszawa", randomWeather()),
        City("Kraków", randomWeather()),
        City("Gdańsk", randomWeather()),
        City("Wrocław", randomWeather()),
        City("Poznań", randomWeather())
    )
    println("Witaj w symulacji prognozy pogody!")
    while (true) {
        println("\nWybierz miasto, aby zobaczyć prognozę pogody:")
        cities.forEachIndexed { index, city -> println("${index + 1}. ${city.name}") }
        println("${cities.size + 1}. Wyjdź")
        val choice = readLine()?.toIntOrNull()
        if (choice == null || choice !in 1..(cities.size + 1)) {
            println("\nNieprawidłowa opcja. Spróbuj ponownie.")
        } else if (choice == cities.size + 1) {
            println("\nDziękujemy za skorzystanie z aplikacji pogodowej. Do zobaczenia!")
            break
        } else {
            val selectedCity = cities[choice - 1]
            println("\nPrognoza pogody dla ${selectedCity.name}: ${selectedCity.weather.displayForecast()}")
        }
    }
}
fun randomWeather(): Weather {
    return when (Random.nextInt(3)) {
        0 -> Sunny()
        1 -> Rainy()
        else -> Cloudy()
    }
}
