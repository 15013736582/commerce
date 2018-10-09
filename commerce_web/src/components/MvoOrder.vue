<template>
    <div id="MvoOrder">
        <div id="page-content" class="clearfix">

            <div class="page-header position-relative">
                <h1 style="color: #2679b5;">品牌商
                    <small><i class="icon-double-angle-right"></i> 订单管理</small>
                </h1>
            </div>
            <form class="form-search">
                商品标题：
                <input type="text" class="input-medium search-query">
                <button onclick="return false;" class="btn btn-purple btn-small">Search <i
                        class="icon-search icon-on-right"></i></button>
            </form>

            <div class="tabbable">
                <ul class="nav nav-tabs" id="myTab">
                    <li class="active"><a @click="getOrder(0)" data-toggle="tab" href="#AwaitingPayment"> 待支付</a></li>
                    <li class=""><a @click="getOrder(1)" data-toggle="tab" href="#paid"> 待发货</a></li>
                    <li class=""><a @click="getOrder(2)" data-toggle="tab" href="#shipped">已发货</a></li>
                    <li class=""><a @click="getOrder(3)" data-toggle="tab" href="#complete">已完成</a></li>
                    <li class=""><a @click="getOrder(4)" data-toggle="tab" href="#canceled">已取消</a></li>
                </ul>
                <div class="tab-content">
                    <div id="AwaitingPayment" class="tab-pane active">
                        <table class="table table-striped table-bordered table-hover">
                            <thead>
                            <tr>
                                <th class="center">
                                    <label><input type="checkbox" class="ace-checkbox-2"><span
                                            class="lbl"></span></label>
                                </th>
                                <th>序号</th>
                                <th>商品标题</th>
                                <th>单价</th>
                                <th>总价</th>
                                <th class="hidden-480">数量</th>
                                <th class="hidden-480">订单编号</th>
                                <th class="hidden-480">订单创建时间</th>
                                <th>订单状态</th>
                            </tr>
                            </thead>

                            <tbody>
                            <tr v-for="(item,index) in orderList" :key="index">
                                <td class="center">
                                    <label><input type="checkbox" class="input"><span class="lbl"></span></label>
                                </td>
                                <td><a href="bvo-goodsdetail.html">{{index}}</a></td>
                                <td>{{item.pro.title}}</td>
                                <td>{{item.pro.price}}</td>
                                <td>{{item.bvoOrder.price}}</td>
                                <td class="hidden-480">{{item.bvoOrder.qty}}</td>
                                <td class="hidden-480">{{item.bvoOrder.id}}</td>
                                <td class="hidden-480">{{item.bvoOrder.createDate}}</td>
                                <td>{{item.bvoOrder.isPay | dicCover('orderType',dicList)}}</td>
                            </tr>
                            </tbody>
                        </table>
                    </div>
                    <div id="paid" class="tab-pane">
                        <table class="table table-striped table-bordered table-hover">
                            <thead>
                            <tr>
                                <th class="center">
                                    <label><input type="checkbox" class="ace-checkbox-2"><span
                                            class="lbl"></span></label>
                                </th>
                                <th>序号</th>
                                <th>商品标题</th>
                                <th>单价</th>
                                <th>总价</th>
                                <th class="hidden-480">数量</th>
                                <th class="hidden-480">订单编号</th>
                                <th class="hidden-480">订单创建时间</th>
                                <th>订单状态</th>
                                <th>操作</th>
                            </tr>
                            </thead>

                            <tbody>
                            <tr v-for="(item,index) in orderList" :key="index">
                                <td class="center">
                                    <label><input type="checkbox" class="input"><span class="lbl"></span></label>
                                </td>
                                <td><a href="bvo-goodsdetail.html">{{index}}</a></td>
                                <td>{{item.pro.title}}</td>
                                <td>{{item.pro.price}}</td>
                                <td>{{item.bvoOrder.price}}</td>
                                <td class="hidden-480">{{item.bvoOrder.qty}}</td>
                                <td class="hidden-480">{{item.bvoOrder.id}}</td>
                                <td class="hidden-480">{{item.bvoOrder.createDate}}</td>
                                <td>{{item.bvoOrder.isPay | dicCover('orderType',dicList)}}</td>
                                <td>
                                    <button @click="shipped(item.bvoOrder,2)">发货</button>
                                    <button @click="shipped(item.bvoOrder,4)">取消</button>
                                </td>
                            </tr>
                            </tbody>
                        </table>
                    </div>
                    <div id="shipped" class="tab-pane">
                        <table class="table table-striped table-bordered table-hover">
                            <thead>
                            <tr>
                                <th class="center">
                                    <label><input type="checkbox" class="ace-checkbox-2"><span
                                            class="lbl"></span></label>
                                </th>
                                <th>序号</th>
                                <th>商品标题</th>
                                <th>单价</th>
                                <th>总价</th>
                                <th class="hidden-480">数量</th>
                                <th class="hidden-480">订单编号</th>
                                <th class="hidden-480">订单创建时间</th>
                                <th>订单状态</th>
                                <th>操作</th>
                            </tr>
                            </thead>

                            <tbody>
                            <tr v-for="(item,index) in orderList" :key="index">
                                <td class="center">
                                    <label><input type="checkbox" class="input"><span class="lbl"></span></label>
                                </td>
                                <td><a href="bvo-goodsdetail.html">{{index}}</a></td>
                                <td>{{item.pro.title}}</td>
                                <td>{{item.pro.price}}</td>
                                <td>{{item.bvoOrder.price}}</td>
                                <td class="hidden-480">{{item.bvoOrder.qty}}</td>
                                <td class="hidden-480">{{item.bvoOrder.id}}</td>
                                <td class="hidden-480">{{item.bvoOrder.createDate}}</td>
                                <td>{{item.bvoOrder.isPay | dicCover('orderType',dicList)}}</td>
                                <td>
                                    <button @click="shipped(item.bvoOrder,3)">完成</button>
                                    <button @click="shipped(item.bvoOrder,4)">取消</button>
                                </td>
                            </tr>
                            </tbody>
                        </table>
                    </div>
                    <div id="complete" class="tab-pane">
                        <table class="table table-striped table-bordered table-hover">
                            <thead>
                            <tr>
                                <th class="center">
                                    <label><input type="checkbox" class="ace-checkbox-2"><span
                                            class="lbl"></span></label>
                                </th>
                                <th>序号</th>
                                <th>商品标题</th>
                                <th>单价</th>
                                <th>总价</th>
                                <th class="hidden-480">数量</th>
                                <th class="hidden-480">订单编号</th>
                                <th class="hidden-480">订单创建时间</th>
                                <th>订单状态</th>
                            </tr>
                            </thead>

                            <tbody>
                            <tr v-for="(item,index) in orderList" :key="index">
                                <td class="center">
                                    <label><input type="checkbox" class="input"><span class="lbl"></span></label>
                                </td>
                                <td><a href="bvo-goodsdetail.html">{{index}}</a></td>
                                <td>{{item.pro.title}}</td>
                                <td>{{item.pro.price}}</td>
                                <td>{{item.bvoOrder.price}}</td>
                                <td class="hidden-480">{{item.bvoOrder.qty}}</td>
                                <td class="hidden-480">{{item.bvoOrder.id}}</td>
                                <td class="hidden-480">{{item.bvoOrder.createDate}}</td>
                                <td>{{item.bvoOrder.isPay | dicCover('orderType',dicList)}}</td>
                            </tr>
                            </tbody>
                        </table>
                    </div>
                    <div id="canceled" class="tab-pane">
                        <table class="table table-striped table-bordered table-hover">
                            <thead>
                            <tr>
                                <th class="center">
                                    <label><input type="checkbox" class="ace-checkbox-2"><span
                                            class="lbl"></span></label>
                                </th>
                                <th>序号</th>
                                <th>商品标题</th>
                                <th>单价</th>
                                <th>总价</th>
                                <th class="hidden-480">数量</th>
                                <th class="hidden-480">订单编号</th>
                                <th class="hidden-480">订单创建时间</th>
                                <th>订单状态</th>
                            </tr>
                            </thead>

                            <tbody>
                            <tr v-for="(item,index) in orderList" :key="index">
                                <td class="center">
                                    <label><input type="checkbox" class="input"><span class="lbl"></span></label>
                                </td>
                                <td><a href="bvo-goodsdetail.html">{{index}}</a></td>
                                <td>{{item.pro.title}}</td>
                                <td>{{item.pro.price}}</td>
                                <td>{{item.bvoOrder.price}}</td>
                                <td class="hidden-480">{{item.bvoOrder.qty}}</td>
                                <td class="hidden-480">{{item.bvoOrder.id}}</td>
                                <td class="hidden-480">{{item.bvoOrder.createDate}}</td>
                                <td>{{item.bvoOrder.isPay | dicCover('orderType',dicList)}}</td>
                            </tr>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    </div>
