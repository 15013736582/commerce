<template>
    <div id="MvoPro">

        <div id="page-content" class="clearfix">


            <div class="page-header position-relative">
                <h1 style="color: #2679b5;">品牌商
                    <small><i class="icon-double-angle-right"></i> 商品信息录入</small>
                </h1>
            </div>
            <form id="findByPname" class="form-search">
                商品标题：
                <input type="text" class="input-medium search-query" name="title">
                <button type="button" @click="findByPname"  class="btn btn-purple btn-small">Search <i
                        class="icon-search icon-on-right"></i></button>
            </form>
            <table id="table_bug_report" class="table table-striped table-bordered table-hover">
                <thead>
                <tr>
                    <th class="center">
                        <label><input type="checkbox" class="ace-checkbox-2"><span class="lbl"></span></label>
                    </th>
                    <th>商品标题</th>
                    <th>商品分类</th>
                    <th>商品价格</th>
                    <th>库存</th>
                    <th>sku</th>
                    <th>状态</th>
                    <th>操作</th>
                </tr>
                </thead>

                <tbody>
                <tr v-for="(p,index) in proList" :key="index">
                    <td class="center">
                        <label><input type="checkbox" class="input"><span class="lbl"></span></label>
                    </td>
                    <td width="30%"><img :src="'http://qn.limitip.com/'+p.img" style="width: 50px;height: 50px">{{p.title}}</td>
                    <td>{{p.type | dicCover('proType',dicList)}}</td>
                    <td>{{p.price}}</td>
                    <td class="hidden-480">{{p.reverse}}</td>
                    <td class="hidden-phone">{{p.sku}}</td>
                    <td class="hidden-phone">
                        <span class="label label-sm label-info arrowed arrowed-righ">
                            {{p.status | dicCover('proState',dicList)}}
                        </span>
                    </td>
                    <td>
                        <!--<button class="btn btn-primary" data-toggle="modal" data-target="#myModal" @click="DicAdd">新增</button>-->
                        <div class="inline position-relative">
                            <button class="btn btn-mini btn-info" data-toggle="modal" data-target="#myModal"
                                    @click="update(index)"><i class="icon-edit"></i></button>
                            <button class="btn btn-mini btn-danger" @click="dele(index)"><i class="icon-trash"></i></button>
                        </div>
                    </td>
                </tr>
                </tbody>
            </table>
            <router-link :to="{name:'mvoProAdd'}">
                <button class="btn btn-primary">新增</button>
            </router-link>
        </div>

        <div class="modal fade bs-example-modal-sm" id="myModal" tabindex="-1" role="dialog"
             aria-labelledby="myModalLabel">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                                aria-hidden="true">&times;</span></button>
                        <h4 class="modal-title" id="myModalLabel">数据字典信息</h4>
                    </div>
                    <div class="modal-body">
                        <form class="form-horizontal">
                            <div class="control-group">
                                <p class="red">商品标题中包含搜索关键字，品牌名，颜色，大小，型号。</p>
                                <label class="control-label">商品标题</label>
                                <div class="controls">
                                    <input type="text" name="title" v-model="currPro.title">
                                </div>
                            </div>
                            <div class="control-group">
                                <label class="control-label">商品sku编码</label>
                                <div class="controls">
                                    <input type="text" name="sku" v-model="currPro.sku">
                                </div>
                            </div>
                            <div class="control-group">
                                <label class="control-label">价格</label>
                                <div class="controls">
                                    <input type="text" name="price" v-model="currPro.price">
                                </div>
                            </div>

                            <div class="control-group">
                                <label class="control-label">库存</label>
                                <div class="controls">
                                    <input type="text" name="reverse" v-model="currPro.reverse">
                                </div>
                            </div>
                            <div class="control-group my">
                                <label class="control-label">商品类型</label>
                                <select v-model="currPro.type" class="form-control">
                                    <option v-for="r in dicList" v-if="r.type=='proType'" v-model="r.code"
                                            :value="r.code" v-text="r.value">
                                    </option>
                                </select>
                            </div>
                            <div class="control-group my">
                                <label class="control-label">商品状态</label>
                                <select v-model="currPro.status" class="form-control">
                                    <option v-for="r in dicList" v-if="r.type == 'proState'" v-model="r.code"
                                            :value="r.code" v-text="r.value">
                                    </option>
                                </select>
                            </div>
                            <div class="control-group">
                                <label class="control-label">简单描述</label>
                                <div class="controls">
                                    <textarea type="text" rows="4" cols="50" name="desp"
                                              v-model="currPro.desp"></textarea>
                                </div>
                            </div>
                            <div class="control-group">
                                <label class="control-label">商品主图</label>
                                <img class="img-rounded my_img" v-show="currPro.img != '' && currPro.img != null"
                                     :src="'http://qn.limitip.com/'+currPro.img"/>
                                <input id="file" @change="upLoad($event)" type="file" name="myFile">
                            </div>
                            <input type="hidden" name="mId" :value="userInfo.id"/>
                            <input type="hidden" name="img" :value="currPro.img"/>
                        </form>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                        <button type="button" class="btn btn-primary" data-dismiss="modal" @click="doUpdate">更新
                        </button>
                    </div>

                </div>
            </div>
        </div>
    </div>
