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
}fun main() {
    println("Witaj w Losowym Generatorze Cytatów!")

    while (true) {
        println("\nWybierz opcję:")
        println("1. Wylosuj cytat")
        println("2. Dodaj nowy cytat")
        println("3. Wyjdź")

        when (readLine()) {
            "1" -> {
                val wylosowanyCytat = Cytaty.wylosujCytat()
                println("\nWylosowany cytat: \"$wylosowanyCytat\"")
            }
            "2" -> {
                println("\nWpisz nowy cytat:")
                val nowyCytat = readLine() ?: ""
                Cytaty.dodajCytat(nowyCytat)
            }
            "3" -> {
                println("\nDziękujemy za korzystanie z Losowego Generatora Cytatów. Do zobaczenia!")
                break
            }
            else -> {
                println("\nNieprawidłowa opcja. Spróbuj ponownie.")
            }
        }
    }
}

