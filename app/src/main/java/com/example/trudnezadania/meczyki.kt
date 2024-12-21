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

