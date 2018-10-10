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
                    <li class=""><a data-toggle="tab" href="#canceled">已取消</a></li>
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
                        <p>
                        <table id="table_bug_report" class="table table-striped table-bordered table-hover">
                            <thead>
                            <tr>
                                <th class="center">
                                    <label><input type="checkbox" class="ace-checkbox-2"><span
                                            class="lbl"></span></label>
                                </th>
                                <th>商品标题</th>
                                <th>价格</th>
                                <th class="hidden-480">数量</th>
                                <th>sku</th>
                                <th>订单编号</th>
                                <th class="hidden-480">订单创建时间</th>

                            </tr>
                            </thead>

                            <tbody>
                            <tr>
                                <td class="center">
                                    <label><input type="checkbox" class="input"><span class="lbl"></span></label>
                                </td>
                                <td><a href="bvo-goodsdetail.html">base.com</a></td>
                                <td>$35</td>
                                <td class="hidden-480">2,595</td>
                                <td class="hidden-phone">Feb 18</td>
                                <td class="hidden-480">75684894</td>
                                <td>

                                </td>

                            </tr>


                            <tr>
                                <td class="center">
                                    <label><input type="checkbox" class="input"><span class="lbl"></span></label>
                                </td>
                                <td><a href="bvo-goodsdetail.html">max.com</a></td>
                                <td>$60</td>
                                <td class="hidden-480">4,400</td>
                                <td class="hidden-phone">Mar 11</td>
                                <td class="hidden-480">75684894</td>
                                <td>

                                </td>

                            </tr>


                            <tr>
                                <td class="center">
                                    <label><input type="checkbox" class="input"><span class="lbl"></span></label>
                                </td>
                                <td><a href="bvo-goodsdetail.html">best.com</a></td>
                                <td>$75</td>
                                <td class="hidden-480">6,500</td>
                                <td class="hidden-phone">Apr 03</td>
                                <td class="hidden-480">75684894</td>
                                <td>

                                </td>

                            </tr>


                            </tbody>
                        </table>
                        </p>
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
            }
        },
        mounted() {
            this.getOrder();
            this.getDic();
        }
    }
</script>

<style scoped>
    /* Export Animations */
    .tab-content{animation:spaceInDown 1s 0s 1 both}
    .clearfix{animation:spaceInDown 1s 0s 1 both}

    @keyframes spaceInDown {
        0% {
            opacity: 0;
            transform-origin: 50% 100%;
            transform: scale(.2) translate(0%, 200%);
        }

        100% {
            opacity: 1;
            transform-origin: 50% 100%;
            transform: scale(1) translate(0%, 0%);
        }
    }



    .info div {
        float: right;
    }

</style>