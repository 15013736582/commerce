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
        }
    },
    mutations: {
        mUserInfo(state, n) {
            state.userInfo = n;
        },
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
    },
})
