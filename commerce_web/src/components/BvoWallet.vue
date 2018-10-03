<template>
    <div id="BvoWallet">
        <div id="page-content" class="clearfix">
            <div class="page-header position-relative">
                <h1 style="color: #2679b5;">借卖方<small><i class="icon-double-angle-right"></i> 钱包账号注册</small></h1>
            </div>
            <div class="Register">
                <div><label class="green">Email:</label><input type="text"></div>
                <div><label class="green">Account Name:</label><input type="text"></div>
                <div><label class="green">Password:</label><input type="password"></div>
                <button class="btn  btn-success save" onclick="gotoWallet()">Sign Up</button>
            </div>

        </div>
    </div>
</template>

<script>
    export default {
        name: "BvoWallet"
    }
</script>

<style scoped>
    .Register{
        width: 50%;
        margin:auto;
    }
    .mydiv{
        margin-bottom: 20px;

    }
    .green {
        color: #69aa46 !important;

        font-weight: normal;
        display: block;
    }
</style>