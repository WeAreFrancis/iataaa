<template>
  <div class="app">
    <nav-bar id="nav-bar"></nav-bar>
    <div id="content">
      <tool-bar id="toolBar"></tool-bar>
      <router-view class="main-component"></router-view>
    </div>
  </div>
</template>

<script>
  import Navbar from './components/Navbar'
  import ToolBar from './components/ToolBar'
  export default {
    name: 'app',
    components: {
      ToolBar,
      'nav-bar': Navbar
    }
  }
</script>

<style lang="less">
  @import 'styles/iataaa';
  @import 'styles/variables';

  #app {
    height: 100%;
  }

  #content {
    padding-top: @nav-bar-height;
  }

  #nav-bar {
    background-color: @secondary-background-color;
    color: @secondary-color;
    height: @nav-bar-height;
  }

  #toolBar {
    background-color: @third-background-color;
    color: @third-color;
    width: 250px;
  }
</style>
