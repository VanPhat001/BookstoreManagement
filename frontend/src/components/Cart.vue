<template>
    <TransitionRoot as="template" :show="open">
        <Dialog as="div" class="relative z-10" @close="open = false">
            <TransitionChild as="template" enter="ease-in-out duration-500" enter-from="opacity-0" enter-to="opacity-100"
                leave="ease-in-out duration-500" leave-from="opacity-100" leave-to="opacity-0">
                <div class="fixed inset-0 bg-gray-500 bg-opacity-75 transition-opacity" />
            </TransitionChild>

            <div class="fixed inset-0 overflow-hidden">
                <div class="absolute inset-0 overflow-hidden">
                    <div class="pointer-events-none fixed inset-y-0 right-0 flex max-w-full pl-10">
                        <TransitionChild as="template" enter="transform transition ease-in-out duration-500 sm:duration-700"
                            enter-from="translate-x-full" enter-to="translate-x-0"
                            leave="transform transition ease-in-out duration-500 sm:duration-700" leave-from="translate-x-0"
                            leave-to="translate-x-full">
                            <DialogPanel class="pointer-events-auto w-screen max-w-md">
                                <div class="flex h-full flex-col overflow-y-scroll bg-white shadow-xl">
                                    <div class="flex-1 overflow-y-auto px-4 py-6 sm:px-6">
                                        <div class="flex items-start justify-between">
                                            <DialogTitle class="text-lg font-medium text-gray-900">Shopping cart
                                            </DialogTitle>
                                            <div class="ml-3 flex h-7 items-center">
                                                <button type="button"
                                                    class="relative -m-2 p-2 text-gray-400 hover:text-gray-500"
                                                    @click="open = false">
                                                    <span class="absolute -inset-0.5" />
                                                    <span class="sr-only">Close panel</span>
                                                    <XMarkIcon class="h-6 w-6" aria-hidden="true" />
                                                </button>
                                            </div>
                                        </div>

                                        <div class="mt-8">
                                            <div class="flow-root">
                                                <ul role="list" class="-my-6 divide-y divide-gray-200">
                                                    <li @click="redirectToBookView(item.bookId)"
                                                        v-for="item in cartItemArrayRender" :key="item.id"
                                                        class="flex py-6 cursor-pointer">
                                                        <div
                                                            class="h-24 w-24 flex-shrink-0 overflow-hidden rounded-md border border-gray-200">
                                                            <img :src="getBookCover(item.bookId)" alt="book image"
                                                                class="h-full w-full object-cover object-center" />
                                                        </div>

                                                        <div class="ml-4 flex flex-1 flex-col">
                                                            <div>
                                                                <div
                                                                    class="flex justify-between text-base font-medium text-gray-900">
                                                                    <h3>
                                                                        <a :href="item.href">{{ getBookName(item.bookId)
                                                                        }}</a>
                                                                    </h3>
                                                                    <p class="ml-4">$ {{ getBookPrice(item.bookId) }}</p>
                                                                </div>
                                                                <p class="mt-1 text-sm text-gray-500">{{ item.color }}
                                                                </p>
                                                            </div>
                                                            <div class="flex flex-1 items-end justify-between text-sm">
                                                                <p class="text-gray-500">Quantity {{ item.quantity }}</p>

                                                                <div class="flex">
                                                                    <div @click.stop="removeShoppingCartItem(item.bookId)"
                                                                        class="font-medium text-indigo-600 hover:text-indigo-500">
                                                                        Remove</div>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </li>
                                                </ul>
                                            </div>
                                        </div>
                                    </div>

                                    <div class="border-t border-gray-200 px-4 py-6 sm:px-6">
                                        <div class="flex justify-between text-base font-medium text-gray-900">
                                            <p>Subtotal</p>
                                            <p>$ {{ subTotal }}</p>
                                        </div>
                                        <p class="mt-0.5 text-sm text-gray-500">Shipping and taxes calculated at checkout.
                                        </p>
                                        <div class="mt-6">
                                            <button @click="redirectToOrderSummaryView"
                                                class="flex items-center justify-center rounded-md border border-transparent bg-indigo-600 px-6 py-3 text-base font-medium text-white shadow-sm hover:bg-indigo-700">Checkout</button>
                                        </div>
                                        <div class="mt-6 flex justify-center text-center text-sm text-gray-500">
                                            <p>
                                                or{{ ' ' }}
                                                <button type="button"
                                                    class="font-medium text-indigo-600 hover:text-indigo-500"
                                                    @click="open = false">
                                                    Continue Shopping
                                                    <span aria-hidden="true"> &rarr;</span>
                                                </button>
                                            </p>
                                        </div>
                                    </div>
                                </div>
                            </DialogPanel>
                        </TransitionChild>
                    </div>
                </div>
            </div>
        </Dialog>
    </TransitionRoot>
</template>
    
<script setup>
import { computed, isProxy, ref, watch } from 'vue'
import { Dialog, DialogPanel, DialogTitle, TransitionChild, TransitionRoot } from '@headlessui/vue'
import { XMarkIcon } from '@heroicons/vue/24/outline'
import axiosConfig from '@/axiosConfig'
import { useAccountSore } from '@/stores/account'
import { useCartStore } from '@/stores/carts'
import router from '@/router';
import { useBookStore } from '@/stores/books'

const emits = defineEmits(['onClose', 'onOpen'])
const props = defineProps({
    open: {
        type: Boolean,
        default: false
    }
})

const accountStore = useAccountSore()
const cartStore = useCartStore()
const bookStore = useBookStore()
const cartMap = computed(() => cartStore.cartMap)
const bookMap = computed(() => bookStore.bookMap)
const open = ref(props.open)

const cartItemArrayRender = computed(() => [...cartMap.value.values()])

const subTotal = computed(() => {
    let s = 0
    cartMap.value.forEach(cart => {
        const book = bookMap.value.get(cart.bookId)
        s += cart.quantity * book.price
    })
    return s.toFixed(2)
})


watch(() => props.open, (newVal, oldVal) => {
    if (newVal != open.value) {
        open.value = newVal
    }
})

watch(() => open.value, (newVal, oldVal) => {
    if (newVal) {
        emits('onOpen')
    } else {
        emits('onClose')
    }
})

// axiosConfig().get(`/shopping-cart/customer/${accountStore.id}`)
//     .then(result => {
//         bookStore.addMany(result.data.books)
//         cartStore.setMany(result.data.cartItems)
//     })
//     .catch(console.log)

function getBookCover(bookId) {
    return bookMap.value.get(bookId).bookCover
}

function getBookName(bookId) {
    return bookMap.value.get(bookId).name
}

function getBookPrice(bookId) {
    return bookMap.value.get(bookId).price
}

function redirectToBookView(bookId) {
    open.value = false
    router.push({
        name: 'book', params: {
            id: bookId
        }
    })
}

function redirectToOrderSummaryView() {
    open.value = false
    router.push({ name: 'order-summary' })
}

function removeShoppingCartItem(bookId) {
    const cusomterId = accountStore.id

    axiosConfig().delete(`/cart-item/${cusomterId}/${bookId}`)
        .then(result => {
            console.log("cart item has deleted")
            if (result.data) {
                const key = cartStore.makeKey(bookId, cusomterId)
                cartStore.deleteOne(key)
            } else {

            }
        })
        .catch(console.log)
}
</script>