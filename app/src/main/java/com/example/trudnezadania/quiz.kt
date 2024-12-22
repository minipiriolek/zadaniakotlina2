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