</template>

<script>
    import {mapGetters, mapActions} from 'vuex'

    export default {
        name: "MvoPro",
        data() {
            return {
                proList: [],
                currPro: {},
                dicList: [],
            }
        },
        computed: {
            ...mapGetters([
                'userInfo'
            ])
        },
        methods: {
            getPro() {
                this.$axios.post("/api/mvo/findProByUserId", $.param({userId: this.userInfo.id}))
                    .then(res => {
                        this.proList = res.data.list;
                    })
            },
            getDic() {
                this.$axios.post("/api/dic/all")
                    .then(res => {
                        this.dicList = res.data.dicList;
                    })
            },
            dele(index){
                this.$axios.post("/api/mvo/delPro",$.param({proId:this.proList[index].id}))
                    .then(res=>{
                        if(res.data.state == 0){
                            console.log(index);
                            this.proList.splice(index,1);
                        }
                    })
            },
            update(index) {
                this.currPro = {...this.proList[index]};
                console.log(this.currPro)
            },

            doUpdate(){
                this.$axios.post("/api/mvo/updatePro",$.param(this.currPro))
                    .then(res=>{
                        this.getPro()
                    })
            },
            upLoad(event) {
                let file = event.target.files[0];
                let data = new FormData();
                data.append("proImg", file);
                this.$axios.post("/api/pro/upload", data)
                    .then(res => {
                        this.currPro.img = res.data.imgSrc;
                    })
                    .catch(function (error) {
                        console.log(error)
                    })
            },
            findByPname(){
                let data=$("#findByPname").serialize();

                this.$axios.post("/api/pro/findByPname",data)
                    .then(res => {
                        console.log(res.data);
                        this.proList = res.data.proList;
                        console.log(data)
                    })
            },
        },
        mounted() {
            this.getPro();
            this.getDic();
        }
    }
</script>

<style scoped>

    body{animation:puffIn 1s 0s 1 both}
    .clearfix{animation:slideUpReturn 1s 0s 1 both}
    .clearfix{animation:vanishIn 1s 0s 1 both}

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
    @keyframes slideUpReturn {
        0% {
            transform-origin: 0 0;
            transform: translateY(-100%);
        }

        100% {
            transform-origin: 0 0;
            transform: translateY(0%);
        }
    }
    @keyframes vanishIn {
        0% {
            opacity: 0;
            transform-origin: 50% 50%;
            transform: scale(2, 2);
            filter: blur(90px);
        }

        100% {
            opacity: 1;
            transform-origin: 50% 50%;
            transform: scale(1, 1);
            filter: blur(0px);
        }
    }


    .my_img {
        width: 200px;
        height: 200px;
    }
</style>