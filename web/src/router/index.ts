import { createRouter, createWebHistory, RouteRecordRaw } from 'vue-router'
import Home from '../views/Home.vue'
import Login from '../views/Login.vue'; // 新增导入

const routes: Array<RouteRecordRaw> = [
  {
    path: '/', // 新增登录路由，首页指向登录页面
    name: 'Login',
    component: Login,
  },
  {
    path: '/home',
    name: 'Home',
    component: Home
  }
]

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes
})

export default router
