<template>
    <div id="BvoInfo">

        <div id="page-content" class="clearfix">
            <div class="page-header position-relative">
                <h1 style="color: #2679b5;">借卖方
                    <small><i class="icon-double-angle-right"></i> 我的信息</small>
                </h1>
            </div>
            <div class="inputName" >
                <div class="mydiv"><label class="green">Name: </label>
                    <input type="text" readonly="readonly"  v-model="bvoInfo.username">
                </div>
                <div class="mydiv">
                    <label class="green">Email:</label>
                    <input type="text" name="email" v-model="bvoInfo.email">
                </div>
                <div class="mydiv">
                    <label class="green">Phone:</label>
                    <input type="text" name="phone" v-model="bvoInfo.phone"></div>
                <button class="btn  btn-success save" @click="doUpdate">save</button>
                <!--<button class="btn  btn-pink" onclick="myshop()">My Stores</button>-->
            </div>
        </div>
    </div>
</template>

<script>
    import {mapGetters, mapActions} from 'vuex'

    export default {
        name: "BvoInfo",
        data() {
            return {
                bvoInfo: {
                    id: null,
                    nickname: null,
                    email: null,
                    phone: null
                },
                report: []
            }
        },
        computed: {
            ...mapGetters([
                'userInfo'
            ])
        },
        methods: {
            ...mapActions([
                'acUserInfo'
            ]),
            getBvoInfo() {

                this.$axios.post("/api/bvo/selfInfo", $.param({userId: this.userInfo.id}))
                    .then(res => {
                        console.log(res.data);
                        this.bvoInfo = res.data.bvoInfo;
                        this.bvoInfo.username = res.data.username;
                        console.log(this.bvoInfo)
                    });
            },
            getReportType() {
                this.$axios.post("/api/dic/type", $.param({type: "report"}))
                    .then(res => {
                        this.report = res.data.dicList;
                    });
            },
            doUpdate() {
                let data = $.param(this.bvoInfo);
                this.$axios.post("/api/bvo/update", data)
                    .then(res => {
                        console.log(res.data)
                    })
            }
        },
        mounted() {
            this.getBvoInfo();
            this.getReportType();
        }
    }
</script>

<style scoped>
    .clearfix{animation:pulse 1s 0s 1 both}
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


    .btn {

        margin-left: 18px;
        margin-right: 8px;
    }

    .btn-success {
        background-color: #87b87f !important;
        border-color: #87b87f
    }

    .btn-success:hover, .btn-success.active {
        background-color: #629b58 !important
    }

    .btn-success.active {
        background-color: #68a563 !important;
        border-color: #629b58
    }

    .btn-pink {
        background-color: #d6487e !important;
        border-color: #d6487e
    }

    .btn-pink:hover {
        background-color: #b73766 !important
    }

    .
    btn-pink.active {
        background-color: #c0406f !important;
        border-color: #b73766
    }

    .inputName {
        width: 50%;
        margin: 0 auto;
        font-size: 20px;
    }

    .green {
        color: #69aa46 !important;
        width: 68px;
        font-weight: normal;
        display: block;
    }
</style>