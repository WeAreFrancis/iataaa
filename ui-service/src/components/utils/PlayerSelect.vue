<template>
  <v-row row>
    <v-col xs4>
      <v-subheader>{{ name }}</v-subheader>
    </v-col>
    <v-col xs8>
      <v-select
        v-bind:items="values"
        v-model="input"
        label="Select"
        light
        single-line
        auto
      />
    </v-col>
  </v-row>
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
    watch: {
      input: function () {
        this.$emit('update:input', this.input)
      }
    }
  }
</script>

<style scoped>

</style>
