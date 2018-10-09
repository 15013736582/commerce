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
    .main{animation:bounce 1s ease 0s 1 both}
    .clearfix{animation:pulse 1s 0s 1 both}
    .clearfix{animation:tada 1s 0s 1 both}
    .clearfix{animation:rubberBand 1s 0s 1 both}
    .col-md-9{animation:wobble 1.8s ease 0s 1 reverse both}
    .col-md-9{animation:fadeInRight 1s 0s 1 both}
    .clearfix{animation:flipInY 1s 0s 1 both}

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
    @keyframes rubberBand {
        from {
            transform: scale3d(1, 1, 1);
        }

        30% {
            transform: scale3d(1.25, 0.75, 1);
        }

        40% {
            transform: scale3d(0.75, 1.25, 1);
        }

        50% {
            transform: scale3d(1.15, 0.85, 1);
        }

        65% {
            transform: scale3d(.95, 1.05, 1);
        }

        75% {
            transform: scale3d(1.05, .95, 1);
        }

        to {
            transform: scale3d(1, 1, 1);
        }
    }
    @keyframes wobble {
        from {
            transform: none;
        }

        15% {
            transform: translate3d(-25%, 0, 0) rotate3d(0, 0, 1, -5deg);
        }

        30% {
            transform: translate3d(20%, 0, 0) rotate3d(0, 0, 1, 3deg);
        }

        45% {
            transform: translate3d(-15%, 0, 0) rotate3d(0, 0, 1, -3deg);
        }

        60% {
            transform: translate3d(10%, 0, 0) rotate3d(0, 0, 1, 2deg);
        }

        75% {
            transform: translate3d(-5%, 0, 0) rotate3d(0, 0, 1, -1deg);
        }

        to {
            transform: none;
        }
    }
    @keyframes fadeInRight {
        from {
            opacity: 0;
            transform: translate3d(100%, 0, 0);
        }

        to {
            opacity: 1;
            transform: none;
        }
    }
    @keyframes flipInY {
        from {
            transform: perspective(400px) rotate3d(0, 1, 0, 90deg);
            animation-timing-function: ease-in;
            opacity: 0;
        }

        40% {
            transform: perspective(400px) rotate3d(0, 1, 0, -20deg);
            animation-timing-function: ease-in;
        }

        60% {
            transform: perspective(400px) rotate3d(0, 1, 0, 10deg);
            opacity: 1;
        }

        80% {
            transform: perspective(400px) rotate3d(0, 1, 0, -5deg);
        }

        to {
            transform: perspective(400px);
        }
    }

    a:hover{
        cursor: pointer;
    }

</style>