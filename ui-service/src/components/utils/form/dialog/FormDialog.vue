<template>
  <md-dialog ref="formDialog">
    <md-dialog-title>{{ title }}</md-dialog-title>
    <md-dialog-content>
      <slot></slot>
    </md-dialog-content>
  </md-dialog>
</template>

<script>
  export default {
    name: 'form-dialog',
    props: ['title'],
    methods: {
      closeDialog () {
        this.$refs.formDialog.close()
      },
      openDialog () {
        this.$refs.formDialog.open()
      }
    }
  }
</script>

<style scoped>

</style>
