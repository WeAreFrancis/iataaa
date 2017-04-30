<template>
  <div id="app">
    <nav-bar></nav-bar>
    <router-view></router-view>
  </div>
</template>

<script>
  import Navbar from './components/Navbar';

export default {
    name: 'app',
    components: {
      'nav-bar': Navbar,
    },
};
</script>

<style>
body {
  padding-top: 3rem;
}
</style>
