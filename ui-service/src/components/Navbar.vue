<template>
  <nav>
    <div class="nav-bar-section">
      <h1>Iataaa</h1>
    </div>
    <div class="nav-bar-section">
      <ul>
        <li>
          <a href="#" class="disabled">
            Checkers
          </a>
        </li>
      </ul>
    </div>
  </nav>
</template>

<script>

  export default {
    name: 'nav-bar'
  }
</script>

<style lang="less" scoped>
  nav {
    background-color: #333;
    color: white;
    position: fixed;
    top: 0;
    right: 0;
    left: 0;
    z-index: 1030;
  }

  h1 {
    font-size: 1.8rem;
  }

  .nav-bar-section {
    display: inline-block;
    padding: 5px;
    margin: 5px;
  }

  ul {
    display: inline-block;
    padding: 0;
  }

  li {
    list-style-type: none;
  }

  a {
    text-decoration: none;
    color: white;
  }
  .disabled {
    color: rgba(255,255,255,.25);
    cursor: not-allowed;
  }


</style>
