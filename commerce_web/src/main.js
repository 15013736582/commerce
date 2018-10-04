import Vue from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'
import cookies from 'vue-cookies'
import 'bootstrap/dist/css/bootstrap.min.css'
import 'bootstrap'
import axios from './axios'

Vue.config.debug = true;
Vue.config.productionTip = false



Vue.prototype.$axios = axios;  //其他页面在使用axios的时候直接  this.$http就可以了
Vue.use(cookies)

Vue.filter('fmtDate', function (timestamp) {
    let date = new Date(timestamp);
    let Y = date.getFullYear() + '-';
    let M = (date.getMonth() + 1 < 10 ? '0' + (date.getMonth() + 1) : date.getMonth() + 1) + '-';
    let D = date.getDate() + ' ';
    let h = date.getHours() + ':';
    let m = date.getMinutes() + ':';
    let s = date.getSeconds();
    return Y + M + D + h + m + s;
});

new Vue({
    router,
    store,
    render: h => h(App)
}).$mount('#app')
