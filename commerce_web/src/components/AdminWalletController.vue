<template>
    <div id="AdminWalletController">
        <div id="page-content" class="clearfix">

            <div class="page-header position-relative">
                <h1 style="color: #2679b5;">管理员<small><i class="icon-double-angle-right"></i> 提现审核</small></h1>
            </div>
            <table id="table_bug_report" class="table table-striped table-bordered table-hover">
                <thead>
                <tr>
                    <th class="center">
                        <label><input type="checkbox" class="ace-checkbox-2"><span class="lbl"></span></label>
                    </th>
                    <th>账户名</th>
                    <th>业务类型</th>
                    <th class="hidden-480">金额</th>
                    <th class="hidden-phone">申请时间</th>
                    <th>状态</th>
                    <th>操作</th>
                </tr>
                </thead>

                <tbody>

                <tr>
                    <td class="center">
                        <label><input type="checkbox" class="input"><span class="lbl"></span></label>
                    </td>
                    <td>LOh</td>
                    <td>充值</td>
                    <td class="hidden-480">$3,330</td>
                    <td class="hidden-phone">Feb 12</td>
                    <td class="state">等待审核</td>
                    <td>

                        <a class="aa" data-toggle="modal" data-target="#myModal">审核</a>

                    </td>
                </tr>


                <tr>
                    <td class="center">
                        <label><input type="checkbox" class="input"><span class="lbl"></span></label>
                    </td>
                    <td>LOh</td>
                    <td>提现</td>
                    <td class="hidden-480">$3,330</td>
                    <td class="hidden-phone">Feb 12</td>
                    <td class="state">等待审核</td>
                    <td>

                        <a class="aa" data-toggle="modal" data-target="#myModal">审核</a>

                    </td>
                </tr>


                <tr>
                    <td class="center">
                        <label><input type="checkbox" class="input"><span class="lbl"></span></label>
                    </td>
                    <td>LOh</td>
                    <td>充值</td>
                    <td class="hidden-480">$3,330</td>
                    <td class="hidden-phone">Feb 12</td>
                    <td class="state">等待审核</td>
                    <td>

                        <a class="aa" data-toggle="modal" data-target="#myModal">审核</a>

                    </td>
                </tr>


                <tr>
                    <td class="center">
                        <label><input type="checkbox" class="input"><span class="lbl"></span></label>
                    </td>
                    <td>LOh</td>
                    <td>提现</td>
                    <td class="hidden-480">$3,330</td>
                    <td class="hidden-phone">Feb 12</td>
                    <td class="state">等待审核</td>
                    <td>
                        <a class="aa" data-toggle="modal" data-target="#myModal">审核</a>
                    </td>
                </tr>
                </tbody>
            </table>


            <!--modal-->
            <div class="modal fade in hide" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="false">
                <div class="modal-dialog" role="document">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">×</span></button>
                            <h4 class="modal-title" id="myModalLabel">审核</h4>
                        </div>
                        <div class="modal-body">
                            <form class="form-horizontal">
                                <div style="text-align: center">
                                    <label style="display: inline-block;margin-right: 20px">
                                        <input name="form-field-radio" type="radio"><span class="lbl"> 通过</span>
                                    </label>
                                    <label style="display: inline-block">
                                        <input name="form-field-radio" type="radio"><span class="lbl"> 不通过</span>
                                    </label>
                                </div>

                                <div id="uploader-demo">
                                    上传水单：
                                    <span class="red">(建议图片大小160*80的jpg/png格式)</span>
                                    <!--用来存放item-->
                                    <div id="thelist" class="uploader-list"></div>
                                    <div style="width: 20%;  margin:20px auto;">
                                        <div id="filePicker" class="webuploader-container" ><div class="webuploader-pick" style="padding: 3px 5px;">选择图片</div><div id="rt_rt_1bn828lkecjk10911jjk1l811ls1" style="position: absolute; top: 0px; left: 0px; width: 86px; height: 40px; overflow: hidden; bottom: auto; right: auto;"><input type="file" name="file" class="webuploader-element-invisible" multiple="multiple" accept="image/*"><label style="opacity: 0; width: 100%; height: 100%; display: block; cursor: pointer; background: rgb(255, 255, 255);"></label></div></div>
                                        <button id="ctlBtn" class="btn btn-default" >开始上传</button>
                                    </div>

                                </div>
                                <small>如不通过，请填写原因：</small>
                                <textarea style="width: 90%" class="span12" id="form-field-8" placeholder="Default Text"></textarea>
                            </form>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                            <button type="button" class="btn btn-primary" data-dismiss="modal">保存</button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</template>

<script>
    export default {
        name: "AdminWalletController"
    }
</script>

<style scoped>
    a:hover{
        cursor: pointer;
    }

</style>