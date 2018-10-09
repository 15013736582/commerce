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
                        <button type="button" class="btn  btn-success save"
                                @click="walletRegister" >注册</button>
                        <button type="button" class="btn  btn-success save my_btn"
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
    .main{animation:bounce 1s ease 0s 1 both}
    .clearfix{animation:pulse 1s 0s 1 both}
    .clearfix{animation:tada 1s 0s 1 both}
    .clearfix{animation:rubberBand 1s 0s 1 both}
    .col-md-9{animation:wobble 1.8s ease 0s 1 reverse both}
    @keyframes bounce {
        from, 20%, 53%, 80%, to {
            animation-timing-function: cubic-bezier(0.215, 0.610, 0.355, 1.000);
            transform: translate3d(0,0,0);
        }

        40%, 43% {
            animation-timing-function: cubic-bezier(0.755, 0.050, 0.855, 0.060);
            transform: translate3d(0, -30px, 0);
        }

        70% {
            animation-timing-function: cubic-bezier(0.755, 0.050, 0.855, 0.060);
            transform: translate3d(0, -15px, 0);
        }

        90% {
            transform: translate3d(0,-4px,0);
        }
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
    @keyframes tada {
        from {
            transform: scale3d(1, 1, 1);
        }

        10%, 20% {
            transform: scale3d(.9, .9, .9) rotate3d(0, 0, 1, -3deg);
        }

        30%, 50%, 70%, 90% {
            transform: scale3d(1.1, 1.1, 1.1) rotate3d(0, 0, 1, 3deg);
        }

        40%, 60%, 80% {
            transform: scale3d(1.1, 1.1, 1.1) rotate3d(0, 0, 1, -3deg);
        }

        to {
            transform: scale3d(1, 1, 1);
        }
    }
    @keyframes rubberBand {
        from {
            transform: scale3d(1, 1, 1);
        }

        30% {
            transform: scale3d(1.25, 0.75, 1);
        }

        40% {
            transform: scale3d(0.75, 1.25, 1);
        }

        50% {
            transform: scale3d(1.15, 0.85, 1);
        }

        65% {
            transform: scale3d(.95, 1.05, 1);
        }

        75% {
            transform: scale3d(1.05, .95, 1);
        }

        to {
            transform: scale3d(1, 1, 1);
        }
    }
    @keyframes wobble {
        from {
            transform: none;
        }

        15% {
            transform: translate3d(-25%, 0, 0) rotate3d(0, 0, 1, -5deg);
        }

        30% {
            transform: translate3d(20%, 0, 0) rotate3d(0, 0, 1, 3deg);
        }

        45% {
            transform: translate3d(-15%, 0, 0) rotate3d(0, 0, 1, -3deg);
        }

        60% {
            transform: translate3d(10%, 0, 0) rotate3d(0, 0, 1, 2deg);
        }

        75% {
            transform: translate3d(-5%, 0, 0) rotate3d(0, 0, 1, -1deg);
        }

        to {
            transform: none;
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