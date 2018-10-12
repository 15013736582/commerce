<template>
    <div id="AdminWalletController">
        <div id="page-content" class="clearfix">

            <div class="page-header position-relative">
                <h1 style="color: #2679b5;">管理员<small><i class="icon-double-angle-right"></i> 提现审核</small></h1>
            </div>
            <table id="table_bug_report" class="table table-striped table-bordered table-hover">
                <thead>
                <tr>
                    <th class="center">
                        <label><input type="checkbox" class="ace-checkbox-2"><span class="lbl"></span></label>
                    </th>
                    <th>账户名</th>
                    <th>业务类型</th>
                    <th class="hidden-480">金额</th>
                    <th>描述</th>
                    <th class="hidden-phone">申请时间</th>
                    <th>状态</th>
                    <th>操作</th>
                </tr>
                </thead>

                <tbody>
                <tr v-for="(o,index) in orders" :key="index" >
                    <td class="center">
                        <label><input type="checkbox" class="input"><span class="lbl"></span></label>
                    </td>
                    <td>{{o.user.username}}</td>
                    <td>{{o.type | dicCover('walletType',dicList)}}</td>
                    <td class="hidden-480">${{o.money}}</td>
                    <td>{{o.desp}}</td>
                    <td class="hidden-phone">{{o.createDate}}</td>
                    <td class="state">{{o.status | dicCover('walletStatus',dicList)}}</td>

                    <!--<td >-->
                        <!--已审核-->
                    <!--</td>-->
                    <td v-if="o.status == 0">
                        <a @click="check(index)" class="aa" data-toggle="modal" data-target="#myModal">审核</a>
                    </td>
                    <td v-else></td>
                </tr>
                </tbody>
            </table>


            <!--modal-->


            <div class="modal fade in" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="false">
                <div class="modal-dialog" role="document">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">×</span></button>
                            <h4 class="modal-title" id="myModalLabel">审核</h4>
                        </div>
                        <div class="modal-body">
                            <form id="frm" class="form-horizontal">
                                <div style="text-align: center">
                                    <label style="display: inline-block;margin-right: 20px">
                                        <input name="status" value="1"   type="radio" ><span class="lbl"> 通过</span>
                                    </label>
                                    <label style="display: inline-block">
                                        <input name="status" value="2" type="radio" ><span class="lbl"> 不通过</span>
                                    </label>
                                </div>

                                <div id="uploader-demo">
                                    上传水单：
                                    <span class="red">(建议图片大小160*80的jpg/png格式)</span>
                                    <!--用来存放item-->
                                    <div id="thelist" class="uploader-list"></div>
                                    <div style="width: 20%;  margin:20px auto;">
                                    </div>
                                    <div class="control-group">
                                        <label class="control-label"> </label>
                                        <img class="img-rounded my_img" v-show="currOrder.img != '' && currOrder.img != null"
                                             :src="'http://qn.limitip.com/'+currOrder.img"/>
                                        <input id="file" @change="upLoad($event)" type="file" name="myFile">
                                    </div>

                                </div>
                                <small>如不通过，请填写原因：</small>
                                <textarea style="width: 90%" class="span12" id="form-field-8" name="desp" placeholder="Default Text"></textarea>
                                <input type="hidden" name="id" :value="currOrder.id" />
                                <input type="hidden" name="img" :value="currOrder.img" />
                                <input type="hidden" name="wId" :value="currOrder.wId" />
                                <input type="hidden" name="type" :value="currOrder.type" />
                                <input type="hidden" name="money" :value="currOrder.money" />
                            </form>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                            <button type="button" class="btn btn-primary" data-dismiss="modal" @click="doCheck">保存</button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</template>

<script>
    export default {
        name: "AdminWalletController",
        data(){
            return{
                dicList: [],
                orders:[],
                currOrder:{}
            }
        },
        methods:{
            getDic() {
                this.$axios.post("/api/dic/all")
                    .then(res => {
                        this.dicList = res.data.dicList;
                    })
            },
            getOrders(){
                this.$axios.post("/api/walletOrder/findAll")
                    .then(res=>{
                        console.log(res.data);
                        this.orders = res.data.orders;
                    })
            },
            upLoad(event) {
                let file = event.target.files[0];
                let data = new FormData();
                data.append("proImg", file);
                this.$axios.post("/api/pro/upload", data)
                    .then(res => {
                        this.currOrder.img = res.data.imgSrc;
                    })
                    .catch(function (error) {
                        console.log(error)
                    })
            },
            check(index){
                this.currOrder = {...this.orders[index]};
            },
            doCheck(){
                let date = $("#frm").serialize();
                this.$axios.post("/api/walletOrder/update",date)
                    .then(res=>{
                        this.getOrders()
                    })
            }
        },
        mounted(){
            this.getDic();
            this.getOrders();
        }
    }
</script>

<style scoped>

    .my_img{
        width: 100px;
        height: 100px;
    }

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
    @keyframes fadeInRight {
        from {
            opacity: 0;
            transform: translate3d(100%, 0, 0);
        }

        to {
            opacity: 1;
            transform: none;
        }
    }
    @keyframes flipInY {
        from {
            transform: perspective(400px) rotate3d(0, 1, 0, 90deg);
            animation-timing-function: ease-in;
            opacity: 0;
        }

        40% {
            transform: perspective(400px) rotate3d(0, 1, 0, -20deg);
            animation-timing-function: ease-in;
        }

        60% {
            transform: perspective(400px) rotate3d(0, 1, 0, 10deg);
            opacity: 1;
        }

        80% {
            transform: perspective(400px) rotate3d(0, 1, 0, -5deg);
        }

        to {
            transform: perspective(400px);
        }
    }

    a:hover{
        cursor: pointer;
    }

</style>