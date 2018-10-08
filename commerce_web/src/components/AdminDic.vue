<template>
    <div id="AdminDic">
        <div id="main-content" class="clearfix">
            <div id="page-content" class="clearfix">

                <div class="page-header position-relative">
                    <h1 style="color: #2679b5;">数据字典管理</h1>
                    <h4>{{hint}}</h4>
                </div>
                <table id="table_bug_report" class="table table-striped table-bordered table-hover">
                    <thead>
                    <tr>
                        <th class="center">
                            <label><input type="checkbox" class="ace-checkbox-2"><span class="lbl"></span></label>
                        </th>
                        <th>字典类型</th>
                        <th>用途描述</th>
                        <th>编码</th>
                        <th>编码值</th>
                        <th>操作</th>
                    </tr>
                    </thead>
                    <tbody>

                    <tr v-for="(dic,index) in dicList" :key="index">
                        <td class="center">
                            <label><input type="checkbox" class="input"><span class="lbl"></span></label>
                        </td>
                        <td>{{dic.type}}</td>
                        <td>{{dic.desp}}</td>
                        <td>{{dic.code}}</td>
                        <td>{{dic.value}}</td>
                        <td>
                            <div class="inline position-relative">
                                <button class="btn btn-mini btn-info" data-toggle="modal" data-target="#myModal"
                                        @click="update(index)">
                                    <i class="icon-edit"></i>
                                </button>
                                <button class="btn btn-mini btn-danger" @click="doDel(index)"><i class="icon-trash"></i>
                                </button>
                            </div>
                        </td>
                    </tr>
                    </tbody>
                </table>

                <button class="btn btn-primary" data-toggle="modal" data-target="#myModal" @click="DicAdd">新增</button>

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
                                        <label class="control-label">字典类型</label>
                                        <div class="controls">
                                            <input type="text" v-model="model.type">
                                        </div>
                                    </div>
                                    <div class="control-group">
                                        <label class="control-label">用途描述</label>
                                        <div class="controls">
                                            <input type="text" v-model="model.desp">
                                        </div>
                                    </div>
                                    <div class="control-group">
                                        <label class="control-label">编码</label>
                                        <div class="controls">
                                            <input type="text" v-model="model.code">
                                        </div>
                                    </div>
                                    <div class="control-group">
                                        <label class="control-label">编码值</label>
                                        <div class="controls">
                                            <input type="text" v-model="model.value">
                                        </div>
                                    </div>

                                </form>
                            </div>
                            <div class="modal-footer" v-if="isAdd">
                                <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                                <button type="button" class="btn btn-primary" data-dismiss="modal"
                                        @click="doDicAdd">增加
                                </button>
                            </div>
                            <div class="modal-footer" v-else>
                                <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                                <button type="button" class="btn btn-primary" data-dismiss="modal"
                                        @click="doUpdate">保存
                                </button>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</template>

<script>
    export default {
        name: "AdminDic",
        data() {
            return {
                dicList: [
                    {
                        "id": null,
                        "type": null,
                        "desp": null,
                        "code": null,
                        "value": null
                    },
                ],
                model: {},
                upIndex: null,
                hint: null,
                isAdd: false,
            }
        },
        computed: {},
        methods: {
            getDic() {
                this.$axios.post("/api/dic/all")
                    .then(res => {
                        this.dicList = res.data.dicList;
                    })
            },
            update(index) {
                this.isAdd = false;
                this.upIndex = index;
                this.model = {...this.dicList[index]};
            },
            doUpdate() {
                this.$axios.post("/api/dic/update", $.param(this.model))
                    .then(res => {
                        let old = Object.assign({}, this.dicList)
                        old[this.upIndex] = this.model;
                        this.dicList = old;
                        console.log(res.data)
                    })
            },
            doDel(index) {
                this.$axios.post("/api/dic/del", $.param({id: this.dicList[index].id}))
                    .then(res => {
                        this.dicList.splice(index, 1);
                        this.hint = "操作成功"
                    })
            },
            DicAdd() {
                this.isAdd = true;
                this.model = {};
            },
            doDicAdd() {
                console.log($.param(this.model));
                this.$axios.post("/api/dic/add", $.param(this.model))
                    .then(res => {
                        this.dicList.push(this.model);
                        this.hint = "操作成功"
                    })
            }
        },
        mounted() {
            this.getDic()
        }
    }
</script>

<style scoped>
</style>