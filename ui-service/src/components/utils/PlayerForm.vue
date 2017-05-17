<template>
  <div class="playerForm">
    <v-card class="grey lighten-4 elevation-0">
      <v-card-text>
        <v-container fluid>
          <player-input :inputInit="player.name" @update:input="val => player.name = val"
                        :type="'text'" :name="'Name'" :label="'Enter name'"
          ></player-input>
          <player-input :inputInit="player.ip" @update:input="val => player.ip = val"
                        :type="'text'" :name="'IP'" :label="'Enter IP'"
          ></player-input>
          <player-input :inputInit="player.port" @update:input="val => player.port = val"
                        :type="'number'" :name="'Port'" :label="'Enter port'"
          ></player-input>
          <player-input :inputInit="player.path" @update:input="val => player.path = val"
                        :type="'text'" :name="'Path'" :label="'Enter path'"
          ></player-input>
          <player-select :inputInit="player.difficulty" @update:input="val => player.difficulty = val"
                         :name="'Difficulty'" :values="['EASY', 'MEDIUM', 'HARD']"
          ></player-select>
        </v-container>
      </v-card-text>
    </v-card>
  </div>
</template>

<script>
  import PlayerInput from './PlayerInput'
  import PlayerSelect from './PlayerSelect'
  export default {
    components: {
      PlayerSelect,
      PlayerInput},
    name: 'player-form',
    props: ['playerInit'],
    data: function () {
      return {
        player: this.playerInit,
        name: ''
      }
    }
  }
</script>

<style scoped>

</style>
