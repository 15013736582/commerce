<template>
    <div id="MovRegister" class="content" style="margin-top: 0px;padding: 0px">
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
                                    <label class="control-label" >Company Name<br>公司名称(英)</label>
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
                                    <label class="control-label control-label">GMC Report Url<br>证书地址</label>
                                    <div class="controls control-label">
                                        <input type="text" >
                                    </div>
                                </div>
                                <div class="control-group">
                                    <label class="control-label">
                                        Brief Introduction<br>公司简介<p>&nbsp</p><p>&nbsp</p>
                                    </label>
                                    <div class="controls control-label">
                                        <textarea rows="3" cols="30" aria-keyshortcuts=""></textarea>
                                        <!--<input type="textarea" style="height: 60px" rows="3">-->
                                    </div>
                                </div>



                            </form>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-primary" @click="doRegister">注册</button>
                        </div>
                    </div>
                </div>
        </div>
    </div>
</template>

<script>
    export default {
        name: "MovRegister",
        methods:{
            doRegister(){
                let data = $('#frm').serialize();
                console.log(data);
                alert("doRegister")
            }
        }
    }
</script>

<style scoped>
    .content{animation:rotateInUpRight 0.5s 0s 1 both}
    @keyframes rotateInUpRight {
        from {
            transform-origin: right bottom;
            transform: rotate3d(0, 0, 1, -90deg);
            opacity: 0;
        }

        to {
            transform-origin: right bottom;
            transform: none;
            opacity: 1;
        }
    }
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