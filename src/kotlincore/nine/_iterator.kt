package kotlincore.nine

/**
 * 迭代
 *
 * @author linnanwei
 * @since 1.0.0
 */
data class Book(val name: String)
class Bookcase(val books: List<Book>) {
    operator fun iterator(): Iterator<Book> = this.books.iterator()
}

// 通过扩展函数扩展iterator
operator fun Bookcase.iterator(): Iterator<Book> = object : Iterator<Book> {
    val iterator = books.iterator()

    override fun hasNext(): Boolean {
        return iterator.hasNext()
    }

    override fun next(): Book {
        return iterator.next()
    }
}