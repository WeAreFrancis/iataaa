<template>
  <div id="app">
    <nav-bar id="nav-bar"></nav-bar>
    <router-view class="main-component"></router-view>
  </div>
</template>

<script>
  import Navbar from './components/Navbar'
  export default {
    name: 'app',
    components: {
      'nav-bar': Navbar
    },
    methods: {
      openModal () {
        $('.ui.modal').modal('show')
      }
    }
  }
</script>

<style lang="less">
  @import 'styles/iataaa';
  @import 'styles/variables';

  #app {
    height: 100%;
  }

  #nav-bar {
    background-color: @secondary-background-color;
    color: @secondary-color;
    height: @nav-bar-height;
  }

  .main-component {
    padding-top: @nav-bar-height;
  }
</style>
