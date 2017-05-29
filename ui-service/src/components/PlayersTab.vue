<template>
  <div id="playersTab">
    <md-tab id="players-item" md-label="Players">
      <div class="iataaa-panel">
        <div>
          Total: {{ playersNb }} players
        </div>
        <md-button class="md-icon-button md-raised md-primary" @click.native="onClickAddPlayer">
          <i class="fa fa-user-plus" aria-hidden="true"></i>
        </md-button>
      </div>
      <players-catalog :players="players"
                       @onClickDeletePlayer="onClickDeletePlayer($event)"
                       @onClickEditPlayer="onClickEditPlayer($event)"
                       @onClickPage="onClickPage($event)"
      ></players-catalog>
    </md-tab>

    <!-- DIALOG -->
    <form-dialog :ref="newPlayerDialog" :title="'New Player'">
      <player-form :initialPlayer="selectedPlayer"
                   :submitLabel="'Add player'"
                   @cancel="closeDialog(newPlayerDialog)"
                   @submit="addPlayer($event)"
      ></player-form>
    </form-dialog>

    <form-dialog :ref="editPlayerDialog" :title="'Edit Player'">
      <player-form :initialPlayer="selectedPlayer"
                   :submitLabel="'Edit ' + selectedPlayer.name"
                   @cancel="closeDialog(editPlayerDialog)"
                   @submit="editPlayer($event)"
      ></player-form>
    </form-dialog>

    <delete-dialog :ref="deletePlayerDialog"
                   :title="'Delete player'"
                   :body="'You delete ' + selectedPlayer.name"
                   :submitLabel="'Delete ' + selectedPlayer.name"
                   @submitted="removePlayer"
    ></delete-dialog>
  </div>
</template>

<script>
  import { mapActions } from 'vuex'
  import PlayerForm from './utils/form/PlayerForm'
  import Pagination from './Pagination'
  import PlayersCatalog from './PlayersCatalog'
  import DeleteDialog from './utils/form/dialog/DeleteDialog'
  import FormDialog from './utils/form/dialog/FormDialog'
  export default {
    components: {
      FormDialog,
      DeleteDialog,
      PlayersCatalog,
      Pagination,
      PlayerForm
    },
    name: 'players-tab',
    props: ['players'],
    data () {
      return {
        deletePlayerDialog: 'deletePlayerDialog',
        editPlayerDialog: 'editPlayerDialog',
        newPlayerDialog: 'newPlayerDialog',
        selectedPlayer: {}
      }
    },
    computed: {
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
        this.$refs[ref].closeDialog()
      },
      onClickAddPlayer () {
        this.selectedPlayer = {}
        this.$refs.newPlayerDialog.openDialog()
      },
      addPlayer (player) {
        this.$emit('addPlayer', player)
      },
      editPlayer (player) {
        this.$emit('editPlayer', player)
      },
      onClickDeletePlayer (player) {
        this.selectedPlayer = player
        this.$refs.deletePlayerDialog.openDialog()
      },
      onClickEditPlayer (player) {
        this.selectedPlayer = player
        this.$refs.editPlayerDialog.openDialog()
      },
      onClickPage (pageNb) {
        this.loadPlayers(pageNb)
      },
      openDialog (ref) {
        this.$refs[ref].open()
      },
      removePlayer () {
        this.$emit('removePlayer', this.selectedPlayer)
      }
    }
  }
</script>

<style scoped>

</style>
