<template>
  <md-dialog ref="dialogRef">
    <md-dialog-title> {{ title }}</md-dialog-title>

    <md-dialog-content>{{ body }}</md-dialog-content>

    <md-dialog-actions>
      <md-button class="md-primary" @click.native="closeDialog()">Cancel</md-button>
      <md-button class="md-primary" @click.native="submitted">{{ submitLabel }}</md-button>
    </md-dialog-actions>
  </md-dialog>
</template>

<script>
  export default {
    name: 'delete-dialog',
    props: ['title', 'body', 'submitLabel'],
    methods: {
      closeDialog () {
        this.$refs.dialogRef.close()
      },
      openDialog () {
        this.$refs.dialogRef.open()
      },
      submitted () {
        this.$emit('submitted')
      }
    }
  }
</script>

<style scoped>

</style>
