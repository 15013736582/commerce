<template>
    <div id="LeftNav">
        <div id="sidebar1">
            <div id="sidebar-shortcuts">
                <div id="sidebar-shortcuts-large">
                    <button class="btn btn-small btn-success"><i class="icon-signal"></i></button>
                    <button class="btn btn-small btn-info"><i class="icon-pencil"></i></button>
                    <button class="btn btn-small btn-warning"><i class="icon-group"></i></button>
                    <button class="btn btn-small btn-danger"><i class="icon-cogs"></i></button>
                </div>
                <div id="sidebar-shortcuts-mini">
                    <span class="btn btn-success"></span>
                    <span class="btn btn-info"></span>
                    <span class="btn btn-warning"></span>
                    <span class="btn btn-danger"></span>
                </div>
            </div><!-- #sidebar-shortcuts -->
            <ul class="nav nav-list">
                <li>
                    <router-link :to="{name:'mvoInfo'}" v-if="userInfo.type==1">
                        <i class="icon-dashboard"></i>
                        <span>品牌商-我的信息</span>
                    </router-link>
                </li>
                <li>
                    <router-link :to="{name:'mvoPro'}" v-if="userInfo.type==1">
                        <i class="icon-text-width"></i>
                        <span>品牌商-商品录入</span>
                    </router-link>
                </li>
                <li>
                    <router-link :to="{name:'mvoProImg'}" v-if="userInfo.type==1">
                        <i class="icon-text-width"></i>
                        <span>品牌商-商品主图</span>
                    </router-link>
                </li>
                <li>
                    <router-link :to="{name:'mvoOrder'}" v-if="userInfo.type==1">
                        <i class="icon-file"></i>
                        <span>品牌商-订单管理</span>
                    </router-link>
                </li>
                <li>
                    <router-link :to="{name:'mvoWallet'}" v-if="userInfo.type==1">
                        <i class="icon-desktop"></i>
                        <span>品牌商-钱包</span>
                    </router-link>
                </li>
                <li>
                    <router-link :to="{name:'bvoInfo'}" v-if="userInfo.type==2">
                        <i class="icon-list"></i>
                        <span>借卖方-我的信息</span>
                    </router-link>
                </li>
                <li>
                    <router-link :to="{name:'bvoShop'}" v-if="userInfo.type==2">
                        <i class="icon-edit"></i>
                        <span>借卖方-店铺管理</span>
                    </router-link>
                </li>
                <li>
                    <router-link :to="{name:'bvoPro'}" v-if="userInfo.type==2">
                        <i class="icon-list-alt"></i>
                        <span>借卖方-商品浏览</span>
                    </router-link>
                </li>
                <li>
                    <router-link :to="{name:'bvoWish'}" v-if="userInfo.type==2">
                        <i class="icon-list-alt"></i>
                        <span>借卖方-心愿单</span>
                    </router-link>
                </li>
                <li>
                    <router-link :to="{name:'bvoOrder'}" v-if="userInfo.type==2">
                        <i class="icon-calendar"></i>
                        <span>借卖方-订单管理</span>
                    </router-link>
                </li>
                <li>
                    <router-link :to="{name:'bvoWallet'}" v-if="userInfo.type==2">
                        <i class="icon-calendar"></i>
                        <span>借卖方-我的钱包</span>
                    </router-link>
                </li>
                <li>
                    <router-link :to="{name:'adminDic'}" v-if="userInfo.type==0">
                        <i class="icon-picture"></i>
                        <span>数据字典管理</span>
                    </router-link>
                </li>
                <li>
                    <router-link :to="{name:'adminPara'}" v-if="userInfo.type==0">
                        <i class="icon-th"></i>
                        <span>参数管理</span>
                    </router-link>
                </li>
                <li>
                    <router-link :to="{name:'adminWalletController'}" v-if="userInfo.type==0">
                        <i class="icon-th"></i>
                        <span>admin-充值提现审核</span>
                    </router-link>
                </li>
            </ul><!--/.nav-list-->
            <div id="sidebar-collapse"><i class="icon-double-angle-left"></i></div>
        </div>
    </div>
</template>

<script>
    import {mapGetters, mapActions} from 'vuex'
    export default {
        name: "LeftNav",
        computed:{
            ...mapGetters([
                'userInfo'
            ]),
        },
        mounted(){
            console.log(this.userInfo)
        }
    }
</script>

<style scoped>

</style>