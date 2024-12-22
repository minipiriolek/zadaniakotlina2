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
    }}