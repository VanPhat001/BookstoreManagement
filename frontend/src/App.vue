<template>
  <Header class="sticky top-0 left-0 right-0 z-10"></Header>
  <RouterView></RouterView>
  <LoadingOverlay :is-open="isOpenLoadingOverlay"></LoadingOverlay>
  <Cart v-if="accountStore.id" :open="isOpenShoppingCart" @on-close="closeShoppingCart"></Cart>
</template>

<script setup>
import { provide, ref } from 'vue'
import Header from './components/Header.vue'
import LoadingOverlay from './components/LoadingOverlay.vue'
import axiosConfig from '@/axiosConfig'
import { useAccountSore } from './stores/account';
import Cart from './components/Cart.vue';
import { useBookStore } from './stores/books';
import { useCartStore } from './stores/carts';



const isOpenLoadingOverlay = ref(true)
const isOpenShoppingCart = ref(false)

provide('openLoadingOverlay', openLoadingOverlay)
provide('closeLoadingOverlay', closeLoadingOverlay)
provide('openShoppingCart', openShoppingCart)
provide('closeShoppingCart', closeShoppingCart)

const accountStore = useAccountSore()
const bookStore = useBookStore()
const cartStore = useCartStore()


const accountId = localStorage.getItem('accountId')
if (accountId) {
  axiosConfig().get(`/customer/${accountId}`)
    .then(result => {
      const account = result.data

      if (account == '') {
        // return router.push({ name: 'login' })
      }

      return initData(account)
    })
    .then(() => { })
    .catch(error => {
      console.log(error)
      // router.push({ name: 'login' })
    })
    .finally(() => {
      closeLoadingOverlay()
    })
} else {
  // router.push({ name: 'login' })
  closeLoadingOverlay()
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

async function initData(account) {
  accountStore.setAccount(account)
  const result = await axiosConfig().get(`/shopping-cart/customer/${account.id}`)
  bookStore.addMany(result.data.books)
  cartStore.setMany(result.data.cartItems)

  console.log(account)
}
</script>