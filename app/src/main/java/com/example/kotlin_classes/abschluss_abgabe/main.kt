package com.example.kotlin_classes.abschluss_abgabe
    fun main() {
        // Library Instanz erstellen
        val library = Library()

        // Adresse erstellen
        val address = Library.LibraryAddress("Main St.", "Metropolis", "12345")
        println()
        address.printAddress()
        println()

        // Bücher zur Bibliothek hinzufügen
        val book1 = Book("The Hobbit", "J.R.R. Tolkien", Genre.FICTION, BookStatus.Available)
        val book2 = Book("A Brief History of Time", "Stephen Hawking", Genre.SCIENCE, BookStatus.Available)
        val book3 = Book("1984", "George Orwell", Genre.FICTION, BookStatus.Available)
        val book4 = Book("Pride and Prejudice", "Jane Austen", Genre.FICTION, BookStatus.Available)
        val book5 = Book("The Great Gatsby", "F. Scott Fitzgerald", Genre.FICTION, BookStatus.Available)
        val book6 = Book("Sapiens: A Brief History of Humankind", "Yuval Noah Harari", Genre.NON_FICTION, BookStatus.Available)
        val book7 = Book("After", "Anna Todd", Genre.FICTION, BookStatus.Available)
        val book8 = Book("After We collided", "Anna Todd", Genre.FICTION, BookStatus.Available)
        val book9 = Book("After We Fell", "Anna Todd", Genre.FICTION, BookStatus.Available)
        val book10 = Book("After Ever Happy", "Anna Todd", Genre.FICTION, BookStatus.Available)
        val book11 = Book("After Before", "Anna Todd", Genre.FICTION, BookStatus.Available)

        library.addBook(book1)
        library.addBook(book2)
        library.addBook(book3)
        library.addBook(book4)
        library.addBook(book5)
        library.addBook(book6)
        library.addBook(book7)
        library.addBook(book8)
        library.addBook(book9)
        library.addBook(book10)
        library.addBook(book11)
        println()

        // Mitglied erstellen
        val member = library.LibraryMember("Kevin", "M001")
        val member2 = library.LibraryMember("Luis", "M002")
        val member3 = library.LibraryMember("Karina", "M003")

        // Bücher ausleihen und reservieren
        member.checkoutBook(book1, "2024-12-31")
        member.reserveBook(book2)
        member2.checkoutBook(book5, "2025-01-04")
        member3.reserveBook(book6)
        println()

        // Status der Bücher anzeigen
        library.displayBookStatuses()
        println()

        println("\nSuche nach Buechern mit Titel '1984':")
        val searchByTitleResults = library.searchBooksByTitle("1984")
        searchByTitleResults.forEach { book ->
            println("Gefunden: ${book.title} von ${book.author}")
        }
        println()

        println("\nSuche nach Buechern mit Titel 'After':")
        val searchByAfterSeries = library.searchBooksByTitle("After")
        searchByAfterSeries.forEach { book ->
            println("Gefunden: ${book.title} von ${book.author}")
        }

        println("\nSuche nach Buechern von Autor 'J.R.R. Tolkien':")
        val searchByAuthorResults = library.searchBooksByAuthor("J.R.R. Tolkien")
        searchByAuthorResults.forEach { book ->
            println("Gefunden: ${book.title} von ${book.author}")
        }

        println("\nBeschreibungen der Genres:")
        Genre.values().forEach { genre ->
            println("Genre: ${genre.name} - ${genre.description}")
        }
    }
