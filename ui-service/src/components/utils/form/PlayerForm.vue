<template>
  <div class="playerForm">
    <form novalidate @submit.stop.prevent="submit">
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
                     :name="'Difficulty'" :values="difficulties"
      ></player-select>
    </form>
  </div>
</template>

<script>
  import PlayerInput from './input/PlayerInput'
  import PlayerSelect from './input/PlayerSelect'
  import {DIFFICULTIES} from '../../../utils/constants'
  export default {
    components: {
      PlayerSelect,
      PlayerInput
    },
    name: 'player-form',
    props: ['playerInit'],
    data: function () {
      return {
        name: '',
        difficulties: DIFFICULTIES
      }
    },
    computed: {
      player () {
        return this.playerInit
      }
    }
  }
</script>

<style scoped>

</style>
