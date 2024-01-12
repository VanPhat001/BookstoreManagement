<template>
    <div class="avatar" :style="{ width: cssSize, height: cssSize }">
        <img :src="props.imageSource" class="w-full h-full rounded-full" alt="">
    </div>
</template>


<script setup>
import { computed } from 'vue';

const props = defineProps({
    imageSource: {
        type: String,
        required: true
    },
    size: {
        type: Number,
        default: 40
    }
})

const cssSize = computed(() => props.size + 'px')
</script>