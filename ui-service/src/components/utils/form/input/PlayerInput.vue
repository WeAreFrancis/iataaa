<template>
  <div class="form-group">
    <label class="form-label" :for="name">{{ name }}</label>
    <p class="control has-icon has-icon-right">
      <input
        :name="name"
        :value="inputComputed"
        v-model="input"
        v-validate.initial="validations"
        :class="{'input': true, 'is-danger': errors.has('input') }"
        type="text">
      <i v-show="errors.has('input')" class="fa fa-warning"></i>
      <span v-show="errors.has('input')" class="help is-danger">{{ errors.first('input') }}</span>
    </p>
  </div>
</template>

<script>
  export default {
    name: 'player-input',
    props: ['inputInit', 'name', 'label', 'type', 'placeholder', 'validations'],
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
