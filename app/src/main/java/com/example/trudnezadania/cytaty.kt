import kotlin.random.Random
object Cytaty {
    private val listaCytatów = mutableListOf(
        "Jedynym ograniczeniem naszej realizacji jutra są nasze dzisiejsze wątpliwości.",
        "Nie patrz na zegar. Rób to, co on. Idź naprzód.",
        "Sukces nie jest ostateczny, porażka nie jest fatalna: liczy się odwaga, by kontynuować.",
        "Przyszłość należy do tych, którzy wierzą w piękno swoich marzeń."
    )
    fun wylosujCytat(): String {
        return if (listaCytatów.isNotEmpty()) {
            listaCytatów[Random.nextInt(listaCytatów.size)]
        } else {
            "Brak dostępnych cytatów. Dodaj kilka!"
        }
    }
    fun dodajCytat(nowyCytat: String) {
        if (nowyCytat.isNotBlank()) {
            listaCytatów.add(nowyCytat)
            println("Cytat został pomyślnie dodany!")
        } else {
            println("Nie można dodać pustego cytatu.")
        }
    }
}