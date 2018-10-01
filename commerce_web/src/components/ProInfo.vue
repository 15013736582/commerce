<template>
    <div id="ProInfo">
        {{proInfo.title}}
        <div id="page-content" class="clearfix">

            <div class="goods-header">
                <div class="goods-header-left"><img src="image/61X0zlgsL9L._SL1001_.jpg" alt="" /></div>
                <div class="goods-header-right">
                    <p>{{proInfo.title}}</p>
                    <p class="red">${{proInfo.price}}</p>
                    <p>sku:{{proInfo.sku}}</p>
                    <p>Brand：GMY</p>
                    <p>Stock in US：{{proInfo.reverse}}</p>

                    <button class="btn btn-primary"><a style="color:#fff" href="bvo-goodsstorechoose.html">Dropship Now</a></button>
                    <button class="btn btn-primary">Add to Wish List</button>
                </div>
            </div>

            <h4 class="lighter">Item Description</h4>
            <div class="tabbable">
                <ul class="nav nav-tabs" id="myTab">
                    <li class="active"><a data-toggle="tab" href="#ebay"> ebay description</a></li>
                    <li class=""><a data-toggle="tab" href="#Amazon">Amazon description</a></li>
                </ul>
                <div class="tab-content">
                    <div id="ebay" class="tab-pane active">
                        Raw denim you probably haven't heard of them jean shorts Austin.
                    </div>
                    <div id="Amazon" class="tab-pane">
                        Food truck fixie locavore, accusamus mcsweeney's marfa nulla single-origin coffee squid.
                    </div>
                </div>
            </div>

        </div>
    </div>
</template>

<script>
    export default {
        name: "ProInfo",
        data(){

        },
        props:[
            'proInfo',
        ]
    }
</script>

<style scoped>
    .goods-header{
        overflow: hidden;
    }
    .goods-header-left{
        width: 30%;
        float: left;
    }
    .goods-header-right{
        width: 70%;
        float: left;
    }
    .goods-header-left img{
        width: 100%;
    }
</style>