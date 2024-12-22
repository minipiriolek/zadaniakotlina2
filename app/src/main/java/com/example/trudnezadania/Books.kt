data class Ksiazka(
    val tytul: String,
    val autor: String,
    val rokWydania: Int
)

class UlubioneKsiazki {
    private val listaKsiazek = mutableListOf<Ksiazka>()

    fun dodajKsiazke(ksiazka: Ksiazka) {
        listaKsiazek.add(ksiazka)
        println("Dodano książkę: ${ksiazka.tytul}")
    }

    fun filtrujPoAutorze(autor: String) {
        val wyniki = listaKsiazek.filter { it.autor.equals(autor, ignoreCase = true) }
        if (wyniki.isEmpty()) {
            println("Nie znaleziono książek autora: $autor")
        } else {
            println("Książki autora $autor:")
            wyniki.forEach { println("- ${it.tytul} (${it.rokWydania})") }
        }
    }

    fun filtrujPoRoku(rok: Int) {
        val wyniki = listaKsiazek.filter { it.rokWydania == rok }
        if (wyniki.isEmpty()) {
            println("Nie znaleziono książek wydanych w roku: $rok")
        } else {
            println("Książki z roku $rok:")
            wyniki.forEach { println("- ${it.tytul} autorstwa ${it.autor}") }
        }
    }
    fun sortujPoTytule() {
        println("Książki posortowane alfabetycznie po tytule:")
        listaKsiazek.sortedBy { it.tytul }.forEach { println("- ${it.tytul} autorstwa ${it.autor}") }
    }

    fun wyswietlWszystkie() {
        if (listaKsiazek.isEmpty()) {
            println("Lista ulubionych książek jest pusta.")
        } else {
            println("Lista ulubionych książek:")
            listaKsiazek.forEach { println("- ${it.tytul} autorstwa ${it.autor} (${it.rokWydania})") }
        }
    }
}
fun main() {
    val tracker = UlubioneKsiazki()

    while (true) {
        println(
            """
            Wybierz opcję:
            1. Dodaj książkę
            2. Filtruj po autorze
            3. Filtruj po roku wydania
            4. Sortuj po tytule
            5. Wyświetl wszystkie książki
            6. Zakończ
        """.trimIndent()
        )
        when (readlnOrNull()) {
            "1" -> {
                println("Podaj tytuł książki:")
                val tytul = readlnOrNull() ?: ""
                println("Podaj autora książki:")
                val autor = readlnOrNull() ?: ""
                println("Podaj rok wydania książki:")
                val rok = readlnOrNull()?.toIntOrNull() ?: 0
                tracker.dodajKsiazke(Ksiazka(tytul, autor, rok))
            }
            "2" -> {
                println("Podaj autora do filtrowania:")
                val autor = readlnOrNull() ?: ""
                tracker.filtrujPoAutorze(autor)
            }
            "3" -> {
                println("Podaj rok wydania do filtrowania:")
                val rok = readlnOrNull()?.toIntOrNull() ?: 0
                tracker.filtrujPoRoku(rok)
            }
            "4" -> tracker.sortujPoTytule()
            "5" -> tracker.wyswietlWszystkie()
            "6" -> {
                println("Zakończono program.")
                break
            }
            else -> println("Nieprawidłowy wybór. Spróbuj ponownie.")
        }
    }
}
