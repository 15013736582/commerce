<template>
    <div id="BvoShop">
        <div id="page-content" class="clearfix">
            <div class="goodscontent">
                <p>My stores</p>
                <div class="store">
                    <h3 class="blue">amamzon</h3>
                    <p v-for="s in store" v-if="s.platform==0">
                        {{s.name}}
                    </p>
                </div>
                <div class="store">
                    <h3 class="blue">ebay</h3>
                    <p v-for="s in store" v-if="s.platform==1">{{s.name}}</p>
                </div>
                <div style="text-align: right">
                    <router-link :to="{name:'bvoShopAdd'}" >
                        <button class="btn btn-primary addshop" >Add a new store</button>
                    </router-link>

                </div>

            </div>
        </div>
    </div>
</template>

<script>
    import {mapGetters, mapActions} from 'vuex'

    export default {
        name: "BvoShop",
        data() {
            return {
                store: [],
                report: []
            }
        },
        computed: {
            ...mapGetters([
                'userInfo'
            ])
        },
        methods: {
            getStore() {
                this.$axios.post("/api/bvo/findStore", $.param({userId: this.userInfo.id}))
                    .then(res => {
                        this.store = res.data.store;
                        console.log(this.store)
                    });
            },


        },
        mounted() {
            this.getStore();

        }
    }
</script>

<style scoped>
    .main{animation:bounce 1s ease 0s 1 both}
    .clearfix{animation:pulse 1s 0s 1 both}
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
    .goodscontent p {
        font-size: 24px;
        line-height: 40px;
    }

    .store {
        border: 1px solid #ccc;
        border-radius: 10px;
        margin: 20px 0 20px 0;
        padding-left: 3%;
    }

    .store h3 {
        line-height: 40px;
    }

    .store p {
        line-height: 40px;
        color: #666;
        border-top: 1px solid #ccc;
    }
</style>