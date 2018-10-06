<template>
  <div class="home " >
      <Heander></Heander>
      <div class="row container" >
          <div class="col-md-3">
              <LeftNav></LeftNav>
          </div>
          <div class="col-md-9">
              <router-view/>
          </div>
      </div>

  </div>
</template>

<script>

import Heander from '@/components/Header'
import LeftNav from '@/components/LeftNav'
export default {
  name: 'home',
  components: {
      Heander,
      LeftNav,
  }
}
</script>

<style scoped>
    @import "../assets/css/ace.min.css";
    @import "../assets/css/ace-skins.min.css";
    @import "../assets/css/ace-responsive.min.css";
    @import "../assets/css/font-awesome.min.css";
    @import "../assets/css/bootstrap-responsive.min.css";
</style>