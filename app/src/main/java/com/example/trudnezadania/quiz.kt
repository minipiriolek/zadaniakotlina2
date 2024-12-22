class PytanieWielokrotnegoWyboru(
    val tresc: String,
    val odpowiedzi: List<String>,
    val poprawnaOdpowiedz: Int
) {
    fun zadawaniePytania(): String {
        val odpowiedziTekst = odpowiedzi.mapIndexed { index, odp -> "${index + 1}. $odp" }.joinToString("\n")
        return "$tresc\n$odpowiedziTekst"
    }

    fun sprawdzOdpowiedz(odpowiedz: String): Boolean {
        return odpowiedz.toIntOrNull() == poprawnaOdpowiedz
    }
}
class PytaniePrawdaFalsz(
    val tresc: String,
    val poprawnaOdpowiedz: Boolean
) {
    fun zadawaniePytania(): String {
        return "$tresc\n1. Prawda\n2. Fałsz"
    }

    fun sprawdzOdpowiedz(odpowiedz: String): Boolean {
        return when (odpowiedz) {
            "1" -> poprawnaOdpowiedz
            "2" -> !poprawnaOdpowiedz
            else -> false
        }
    }
}