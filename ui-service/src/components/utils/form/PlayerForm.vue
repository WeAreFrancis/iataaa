<template>
  <div class="playerForm">
    <form @submit.prevent="validateBeforeSubmit">

      <div class="form-group">
        <label for="name" class="required">Name</label>
        <div class="input-control">
          <input name="name" type="text"
                 v-model="player.name"
                 v-validate="'required'"
                 :class="{'input': true, 'is-danger': errors.has('name') }"
          >
          <span v-show="errors.has('name')" class="danger">{{ errors.first('name') }}</span>
        </div>
      </div>

      <div class="form-group">
        <label class="required" for="ip">IP</label>
        <div class="input-control">
          <input name="ip" type="text"
                 v-model="player.ip"
                 v-validate="'required|ip'"
                 :class="{'input': true, 'is-danger': errors.has('ip') }"
          >
          <span v-show="errors.has('ip')" class="danger">{{ errors.first('ip') }}</span>
        </div>
      </div>

      <div class="form-group">
        <label class="required" for="port">Port</label>
        <div class="input-control">
          <input name="port" type="number"
                 v-model="player.port"
                 v-validate="'required'"
                 :class="{'input': true, 'is-danger': errors.has('port') }"
          >
          <span v-show="errors.has('port')" class="danger">{{ errors.first('port') }}</span>
        </div>
      </div>

      <div class="form-group">
        <label for="path">Path</label>
        <div class="input-control">
          <input name="path" type="text"
                 v-model="player.path"
                 class="input"
          >
        </div>
      </div>

      <div class="form-group">
        <label class="required" for="difficulty">Difficulty</label>
        <div class="input-control">
          <select name="difficulty"
                  v-model="player.difficulty"
                  v-validate="'required'"
                  :class="{'input': true, 'is-danger': errors.has('difficulty') }"
          >
            <option v-for="difficulty in difficulties" :value="difficulty.id">{{difficulty.name}}</option>
          </select>
          <span v-show="errors.has('difficulty')" class="danger">{{ errors.first('difficulty') }}</span>
        </div>
      </div>

      <div class="actions">
        <md-button class="md-primary" @click.native="cancel">Cancel</md-button>
        <md-button class="md-primary" type="submit" :disabled="disabled"> {{ submitLabel }}</md-button>
      </div>
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
    props: ['initialPlayer', 'submitLabel'],
    data: function () {
      return {
        name: null,
        difficulties: DIFFICULTIES
      }
    },
    computed: {
      disabled () {
        return this.errors.count() !== 0
      },
      player () {
        return this.initialPlayer
      }
    },
    methods: {
      cancel () {
        this.$emit('cancel')
      },
      validateBeforeSubmit () {
        this.$validator.validateAll().then(() => {
          this.$emit('submit', this.player)
        }).catch(() => {})
      }
    }
  }
</script>

<style scoped>
  .input-control {
    min-height: 52px;
  }
</style>
