class Krokomierz {
    companion object {
        var liczbaKroków: Int = 0
        fun zróbKrok() {
            liczbaKroków++
            println("Wykonano krok! Obecna liczba kroków: $liczbaKroków")
        }
        fun zresetujLicznik() {
            liczbaKroków = 0
            println("Licznik kroków został zresetowany do zera.")
        }
    }
}
fun main() {
    println("Witaj w aplikacji Krokomierz!")

    while (true) {
        println("\nWybierz opcję:")
        println("1. Zrób krok")
        println("2. Zresetuj licznik kroków")
        println("3. Wyjdź")
        when (readLine()) {
            "1" -> Krokomierz.zróbKrok()
            "2" -> Krokomierz.zresetujLicznik()
            "3" -> {
                println("\nDziękujemy za skorzystanie z Krokomierza. Do zobaczenia!")
                break
            }
            else -> println("\nNieprawidłowa opcja. Spróbuj ponownie.")
        }
    }
}
