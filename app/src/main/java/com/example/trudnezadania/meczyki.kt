class WynikiMeczów {
    private val wyniki = mutableListOf<Int>()
    fun dodajWynik(wynik: Int) {
        if (wynik >= 0) {
            wyniki.add(wynik)
            println("Dodano wynik: $wynik")
        } else {
            println("Wynik nie może być ujemny.")
        }
    }
    fun pokazWyniki() {
        if (wyniki.isEmpty()) {
            println("Brak wyników do wyświetlenia.")
        } else {
            println("Wyniki meczów: $wyniki")
        }
    }
    fun filtrujWyniki(prog: Int) {
        val przefiltrowane = wyniki.filter { it > prog }
        println("Wyniki powyżej $prog punktów: $przefiltrowane")
    }
    fun dodajBonus(bonus: Int) {
        for (i in wyniki.indices) {
            wyniki[i] += bonus
        }
        println("Dodano $bonus punktów do każdego wyniku. Aktualne wyniki: $wyniki")
    }
    fun sumaWyników() {
        val suma = wyniki.sum()
        println("Suma wszystkich wyników: $suma")
    }
    fun maksymalnyWynik() {
        if (wyniki.isNotEmpty()) {
            val max = wyniki.maxOrNull() ?: 0
            println("Najwyższy wynik: $max")
        } else {
            println("Brak wyników do analizy.")
        }
    }
    fun roznicaMaksMin() {
        if (wyniki.isNotEmpty()) {
            val max = wyniki.maxOrNull() ?: 0
            val min = wyniki.minOrNull() ?: 0
            println("Różnica między najwyższym a najniższym wynikiem: ${max - min}")
        } else {
            println("Brak wyników do analizy.")
        }
    }
    fun liczbaMeczówPowyzej(prog: Int) {
        val liczba = wyniki.count { it > prog }
        println("Liczba meczów z wynikiem powyżej $prog: $liczba")
    }
}
fun main() {
    val analyzer = WynikiMeczów()
    println("Witaj w analizatorze wyników sportowych!")
    while (true) {
        println("\nWybierz opcję:")
        println("1. Dodaj wynik meczu")
        println("2. Pokaż wszystkie wyniki")
        println("3. Filtruj wyniki powyżej progu")
        println("4. Dodaj bonus do wyników")
        println("5. Oblicz sumę wyników")
        println("6. Znajdź maksymalny wynik")
        println("7. Oblicz różnicę między największym a najmniejszym wynikiem")
        println("8. Zlicz mecze powyżej określonego wyniku")
        println("9. Wyjdź")
        when (readLine()) {
            "1" -> {
                println("Podaj wynik meczu:")
                val wynik = readLine()?.toIntOrNull()
                if (wynik != null) {
                    analyzer.dodajWynik(wynik)
                } else {
                    println("Nieprawidłowy wynik.")
                }
            }
            "2" -> analyzer.pokazWyniki()
            "3" -> {
                println("Podaj próg:")
                val prog = readLine()?.toIntOrNull()
                if (prog != null) {
                    analyzer.filtrujWyniki(prog)
                } else {
                    println("Nieprawidłowy próg.")
                }
            }
            "4" -> {
                println("Podaj wartość bonusu:")
                val bonus = readLine()?.toIntOrNull()
                if (bonus != null) {
                    analyzer.dodajBonus(bonus)
                } else {
                    println("Nieprawidłowa wartość bonusu.")
                }
            }
            "5" -> analyzer.sumaWyników()
            "6" -> analyzer.maksymalnyWynik()
            "7" -> analyzer.roznicaMaksMin()
            "8" -> {
                println("Podaj próg:")
                val prog = readLine()?.toIntOrNull()
                if (prog != null) {
                    analyzer.liczbaMeczówPowyzej(prog)
                } else {
                    println("Nieprawidłowy próg.")
                }
            }
            "9" -> {
                println("Dziękujemy za skorzystanie z aplikacji. Do zobaczenia!")
                break
            }
            else -> println("Nieprawidłowa opcja. Spróbuj ponownie.")
        }
    }
}


