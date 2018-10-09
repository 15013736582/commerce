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
    .main{animation:bounce 1s ease 0s 1 both}
    .clearfix{animation:pulse 1s 0s 1 both}
    .clearfix{animation:tada 1s 0s 1 both}
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
</style>