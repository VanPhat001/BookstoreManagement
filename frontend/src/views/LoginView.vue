<style scoped>
.login_img_section {
    background: linear-gradient(rgba(2, 2, 2, .7), rgba(0, 0, 0, .7)), url(https://images.unsplash.com/photo-1650825556125-060e52d40bd0?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1170&q=80) center center;
}
</style>

<template>
    <!-- component -->
    <div class=" h-screen flex">
        <div class="hidden lg:flex w-full lg:w-1/2 login_img_section
          justify-around items-center">
            <div class=" bg-black opacity-20 inset-0 z-0">

            </div>
            <div class="w-full mx-auto px-20 flex-col items-center space-y-6">
                <h1 class="text-white font-bold text-4xl font-sans">Simple App</h1>
                <p class="text-white mt-1">The simplest app to use</p>
                <div class="flex justify-center lg:justify-start mt-6">
                    <!-- <a href="#"
                        class="hover:bg-indigo-700 hover:text-white hover:-translate-y-1 transition-all duration-500 bg-white text-indigo-800 mt-4 px-4 py-2 rounded-2xl font-bold mb-2">Get
                        Started</a> -->
                </div>
            </div>
        </div>
        <div class="flex w-full lg:w-1/2 justify-center items-center bg-white space-y-8">
            <div class="w-full px-8 md:px-32 lg:px-24">
                <form class="bg-white rounded-md shadow-2xl p-5" @submit.prevent="onLogin">
                    <h1 class="text-gray-800 font-bold text-2xl mb-1">Hello Again!</h1>
                    <p class="text-sm font-normal text-gray-600 mb-8">Welcome Back</p>
                    <div class="flex items-center border-2 mb-8 py-2 px-3 rounded-2xl">
                        <svg xmlns="http://www.w3.org/2000/svg" class="h-5 w-5 text-gray-400" fill="none"
                            viewBox="0 0 24 24" stroke="currentColor">
                            <path strokeLinecap="round" strokeLinejoin="round" strokeWidth="2"
                                d="M16 12a4 4 0 10-8 0 4 4 0 008 0zm0 0v1.5a2.5 2.5 0 005 0V12a9 9 0 10-9 9m4.5-1.206a8.959 8.959 0 01-4.5 1.207" />
                        </svg>
                        <input id="username" class=" pl-2 w-full outline-none border-none" type="text" name="username"
                            placeholder="Username" v-model="username" />
                    </div>
                    <div class="flex items-center border-2 mb-12 py-2 px-3 rounded-2xl ">
                        <svg xmlns="http://www.w3.org/2000/svg" class="h-5 w-5 text-gray-400" viewBox="0 0 20 20"
                            fill="currentColor">
                            <path fillRule="evenodd"
                                d="M5 9V7a5 5 0 0110 0v2a2 2 0 012 2v5a2 2 0 01-2 2H5a2 2 0 01-2-2v-5a2 2 0 012-2zm8-2v2H7V7a3 3 0 016 0z"
                                clipRule="evenodd" />
                        </svg>
                        <input class="pl-2 w-full outline-none border-none" type="password" name="password" id="password"
                            placeholder="Password" v-model="password" />

                    </div>

                    <button type="submit"
                        class="block w-full bg-indigo-600 mt-5 py-2 rounded-2xl hover:bg-indigo-700 hover:-translate-y-1 transition-all duration-500 text-white font-semibold mb-2">Login</button>

                    <div class="flex justify-between mt-4">
                        <span
                            class="text-sm ml-2 hover:text-blue-500 cursor-pointer hover:-translate-y-1 duration-500 transition-all">Forgot
                            Password ?</span>

                        <RouterLink :to="{ name: 'register' }"
                            class="text-sm ml-2 hover:text-blue-500 cursor-pointer hover:-translate-y-1 duration-500 transition-all">Don't
                            have an account yet?</RouterLink>
                    </div>

                </form>
            </div>

        </div>
    </div>
</template>


<!-- <template>
  <div class="login-view flex min-h-full flex-1 flex-col justify-center px-6 py-12 lg:px-8">
    <div class="sm:mx-auto sm:w-full sm:max-w-sm">
      <img class="mx-auto h-10 w-auto" src="https://tailwindui.com/img/logos/mark.svg?color=indigo&shade=600"
        alt="Your Company" />
      <h2 class="mt-10 text-center text-2xl font-bold leading-9 tracking-tight text-gray-900">Sign in to your account</h2>
    </div>

    <div class="mt-10 sm:mx-auto sm:w-full sm:max-w-sm">
      <form class="space-y-6" @submit.prevent="onLogin">
        <div>
          <label for="username" class="block text-sm font-medium leading-6 text-gray-900">Username</label>
          <div class="mt-2">
            <input v-model="username" autofocus id="username" name="username" type="text" autocomplete="username"
              class="block px-2 w-full rounded-md border-0 py-1.5 text-gray-900 shadow-sm ring-1 ring-inset ring-gray-300 placeholder:text-gray-400 focus:ring-2 focus:ring-inset focus:ring-indigo-600 sm:text-sm sm:leading-6" />
          </div>
        </div>

        <div>
          <div class="flex items-center justify-between">
            <label for="password" class="block text-sm font-medium leading-6 text-gray-900">Password</label>
            <div class="text-sm">
              <RouterLink :to="{ name: 'home' }" class="font-semibold text-indigo-600 hover:text-indigo-500"
                tabindex="-1">Forgot password?</RouterLink>
            </div>
          </div>
          <div class="mt-2">
            <input v-model="password" id="password" name="password" type="password" autocomplete="current-password"
              class="block px-2 w-full rounded-md border-0 py-1.5 text-gray-900 shadow-sm ring-1 ring-inset ring-gray-300 placeholder:text-gray-400 focus:ring-2 focus:ring-inset focus:ring-indigo-600 sm:text-sm sm:leading-6" />
          </div>
        </div>

        <div>
          <button type="submit"
            class="flex w-full justify-center rounded-md bg-indigo-600 px-3 py-1.5 text-sm font-semibold leading-6 text-white shadow-sm hover:bg-indigo-500 focus-visible:outline focus-visible:outline-2 focus-visible:outline-offset-2 focus-visible:outline-indigo-600">Sign
            in</button>
        </div>
      </form>

      <p class="mt-10 text-center text-sm text-gray-500">
        Not a member?
        {{ ' ' }} -->
        <!-- <a href="#" class="font-semibold leading-6 text-indigo-600 hover:text-indigo-500">Start a 14 day free trial</a> -->
        <!-- <router-link :to="{ name: 'register' }"
          class="font-semibold leading-6 text-indigo-600 hover:text-indigo-500">Register now!</router-link>
      </p>
    </div>
  </div>
</template> -->

<script setup>
import { reactive, ref } from 'vue';
import axiosConfig from '@/axiosConfig'
import { useRouter } from 'vue-router';

const router = useRouter()
const username = ref('customer1')
const password = ref('1234')

function onLogin() {
    // console.log(username.value, password.value)
    axiosConfig().post('/customer/find', {
        username: username.value,
        password: password.value
    })
        .then(result => {
            const account = result.data
            if (account != '') {
                localStorage.setItem('accountId', account.id)
                // router.push({ name: 'home' })
                window.location.href = '/'
            }
        })
        .catch(console.log)

}
</script>
  