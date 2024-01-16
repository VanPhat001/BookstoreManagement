<template>
    <div class="home-view bg-white">
        <div class="mx-auto max-w-2xl px-4 py-16 sm:px-6 sm:py-24 lg:max-w-7xl lg:px-8">
            <h2 class="text-2xl font-bold tracking-tight text-gray-900">Customers also purchased</h2>

            <div class="mt-6 grid grid-cols-1 gap-x-6 gap-y-10 sm:grid-cols-2 lg:grid-cols-4 xl:gap-x-8">
                <template v-for="(id, index) in bookIds" :key="id" >
                    <Book :book="bookStore.get(id)"></Book>
                </template>
            </div>

            <Pagination class="my-4 mx-auto"></Pagination>
        </div>
    </div>
</template>


<script setup>
import axiosConfig from '@/axiosConfig'
import Book from '@/components/Book.vue'
import Pagination from '@/components/Pagination.vue'
import { useBookStore } from '@/stores/books'
import { ref } from 'vue'


const bookIds = ref([])
const bookStore = useBookStore()

axiosConfig().get('/book')
    .then(result => {
        const _books = result.data
        bookStore.addMany(_books)
        bookIds.value = _books.map(book => book.id)
    })
    .catch(console.log)
</script>