<template>
    <div id="BvoOrder">
        <div id="page-content" class="clearfix">

            <div class="page-header position-relative">
                <h1 style="color: #2679b5;">借卖方
                    <small><i class="icon-double-angle-right"></i> 订单管理</small>
                </h1>
            </div>
            <form class="form-search">
                Title：
                <input type="text" class="input-medium search-query">
                <button onclick="return false;" class="btn btn-purple btn-small">Search <i
                        class="icon-search icon-on-right"></i></button>
            </form>
            <a href="#" class="btn  btn-success" style="margin-bottom: 30px">
                <i class="icon-refresh"></i>
                Pull Orders
            </a>

            <div class="tabbable">
                <ul class="nav nav-tabs" id="myTab">
                    <li class="active"><a @click="getPaidOrders(0)" data-toggle="tab" href="#AwaitingPayment"> Awaiting
                        Payment(等待付款)</a></li>
                    <li class=""><a @click="getPaidOrders(1)" data-toggle="tab" href="#paid">paid(已付款)</a></li>
                    <li class=""><a @click="getPaidOrders(2)" data-toggle="tab" href="#shipped">Shiped</a></li>
                    <li class=""><a @click="getPaidOrders(3)" data-toggle="tab" href="#complete">Completed Orders</a></li>
                    <li class=""><a @click="getPaidOrders(4)" data-toggle="tab" href="#canceled">Cancelled Orders</a></li>
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
                                <th class="hidden-480">单号</th>
                                <th>Title</th>
                                <th class="hidden-480">数量</th>
                                <th class="hidden-480">总价</th>
                                <th>订单状态</th>
                                <th></th>
                            </tr>
                            </thead>

                            <tbody>
                            <tr v-for="(item,index) in orders" :key="index">
                                <td class="center">
                                    <label><input type="checkbox" class="input"><span class="lbl"></span></label>
                                </td>
                                <td>{{index}}</td>
                                <td class="hidden-phone">{{item.id}}</td>
                                <td>{{item.title}}</td>
                                <td class="hidden-480">{{item.qty}}</td>
                                <td class="hidden-480">{{item.price}}</td>
                                <td>{{item.isPay | dicCover('orderType',dicList) }}</td>
                                <td>
                                    <button @click="buyNow(index)">Pay Now</button>
                                    <button @click="shipped(item,4)">Cancelle</button>
                                </td>
                            </tr>
                            </tbody>
                        </table>
                        <h1>{{hint}}</h1>
                    </div>
                    <div id="paid" class="tab-pane">
                        <table id="table_bug_report" class="table table-striped table-bordered table-hover">
                            <thead>
                            <tr>
                                <th class="center">
                                    <label><input type="checkbox" class="ace-checkbox-2"><span
                                            class="lbl"></span></label>
                                </th>
                                <th>序号</th>
                                <th class="hidden-480">单号</th>
                                <th>Title</th>
                                <th class="hidden-480">数量</th>
                                <th class="hidden-480">总价</th>
                                <th>订单状态</th>
                                <!--<th></th>-->
                            </tr>
                            </thead>

                            <tbody>
                            <tr v-for="(item,index) in orders" :key="index">
                                <td class="center">
                                    <label><input type="checkbox" class="input"><span class="lbl"></span></label>
                                </td>
                                <td>{{index}}</td>
                                <td class="hidden-phone">{{item.id}}</td>
                                <td>{{item.title}}</td>
                                <td class="hidden-480">{{item.qty}}</td>
                                <td class="hidden-480">{{item.price}}</td>
                                <td>{{item.isPay | dicCover('orderType',dicList) }}</td>

                                <!--<td>-->
                                    <!--<button @click="buyNow(index)">Pay Now</button>-->
                                <!--</td>-->
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
                                <th class="hidden-480">单号</th>
                                <th>Title</th>
                                <th class="hidden-480">数量</th>
                                <th class="hidden-480">总价</th>
                                <th>订单状态</th>
                                <th></th>
                            </tr>
                            </thead>

                            <tbody>
                            <tr v-for="(item,index) in orders" :key="index">
                                <td class="center">
                                    <label><input type="checkbox" class="input"><span class="lbl"></span></label>
                                </td>
                                <td>{{index}}</td>
                                <td class="hidden-phone">{{item.id}}</td>
                                <td>{{item.title}}</td>
                                <td class="hidden-480">{{item.qty}}</td>
                                <td class="hidden-480">{{item.price}}</td>
                                <td>{{item.isPay | dicCover('orderType',dicList) }}</td>
                                <td>
                                    <button @click="buyNow(index)">Pay Now</button>
                                </td>
                            </tr>
                            </tbody>
                        </table>
                        <h1>{{hint}}</h1>
                    </div>
                    <div id="complete" class="tab-pane">
                        <table id="table_bug_report" class="table table-striped table-bordered table-hover">
                            <thead>
                            <tr>
                                <th class="center">
                                    <label><input type="checkbox" class="ace-checkbox-2"><span
                                            class="lbl"></span></label>
                                </th>
                                <th>序号</th>
                                <th class="hidden-480">单号</th>
                                <th>Title</th>
                                <th class="hidden-480">数量</th>
                                <th class="hidden-480">总价</th>
                                <th>订单状态</th>
                                <!--<th></th>-->
                            </tr>
                            </thead>

                            <tbody>
                            <tr v-for="(item,index) in orders" :key="index">
                                <td class="center">
                                    <label><input type="checkbox" class="input"><span class="lbl"></span></label>
                                </td>
                                <td>{{index}}</td>
                                <td class="hidden-phone">{{item.id}}</td>
                                <td>{{item.title}}</td>
                                <td class="hidden-480">{{item.qty}}</td>
                                <td class="hidden-480">{{item.price}}</td>
                                <td>{{item.isPay | dicCover('orderType',dicList) }}</td>

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
                                <th class="hidden-480">单号</th>
                                <th>Title</th>
                                <th class="hidden-480">数量</th>
                                <th class="hidden-480">总价</th>
                                <th>订单状态</th>
                                <th></th>
                            </tr>
                            </thead>

                            <tbody>
                            <tr v-for="(item,index) in orders" :key="index">
                                <td class="center">
                                    <label><input type="checkbox" class="input"><span class="lbl"></span></label>
                                </td>
                                <td>{{index}}</td>
                                <td class="hidden-phone">{{item.id}}</td>
                                <td>{{item.title}}</td>
                                <td class="hidden-480">{{item.qty}}</td>
                                <td class="hidden-480">{{item.price}}</td>
                                <td>{{item.isPay | dicCover('orderType',dicList) }}</td>
                                <td>
                                    <button @click="buyNow(index)">Pay Now</button>
                                </td>
                            </tr>
                            </tbody>
                        </table>
                        <h1>{{hint}}</h1>
                    </div>
                </div>
            </div>
        </div>
    </div>
