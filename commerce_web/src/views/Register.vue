<template>
    <div id="Register" class="conten mypadding">
        <ul class="nav nav-pills form-signin mypadding" style="padding: 0px">
            <li role="presentation" class="mypadding" >
                <router-link :to="{name:'m_register'}">品牌商注册</router-link>
            </li>
            <li role="presentation" class="mypadding" ><router-link :to="{name:'b_register'}">借卖商注册</router-link></li>
        </ul>
        <router-view/>
    </div>
</template>

<script>
    export default {
        name: "Register"
    }
</script>

<style scoped>
    .mypadding{
        padding: 0px;
        padding-bottom: 0px;
    }
    .conten {
        padding-top: 20px;
        padding-bottom: 0px;
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