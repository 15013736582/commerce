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
                    <li class="active"><a @click="waitingPayment" data-toggle="tab" href="#AwaitingPayment"> Awaiting
                        Payment(等待付款)</a></li>
                    <li class=""><a @click="getPaidOrders" data-toggle="tab" href="#AwaitingShipment">paid(已付款)</a></li>
                    <li class=""><a data-toggle="tab" href="#shipped">Shiped</a></li>
                    <li class=""><a data-toggle="tab" href="#complete">Completed Orders</a></li>
                    <li class=""><a data-toggle="tab" href="#canceled">Cancelled Orders</a></li>
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
                                <th></th>
                            </tr>
                            </thead>

                            <tbody>
                            <tr v-for="(item,index) in waitOrders" :key="index">
                                <td class="center">
                                    <label><input type="checkbox" class="input"><span class="lbl"></span></label>
                                </td>
                                <td>{{index}}</td>
                                <td class="hidden-phone">{{item.id}}</td>
                                <td>{{item.title}}</td>
                                <td class="hidden-480">{{item.qty}}</td>
                                <td class="hidden-480">{{item.price}}</td>
                                <td>
                                    <button @click="buyNow(index)">Pay Now</button>
                                </td>
                            </tr>

                            </tbody>
                        </table>
                        <h1>{{hint}}</h1>
                    </div>
                    <div id="AwaitingShipment" class="tab-pane">
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
                                <!--<th></th>-->
                            </tr>
                            </thead>

                            <tbody>
                            <tr v-for="(item,index) in paidOrders" :key="index">
                                <td class="center">
                                    <label><input type="checkbox" class="input"><span class="lbl"></span></label>
                                </td>
                                <td>{{index}}</td>
                                <td class="hidden-phone">{{item.id}}</td>
                                <td>{{item.title}}</td>
                                <td class="hidden-480">{{item.qty}}</td>
                                <td class="hidden-480">{{item.price}}</td>
                                <!--<td>-->
                                    <!--<button @click="buyNow(index)">Pay Now</button>-->
                                <!--</td>-->
                            </tr>

                            </tbody>
                        </table>
                    </div>
                    <div id="shipped" class="tab-pane">
                        <p>
                        <table id="table_bug_report" class="table table-striped table-bordered table-hover">
                            <thead>
                            <tr>
                                <th class="center">
                                    <label><input type="checkbox" class="ace-checkbox-2"><span
                                            class="lbl"></span></label>
                                </th>
                                <th>Title</th>
                                <th>Price</th>
                                <th>QTY</th>
                                <th>Sku</th>
                                <th>Total</th>
                                <th>Order No</th>
                                <th>Tracking No</th>

                            </tr>
                            </thead>

                            <tbody>

                            <tr>
                                <td class="center">
                                    <label><input type="checkbox" class="input"><span class="lbl"></span></label>
                                </td>
                                <td><a href="bvo-goodsdetail.html">ace.com</a></td>
                                <td>$45</td>
                                <td>3</td>
                                <td>sk0012</td>

                                <td>$135</td>
                                <td>
                                    3562678989
                                </td>
                                <td>
                                    <a href="bvo-ordertracking.html">3534658889</a>
                                </td>
                            </tr>


                            <tr>
                                <td class="center">
                                    <label><input type="checkbox" class="input"><span class="lbl"></span></label>
                                </td>
                                <td><a href="bvo-goodsdetail.html">base.com</a></td>
                                <td>$45</td>
                                <td>3</td>
                                <td>sk0012</td>

                                <td>$135</td>
                                <td>
                                    3562678989
                                </td>
                                <td>
                                    <a href="bvo-ordertracking.html">3534658889</a>
                                </td>
                            </tr>


                            <tr>
                                <td class="center">
                                    <label><input type="checkbox" class="input"><span class="lbl"></span></label>
                                </td>
                                <td><a href="bvo-goodsdetail.html">max.com</a></td>
                                <td>$45</td>
                                <td>3</td>
                                <td>sk0012</td>

                                <td>$135</td>
                                <td>
                                    3562678989
                                </td>
                                <td>
                                    <a href="bvo-ordertracking.html">3534658889</a>
                                </td>
                            </tr>


                            <tr>
                                <td class="center">
                                    <label><input type="checkbox" class="input"><span class="lbl"></span></label>
                                </td>
                                <td><a href="bvo-goodsdetail.html">best.com</a></td>
                                <td>$45</td>
                                <td>3</td>
                                <td>sk0012</td>

                                <td>$135</td>
                                <td>
                                    3562678989
                                </td>
                                <td>
                                    <a href="bvo-ordertracking.html">3534658889</a>
                                </td>
                            </tr>


                            </tbody>
                        </table>
                        </p>
                    </div>
                    <div id="complete" class="tab-pane">
                        <p>
                        <table id="table_bug_report" class="table table-striped table-bordered table-hover">
                            <thead>
                            <tr>
                                <th class="center">
                                    <label><input type="checkbox" class="ace-checkbox-2"><span
                                            class="lbl"></span></label>
                                </th>
                                <th>Title</th>
                                <th>Price</th>
                                <th>QTY</th>
                                <th>Sku</th>
                                <th>Total</th>
                                <th>Order No</th>
                                <th>Tracking No</th>

                            </tr>
                            </thead>

                            <tbody>

                            <tr>
                                <td class="center">
                                    <label><input type="checkbox" class="input"><span class="lbl"></span></label>
                                </td>
                                <td><a href="bvo-goodsdetail.html">ace.com</a></td>
                                <td>$45</td>
                                <td class="hidden-480">3</td>
                                <td>Gm7643377</td>
                                <td>$135</td>
                                <td>546738788</td>
                                <td class="hidden-480"><a href="bvo-ordertracking.html">46578990890</a></td>
                            </tr>


                            <tr>
                                <td class="center">
                                    <label><input type="checkbox" class="input"><span class="lbl"></span></label>
                                </td>
                                <td><a href="bvo-goodsdetail.html">ace.com</a></td>
                                <td>$45</td>
                                <td class="hidden-480">3</td>
                                <td>Gm7643377</td>
                                <td>$135</td>
                                <td>546738788</td>
                                <td class="hidden-480"><a href="bvo-ordertracking.html">46578990890</a></td>

                            </tr>


                            <tr>
                                <td class="center">
                                    <label><input type="checkbox" class="input"><span class="lbl"></span></label>
                                </td>
                                <td><a href="bvo-goodsdetail.html">ace.com</a></td>
                                <td>$45</td>
                                <td class="hidden-480">3</td>
                                <td>Gm7643377</td>
                                <td>$135</td>
                                <td>546738788</td>
                                <td class="hidden-480"><a href="bvo-ordertracking.html">46578990890</a></td>

                            </tr>


                            <tr>
                                <td class="center">
                                    <label><input type="checkbox" class="input"><span class="lbl"></span></label>
                                </td>
                                <td><a href="bvo-goodsdetail.html">ace.com</a></td>
                                <td>$45</td>
                                <td class="hidden-480">3</td>
                                <td>Gm7643377</td>
                                <td>$135</td>
                                <td>546738788</td>
                                <td class="hidden-480"><a href="bvo-ordertracking.html">46578990890</a></td>

                            </tr>


                            </tbody>
                        </table>
                        </p>
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
                                <th>Title</th>
                                <th>Price</th>
                                <th class="hidden-480">QTY</th>
                                <th> Sku</th>
                                <th class="hidden-480">Total</th>
                                <th class="hidden-480">Order No</th>
                            </tr>
                            </thead>

                            <tbody>
                            <tr>
                                <td class="center">
                                    <label><input type="checkbox" class="input"><span class="lbl"></span></label>
                                </td>
                                <td><a href="bvo-goodsdetail.html">base.com</a></td>
                                <td>$35</td>
                                <td class="hidden-480">20</td>
                                <td>Gm356677</td>
                                <td>$7000</td>
                                <td>543678788</td>
                            </tr>


                            <tr>
                                <td class="center">
                                    <label><input type="checkbox" class="input"><span class="lbl"></span></label>
                                </td>
                                <td><a href="bvo-goodsdetail.html">base.com</a></td>
                                <td>$35</td>
                                <td class="hidden-480">20</td>
                                <td>Gm356677</td>
                                <td>$7000</td>
                                <td>543678788</td>
                            </tr>


                            <tr>
                                <td class="center">
                                    <label><input type="checkbox" class="input"><span class="lbl"></span></label>
                                </td>
                                <td><a href="bvo-goodsdetail.html">base.com</a></td>
                                <td>$35</td>
                                <td class="hidden-480">20</td>
                                <td>Gm356677</td>
                                <td>$7000</td>
                                <td>543678788</td>
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
        name: "BvoOrder",
        data() {
            return {
                waitOrders: [],
                paidOrders: [],
                hint: "",

            }
        },
        computed: {
            ...mapGetters([
                'userInfo'
            ])
        },
        methods: {
            waitingPayment() {
                this.$axios.post("/api/bvoOrder/findByUserIdAndIsPay", $.param({
                    userId: this.userInfo.id, isPay: 0
                })).then(res => {
                    console.log(res.data);
                    this.waitOrders = res.data.orders;
                })
            },
            buyNow(index) {
                console.log(this.waitOrders[index]);
                this.$axios.post("/api/bvoOrder/pay", $.param(this.waitOrders[index]))
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
            getPaidOrders(){
                this.$axios.post("/api/bvoOrder/findByUserIdAndIsPay", $.param({
                    userId: this.userInfo.id, isPay: 1
                })).then(res => {
                    console.log(res.data);
                    this.paidOrders = res.data.orders;
                })
            }
        },
        mounted() {
            this.waitingPayment()
        }

    }
</script>

<style scoped>
    .info div {
        float: right;
    }
</style>