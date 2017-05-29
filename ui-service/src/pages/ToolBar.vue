<template>
  <div id="toolBar">
    <md-tabs>
      <players-tab
        ref="playersTab"
        :players="$store.state.players"
        @addPlayer="addPlayer($event)"
        @editPlayer="editPlayer($event)"
        @removePlayer = removePlayer($event)
      ></players-tab>
      <md-tab id="games-item" md-label="Games" md-disabled>
      </md-tab>
    </md-tabs>
  </div>
</template>

<script>
  import PlayerForm from '../components/utils/form/PlayerForm'
  import PlayersTab from '../components/PlayersTab'
  import {mapActions} from 'vuex'
  import {PlayerToWrite} from '../entities/playerToWrite'
  export default {
    components: {
      PlayersTab,
      PlayerForm
    },
    name: 'tool-bar',
    mounted: function () {
      this.loadPlayers(0)
    },
    methods: {
      ...mapActions(['createPlayer', 'deletePlayer', 'loadPlayers', 'updatePlayer']),
      addPlayer (player) {
        let playerToWrite = new PlayerToWrite(player.name, player.ip, player.port, player.path, player.difficulty)
        this.createPlayer(playerToWrite)
        this.$refs.playersTab.closeDialog(this.$refs.playersTab.newPlayerDialog)
      },
      editPlayer (player) {
        let playerToWrite = new PlayerToWrite(player.name, player.ip, player.port, player.path, player.difficulty)
        let parameters = []
        parameters.push(player.id)
        parameters.push(playerToWrite)
        this.updatePlayer(parameters)
        this.$refs.playersTab.closeDialog(this.$refs.playersTab.editPlayerDialog)
      },
      removePlayer (player) {
        this.deletePlayer(player)
        this.$refs.playersTab.closeDialog(this.$refs.playersTab.deletePlayerDialog)
      }
    }
  }
</script>

<style scoped>

  #toolBar {
    height: 100%;
  }
</style>
