<template>
  <div id="game">
    <players id="toolBar"></players>
  </div>
</template>

<script>
  import Players from './ToolBar'
  export default {
    components: {Players},
    name: 'game'
  }
</script>

<style lang="less" scoped>
  @import '../styles/variables';

  #game {
    height: 100%;
  }

  #toolBar {
    background-color: @third-background-color;
    color: @third-color;
    width: 250px;
  }

</style>
