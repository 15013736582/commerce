<template>
    <div id="app">
        <!--<div id="nav">-->
        <!--<router-link to="/">Home</router-link> |-->
        <!--<router-link to="/about">About</router-link>-->
        <!--</div>-->
        <router-view/>
        <Loading class="my_loading" v-if="showLoading"></Loading>
    </div>
</template>

<script>
    import {mapGetters, mapActions} from 'vuex'
    import Loading from '@/components/loading/Loading.vue'
    export default {
        name: "app",
        computed: {
            ...mapGetters([
                'userInfo',
                'showLoading',
            ]),
        },
        methods: {
            ...mapActions([
                'acUserInfo',
            ])
        },
        mounted() {
            let userId = this.$cookies.get("userId");
            let type = this.$cookies.get("userType");
            if (userId != null && userId != "") {
                this.$axios.post("/api/user/getUserById",$.param({userId: userId}))
                    .then(res=>{
                        let userInfo = this.userInfo;
                        userInfo = res.data.userInfo;
                        userInfo.type = type;
                        this.acUserInfo(userInfo);
                        this.acUserInfo(userInfo);
                        this.$router.replace({name: 'home'})
                    });
            }
        },
        components: {
            Loading,
        }
    }
</script>
<style lang="scss">
 .my_loading{
     position: fixed;
     top: 280px;
     left: 0;
     right: 0;
     bottom: 0;
     background: rgba(0,0,0,0);
 }
</style>
