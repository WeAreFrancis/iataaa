<template>
  <div v-if="total != 0" class="pagination">
    <md-button-toggle md-single class="md-primary button-group">
      <md-button v-if="current != 1" class="md-icon-button" @click.native="onClickPage(1)" :key="1">
        1
      </md-button>
      <div v-if="current - 2 > 1" class="suspension-points">
        ...
      </div>
      <md-button v-if="current - 1 > 1" class="md-icon-button" @click.native="onClickPage(current - 1)" :key="current - 1">
        {{ current - 1 }}
      </md-button>

      <md-button class="md-icon-button md-toggle disabled" :key="current">
        {{ current }}
      </md-button>

      <md-button v-if="current + 1 < total" class="md-icon-button" @click.native="onClickPage(current + 1)" :key="current + 1">
        {{ current + 1 }}
      </md-button>
      <div v-if="current + 2 < total" class="suspension-points">
        ...
      </div>
      <md-button v-if="current != total" class="md-icon-button" @click.native="onClickPage(total)" :key="total">
        {{ total }}
      </md-button>
    </md-button-toggle>
  </div>
</template>

<script>
  export default {
    name: 'pagination',
    props: ['currentPage', 'totalPages'],
    computed: {
      current () {
        return this.currentPage + 1
      },
      total () {
        return this.totalPages
      }
    },
    methods: {
      onClickPage (page) {
        this.$emit('onClickPage', page - 1)
      }
    }
  }
</script>

<style scoped>
  .pagination {
    display: flex;
    border-radius: 10px;
  }
  .button-group {
    margin: auto;
  }
  .suspension-points {
    margin: auto;
  }
</style>
