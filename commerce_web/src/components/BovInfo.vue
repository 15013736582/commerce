<template>
    <div id="BovInfo">

            <div id="page-content" class="clearfix">
                <div class="page-header position-relative">
                    <h1 style="color: #2679b5;">借卖方
                        <small><i class="icon-double-angle-right"></i> 我的信息</small>
                    </h1>
                </div>
                <div class="inputName">
                    <div class="mydiv"><label class="green">Name: </label><input type="text" value="" placeholder="Lucy"></div>
                    <div class="mydiv"><label class="green">Email:</label><input type="text" value="" placeholder="845153@qq.com">
                    </div>
                    <div class="mydiv"><label class="green">Phone:</label><input type="text" value="" placeholder="1376533621"></div>
                    <button class="btn  btn-success save">save</button>
                    <button class="btn  btn-pink" onclick="myshop()">My Stores</button>
                </div>
            </div>
    </div>
</template>

<script>
    export default {
        name: "BovInfo"
    }
</script>

<style scoped>
    .mydiv{
        margin-bottom: 20px;

    }
    .btn {

        margin-left: 18px;
   margin-right:8px;
    }

    .btn-success {
        background-color: #87b87f !important;
        border-color: #87b87f
    }

    .btn-success:hover, .btn-success.active {
        background-color: #629b58 !important
    }

    .btn-success.active {
        background-color: #68a563 !important;
        border-color: #629b58
    }

    .btn-pink {
        background-color: #d6487e !important;
        border-color: #d6487e
    }

    .btn-pink:hover {
        background-color: #b73766 !important
    }

    .
    btn-pink.active {
        background-color: #c0406f !important;
        border-color: #b73766
    }

    .inputName {
        width: 50%;
        margin: 0 auto;
        font-size: 20px;
    }

    .green {
        color: #69aa46 !important;
        width: 68px;
        font-weight: normal;
        display: block;
    }
</style>