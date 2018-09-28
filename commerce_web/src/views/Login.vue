<template>
    <div id="Login" class="conten">
        <div class="container">
            <form class="form-signin">
                <h2 class="form-signin-heading">Please sign in</h2>
                <label class="sr-only">Username（用户名）</label>
                <input type="email" id="inputEmail" class="form-control sr-only" placeholder="用户名" required autofocus>
                <label class="sr-only">Password</label>
                <input type="password" id="inputPassword" class="form-control" placeholder="密码" required>
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

        </div>
    </div>
</template>

<script>
    import {mapGetters, mapActions} from 'vuex'
    export default {
        name: "Login",
        computed:{
            ...mapGetters([
                'user',
            ]),
        },
        methods:{
            ...mapActions([
                'acUser',
            ]),
            doLogin(){
                alert("doLogin")
            }
        }
    }
</script>

<style scoped>
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
    .nav.nav-pills.form-signin.mypadding{animation:puffIn 0.5s 0s 1 both}
    .form-signin{animation:twisterInDown 1s 0s 1 normal both}
    @keyframes puffIn {
        0% {
            opacity: 0;
            transform-origin: 50% 50%;
            transform: scale(2,2);
            filter: blur(2px);
        }

        100% {
            opacity: 1;
            transform-origin: 50% 50%;
            transform: scale(1,1);
            filter: blur(0px);
        }
    }
    @keyframes twisterInDown {
        0% {
            opacity: 0;
            transform-origin: 0 100%;
            transform: scale(0, 0) rotate(360deg) translateY(-100%);
        }

        30% {
            transform-origin: 0 100%;
            transform: scale(0, 0) rotate(360deg) translateY(-100%);
        }

        100% {
            opacity: 1;
            transform-origin: 100% 100%;
            transform: scale(1, 1) rotate(0deg) translateY(0%);
        }
    }
</style>