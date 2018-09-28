import Vue from 'vue'
import Router from 'vue-router'
import Home from './views/Home.vue'
import Login from '@/views/Login.vue'
import Register from '@/views/Register.vue'
import BovRegister from '@/components/BovRegister.vue'
import MovRegister from '@/components/MovRegister.vue'
import BovInfo from '@/components/BovInfo.vue'

Vue.use(Router)

export default new Router({
    mode: 'history',
    base: process.env.BASE_URL,
    routes: [
        {path: '/home', redirect: '/home/show'},
        {
            path: '/home', name: 'home', component: Home,
            children:[
                // {path:'show', name: 'show', component:Show},
                // {path:'login', name: 'login', component:Login},
                // {path:'register', name: 'register', component:Register},
                // {path:'shopCar', name: 'shopCar', component:ShopCar},
                // {path:'products', name: 'products', component:Products},
                // {path:'contact', name: 'contact', component:Contact},
                // {path:'detail', name: 'detail', component:Detail,props:true},
            ]
        },
        {path: '/login', name:'login', component:Login},
        {
            path: '/register', name:'register', component:Register,
            children: [
                {path:'mov', name : 'm_register',component:MovRegister},
                {path:'bov', name : 'b_register',component:BovRegister},
                {path:'test', name : 'test',component:BovInfo}
            ]
        },
        {path: '/',redirect: '/login'},
        {path: '*', redirect: '/login'},
    ]
})
