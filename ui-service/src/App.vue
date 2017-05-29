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
  import Navbar from './pages/Navbar'
  import ToolBar from './pages/ToolBar'
  export default {
    name: 'app',
    components: {
      ToolBar,
      'nav-bar': Navbar
    }
  }
</script>

<style lang="less">
  @import 'styles/variables';

  .app {
    height: 100%;
  }

  #content {
    padding-top: @nav-bar-height;
    display: flex;
    height: 100%;
  }

  .main-component {
    height: 100%;
    width: 100%;
  }

  #nav-bar {
    background-color: @secondary-background-color;
    color: @secondary-color;
    height: @nav-bar-height;
  }

  #toolBar {
    background-color: @third-background-color;
    color: @third-color;
    min-width: @tool-bar-width;
    width: @tool-bar-width;
    max-width: @tool-bar-width;
  }
</style>
