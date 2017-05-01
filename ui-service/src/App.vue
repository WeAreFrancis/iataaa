<template>
  <div id="app">
    <nav-bar></nav-bar>
    <router-view></router-view>
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
</style>
