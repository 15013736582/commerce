import Vue from 'vue'
import Router from 'vue-router'
import Home from './views/Home.vue'
import Login from '@/views/Login.vue'
import Register from '@/views/Register.vue'
import BovRegister from '@/components/BovRegister.vue'
import MovRegister from '@/components/MovRegister.vue'
import BovInfo from '@/components/BovInfo.vue'
import BovOrder from '@/components/BovOrder.vue'
import BovPro from '@/components/BovPro.vue'
import BovShop from '@/components/BovShop.vue'
import BovWallet from '@/components/BovWallet.vue'
import BovWish from '@/components/BovWish.vue'
import MovInfo from '@/components/MovInfo.vue'
import MovOrder from '@/components/MovOrder.vue'
import MovProAdd from '@/components/MovProAdd.vue'
import MovProImg from '@/components/MovProImg.vue'
import MovWallet from '@/components/MovWallet.vue'
import AdminDic from '@/components/AdminDic.vue'
import AdminPara from '@/components/AdminPara.vue'
import AdminWalletController from '@/components/AdminWalletController.vue'

Vue.use(Router)

export default new Router({
    mode: 'history',
    base: process.env.BASE_URL,
    routes: [
        {
            path: '/home', name: 'home', component: Home,
            children:[
                {path:'bov_info', name: 'bovInfo', component:BovInfo},
                {path:'bov_order', name: 'bovOrder', component:BovOrder},
                {path:'bov_pro', name: 'bovPro', component:BovPro},
                {path:'bov_shop', name: 'bovShop', component:BovShop},
                {path:'bov_wallet', name: 'bovWallet', component:BovWallet},
                {path:'bov_wish', name: 'bovWish', component:BovWish},
                {path:'mov_info', name: 'movInfo', component:MovInfo},
                {path:'mov_order', name: 'movOrder', component:MovOrder},
                {path:'mov_proAdd', name: 'movProAdd', component:MovProAdd},
                {path:'mov_proImg', name: 'movProImg', component:MovProImg},
                {path:'mov_wallet', name: 'movWallet', component:MovWallet},
                {path:'admin_dic', name: 'adminDic', component:AdminDic},
                {path:'admin_para', name: 'adminPara', component:AdminPara},
                {path:'admin_wallet_controller', name: 'adminWalletController', component:AdminWalletController},
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
