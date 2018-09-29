import Vue from 'vue'
import Router from 'vue-router'
import Home from './views/Home.vue'
import Login from '@/views/Login.vue'
import Register from '@/views/Register.vue'
import BvoRegister from '@/components/BvoRegister.vue'
import MvoRegister from '@/components/MvoRegister.vue'
import BvoInfo from '@/components/BvoInfo.vue'
import BvoOrder from '@/components/BvoOrder.vue'
import BvoPro from '@/components/BvoPro.vue'
import BvoShop from '@/components/BvoShop.vue'
import BvoWallet from '@/components/BvoWallet.vue'
import BvoWish from '@/components/BvoWish.vue'
import MvoInfo from '@/components/MvoInfo.vue'
import MvoOrder from '@/components/MvoOrder.vue'
import MvoProAdd from '@/components/MvoProAdd.vue'
import MvoProImg from '@/components/MvoProImg.vue'
import MvoWallet from '@/components/MvoWallet.vue'
import AdminDic from '@/components/AdminDic.vue'
import AdminPara from '@/components/AdminPara.vue'
import AdminWalletController from '@/components/AdminWalletController.vue'
import ProInfo from '@/components/ProInfo.vue'

Vue.use(Router)

export default new Router({
    mode: 'history',
    base: process.env.BASE_URL,
    routes: [
        {
            path: '/home', name: 'home', component: Home,
            children:[
                {path:'bvo_info', name: 'bvoInfo', component:BvoInfo},
                {path:'bvo_order', name: 'bvoOrder', component:BvoOrder},
                {path:'bvo_pro', name: 'bvoPro', component:BvoPro},
                {path:'bvo_shop', name: 'bvoShop', component:BvoShop},
                {path:'bvo_wallet', name: 'bvoWallet', component:BvoWallet},
                {path:'bvo_wish', name: 'bvoWish', component:BvoWish},
                {path:'mvo_info', name: 'mvoInfo', component:MvoInfo},
                {path:'mvo_order', name: 'mvoOrder', component:MvoOrder},
                {path:'mvo_proAdd', name: 'mvoProAdd', component:MvoProAdd},
                {path:'mvo_proImg', name: 'mvoProImg', component:MvoProImg},
                {path:'mvo_wallet', name: 'mvoWallet', component:MvoWallet},
                {path:'admin_dic', name: 'adminDic', component:AdminDic},
                {path:'admin_para', name: 'adminPara', component:AdminPara},
                {path:'admin_wallet_controller', name: 'adminWalletController', component:AdminWalletController},
                {path:'pro_info', name: 'proInfo', component:ProInfo,props:true},

            ]
        },
        {path: '/login', name:'login', component:Login},
        {
            path: '/register', name:'register', component:Register,
            children: [
                {path:'mvo', name : 'm_register',component:MvoRegister},
                {path:'bvo', name : 'b_register',component:BvoRegister},
                {path:'test', name : 'test',component:BvoInfo}
            ]
        },
        {path: '/',redirect: '/login'},
        {path: '*', redirect: '/login'},
    ]
})
