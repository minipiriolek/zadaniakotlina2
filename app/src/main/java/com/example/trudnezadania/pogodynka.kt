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