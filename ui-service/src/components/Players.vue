<template>
  <div id="players">
    <div class="ui attached pointing menu">
      <a class="item active" data-tab="players">Players</a>
      <a class="item" data-tab="games">Games</a>
    </div>

    <div class="ui bottom attached tab segment active" data-tab="players">
      <div class="panel">
        <button @click="openModal('#addPlayerModal')"
                class="ui icon primary button"
        >
          <i class="fa fa-plus" aria-hidden="true"></i>
          Add Player
        </button>
      </div>
      <div class="ui styled fluid accordion">
        <div v-for="player in $store.state.players">
          <div class="title">
            <i class="dropdown icon"></i>
            {{ player.name }}
          </div>
          <div class="content">
            <ul class="transition hidden">
              <li>Name: {{player.name}}</li>
              <li>IP: {{player.ip}}</li>
              <li>Port: {{player.port}}</li>
              <li>Path: {{player.path}}</li>
              <li>Difficulty: {{player.difficulty}}</li>
              <li>Token: {{player.token}}</li>
            </ul>
          </div>
        </div>
      </div>
    </div>

    <div class="ui bottom attached tab segment" data-tab="games">
      <i class="fa fa-exclamation-triangle" aria-hidden="true"></i>
      Not implemented
    </div>

    <!-- MODAL -->
    <div id="addPlayerModal" class="ui modal">
      <i class="close icon"></i>
      <div class="header">
        Add Player
      </div>
      <div class="content">
        <div class="description">
          Future form
        </div>
      </div>
      <div class="actions">
        <div class="ui black deny button">
          Back
        </div>
        <div class="ui positive right labeled icon button">
          Create player
          <i class="checkmark icon"></i>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
  import { mapActions } from 'vuex'
  export default {
    name: 'players',

    mounted: function () {
      this.loadPlayers()
      $('.menu .item').tab()
      $('.accordion').accordion({
        selector: {
          trigger: '.title'
        },
        exclusive: false
      })
    },

    methods: {
      ...mapActions(['loadPlayers']),
      openModal (modalName) {
        $(modalName).modal('show')
      }
    }
  }
</script>

<style scoped>

  .accordion {
    margin-top: 10px;
  }

  #players {
    height: 100%;
    width: 200px;
    position: fixed;
    left: 0;
  }

  .panel {
    text-align: right;
  }

  .tab {
    color: black !important;
    height: 100%;
  }

  ul {
    list-style:none;
    margin:0;
    padding:0;
  }

  li {
    padding: 2px;
    margin: 2px;
  }

</style>
