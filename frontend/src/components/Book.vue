<template>
    <RouterLink :to="{ name: 'book', params: { id: book.id } }" class="book group relative">
        <div
            class="aspect-h-1 aspect-w-1 w-full overflow-hidden rounded-md bg-gray-200 lg:aspect-none group-hover:opacity-75 lg:h-80">
            <img :src="book.bookCover" alt="hình ảnh sản phẩm"
                class="h-full w-full object-cover object-center lg:h-full lg:w-full" />
        </div>
        <div class="mt-4 flex justify-between">
            <div>
                <h3 class="text-sm text-gray-700">
                    <a :href="book.href">
                        <span aria-hidden="true" class="absolute inset-0" />
                        {{ book.name }}
                    </a>
                </h3>
                <!-- <p class="mt-1 text-sm text-gray-500">{{ book.color || 'đen' }}</p> -->
            </div>
            <p class="text-sm font-medium text-gray-900">{{ book.price }}</p>
        </div>
    </RouterLink>
</template>

<script setup>
import { computed } from 'vue';

const props = defineProps({
    book: {
        type: Object,
        required: true
    }
})
const book = computed(() => props.book)
</script>