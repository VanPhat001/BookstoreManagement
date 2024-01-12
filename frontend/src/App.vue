<template>
  <Header class="sticky top-0 left-0 right-0 z-10"></Header>
  <RouterView></RouterView>

  <LoadingOverlay :is-open="isOpenLoadingOverlay"></LoadingOverlay>
  <Cart v-if="accountStore.id" :open="isOpenShoppingCart" @on-close="closeShoppingCart"></Cart>
</template>

<script setup>
import { onMounted, provide, ref } from 'vue'
import Header from './components/Header.vue'
import LoadingOverlay from './components/LoadingOverlay.vue'
import axiosConfig from '@/axiosConfig'
import { useAccountSore } from './stores/account';
import router from './router';
import Cart from './components/Cart.vue';



const isOpenLoadingOverlay = ref(false)
const isOpenShoppingCart = ref(false)

provide('openLoadingOverlay', openLoadingOverlay)
provide('closeLoadingOverlay', closeLoadingOverlay)
provide('openShoppingCart', openShoppingCart)
provide('closeShoppingCart', closeShoppingCart)

const accountStore = useAccountSore()


const accountId = localStorage.getItem('accountId')
if (accountId) {
  axiosConfig().get(`/customer/${accountId}`)
    .then(result => {
      const account = result.data

      if (account == '') {
        // return router.push({ name: 'login' })
      }

      accountStore.setAccount(account)
      console.log(account)
    })
    .catch(error => {
      console.log(error)
      // router.push({ name: 'login' })
    })
} else {
  // router.push({ name: 'login' })
}



function openLoadingOverlay() {
  isOpenLoadingOverlay.value = true
}

function closeLoadingOverlay() {
  isOpenLoadingOverlay.value = false
}

function openShoppingCart() {
  console.log('open shopping cart')
  isOpenShoppingCart.value = true
}

function closeShoppingCart() {
  console.log('close shopping cart')
  isOpenShoppingCart.value = false
}

</script>