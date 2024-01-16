import { createRouter, createWebHistory } from 'vue-router'
import HomeView from '../views/HomeView.vue'

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      name: 'home',
      component: HomeView
    },
    {
      path: '/login',
      name: 'login',
      component: () => import('../views/LoginView.vue')
    },
    {
      path: '/register',
      name: 'register',
      component: () => import('../views/RegisterView.vue')
    },
    {
      path: '/search',
      name: 'search',
      component: () => import('../views/SearchView.vue')
    },
    {
      path: '/order-summary',
      name: 'order-summary',
      component: () => import('../views/OrderSummaryView.vue')
    },
    {
      path: '/book/:id',
      name: 'book',
      component: () => import('../views/BookView.vue')
    },
    {
      path: '/test',
      name: 'test',
      component: () => import('../views/TestView.vue')
    },
    {
      path: '/:pathMatch(.*)*', 
      name: 'error',
      component: () => import('../views/ErrorView.vue')
    },

  ]
})

export default router
