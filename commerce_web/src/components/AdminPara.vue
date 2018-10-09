<template>
    <div id="AdminPara">
            <div id="page-content" class="clearfix">
                <div class="page-header position-relative">
                    <h1 style="color: #2679b5;">参数管理</h1>
                </div>
                <table id="table_bug_report" class="table table-striped table-bordered table-hover">
                    <thead>
                    <tr>
                        <th class="center">
                            <label><input type="checkbox" class="ace-checkbox-2"><span class="lbl"></span></label>
                        </th>
                        <th>参数主键</th>
                        <th>参数值</th>
                        <th>参数说明</th>
                        <th>操作</th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                        <td class="center">
                            <label><input type="checkbox" class="input" ><span class="lbl"></span></label>
                        </td>
                        <td>STOCK_TIME</td>
                        <td>7</td>
                        <td>库存预警天数</td>
                        <td>
                            <div class="inline position-relative" >
                                <button class="btn btn-mini btn-info" data-toggle="modal" data-target="#myModal"><i class="icon-edit"></i></button>
                                <button class="btn btn-mini btn-danger"><i class="icon-trash"></i></button>
                            </div>
                        </td>
                    </tr>
                    <tr>
                        <td class="center">
                            <label><input type="checkbox" class="input"><span class="lbl"></span></label>
                        </td>
                        <td>POUNDAGE</td>
                        <td>0</td>
                        <td>提现手续费</td>
                        <td>
                            <div class="inline position-relative" >
                                <button class="btn btn-mini btn-info" data-toggle="modal" data-target="#myModal"><i class="icon-edit"></i></button>
                                <button class="btn btn-mini btn-danger"><i class="icon-trash"></i></button>
                            </div>
                        </td>
                    </tr>
                    </tbody>
                </table>
                <button class="btn btn-primary" data-toggle="modal" data-target="#myModal">新增</button>
                <!-- Modal -->
                <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
                    <div class="modal-dialog" role="document">
                        <div class="modal-content">
                            <div class="modal-header">
                                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                                <h4 class="modal-title" id="myModalLabel">参数信息</h4>
                            </div>
                            <div class="modal-body" >
                                <form class="form-horizontal">
                                    <div class="control-group">
                                        <label class="control-label">参数主键</label>
                                        <div class="controls">
                                            <input type="text"  >
                                        </div>
                                    </div>
                                    <div class="control-group">
                                        <label class="control-label">参数值</label>
                                        <div class="controls">
                                            <input type="text"  >
                                        </div>
                                    </div>
                                    <div class="control-group">
                                        <label class="control-label" >参数描述</label>
                                        <div class="controls">
                                            <input type="text" >
                                        </div>
                                    </div>
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
        name: "AdminPara"
    }
</script>

<style scoped>
    /* Export Animations */
    .main{animation:bounce 1s ease 0s 1 both}
    .clearfix{animation:pulse 1s 0s 1 both}
    .clearfix{animation:tada 1s 0s 1 both}
    .clearfix{animation:rubberBand 1s 0s 1 both}
    .col-md-9{animation:wobble 1.8s ease 0s 1 reverse both}
    .col-md-9{animation:fadeInRight 1s 0s 1 both}
    .clearfix{animation:flipInY 1s 0s 1 both}
    .clearfix{animation:fadeInLeft 1s 0s 1 both}
    /* export keyframes  */
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
    @keyframes fadeInLeft {
        from {
            opacity: 0;
            transform: translate3d(-100%, 0, 0);
        }

        to {
            opacity: 1;
            transform: none;
        }
    }

</style>