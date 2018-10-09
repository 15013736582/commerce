<template>
    <div id="BvoWish">
        <div id="page-content" class="clearfix" style="margin-top: 45px;">
            <div class="page-header position-relative">
                <h1 style="color: #2679b5;">借卖方<small><i class="icon-double-angle-right"></i> 心愿单</small></h1>
            </div>
            <button class="btn btn-success" @click="delWish()"><i class="icon-trash icon-4x icon-only">delete</i></button>
            <ul>
                <!--222{{wishs[1].title}}-->
                <li class="imglist" v-for="(wish,index) in wishs" :key="index">

                    <label><input type="checkbox" class="input" id="index"><span class="lbl"></span></label>

                    <router-link :to="{name:'proInfo',params:{proInfo:wishs[index]}}">
                        <img :src="'http://qn.limitip.com/'+wish.img"  alt="" />
                        <div class="right">
                            <p>{{wish.title}}</p>
                            <span class="red">${{wish.price}}</span>
                            <p>sku:{{wish.sku}}</p>
                            <input type="checkbox" />
                        </div>
                    </router-link>

                </li>

            </ul>
        </div>
    </div>
</template>

<script>
    import {mapGetters, mapActions} from 'vuex'
    export default {
        name: "BvoWish",
        data(){
            return{
                wishs: [],
                hint: "",

            }

        },
        computed: {
            ...mapGetters([
                'userInfo'
            ])
        },
        methods:{
            getWish() {
                console.log(this.userInfo.id)
                this.$axios.post("/api/wish/find", $.param({uid: this.userInfo.id}))
                    .then(res => {
                        this.wishs = res.data.wishs;
                    });
            },
            delWish(){

                console.log(this.userInfo.id)
                console.log(this.wishs[index].id)
                this.$axios.post("/api/wish/del", $.param({uid: this.userInfo.id,pid:this.wishs[index].id}))
                    .then(res => {
                        if(res.data.state==0){
                            console.log(index);
                            this.wishs.splice(index,1);
                        }

                    });
            }
        },
        mounted() {
            this.getWish();
        }
    }
</script>

<style scoped>

    img{
        width: 200px;
        height: 200px;
    }
    .imglist{
        width: 100%;
        height: 250px;
        list-style: none;
        margin-left: 100px;

    }
    .imglist a{
        display: block;
        width: 100%;
        height: 100%;
    }
    .imglist img{
        float: left;
        margin-right: 20px;
    }
    .imglist .right,.imglist label{
        float: left;
    }
    .imglist label{
        width: 25px;
        height: 25px;
        margin-right: 10px;
    }
    .clearfix>ul{animation:puffIn 1s 0s 1 both}
    @keyframes puffIn {
        0% {
            opacity: 0;
            transform-origin: 50% 50%;
            transform: scale(2,2);
            filter: blur(2px);
        }

        100% {
            opacity: 1;
            transform-origin: 50% 50%;
            transform: scale(1,1);
            filter: blur(0px);
        }
    }

</style>