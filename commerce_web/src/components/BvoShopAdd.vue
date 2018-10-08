<template>
    <div id="BvoShopAdd">
        <div id="page-content" class="clearfix">
            <h3 class="header smaller lighter red">Add a new store</h3>
            <div class="content">
                <div class="gray shop" style="margin-bottom: 20px">Set up API connection with your store by account
                    authorisation
                </div>

                <!--<button class="btn btn-primary btn-block shop">Amazon</button><br>-->
                <!--<button class="btn btn-primary btn-block shop">eBay</button>-->

                <div class="goodsname  control-group">
                    <form id="addStore">
                        <div><h4>Store Name</h4><input type="text" v-model="store.name" name="name"></div>
                        <div><h4>Seller ID</h4><input type="text" v-model="store.bId" name="bId"></div>
                        <div><h4>Placeform</h4>
                            <select name="platform" v-model="store.platform">
                                <option v-for="p in platform" v-model="p.code" :value="p.code" v-text="p.value">

                                </option>
                            </select>
                        </div>

                        <div class="button save" style="margin-top: 16px">
                            <button type="button" class="btn btn-primary" @click="addStore">save</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>


    </div>
</template>

<script>
    import {mapGetters, mapActions} from 'vuex'

    export default {
        name: "BvoShopAdd",
        data() {
            return {
                store: {
                    id: null,
                    name: null,
                    platform: null,
                    bId: null,
                },
                platform: []
            }
        },

        computed: {
            ...mapGetters([
                'userInfo'
            ])
        },

        methods: {
            getStore() {
                console.log(this.userInfo.id)
                this.$axios.post("/api/bvo/findStore", $.param({userId: this.userInfo.id}))
                    .then(res => {
                        this.store = res.data.store;
                    });
            },

            getPlatform() {
                this.$axios.post("/api/dic/type", $.param({type: "platform"}))
                    .then(res => {
                        console.log(res.data);
                        this.platform = res.data.dicList;
                    });
            },

            addStore() {
                let data=$("#addStore").serialize();
                this.$axios.post("/api/bvo/addStore",data)
                    .then(res => {
                   this.$router.replace({name:"bvoShop"});
                    });
            },
        },

        mounted() {
            this.getStore();
            this.getPlatform();
        }
    }
</script>

<style scoped>
    .content {
        width: 50%;
        margin: 20px auto;
    }

    .shop {
        width: 80%;
        margin-top: 50px;
    }
</style>