import { defineStore } from 'pinia'
import { ref } from 'vue'

export const useAccountSore = defineStore('account', () => {
    const id = ref('')
    const username = ref('')
    const password = ref('')
    const email = ref('')
    const avatar = ref('')
    const name = ref('')
    const gender = ref('')
    const phone = ref('')
    const address = ref('')

    function setAccount(account) {
        id.value = account.id
        username.value = account.username
        password.value = account.password
        email.value = account.email
        avatar.value = account.avatar
        name.value = account.name
        gender.value = account.gender
        phone.value = account.phone
        address.value = account.address
    }

    function clear() {
        id.value = ''
        username.value = ''
        password.value = ''
        email.value = ''
        avatar.value = ''
        name.value = ''
        gender.value = ''
        phone.value = ''
        address.value = ''
    }

    function clone() {
        return {
            id: id.value,
            username: username.value,
            password: password.value,
            email: email.value,
            avatar: avatar.value,
            name: name.value,
            gender: gender.value,
            phone: phone.value,
            address: address.value
        }
    }

    return {
        id, username, password, email, avatar, name, gender, phone, address,
        setAccount, clone, clear
    }
})