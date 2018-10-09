import axios from 'axios'
import cookies from 'vue-cookies'
import router from './router'
// import {mapGetters, mapActions} from 'vuex'
// axios.defaults.headers.common['token'] = cookies.get("token");
import store from './store.js';

// 添加请求拦截器
axios.interceptors.request.use(config => {
    store.state.showLoading = true;
    // console.log("=============")
    // console.log(store.state.showLoading == false)
    // console.log("=============")

    // 在发送请求之前做些什么
    config.headers.common['token'] = cookies.get("token");
    return config;
}, function (error) {
    // 对请求错误做些什么
    return Promise.reject(error);
});


// 添加响应拦截器
axios.interceptors.response.use(response => {
    store.state.showLoading = false;
    // 对响应数据做点什么
    if (response.data.state == 401) {
        router.replace({name: 'login'})
    }
    return response;
}, error => {
    // 对响应错误做点什么
    return Promise.reject(error);
});


export default axios;

