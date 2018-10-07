<template>
    <div id="Login" class="conten">

        <div class="container">
            <form id="frm" class="form-signin">
                <h2 class="form-signin-heading">Please sign in</h2>
                <label class="sr-only">Username（用户名）</label>
                <input  id="inputEmail" name="username" class="form-control sr-only">
                <label class="sr-only">Password</label>
                <input type="password" id="inputPassword" name="password" class="form-control">
                <div class="checkbox">
                    <label>
                        <input type="checkbox" value="remember-me"> Remember me
                    </label>
                </div>
                <button class="btn  btn-primary btn-block" type="button" @click="doLogin">登录</button>
                <router-link :to="{name:'m_register'}">
                    <button class="btn  btn-primary btn-block" type="button">注册</button>
                </router-link>
            </form>
            <p v-text="hint"></p>
        </div>
    </div>
</template>

<script>
    import {mapGetters, mapActions} from 'vuex'
    export default {
        name: "Login",
        data(){
          return{
              hint:""
          }
        },
        computed:{
            ...mapGetters([
                'userInfo'
            ]),
        },
        methods: {
            ...mapActions([
                'acUserInfo',
            ]),
            doLogin(){
                let _this = this;
                let data = $("#frm").serialize();
                this.$axios.post("/api/user/login",data)
                    .then(res=>{
                        let data = res.data;
                        if(data.state == 0){
                            data.userInfo.type = data.type;
                            _this.acUserInfo(data.userInfo)
                            console.log(data.userInfo)
                            this.$router.replace({name:"home"})
                        }else {
                            _this.hint = "账户或密码错误"
                        }
                    })
            },
        },
        mounted(){
            let userId = this.$cookies.get("userId");
            let type = this.$cookies.get("userType");
            console.log(type+"@@@@@@@@@@@@@@@@@@@@@@")
            if(userId != null && userId != ""){
                let userInfo = this.userInfo;
                userInfo.id = userId;
                userInfo.type = type;
                this.acUserInfo(userInfo);
                this.$router.replace({name:'home'})
            }
        }

    }
</script>

<style scoped>
    .form-signin {
        animation: pulse 1s 0s 1 both
    }

    @keyframes pulse {
        from {
            transform: scale3d(1, 1, 1);
        }

        50% {
            transform: scale3d(1.05, 1.05, 1.05);
        }

        to {
            transform: scale3d(1, 1, 1);
        }
    }

    .sr-only {
        padding-bottom: 50px;

    }

    .conten {
        padding-top: 40px;
        padding-bottom: 40px;
        background-color: #eee;
        height: 100vh
    }

    .form-signin {
        max-width: 330px;
        padding: 15px;
        margin: 0 auto;
    }

    .form-signin .form-signin-heading,
    .form-signin .checkbox {
        margin-bottom: 10px;
    }

    .form-signin .checkbox {
        font-weight: normal;
    }

    .form-signin .form-control {
        position: relative;
        height: auto;
        -webkit-box-sizing: border-box;
        -moz-box-sizing: border-box;
        box-sizing: border-box;
        padding: 10px;
        font-size: 16px;
    }

    .form-signin .form-control:focus {
        z-index: 2;
    }

    .form-signin input[type="email"] {
        margin-bottom: -1px;
        border-bottom-right-radius: 0;
        border-bottom-left-radius: 0;
    }

    .form-signin input[type="password"] {
        margin-bottom: 10px;
        border-top-left-radius: 0;
        border-top-right-radius: 0;
    }
</style>