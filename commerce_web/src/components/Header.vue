<template>
    <div id="Header">
        <div class="navbar navbar-inverse">
            <div class="navbar-inner" style="background:#0099CC;">
                <div class="container-fluid">
                    <a class="brand">
                        <small><i class="icon-leaf"></i> gmcbrand</small>
                    </a>

                    <ul class="nav ace-nav pull-right">

                        <li class="light-blue user-profile">
                            <a class="user-menu dropdown-toggle" href="javascript:;" data-toggle="dropdown">
                                <img alt="LRJ" src="@/assets/image/avatar.jpg" class="nav-user-photo">
                                <span id="user_info"><small>Welcome</small> gmcbrand</span>
                                <i class="icon-caret-down"></i>
                            </a>
                            <ul id="user_menu" class="pull-right dropdown-menu dropdown-yellow dropdown-caret dropdown-closer">


                                <li><a href="logout"><i class="icon-off"></i> 退出</a></li>
                            </ul>
                        </li>
                    </ul>
                </div>
            </div>
        </div>
    </div>
</template>

<script>
    export default {
        name: "Header"
    }
</script>

<style scoped>

</style>