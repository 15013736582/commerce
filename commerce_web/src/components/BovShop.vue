<template>
    <div id="BovShop">
        <div id="page-content" class="clearfix">
            <div class="goodscontent">
                <p>My stores</p>
                <div class="store">
                    <h3 class="blue">amamzon</h3>
                    <p>store_001</p>
                    <p>store_002</p>
                    <p>store_003</p>
                </div>
                <div class="store">
                    <h3 class="blue">ebay</h3>
                    <p>store_001</p>
                    <p>store_002</p>
                    <p>store_003</p>
                </div>
                <div style="text-align: right"><button class="btn btn-primary addshop">Add a new store</button></div>

            </div>
        </div>
    </div>
</template>

<script>
    export default {
        name: "BovShop"
    }
</script>

<style scoped>
    .goodscontent p {
        font-size: 24px;
        line-height: 40px;
    }

    .store {
        border: 1px solid #ccc;
        border-radius: 10px;
        margin: 20px 0 20px 0;
        padding-left: 3%;
    }

    .store h3 {
        line-height: 40px;
    }

    .store p {
        line-height: 40px;
        color: #666;
        border-top: 1px solid #ccc;
    }
</style>