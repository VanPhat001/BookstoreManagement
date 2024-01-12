<template>
    <div class="home-view bg-white">
        <div class="mx-auto max-w-2xl px-4 py-16 sm:px-6 sm:py-24 lg:max-w-7xl lg:px-8">
            <h2 class="text-2xl font-bold tracking-tight text-gray-900">Customers also purchased</h2>

            <div class="mt-6 grid grid-cols-1 gap-x-6 gap-y-10 sm:grid-cols-2 lg:grid-cols-4 xl:gap-x-8">
                <template v-for="book in books" :key="book.id" >
                    <Book :book="book"></Book>
                </template>
            </div>
        </div>
    </div>
</template>


<script setup>
import axiosConfig from '@/axiosConfig';
import Book from '@/components/Book.vue';
import { ref } from 'vue';


const books = ref([])

axiosConfig().get('/book')
    .then(result => {
        console.log(result.data)
        books.value = result.data
    })
    .catch(console.log)
</script>