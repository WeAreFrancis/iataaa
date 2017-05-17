<template>
  <div id="players">
    <v-tabs grow>
      <v-tab-item href="#players-item" slot="activators">
        Players
      </v-tab-item>
      <v-tab-item href="#games-item" slot="activators">
        Games
      </v-tab-item>

      <!-- PLAYERS ITEM -->
      <v-tab-content id="players-item" slot="content">
        <v-card>
          <v-card-text>
            <div class="panel">
              <!-- MODAL -->
              <v-dialog v-model="openedModal" width>
                <v-btn small primary dark slot="activator">Add Player</v-btn>
                <v-card>
                  <v-card-row>
                    <v-card-title>Create Player</v-card-title>
                  </v-card-row>
                  <v-card-row>
                    <v-card-text>
                      <player-form :playerInit="player"></player-form>
                    </v-card-text>
                  </v-card-row>
                  <v-card-row actions>
                    <v-btn light default @click.native="openedModal = false">Back</v-btn>
                    <v-btn light primary @click.native="addPlayer">Create Player</v-btn>
                  </v-card-row>
                </v-card>
              </v-dialog>
            </div>
            <v-expansion-panel v-for="player in $store.state.players" :key="player.id">
              <v-expansion-panel-content>
                <div slot="header">{{ player.name }}</div>
                <v-card>
                  <v-card-text>
                    <ul>
                      <li>Name: {{player.name}}</li>
                      <li>IP: {{player.ip}}</li>
                      <li>Port: {{player.port}}</li>
                      <li>Path: {{player.path}}</li>
                      <li>Difficulty: {{player.difficulty}}</li>
                      <li>Token: {{player.token}}</li>
                    </ul>
                    <v-btn error @click.native="deletePlayer(player)">
                      <i class="fa fa-trash" aria-hidden="true"></i>
                      Delete
                    </v-btn>
                  </v-card-text>
                </v-card>
              </v-expansion-panel-content>
            </v-expansion-panel>
          </v-card-text>
        </v-card>
      </v-tab-content>

      <!--GAMES ITEM -->
      <v-tab-content id="games-item" slot="content">
        <v-card>
          <v-card-text>Not implemented</v-card-text>
        </v-card>
      </v-tab-content>
    </v-tabs>
  </div>
</template>

<script>
  import { mapActions } from 'vuex'
  import PlayerForm from './utils/PlayerForm'
  import {Player} from '../entities/player'
  export default {
    components: {PlayerForm},
    name: 'players',
    component: [PlayerForm],

    data () {
      return {
        player: {
          name: '',
          ip: '',
          port: 0,
          path: '',
          difficulty: ''
        },
        openedModal: false
      }
    },
    mounted: function () {
      this.loadPlayers()
    },

    methods: {
      ...mapActions(['createPlayer', 'deletePlayer', 'loadPlayers']),
      addPlayer () {
        this.createPlayer(
            new Player(null, this.player.name, this.player.ip, this.player.port, this.player.path, this.player.difficulty, null)
        )
        this.openedModal = false
      }
    }
  }
</script>

<style scoped>

  #players {
    height: 100%;
    width: 250px;
    position: fixed;
    left: 0;
  }

  .panel {
    text-align: right;
  }

</style>
