package com.example.kotlin_classes.abschluss_abgabe

sealed class BookStatus {
    object Available : BookStatus()
    data class CheckedOut(val dueDate: String) : BookStatus()
    data class Reserved(val reservedBy: String) : BookStatus()

    fun printStatus() {
        when (this) {
            is Available -> println("Available")
            is CheckedOut -> println("Checked out, due on $dueDate")
            is Reserved -> println("Reserved by $reservedBy")
            else -> println("Unknown status")
        }
    }
}

class Library {
    private val books = mutableListOf<Book>()

    // Nested Class: LibraryAddress
    class LibraryAddress(val street: String, val city: String, val zipCode: String) {
        fun printAddress() {
            println("Address: $street, $city, $zipCode")
        }
    }

    // Inner Class: LibraryMember
    inner class LibraryMember(val name: String, val memberID: String) {
        fun checkoutBook(book: Book, dueDate: String) {
            val index = books.indexOf(book)
            if (index != -1) {
                books[index] = book.copy(status = BookStatus.CheckedOut(dueDate))
                println("$name checked out ${book.title}. Due on $dueDate.")
            } else {
                println("Book not found in library.")
            }
        }

        fun reserveBook(book: Book) {
            val index = books.indexOf(book)
            if (index != -1) {
                books[index] = book.copy(status = BookStatus.Reserved(name))
                println("$name reserved ${book.title}.")
            } else {
                println("Book not found in library.")
            }
        }
    }

    fun addBook(book: Book) {
        books.add(book)
        println("Added book: ${book.title}")
    }

    fun searchBooksByTitle(title: String): List<Book> {
        return books.filter { it.title.contains(title, ignoreCase = true) }
    }

    fun searchBooksByAuthor(author: String): List<Book> {
        return books.filter { it.author.contains(author, ignoreCase = true) }
    }

    fun displayBookStatuses() {
        books.forEach { book ->
            println("Book: ${book.title} by ${book.author} - Status: ")
            book.status.printStatus()
        }
    }
}