import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)

export default new Vuex.Store({
    state: {
        userInfo: {
            id: "",
            username: "",
            password: "",
            nickname: null,
            sex: null,
            walletId: null,
            token: null,
            addDate: null,
            type:null,
        },
        showLoading:false,
    },
    mutations: {
        mUserInfo(state, n) {
            state.userInfo = n;
        },
        mShowLoading(){

        }
    },
    actions: {
        acUserInfo({commit}, n) {
            commit('mUserInfo', n);
        },
    },
    getters: {
        userInfo: (state) => {
            return state.userInfo;
        },
        showLoading:(state) => {
            return state.showLoading;
        },
    },
})
