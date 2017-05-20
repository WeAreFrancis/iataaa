import Vue from 'vue'
import App from './App'
import router from './router'
import VueResource from 'vue-resource'
import store from './store/store'
import '../node_modules/font-awesome/css/font-awesome.min.css'
import '../node_modules/vue-material/dist/vue-material.css'

Vue.config.productionTip = false
Vue.use(VueResource)
var VueMaterial = require('vue-material')
Vue.use(VueMaterial)

/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  store,
  template: '<App/>',
  components: { App }
})
