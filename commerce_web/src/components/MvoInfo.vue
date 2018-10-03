<template>
    <div id="MvoInfo">
        <div class=" position-relative" >
            <h4 style="color: #2679b5;text-align: center;margin-right: 100px">钱包注册</h4>
            <hr>
            <!--<h1 style="color: #2679b5;"><small><i class="icon-double-angle-right" style="align: center"></i> 钱包账号注册</small></h1>-->
        </div>

        <div id="main-content" class="clearfix">
            <div id="page-content" class="clearfix">

                <div class="Register">

                    <div class="mydiv"><label class="green">账号:</label><input type="text"></div>
                    <div class="mydiv"><label class="green">邮箱:</label><input type="text"></div>
                    <div class="mydiv"><label class="green">密码:</label><input type="password"></div>
                    <button class="btn  btn-success save" onclick="gotoWallet()">注册</button>
                </div>

            </div>
        </div>
    </div>
</template>

<script>
    export default {
        name: "MvoInfo"
    }
</script>

<style scoped>
    #editor{
        height: 200px;
    }
    #main-content{
        margin-left: 190px;
    }
    #page-content {
        margin: 0;
        background: #FFF;
        padding: 8px 20px 24px;
    }
    .modal-footer{
        background: #fff;
    }

    .control-label{
        display: inline-block;
        margin-right: 20px;
        margin-top: 20px;
        width: 160px;
    }
</style>