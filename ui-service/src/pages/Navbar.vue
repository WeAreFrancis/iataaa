<template>
  <nav>
    <div class="nav-bar-section">
      <h1>Iataaa</h1>
    </div>
  </nav>
</template>

<script>
  export default {
    name: 'nav-bar'
  }
</script>

<style scoped>
  nav {
    position: fixed;
    top: 0;
    right: 0;
    left: 0;
    z-index: 1030;
    display: flex;
  }

  h1 {
    font-size: 1.8rem;
    margin: 0
  }

  .nav-bar-section {
    margin: auto 10px auto 10px;
  }

  ul {
    padding: 0;
    margin: 0;
  }

  li {
    list-style-type: none;
  }

  a {
    text-decoration: none;
    color: white;
  }
</style>
