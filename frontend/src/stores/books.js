import { defineStore } from "pinia";
import { ref } from "vue";
import axiosConfig from '@/axiosConfig'

export const useBookStore = defineStore('book', () => {
    const bookMap = ref(new Map())

    function get(bookId) {
        return bookMap.value.get(bookId)
    }

    function setOne(book) {
        bookMap.value.set(book.id, book)
    }

    function setMany(books) {
        books.forEach(book => { setOne(book) })
    }

    function addOne(book) {
        if (!bookMap.value.has(book)) {
            bookMap.value.set(book.id, book)
        }
    }

    function addMany(books) {
        books.forEach(book => { addOne(book) })
    }

    function has(book) {
        return bookMap.value.has(book)
    }

    async function fetch(bookIdArray) {
        try {
            const result = await axiosConfig().post('/book/list', {
                bookIdArray: bookIdArray
            })
            const books = result.data
            setMany(books)
            return books
        } catch (error) {
            console.log(error)
            return []
        }
    }

    return {
        bookMap,
        setOne, setMany,
        addOne, addMany,
        has, fetch, get
    }
})