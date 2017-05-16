<template>
  <div id="game">
    <players id="players"></players>
  </div>
</template>

<script>
  import Players from './Players'
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

  #players {
    background-color: @third-background-color;
    color: @third-color;
  }

</style>