</template>

<script>
    import {mapGetters, mapActions} from 'vuex'

    export default {
        name: "BvoOrder",
        data() {
            return {
                orders: [],
                hint: "",
                dicList:[],

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
            buyNow(index) {
                this.$axios.post("/api/bvoOrder/pay", $.param(this.orders[index]))
                    .then(res => {
                        console.log(res.data);
                        if (res.data.state == 0) {
                            this.waitOrders.splice(index, 1);
                        }
                        else {
                            this.hint = res.data.msg;
                        }
                    })
            },
            getPaidOrders(isPay){
                this.$axios.post("/api/bvoOrder/findByUserIdAndIsPay", $.param({
                    userId: this.userInfo.id, isPay: isPay}))
                    .then(res => {
                    console.log(res.data);
                    this.orders = res.data.orders;
                })
            },
            shipped(orders,isPay){
                console.log("!!!!!!!!!!")
                orders.isPay = isPay;
                console.log(orders)
                console.log("!!!!!!!!!!")
                this.$axios.post("/api/bvoOrder/update",$.param(orders))
                    .then(res=>{
                    })
            },

        },
        mounted() {
            this.getDic();
            this.getPaidOrders(0)
        }

    }
</script>

<style scoped>
    .info div {
        float: right;
    }
</style>