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
            if (userId != null && userId != "") {
                let userInfo = this.userInfo;
                userInfo.id = userId;
                this.acUserInfo(userInfo);
                this.$router.replace({name: 'home'})
            }
        }
    }
</script>
<style lang="scss">

</style>