</template>

<script>
    import {mapGetters, mapActions} from 'vuex'

    export default {
        name: "MvoOrder",
        data() {
            return {
                dicList: [],
                orderList: [],
            }
        },
        computed: {
            ...mapGetters([
                'userInfo'
            ])
        },
        methods: {
            getDic() {
                this.$axios.post("/api/dic/all")
                    .then(res => {
                        this.dicList = res.data.dicList;
                    })
            },
            getOrder(isPay) {
                this.$axios.post("/api/mvoOrder/mvoOrderDetail", $.param({userId: this.userInfo.id, isPay: isPay}))
                    .then(res => {
                        this.orderList = res.data.orderList;
                    })
            },
            shipped(bvoOrder,isPay){
                bvoOrder.isPay = isPay;
                this.$axios.post("/api/bvoOrder/update",$.param(bvoOrder))
                    .then(res=>{
                    })
            },
        },
        mounted() {
            this.getOrder();
            this.getDic();
        }
    }
</script>

<style scoped>
    #frm{animation:swing 1s 0s 1 both}
    .col-md-9{animation:jello 2s 0s 1 both}
    .clearfix{animation:jello 2s 0s 1 both}
    .clearfix{animation:bounce 2s 0s 1 both}
    @keyframes swing {
        20% {
            transform: rotate3d(0, 0, 1, 15deg);
        }

        40% {
            transform: rotate3d(0, 0, 1, -10deg);
        }

        60% {
            transform: rotate3d(0, 0, 1, 5deg);
        }

        80% {
            transform: rotate3d(0, 0, 1, -5deg);
        }

        to {
            transform: rotate3d(0, 0, 1, 0deg);
        }
    }
    @keyframes jello {
        from, 11.1%, to {
            transform: none;
        }

        22.2% {
            transform: skewX(-12.5deg) skewY(-12.5deg);
        }

        33.3% {
            transform: skewX(6.25deg) skewY(6.25deg);
        }

        44.4% {
            transform: skewX(-3.125deg) skewY(-3.125deg);
        }

        55.5% {
            transform: skewX(1.5625deg) skewY(1.5625deg);
        }

        66.6% {
            transform: skewX(-0.78125deg) skewY(-0.78125deg);
        }

        77.7% {
            transform: skewX(0.390625deg) skewY(0.390625deg);
        }

        88.8% {
            transform: skewX(-0.1953125deg) skewY(-0.1953125deg);
        }
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

    .info div {
        float: right;
    }

</style>