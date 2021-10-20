package com.example.audiobb

// probably will need to be restructured if it needs to be passed in a weird way
class Book(var title: String, var author: String) {
}

class BookList : MutableList<Book> {
    override val size: Int
        get() = books.size

    // Is this cheating?
    private var books = mutableListOf<Book>()

    /**
     * Adds the specified element to the end of this list.
     *
     * @return `true` because the list is always modified as the result of this operation.
     */
    override fun add(element: Book): Boolean {
        return books.add(element)
    }

    /**
     * Inserts an element into the list at the specified [index].
     */
    override fun add(index: Int, element: Book) {
        return books.add(index, element)
    }

    /**
     * Inserts all of the elements of the specified collection [elements] into this list at the specified [index].
     *
     * @return `true` if the list was changed as the result of the operation.
     */
    override fun addAll(index: Int, elements: Collection<Book>): Boolean {
        return books.addAll(index, elements)
    }

    /**
     * Adds all of the elements of the specified collection to the end of this list.
     *
     * The elements are appended in the order they appear in the [elements] collection.
     *
     * @return `true` if the list was changed as the result of the operation.
     */
    override fun addAll(elements: Collection<Book>): Boolean {
        return books.addAll(elements)
    }

    override fun clear() {
        return books.clear()
    }

    override fun remove(element: Book): Boolean {
        return books.remove(element)
    }

    override fun removeAll(elements: Collection<Book>): Boolean {
        return books.removeAll(elements)
    }

    /**
     * Removes an element at the specified [index] from the list.
     *
     * @return the element that has been removed.
     */
    override fun removeAt(index: Int): Book {
        return books.removeAt(index)
    }

    override fun retainAll(elements: Collection<Book>): Boolean {
        TODO("Not yet implemented")
    }

    /**
     * Replaces the element at the specified position in this list with the specified element.
     *
     * @return the element previously at the specified position.
     */
    override fun set(index: Int, element: Book): Book {
        TODO("Not yet implemented")
    }

    override fun contains(element: Book): Boolean {
        TODO("Not yet implemented")
    }

    override fun containsAll(elements: Collection<Book>): Boolean {
        TODO("Not yet implemented")
    }

    /**
     * Returns the element at the specified index in the list.
     */
    override fun get(index: Int): Book {
        return books[index]
    }

    /**
     * Returns the index of the first occurrence of the specified element in the list, or -1 if the specified
     * element is not contained in the list.
     */
    override fun indexOf(element: Book): Int {
        // this may not work, may only check the hash
        return books.indexOf(element)
    }

    override fun isEmpty(): Boolean {
        TODO("Not yet implemented")
    }

    override fun iterator(): MutableIterator<Book> {
        return books.iterator()
    }

    /**
     * Returns the index of the last occurrence of the specified element in the list, or -1 if the specified
     * element is not contained in the list.
     */
    override fun lastIndexOf(element: Book): Int {
        TODO("Not yet implemented")
    }

    override fun listIterator(): MutableListIterator<Book> {
        return books.listIterator()
    }

    override fun listIterator(index: Int): MutableListIterator<Book> {
        return books.listIterator(index)
    }

    override fun subList(fromIndex: Int, toIndex: Int): MutableList<Book> {
        TODO("Not yet implemented")
    }
}