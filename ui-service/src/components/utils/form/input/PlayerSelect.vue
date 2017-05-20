<template>
  <md-input-container>
    <label :for="name">{{ name }}</label>
    <md-select :value="inputComputed" :name="name" :id="name" v-model="input">
      <md-option v-for="value in values" :value="value.id" :key="value.key">{{ value.name }}</md-option>
    </md-select>
  </md-input-container>
</template>

<script>
  export default {
    name: 'player-select',
    props: ['inputInit', 'name', 'values'],
    data: function () {
      return {
        input: this.inputInit
      }
    },
    computed: {
      inputComputed () {
        this.input = this.inputInit
      }
    },
    watch: {
      input: function () {
        this.$emit('update:input', this.input)
      }
    }
  }
</script>

<style scoped>

</style>
