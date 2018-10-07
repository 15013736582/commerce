<template>
    <div id="MvoProImg">
        <div id="page-content" class="clearfix">

            <div class="page-header position-relative" data-toggle="modal" data-target="#myModal">
                <h1 style="color: #2679b5;">品牌商 <small><i class="icon-double-angle-right"></i> 商品分类&主图</small></h1>
            </div>
            <form class="form-search">
                商品标题：
                <input type="text" class="input-medium search-query">
                <button onclick="return false;" class="btn btn-purple btn-small">Search <i class="icon-search icon-on-right"></i></button>
            </form>

            <table id="table_bug_report" class="table table-striped table-bordered table-hover">
                <thead>
                <tr>
                    <th class="center">
                        <label><input type="checkbox" class="ace-checkbox-2"><span class="lbl"></span></label>
                    </th>
                    <th>商品标题</th>
                    <th>分类</th>
                    <th class="hidden-480">主图</th>
                    <th class="hidden-480">状态</th>
                    <th>操作</th>
                </tr>
                </thead>

                <tbody>

                <tr>
                    <td class="center">
                        <label><input type="checkbox" class="input"><span class="lbl"></span></label>
                    </td>
                    <td>MP3</td>
                    <td>电子产品</td>
                    <td class="hidden-480"><img src="image/goods.png" alt="" class="imgList"></td>
                    <td class="hidden-480"><span class="label label-sm label-warning">待入仓</span></td>
                    <td>
                        <div class="inline position-relative" >
                            <button class="btn btn-mini btn-info" data-toggle="modal" data-target="#myModal"><i class="icon-edit"></i></button>
                            <button class="btn btn-mini btn-danger"><i class="icon-trash"></i></button>
                            <button class="btn btn-mini btn-success">
                                入仓
                            </button>
                        </div>
                    </td>
                </tr>


                <tr>
                    <td class="center">
                        <label><input type="checkbox" class="input"><span class="lbl"></span></label>
                    </td>
                    <td>电饭锅</td>
                    <td>电器</td>
                    <td><img src="image/goods.png" alt="" class="imgList"></td>
                    <td><span class="label label-success">入仓中</span></td>
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
                    <td>电冰箱</td>
                    <td>电器</td>
                    <td><img src="image/goods.png" alt="" class="imgList"></td>
                    <td><span class="label label-inverse arrowed-in">待上架</span></td>
                    <td>
                        <div class="inline position-relative" >
                            <button class="btn btn-mini btn-info" data-toggle="modal" data-target="#myModal"><i class="icon-edit"></i></button>
                            <button class="btn btn-mini btn-danger"><i class="icon-trash"></i></button>
                            <button class="btn btn-mini btn-success">
                                上架
                            </button>
                        </div>
                    </td>
                </tr>


                <tr>
                    <td class="center">
                        <label><input type="checkbox" class="input"><span class="lbl"></span></label>
                    </td>
                    <td>耳机</td>
                    <td>电子产品</td>
                    <td><img src="image/goods.png" alt="" class="imgList"></td>
                    <td><span class="label label-sm label-info arrowed arrowed-righ">上架中</span></td>
                    <td>
                        <div class="inline position-relative" >
                            <button class="btn btn-mini btn-info" data-toggle="modal" data-target="#myModal"><i class="icon-edit"></i></button>
                            <button class="btn btn-mini btn-danger"><i class="icon-trash"></i></button>
                            <button class="btn btn-mini btn-success">
                                下架
                            </button>
                        </div>
                    </td>
                </tr>


                <tr>
                    <td class="center">
                        <label><input type="checkbox" class="input"><span class="lbl"></span></label>
                    </td>
                    <td>电饭煲</td>
                    <td>电器</td>
                    <td class="hidden-480"><img src="image/goods.png" alt="" class="imgList"></td>
                    <td><span class="label label-sm label-info arrowed arrowed-righ">上架中</span></td>

                    <td>
                        <div class="inline position-relative" >
                            <button class="btn btn-mini btn-info" data-toggle="modal" data-target="#myModal"><i class="icon-edit"></i></button>
                            <button class="btn btn-mini btn-danger"><i class="icon-trash"></i></button>
                            <button class="btn btn-mini btn-success">
                                下架
                            </button>
                        </div>
                    </td>
                </tr>

                </tbody>
            </table>
            <button class="btn btn-primary" data-toggle="modal" data-target="#myModal">新增</button>

            <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
                <div class="modal-dialog" role="document">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                            <h4 class="modal-title" id="myModalLabel">商品信息</h4>
                        </div>
                        <div class="modal-body" >
                            <form class="form-horizontal">

                                <div class="control-group">
                                    <p class="red">商品标题准确、简洁、完整</p>
                                    <label class="control-label" for="form-field-1">商品标题</label>
                                    <div class="controls">
                                        <select id="form-field-select-1">

                                            <option value=""></option>
                                            <option value="AL">Alabama</option>
                                            <option value="AK">Alaska</option>
                                        </select>
                                    </div>
                                </div>
                                <div class="control-group">
                                    <p class="red">请先选择GMC借卖平台商品大类，此分类决定了您的商品在借卖平台中展示的位置</p>
                                    <label class="control-label" for="form-field-1">商品分类</label>
                                    <div class="controls">
                                        <select id="form-field-select-2" multiple="multiple">

                                            <option value="AL">Alabama</option>
                                            <option value="AK">Alaska</option>
                                            <option value="AZ">Arizona</option>
                                        </select>
                                        <select id="form-field-select-2" multiple="multiple">

                                            <option value="AL">Alabama</option>
                                            <option value="AK">Alaska</option>
                                            <option value="AZ">Arizona</option>
                                        </select>
                                    </div>
                                </div>


                                <div class="control-group">
                                    <p class="red">
                                        图片要求：

                                        最多可以上传12张图：eBay 12张、Amazon 9张；
                                        分辨率1000像素（高度）X 1000像素（宽度）以上；
                                        正方形，为无水印白底图或情景图，商品占图片80%；
                                        可以是多角度拍摄商品图片，也可以是细节图。
                                    </p>
                                    <label class="control-label" for="form-field-1">商品主图</label>

                                    <div class="controls">
                  <span style="font-size:14px;"><div id="uploader-demo">
                  <!--用来存放item-->
                  <div id="thelist" class="uploader-list"></div>
                  <div>
                   <div id="filePicker">选择图片</div>
                   <button id="ctlBtn" class="btn btn-default">开始上传</button>
                  </div>
                     <small class="blue">商品主图第1张图片，将出现在商
                        品列表页、商品详情页第一张图等</small>
                  </div>
                  </span>
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
        name: "MvoProImg"
    }
</script>

<style scoped>
    .file-item .info {
        position: absolute;
        left: 4px;
        bottom: 4px;
        right: 4px;
        height: 20px;
        line-height: 20px;
        text-indent: 5px;
        background: rgba(0, 0, 0, 0.6);
        color: white;
        overflow: hidden;
        white-space: nowrap;
        text-overflow: ellipsis;
        font-size: 12px;
        z-index: 10;
    }
    .imgList{
        width: 30px;
        height: 30px;
    }
    .red{
        width: 73%;
        margin: auto;
    }
</style>