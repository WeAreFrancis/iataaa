<template>
  <div class="nav-bar">
    <nav>
      <div id="title-block">
        <span>Iataaa</span>
      </div>
      <ul>
        <li>
          <a href="/checkers" class="disabled">
            Checkers
          </a>
        </li>
      </ul>
    </nav>
  </div>
</template>

<script>

  export default {
    name: 'nav-bar',
  };
</script>

<style scoped>
  nav {
    background-color: #333;
    color: white;
    position: fixed;
    top: 0;
    right: 0;
    left: 0;
    z-index: 1030;
  }

  #title-block {
    display: inline-block;
    padding: 5px;
    margin: 5px;
  }

  ul {
    display: inline-block;
  }

  li {
    list-style-type: none;
  }
  a {
    text-decoration: none;
  }

  .disabled {
    color: rgba(255,255,255,.25);
    cursor: not-allowed;
  }

</style>
