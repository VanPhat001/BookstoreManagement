<template>
    <div class="edit-profile bg-white border border-4 rounded-lg shadow relative m-10">
    
        <div class="flex items-start justify-between p-5 border-b rounded-t">
            <h3 class="text-xl font-semibold">
                Edit Profile
            </h3>
            <button @click="router.back()" type="button" class="text-gray-400 bg-transparent hover:bg-gray-200 hover:text-gray-900 rounded-lg text-sm p-1.5 ml-auto inline-flex items-center" data-modal-toggle="product-modal">
               <svg class="w-5 h-5" fill="currentColor" viewBox="0 0 20 20" xmlns="http://www.w3.org/2000/svg"><path fill-rule="evenodd" d="M4.293 4.293a1 1 0 011.414 0L10 8.586l4.293-4.293a1 1 0 111.414 1.414L11.414 10l4.293 4.293a1 1 0 01-1.414 1.414L10 11.414l-4.293 4.293a1 1 0 01-1.414-1.414L8.586 10 4.293 5.707a1 1 0 010-1.414z" clip-rule="evenodd"></path></svg>
            </button>
        </div>
    
        <div class="p-6 space-y-6">
            <form @submit.prevent="onSubmitForm">
                <div class="grid grid-cols-6 gap-6">
                    <div class="col-span-6 sm:col-span-3">
                        <label for="account-id" class="text-sm font-medium text-gray-900 block mb-2">Id</label>
                        <input type="text" name="account-id" id="account-id" class="shadow-sm bg-gray-50 border border-gray-300 text-gray-900 sm:text-sm rounded-lg focus:ring-cyan-600 focus:border-cyan-600 block w-full p-2.5" :value="accountStore.id" disabled>
                    </div>
                    
                    <div class="col-span-6 sm:col-span-3">
                        <label for="username" class="text-sm font-medium text-gray-900 block mb-2">Username</label>
                        <input type="text" name="username" id="username" class="shadow-sm bg-gray-50 border border-gray-300 text-gray-900 sm:text-sm rounded-lg focus:ring-cyan-600 focus:border-cyan-600 block w-full p-2.5" :value="accountStore.username" disabled>
                    </div>

                    
                    <div class="col-span-6 sm:col-span-3">
                        <label for="email" class="text-sm font-medium text-gray-900 block mb-2">Email</label>
                        <input type="text" name="email" id="email" class="shadow-sm bg-gray-50 border border-gray-300 text-gray-900 sm:text-sm rounded-lg focus:ring-cyan-600 focus:border-cyan-600 block w-full p-2.5" :value="accountStore.email" disabled>
                    </div>

                    <div class="col-span-6 sm:col-span-3">
                        <label for="phone" class="text-sm font-medium text-gray-900 block mb-2">Phone</label>
                        <input type="text" name="phone" id="phone" class="shadow-sm bg-gray-50 border border-gray-300 text-gray-900 sm:text-sm rounded-lg focus:ring-cyan-600 focus:border-cyan-600 block w-full p-2.5" v-model="account.phone">
                    </div>

                    <div class="col-span-6">
                        <label for="name" class="text-sm font-medium text-gray-900 block mb-2">Name</label>
                        <input type="text" name="name" id="name" class="shadow-sm bg-gray-50 border border-gray-300 text-gray-900 sm:text-sm rounded-lg focus:ring-cyan-600 focus:border-cyan-600 block w-full p-2.5" v-model="account.name">
                    </div>

                    <div class="col-span-6">
                        <label for="address" class="text-sm font-medium text-gray-900 block mb-2">Address</label>
                        <input type="text" name="address" id="address" class="shadow-sm bg-gray-50 border border-gray-300 text-gray-900 sm:text-sm rounded-lg focus:ring-cyan-600 focus:border-cyan-600 block w-full p-2.5" v-model="account.address">
                    </div>

                    <!-- gender -->
                    <!-- avatar -->

                    
                    <div class="col-span-6">
                        <label for="password" class="text-sm font-medium text-gray-900 block mb-2">Password</label>
                        <input type="password" name="password" id="password" class="shadow-sm bg-gray-50 border border-gray-300 text-gray-900 sm:text-sm rounded-lg focus:ring-cyan-600 focus:border-cyan-600 block w-full p-2.5" v-model="account.password">
                    </div>
                    
                    <!-- <div class="col-span-6 sm:col-span-3">
                        <label for="price" class="text-sm font-medium text-gray-900 block mb-2">Price</label>
                        <input type="number" name="price" id="price" class="shadow-sm bg-gray-50 border border-gray-300 text-gray-900 sm:text-sm rounded-lg focus:ring-cyan-600 focus:border-cyan-600 block w-full p-2.5" placeholder="$2300">
                    </div> -->

                    <!-- <div class="col-span-full">
                        <label for="product-details" class="text-sm font-medium text-gray-900 block mb-2">Product Details</label>
                        <textarea id="product-details" rows="6" class="bg-gray-50 border border-gray-300 text-gray-900 sm:text-sm rounded-lg focus:ring-cyan-600 focus:border-cyan-600 block w-full p-4" placeholder="Details"></textarea>
                    </div> -->
                </div>
            </form>
        </div>
    
        <div class="p-6 border-t border-gray-200 rounded-b">
            <button class="text-white bg-cyan-600 hover:bg-cyan-700 focus:ring-4 focus:ring-cyan-200 font-medium rounded-lg text-sm px-12 py-2.5 text-center" type="submit" @click="onSubmitForm">Update</button>
        </div>
    
    </div>
</template>

<style>
input:disabled {
    opacity: .5;
}
</style>

<script setup>
import { useAccountSore } from '@/stores/account'
import axiosConfig from '@/axiosConfig'
import router from '@/router';


let accountStore = useAccountSore()
let account = useAccountSore().clone()
// console.log(accountStore);
// console.log(account);

function onSubmitForm()
{
    console.log("send form");

    axiosConfig().post("/customer/update", account)
    .then(result => {
        if (result.data)
        {
            account.password = null
            accountStore.setAccount(account)
            alert("Your profile is updated")
        }
        else
        {
            alert("Password is not correct!!!")
        }
    })
    .catch(console.log)
}

</script>