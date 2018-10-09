<template>
    <div id="MvoProAdd">
        <div id="main-content" class="clearfix">
            <div id="page-content" class="clearfix">
                <div class="page-header position-relative">
                    <h1 style="color: #2679b5;">品牌商
                        <small><i class="icon-double-angle-right"></i> 商品信息录入</small>
                    </h1>
                </div>

                <form id="frm" class="form-horizontal">

                    <div class="control-group">
                        <p class="red">商品标题中包含搜索关键字，品牌名，颜色，大小，型号。</p>
                        <label class="control-label">商品标题</label>
                        <div class="controls">
                            <input type="text" name="title">
                        </div>
                    </div>
                    <div class="control-group">
                        <label class="control-label">商品sku编码</label>
                        <div class="controls">
                            <input type="text" name="sku">
                        </div>
                    </div>
                    <div class="control-group">
                        <label class="control-label">价格</label>
                        <div class="controls">
                            <input type="text" name="price">
                        </div>
                    </div>

                    <div class="control-group">
                        <label class="control-label">库存</label>
                        <div class="controls">
                            <input type="text" name="reverse">
                        </div>
                    </div>
                    <div class="control-group my">
                        <label class="control-label">商品类型</label>
                        <select name="type" class="form-control">
                            <option v-for="r in proType" v-model="r.code"
                                    :value="r.code" v-text="r.value">
                            </option>
                        </select>
                    </div>
                    <div class="control-group my">
                        <label class="control-label">商品状态</label>
                        <select name="status" class="form-control">
                            <option v-for="r in proState" v-model="r.code"
                                    :value="r.code" v-text="r.value">
                            </option>
                        </select>
                    </div>
                    <div class="control-group">
                        <label class="control-label">简单描述</label>
                        <div class="controls">
                            <textarea type="text" rows="4" cols="50" name="desp"></textarea>
                        </div>
                    </div>
                    <div class="control-group">
                        <label class="control-label">商品主图</label>
                        <img class="img-rounded my_img" v-show="uploadImgSrc != '' && uploadImgSrc != null"
                             :src="'http://qn.limitip.com/'+uploadImgSrc"/>
                        <input id="file" @change="upLoad($event)" type="file" name="myFile">
                    </div>
                    <input type="hidden" name="mId" :value="userInfo.id"/>
                    <input type="hidden" name="img" :value="uploadImgSrc"/>
                </form>
                <div style="text-align: center">
                    <button class="btn">取消</button>
                    <button class="btn btn-primary saved" @click="doAdd">增加</button>
                </div>
                <div>{{hint}}</div>
            </div>

        </div>
    </div>
</template>

<script>
    import {mapGetters, mapActions} from 'vuex'
    export default {
        name: "MvoProAdd",
        data() {
            return {
                proType: [],
                proState:"",
                uploadImgSrc: "",
                hint:"",
            }
        },
        computed:{
            ...mapGetters([
                'userInfo'
            ])
        },
        methods: {
            getReportType() {
                this.$axios.post("/api/dic/type", $.param({type: "proType"}))
                    .then(res => {
                        console.log(res.data);
                        this.proType = res.data.dicList;
                    });
                this.$axios.post("/api/dic/type", $.param({type: "proState"}))
                    .then(res => {
                        console.log(res.data);
                        this.proState = res.data.dicList;
                    });
            },
            upLoad(event){
                let file = event.target.files[0];
                let data = new FormData();
                data.append("proImg",file);
                this.$axios.post("/api/pro/upload",data)
                    .then(res=> {
                        this.uploadImgSrc = res.data.imgSrc;
                    })
                    .catch(function (error) {
                        console.log(error)
                    })

            },
            doAdd(){
                let data = $("#frm").serialize();
                this.$axios.post("/api/pro/add",data)
                    .then(res=>{
                        this.hint = "操作成功"
                        this.$router.replace({name:"mvoPro"})
                    })
            }
        },
        mounted() {
            this.getReportType();
        }

    }
</script>

<style scoped>

    .my {
        width: 30%;
    }
    .my_img {
        width: 200px;
        height: 200px;
    }
</style>