<template>
    <div id="BvoPro" class="main">
        <div>
            <h5 style="margin-top: 45px;">Feature Products</h5>
            <!--<div class="container">-->
            <!--<div class="row">-->
            <!--<div class="col-md-3">-->
            <!--</div>-->
            <!--</div>-->
            <!--</div>-->
            <ul>
                <li v-for="(pro,index) in proList " :key="index">
                    <router-link :to="{name:'proInfo', params: {proInfo:proList[index]}}">
                        <div class="img"></div>
                        <img :src="'http://qn.limitip.com/'+pro.img" alt="" style="height: 136px" width="80px"/>
                        <p>{{pro.title}}</p>
                        <p>{{pro.type | dicCover("proType",dicList)}} </p>
                        <span>${{pro.price}}</span>
                    </router-link>
                </li>
            </ul>
        </div>
    </div>
</template>

<script>
    export default {
        name: "BvoPro",
        data() {
            return {
                proList: [],
                dicList: []
            }
        },
        methods: {
            getProList() {
                this.$axios.post("/api/pro/queryByState", $.param({state: "0"}))
                    .then(res => {
                            this.proList = res.data.proList;
                            console.log(res.data)
                        }
                    )
            },
            getDic() {
                this.$axios.post("/api/dic/all")
                    .then(res => {
                        this.dicList = res.data.dicList;
                    })
            },
        },
        mounted() {
            this.getProList();
            this.getDic();
        }

    }
</script>

<style scoped>
    .col-md-9{animation:tada 1s 0s 1 both}
    .main{animation:bounce 1s ease 0s 1 both}
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
    li {
        list-style: none;
    }

    .main {
        /*margin-left: 190px;*/
        padding: 8px 20px 24px;
    }

    .main ul {
        overflow: hidden;
    }

    .main li {
        width: 25%;
        padding: 0 2.5%;
        box-sizing: border-box;
        float: left;
        margin-bottom: 30px;
    }

    .main li p {
        font-size: 15px;
        color: #666;
        height: 36px;
        overflow: hidden;
        overflow: hidden;
        text-overflow: ellipsis;
        display: -webkit-box;
        -webkit-line-clamp: 2;
        -webkit-box-orient: vertical;
    }

    .main li:hover,
        /*:focus {*/
        /*background-color: #f5f5f5;*/
        /*box-shadow: 2px 2px 5px #999;*/
        /*}*/

    .main li a {
        display: inline;
    }

    .main li span {
        color: #d72439;
        line-height: 40px;
    }

    .main li img {
        width: 100%;
    }

    .main h5 {
        line-height: 40px;
        padding-left: 2%;
        box-sizing: border-box;
        font-size: 20px;
    }
</style>