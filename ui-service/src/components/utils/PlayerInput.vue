<template>
  <v-row row>
    <v-col xs4>
      <v-subheader>{{ name }}</v-subheader>
    </v-col>
    <v-col xs8>
      <v-text-field
        v-model="input" :type="type" :name="name" :label="label"
      ></v-text-field>
    </v-col>
  </v-row>
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
    watch: {
      input: function () {
        this.$emit('update:input', this.input)
      }
    }
  }
</script>

<style scoped>

</style>
