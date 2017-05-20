<template>
  <md-input-container>
    <label>{{ name }}</label>
    <md-input :value="inputComputed" v-model="input" :type="type" :name="name" :label="label"></md-input>
  </md-input-container>
</template>

<script>
  export default {
    name: 'player-input',
    props: ['inputInit', 'name', 'label', 'type'],
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
      input (newValue) {
        this.$emit('update:input', newValue)
      }
    }
  }
</script>

<style scoped>

</style>
