package com.example.trudnezadania
data class Book(val title: String, val author: String, val year: Int)
fun addBook(favoriteBooks: MutableList<Book>) {
    print("Podaj tytuł książki: ")
    val title = readLine() ?: ""
    print("Podaj autora książki: ")
    val author = readLine() ?: ""
    print("Podaj rok wydania książki: ")
    val year = readLine()?.toIntOrNull() ?: return println("Nieprawidłowy rok!")

    val book = Book(title, author, year)
    favoriteBooks.add(book)
    println("Książka '$title' została dodana do listy.")
}
fun displayBooks(favoriteBooks: MutableList<Book>) {
    if (favoriteBooks.isEmpty()) {
        println("Brak książek na liście.")
    } else {
        println("Lista wszystkich książek:")
        favoriteBooks.forEach {
            println("${it.title} - ${it.author} (${it.year})")
        }
    }
}