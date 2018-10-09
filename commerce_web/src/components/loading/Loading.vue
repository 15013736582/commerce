<template>
    <div id="Loading">
        <!--balls, bars, beat, bubbles, cylon, spin, spiningDubbles, barsCylon-->
        <vue-loading type="spiningDubbles" color="#18bc9c" :size="{ width: '150px', height: '150px' }"></vue-loading>
    </div>
</template>
<script>
    import { VueLoading } from 'vue-loading-template'
    export default {
        name: 'Loading',
        components: {
            VueLoading
        }
    }
</script>

<style>

</style>