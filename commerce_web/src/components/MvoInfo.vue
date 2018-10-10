<template>
    <div id="MvoInfo">
        <div id="page-content" class="clearfix">
            <div class="page-header position-relative">
                <h1 style="color: #2679b5;">品牌商
                    <small><i class="icon-double-angle-right"></i> 我的信息</small>
                </h1>
            </div>
            <form id="frm">


                <div class="inputName">
                    <div class="mydiv">
                        <label class="green">中文名: </label>
                        <input type="text" name="cName" v-model="mvoInfo.cName">
                    </div>
                    <div class="mydiv">
                        <label class="green">英文名:</label>
                        <input type="text" name="eName" v-model="mvoInfo.eName">
                    </div>
                    <div class="mydiv">
                        <label class="green">Email:</label>
                        <input type="text" name="email" v-model="mvoInfo.email">
                    </div>

                    <div class="mydiv">
                        <label class="green">认证类型:</label>
                        <select name="type"  class="form-control" v-model="mvoInfo.reportType">
                            <option v-for="r in report" v-model="r.code"
                                    v-text="r.value">
                            </option>
                        </select>
                    </div>
                    <div class="mydiv">
                        <label class="green">认证地址:</label>
                        <input type="text" name="reportUrl" v-model="mvoInfo.reportUrl">
                    </div>
                    <button type="button" class="btn  btn-success save" @click="doUpdate">save</button>
                    <!--<button class="btn  btn-pink" onclick="myshop()">My Stores</button>-->
                </div>
            </form>
        </div>
    </div>
</template>

<script>
    import {mapGetters, mapActions} from 'vuex'

    export default {
        name: "MvoInfo",
        data() {
            return {
                mvoInfo: {
                    id: null,
                    cName: null,
                    eName: null,
                    introduce: null,
                    reportType: null,
                    reportUrl: null,
                    email: null
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
            getMvoInfo() {
                console.log(this.userInfo.id)
                this.$axios.post("/api/mvo/selfInfo", $.param({userId: this.userInfo.id}))
                    .then(res => {
                        this.mvoInfo = res.data.mvoInfo;
                    });
            },
            getReportType() {
                this.$axios.post("/api/dic/type", $.param({type: "report"}))
                    .then(res => {
                        console.log(res.data);
                        this.report = res.data.dicList;
                    });
            },
            doUpdate() {
                let data = $.param(this.mvoInfo);
                console.log(data);
                this.$axios.post("/api/mvo/update", data)
                    .then(res => {
                        console.log(res.data)
                    })
            }

        },
        mounted() {
            this.getMvoInfo();
            this.getReportType();
        }
    }
</script>

<style scoped>
    #frm{animation:boingInUp 1s 0s 1 both}
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
        width: 100px;
        font-weight: normal;
        display: block;
    }
</style>