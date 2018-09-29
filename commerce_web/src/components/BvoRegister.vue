<template>
    <div id="MvoRegister" class="content" style="margin-top: 0px;padding: 0px">
        <div id="main-content" class="clearfix" >
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-body" style="max-height:none" >
                        <form class="form-horizontal">
                            <div class="control-group">
                                <label class="control-label">username<br>用户名</label>
                                <div class="controls control-label">
                                    <input type="text"  >
                                </div>
                            </div>
                            <div class="control-group">
                                <label class="control-label">password<br>密码</label>
                                <div class="controls control-label">
                                    <input type="text"  >
                                </div>
                            </div>
                            <div class="control-group">
                                <label class="control-label">Company Name<br>公司名称(中)</label>
                                <div class="controls control-label">
                                    <input type="text"  >
                                </div>
                            </div>
                            <div class="control-group">
                                <label class="control-label" >Email<br>邮箱</label>
                                <div class="controls control-label">
                                    <input type="text"  >
                                </div>
                            </div>
                            <div class="control-group">
                                <label class="control-label" >GMC Report Type<br> 品牌商认证类型</label>
                                <div class="controls control-label">
                                    <input type="text" >
                                </div>
                            </div>
                            <div class="control-group">
                                <label class="control-label control-label">Phone<br>电话</label>
                                <div class="controls control-label">
                                    <input type="text" >
                                </div>
                            </div>
                        </form>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-primary" id="btnsave">注册</button>
                    </div>
                </div>
            </div>
        </div>
    </div>
</template>

<script>
    export default {
        name: "MvoRegister"
    }
</script>

<style scoped>
    .control-label{
        display: inline-block;
        margin-right: 20px;
        margin-top: 20px;
        width: 160px;
    }
    #editor{
        height: 200px;
    }
    #main-content{
        margin-left: 60px;
    }
    #page-content {
        margin: 0;
        background: #FFF;
        padding: 8px 20px 24px;
    }
    .modal-footer{
        background: #fff;
    }
    .content {
        padding-top: 40px;
        padding-bottom: 40px;
        background-color: #eee;
        height: 100vh
    }

    .form-signin {
        max-width: 330px;
        padding: 15px;
        margin: 0 auto;
    }
    .form-signin .form-signin-heading,
    .form-signin .checkbox {
        margin-bottom: 10px;
    }
    .form-signin .checkbox {
        font-weight: normal;
    }
    .form-signin .form-control {
        position: relative;
        height: auto;
        -webkit-box-sizing: border-box;
        -moz-box-sizing: border-box;
        box-sizing: border-box;
        padding: 10px;
        font-size: 16px;
    }
    .form-signin .form-control:focus {
        z-index: 2;
    }
    .form-signin input[type="email"] {
        margin-bottom: -1px;
        border-bottom-right-radius: 0;
        border-bottom-left-radius: 0;
    }
    .form-signin input[type="password"] {
        margin-bottom: 10px;
        border-top-left-radius: 0;
        border-top-right-radius: 0;
    }
</style>