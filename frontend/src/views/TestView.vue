<template>
  <div class="flex justify-center">
    <vue-number-input controls inline rounded center :min="0" v-model="value"></vue-number-input>
  </div>
</template>

<script setup>
import { ref, watch } from 'vue';

const value = ref(0)

watch(
  () => value.value,
  () => {
    console.log(value.value);
  }
)

</script>