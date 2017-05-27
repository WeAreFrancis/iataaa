<template>
  <div id="playersTab">
    <md-tab id="players-item" md-label="Players">
      <div class="panel">
        <div>
          Total: {{ playersNb }} players
        </div>
        <md-button class="md-icon-button md-raised md-primary" @click.native="onClickAddPlayer">
          <md-icon>add</md-icon>
        </md-button>
      </div>
      <div class="players-list">
        <md-list>
          <md-list-item v-for="player in players.content" :key="player.id" md-expand-multiple>
            <md-icon><i class="fa fa-address-card" aria-hidden="true"></i></md-icon>
            <span> {{ player.name }}</span>

            <md-list-expand>
              <ul>
                <li>Name: {{player.name}}</li>
                <li>IP: {{player.ip}}</li>
                <li>Port: {{player.port}}</li>
                <li>Path: {{player.path}}</li>
                <li>Difficulty: {{player.difficulty}}</li>
                <li>Token: {{player.token}}</li>
              </ul>
              <div class="panel">
                <md-button class="md-raised md-warn" @click.native="onClickDeletePlayer(player)">
                  <i class="fa fa-trash" aria-hidden="true"></i>
                  Delete
                </md-button>
                <md-button class="md-raised md-primary" @click.native="onClickEditPlayer(player)">
                  <i class="fa fa-pencil-square-o" aria-hidden="true"></i>
                  Edit
                </md-button>
              </div>
            </md-list-expand>
          </md-list-item>
        </md-list>
      </div>
      <pagination :currentPage="currentPage"
                  :totalPages="totalPages"
                  @onClickPage="onClickPage($event)"
      >
      </pagination>
    </md-tab>

    <!-- DIALOG -->
    <md-dialog md-open-from="#custom" md-close-to="#custom" class="dialog" :ref="playerDialog.name">

      <md-dialog-title>{{ playerDialog.title }}</md-dialog-title>
      <md-dialog-content>
        <player-form :playerInit="selectedPlayer"></player-form>
      </md-dialog-content>
      <md-dialog-actions>
        <md-button class="md-primary" @click.native="closeDialog(playerDialog.name)">Cancel</md-button>
        <md-button class="md-primary" @click.native="onClickConfirmPlayerModal">{{ playerDialog.confirm }}</md-button>
      </md-dialog-actions>
    </md-dialog>

    <md-dialog md-open-from="#custom" md-close-to="#custom" ref="confirmDialog">
      <md-dialog-title> {{ confirm.title }}</md-dialog-title>

      <md-dialog-content>{{ confirm.body }}</md-dialog-content>

      <md-dialog-actions>
        <md-button class="md-primary" @click.native="closeDialog('confirmDialog')">Cancel</md-button>
        <md-button class="md-primary" @click.native="removePlayer(selectedPlayer)">Delete {{ selectedPlayer.name }}</md-button>
      </md-dialog-actions>
    </md-dialog>
  </div>
</template>

<script>
  import { mapActions } from 'vuex'
  import PlayerForm from './utils/form/PlayerForm'
  import {DIALOG_TYPE} from '../utils/constants'
  import {PlayerToWrite} from '../entities/playerToWrite'
  import Pagination from './Pagination'
  export default {
    components: {
      Pagination,
      PlayerForm
    },
    name: 'players-tab',
    props: ['players'],
    data () {
      return {
        selectedPlayer: {
          name: '',
          ip: '',
          port: 0,
          path: null,
          difficulty: ''
        },
        playerDialog: {
          name: 'playerDialog',
          title: 'Create player',
          confirm: 'Create player',
          type: DIALOG_TYPE.CREATION
        }
      }
    },
    mounted: function () {
      this.loadPlayers(0)
    },
    computed: {
      confirm () {
        return {
          title: 'Delete player',
          body: 'You delete ' + this.selectedPlayer.name,
          ok: 'Delete ' + this.selectedPlayer.name,
          cancel: 'Cancel'
        }
      },
      currentPage () {
        return this.players.number
      },
      playersNb () {
        return this.players.totalElements
      },
      totalPages () {
        return this.players.totalPages
      }
    },
    methods: {
      ...mapActions(['createPlayer', 'deletePlayer', 'loadPlayers', 'updatePlayer']),
      closeDialog (ref) {
        this.$refs[ref].close()
      },
      initializeSelectedPlayer () {
        this.selectedPlayer = {
          name: '',
          ip: '',
          port: 0,
          path: null,
          difficulty: ''
        }
      },
      onClickAddPlayer () {
        this.playerDialog.title = 'Create player'
        this.playerDialog.confirm = 'Create player'
        this.playerDialog.type = DIALOG_TYPE.CREATION
        this.initializeSelectedPlayer()
        this.openDialog(this.playerDialog.name)
      },
      onClickConfirmPlayerModal () {
        if (this.playerDialog.type === DIALOG_TYPE.CREATION) {
          this.createPlayer(
            new PlayerToWrite(
              this.selectedPlayer.name,
              this.selectedPlayer.ip,
              this.selectedPlayer.port,
              this.selectedPlayer.path,
              this.selectedPlayer.difficulty)
          )
        } else if (this.playerDialog.type === DIALOG_TYPE.EDITION) {
          let parameters = []
          parameters.push(this.selectedPlayer.id)
          parameters.push(new PlayerToWrite(
            this.selectedPlayer.name,
            this.selectedPlayer.ip,
            this.selectedPlayer.port,
            this.selectedPlayer.path,
            this.selectedPlayer.difficulty))
          this.updatePlayer(parameters)
        }
        this.closeDialog(this.playerDialog.name)
      },
      onClickDeletePlayer (player) {
        this.selectedPlayer = player
        this.openDialog('confirmDialog')
      },
      onClickEditPlayer (player) {
        this.playerDialog.title = 'Edit player'
        this.playerDialog.confirm = 'Edit ' + player.name
        this.playerDialog.type = DIALOG_TYPE.EDITION
        this.selectedPlayer = player
        this.openDialog(this.playerDialog.name)
      },
      onClickPage (pageNb) {
        this.loadPlayers(pageNb)
      },
      openDialog (ref) {
        this.$refs[ref].open()
      },
      removePlayer (player) {
        this.deletePlayer(player)
        this.closeDialog('confirmDialog')
      }
    }
  }
</script>

<style scoped>
  .panel {
    display: flex;
    margin: 5px 0 5px 0;
    padding: 5px 0 5px 0;
  }

  .panel > * {
    margin: auto;
  }

  .players-list {
    overflow-y: scroll;
    height: 500px;
  }
</style>
