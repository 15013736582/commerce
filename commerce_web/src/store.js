import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)

export default new Vuex.Store({
    state: {
        user:{},
    },
    mutations: {
        mUser(state, n){

        }
    },
    actions: {
        acLogin({commit}, n){
            commit('mUser', n);
        }
    },
    getters: {
        user: (state) => {
            return state.user;
        },
    },
})
