import { createApp } from 'vue'
import { createPinia } from 'pinia'
import VueNumberInput from '@chenfengyuan/vue-number-input'

import '@/assets/base.css'

import App from './App.vue'
import router from './router'

const app = createApp(App)

app.component(VueNumberInput.name, VueNumberInput);
app.use(createPinia())
app.use(router)

app.mount('#app')

