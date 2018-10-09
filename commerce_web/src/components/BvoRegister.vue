<template>
    <div id="MvoRegister" class="content" style="margin-top: 0px;padding: 0px">
        <div id="main-content" class="clearfix" >
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-body" style="max-height:none" >
                        <form id="frm" class="form-horizontal">
                            <div class="control-group">
                                <label class="control-label">username<br>用户名</label>
                                <div class="controls control-label">
                                    <input type="text" name="username"  >
                                </div>
                            </div>
                            <div class="control-group">
                                <label class="control-label">password<br>密码</label>
                                <div class="controls control-label">
                                    <input type="text" name="password" >
                                </div>
                            </div>
                            <div class="control-group">
                                <label class="control-label" >Email<br>邮箱</label>
                                <div class="controls control-label">
                                    <input type="text" name="email" v-model="email">
                                </div>
                            </div>
                            <div class="control-group">
                                <label class="control-label control-label">Phone<br>电话</label>
                                <div class="controls control-label">
                                    <input type="text" name="phone" v-model="phone">
                                </div>
                            </div>
                        </form>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-primary" id="btnsave" @click="doRegister">注册</button>
                    </div>
                    <p v-text="hint"></p>
                </div>
            </div>
        </div>
    </div>
</template>

<script>
    export default {
        name: "MvoRegister",
        data(){
            return{
                hint:"",
                email:""
            }
        },
        methods:{

            doRegister(){
                var reg=11 && /^((13|14|15|17|18)[0-9]{1}\d{8})$/;
                if(this.phone==''){
                    alert("请输入手机号码");
                    return;
                }else if(!reg.test(this.phone)){
                    alert("手机格式不正确");
                    return;
                }

                var regEmail=/^\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/;
                if(this.email==''){
                    alert("请输入邮箱");
                    return;
                }else if(!regEmail.test(this.email)){
                    alert("邮箱格式不正确");
                    return;
                }

                let _this = this;
                let data = $('#frm').serialize();
                this.$axios.post("/api/bvo/register",data)
                    .then(res=>{

                        let data = res.data;
                        console.log(data)
                        if(data.state == 0){
                            _this.hint = "注册成功,3秒后返回登录界面"
                            let intervalId = setInterval(()=>{
                                _this.$router.replace({name:"login"});
                                clearInterval(intervalId)
                            },3000)
                        }
                    })
            }
        }

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