import { defineStore } from "pinia";
import { ref } from "vue";

export const useCartStore = defineStore('cart', () => {
    const cartMap = ref(new Map())

    function makeKey(bookId, customerId) {
        return customerId + ' ' + bookId
    }

    function getKey(cart) {
        return cart.customerId + ' ' + cart.bookId
    }

    function getByCartKey(cartKey) {
        return cartMap.value.get(cartKey)
    }

    function setOne(cart) {
        const key = getKey(cart)
        cartMap.value.set(key, cart)
    }

    function setMany(carts) {
        carts.forEach(cart => { setOne(cart) })
    }

    function addOne(cart) {
        const key = getKey(cart)
        if (!cartMap.value.has(key)) {
            cartMap.value.set(key, cart)
        }
    }

    function addMany(carts) {
        carts.forEach(cart => { addOne(cart) })
    }

    function deleteOne(cartKey) {
        cartMap.value.delete(cartKey)
    }

    function has(cart) {
        const key = getKey(cart)
        return cartMap.value.has(key)
    }

    async function fetch(cartKeyArray) {
        try {
            const result = await axiosConfig().post('/cart-item/list', {
                cartKeyArray: cartKeyArray
            })
            const carts = result.data
            setMany(carts)
            return carts
        } catch (error) {
            console.log(error)
            return []
        }
    }

    return {
        cartMap,
        setOne, setMany,
        addOne, addMany,
        deleteOne,
        has, fetch, getByCartKey, 
        makeKey, getKey
    }
})