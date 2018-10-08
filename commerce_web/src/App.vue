<template>
    <div id="app">
        <!--<div id="nav">-->
        <!--<router-link to="/">Home</router-link> |-->
        <!--<router-link to="/about">About</router-link>-->
        <!--</div>-->
        <router-view/>
    </div>
</template>

<script>
    import {mapGetters, mapActions} from 'vuex'

    export default {
        name: "app",
        computed: {
            ...mapGetters([
                'userInfo'
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
        }
    }
</script>
<style lang="scss">

</style>
