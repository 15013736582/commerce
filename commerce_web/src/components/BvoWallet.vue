<template>
    <div id="BvoWallet">
        <div class=" position-relative">
            <h4 style="color: #2679b5;text-align: center;margin-right: 100px" v-if="!isLogin">钱包注册/登陆</h4>
            <h4 style="color: #2679b5;text-align: center;margin-right: 100px" v-if="isLogin">钱包查看</h4>
            <hr>
        </div>

        <div class="clearfix" v-if="!isLogin">
            <div id="page-content" class="clearfix">

                <div class="Register">
                    <form id="rWallet">
                        <input type="hidden" name="userId" :value="userInfo.id">
                        <div class="mydiv">
                            <label class="green">钱包账号:</label><input
                                type="text" name="username">
                        </div>
                        <div class="mydiv" >
                            <label class="green">密码:</label><input
                                type="password" name="password">
                        </div>
                        <button v-if="userInfo.walletId ==null" type="button" class="btn  btn-success save"
                                @click="walletRegister" >注册</button>
                        <button v-if="userInfo.walletId !=null" type="button" class="btn  btn-success save my_btn"
                                @click="walletLogin" >登陆</button>
                    </form>
                    <div>{{hint}}</div>
                </div>
            </div>
        </div>


        <div  class="clearfix" v-if="isLogin" >
            <div id="page-content" class="clearfix">

                <div class="Register">
                    <form >
                        <input type="hidden" name="userId" :value="userInfo.id">
                        <div class="mydiv" >
                            <label class="green" >账号:</label>
                            <input type="text" readonly="readonly" name="username" :value="wallet.username">
                        </div>
                        <div class="mydiv" >
                            <label class="green">余额:</label>
                            <input type="text" readonly="readonly" name="password" :value="wallet.money">
                        </div>
                        <button type="button" @click="walletRegister" class="btn  btn-success save" v-if="userInfo.walletId ==null">注册</button>
                    </form>
                    <div class="mydiv" >
                        <label class="green" >充值:</label>
                        <input type="text" v-model="addm" >
                        <button @click="recharge">确定</button>
                    </div>
                    <div>{{hint}}</div>
                </div>
            </div>
        </div>

    </div>
</template>

<script>
    import {mapGetters, mapActions} from 'vuex'
    export default {
        name: "BvoWallet",
        data() {
            return {
                wallet:{
                    id:null,
                    username:null,
                    password:null,
                    money:0,
                    createDate:null,
                },
                hint: "",
                isLogin:false,
                addm:0,
            }
        },
        computed: {
            ...mapGetters([
                'userInfo'
            ])
        },
        methods: {
            getWallet() {
                console.log(this.userInfo.id)
                this.$axios.post("/api/wallet/find", $.param({userId: this.userInfo.id}))
                    .then(res => {
                        this.wallet = res.data.wallet;
                    });
            },
            walletRegister() {
                let data = $("#rWallet").serialize();
                console.log(data);
                this.$axios.post("/api/wallet/register", data)
                    .then(res => {
                        this.hint = "注册成功";
                        console.log(res.data);
                    })
            },
            walletLogin(){
                let data = $("#rWallet").serialize();
                this.$axios.post("/api/wallet/login", data)
                    .then(res => {
                        if(res.data.state == 0){
                            this.isLogin = true;
                            this.hint = "";
                        }else {
                            this.hint = "用户名或者密码错误"
                        }
                    })
            },
            recharge(){
                let data = {...this.wallet};
                data.num = this.addm;
                this.$axios.post("/api/wallet/recharge", $.param(data))
                    .then(res => {
                        if(res.data.state == 0){
                            this.hint = "充值成功";
                            this.wallet.money = parseInt(this.wallet.money) + parseInt(this.addm);
                        }else {
                            this.hint = "用户名或者密码错误"
                        }
                    })
            }
        },
        mounted() {
            this.getWallet()
        }

    }
</script>

<style scoped>
    #frm{animation:boingInUp 1s 0s 1 both}
    #AdminDic{animation:twisterInUp 1s 0s 1 both}
    #BvoWallet{animation:slideRightReturn 1s 0s 1 both}
    @keyframes boingInUp {
        0% {
            opacity: 0;
            transform-origin: 50% 0%;
            transform: perspective(800px) rotateX(-90deg);
        }

        50% {
            opacity: 1;
            transform-origin: 50% 0%;
            transform: perspective(800px) rotateX(50deg);
        }

        100% {
            opacity: 1;
            transform-origin: 50% 0%;
            transform: perspective(800px) rotateX(0deg);
        }
    }
    @keyframes twisterInUp {
        0% {
            opacity: 0;
            transform-origin: 100% 0;
            transform: scale(0, 0) rotate(360deg) translateY(100%);
        }

        30% {
            transform-origin: 100% 0;
            transform: scale(0, 0) rotate(360deg) translateY(100%);
        }

        100% {
            opacity: 1;
            transform-origin: 0 0;
            transform: scale(1, 1) rotate(0deg) translateY(0);
        }
    }
    @keyframes slideRightReturn {
        0% {
            transform-origin: 0 0;
            transform: translateX(100%);
        }

        100% {
            transform-origin: 0 0;
            transform: translateX(0%);
        }
    }


    .my_btn{
        margin-left: 20%;
    }
    .Register{
        width: 50%;
        margin:auto;
    }
    .mydiv{
        margin-bottom: 20px;

    }
    .green {
        color: #69aa46 !important;

        font-weight: normal;
        display: block;
    }
</style>