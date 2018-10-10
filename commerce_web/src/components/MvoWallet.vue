<template>
    <div id="MvoWallet">

        <div class=" position-relative">
            <h4 style="color: #2679b5;text-align: center;margin-right: 100px" v-if="userInfo.walletId ==null">钱包注册</h4>
            <h4 style="color: #2679b5;text-align: center;margin-right: 100px" v-if="userInfo.walletId != null">钱包查看</h4>
            <hr>
        </div>

        <div id="main-content" class="clearfix">
            <div id="page-content" class="clearfix">

                <div class="Register">
                    <form id="rWallet">
                        <input type="hidden" name="userId" :value="userInfo.id">
                        <div class="mydiv" v-if="userInfo.walletId ==null"><label class="green">账号:</label><input
                                type="text" name="username"></div>
                        <div class="mydiv" v-if="userInfo.walletId ==null"><label class="green">密码:</label><input
                                type="password" name="password"></div>
                            <div class="mydiv" v-if="userInfo.walletId !=null"><label class="green" >账号:</label>
                                <input type="text" readonly="readonly" name="username" :value="wallet.username"></div>
                            <div class="mydiv" v-if="userInfo.walletId !=null"><label class="green">余额:</label>
                                <input type="text" readonly="readonly" name="password" :value="wallet.money">

                            </div>

                            <button type="button" @click="walletRegister" class="btn  btn-success save" v-if="userInfo.walletId ==null">注册</button>
                    </form>
                    <div>{{hint}}</div>
                </div>
            </div>
        </div>

    </div>
</template>

<script>
    import {mapGetters, mapActions} from 'vuex'

    export default {
        name: "MvoWallet",
        data() {
            return {
                wallet:{
                    id:null,
                    username:null,
                    password:null,
                    money:null,
                    createDate:null,
                },
                hint: ""
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
                        this.hint = "操作成功"
                        console.log(res.data);


                    })
            }
        },
        mounted() {
            this.getWallet()
        }

    }
</script>

<style scoped>
    /* Export Animations */
    .clearfix{animation:spaceInRight 1s 0s 1 both}

    @keyframes spaceInRight {
        0% {
            opacity: 0;
            transform-origin: 100% 50%;
            transform: scale(.2) translate(200%, 0%);
        }

        100% {
            opacity: 1;
            transform-origin: 100% 50%;
            transform: scale(1) translate(0%, 0%);
        }
    }


    .mydiv {
        margin-bottom: 20px;

    }

    .Register {
        width: 50%;
        margin: auto;
    }

    .green {
        color: #69aa46 !important;
        width: 68px;
        font-weight: normal;
        display: block;
    }
</style>