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
fun main() {
    val pytania = listOf(
        PytanieWielokrotnegoWyboru(
            "Który język programowania jest używany na platformie Android?",
            listOf("Python", "Kotlin", "JavaScript"),
            2
        ),
        PytaniePrawdaFalsz(
            "Czy Kotlin jest językiem statycznie typowanym?",
            true
        ),
        PytanieWielokrotnegoWyboru(
            "Która firma stworzyła język Kotlin?",
            listOf("Microsoft", "JetBrains", "Google"),
            2
        )
    )

    var poprawneOdpowiedzi = 0
    println("Witaj w prostym quizie! Odpowiedz na pytania wybierając numer odpowiedzi.")

    for (pytanie in pytania) {
        val pytanieTekst = when (pytanie) {
            is PytanieWielokrotnegoWyboru -> pytanie.zadawaniePytania()
            is PytaniePrawdaFalsz -> pytanie.zadawaniePytania()
            else -> "Nieznane pytanie."
        }
        println(pytanieTekst)
        val odpowiedz = readlnOrNull() ?: ""
        val poprawna = when (pytanie) {
            is PytanieWielokrotnegoWyboru -> pytanie.sprawdzOdpowiedz(odpowiedz)
            is PytaniePrawdaFalsz -> pytanie.sprawdzOdpowiedz(odpowiedz)
            else -> false
        }
        if (poprawna) {
            println("Poprawna odpowiedź!\n")
            poprawneOdpowiedzi++
        } else {
            println("Niepoprawna odpowiedź.\n")
        }
    }
    println("Koniec quizu! Uzyskałeś $poprawneOdpowiedzi z ${pytania.size} możliwych punktów.")
}
