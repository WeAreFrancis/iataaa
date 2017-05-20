<template>
  <div id="toolBar">
    <md-tabs>
      <players-tab :players="$store.state.players"></players-tab>
      <md-tab id="games-item" md-label="Games" md-disabled>
      </md-tab>
    </md-tabs>
  </div>
</template>

<script>
  import { mapActions } from 'vuex'
  import PlayerForm from './utils/form/PlayerForm'
  import PlayersTab from './PlayersTab'
  export default {
    components: {
      PlayersTab,
      PlayerForm
    },
    name: 'tool-bar',
    mounted: function () {
      this.loadPlayers()
    },
    methods: {
      ...mapActions(['loadPlayers'])
    }
  }
</script>

<style scoped>

  #toolBar {
    height: 100%;
    width: 260px;
    position: fixed;
    left: 0;
  }
</style>
