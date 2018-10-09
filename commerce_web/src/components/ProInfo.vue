<template>
    <div id="ProInfo">
        <div id="page-content" class="clearfix">

            <div class="goods-header">
                <div class="goods-header-left "><img class="my_img" :src="'http://qn.limitip.com/'+proInfo.img"/></div>
                <div class="goods-header-right">
                    <p>{{proInfo.title}}</p>
                    <p class="red">${{proInfo.price}}</p>
                    <p>类型: {{proInfo.type | dicCover('proType',dicList)}}</p>
                    <p>sku: {{proInfo.sku}}</p>
                    <p>库存：{{proInfo.reverse}}</p>
                    <button class="btn btn-primary" @click="buy"> buy</button>
                    <button class="btn btn-primary" @click="addWish">Add to Wish List</button>
                    <div>{{hint}}</div>
                </div>
            </div>

            <h4 class="lighter">Item Description</h4>
            <div class="tabbable">
                <ul class="nav nav-tabs" id="myTab">
                    <li class="active"><a data-toggle="tab" href="#ebay"> ebay description</a></li>
                    <li class=""><a data-toggle="tab" href="#Amazon">Amazon description</a></li>
                </ul>
                <div class="tab-content">
                    <div id="ebay" class="tab-pane active">
                        Raw denim you probably haven't heard of them jean shorts Austin.
                    </div>
                    <div id="Amazon" class="tab-pane">
                        Food truck fixie locavore, accusamus mcsweeney's marfa nulla single-origin coffee squid.
                    </div>
                </div>
            </div>

        </div>
    </div>
</template>

<script>

    import {mapGetters, mapActions} from 'vuex'
    export default {
        name: "ProInfo",
        data(){
            return{
                dicList:[],
                wish:{},
                hint:""
            }
        },
        props:[
            'proInfo'
        ],
        computed:{
            ...mapGetters([
                'userInfo'
            ])
        },
        methods:{
            getDic() {
                this.$axios.post("/api/dic/all")
                    .then(res => {
                        this.dicList = res.data.dicList;
                    })
            },
            buy(){
                let data = {...this.proInfo};
                data.userId = this.userInfo.id;
                this.$axios.post("/api/bvoOrder/buyOne",$.param(data))
                    .then(res => {
                        console.log(res.data)
                    })
            },
            addWish(){
                let data={uid:this.userInfo.id,pid:this.proInfo.id};
                data=$.param(data);
                this.$axios.post("/api/wish/add",data)
                    .then(res=>{
                        this.hint = "操作成功"
                        console.log(res.data)
                    })

            }
        },
        mounted(){
            this.getDic();
        }
    }
</script>

<style scoped>
    .my_img{
        width: 140px;
        height: 180px;
    }
    .goods-header{
        overflow: hidden;
    }
    .goods-header-left{
        width: 30%;
        float: left;
    }
    .goods-header-right{
        width: 70%;
        float: left;
    }
    .goods-header-left img{
        width: 100%;
    }
</style>