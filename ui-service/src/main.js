import Vue from 'vue'
import App from './App'
import router from './router'
import VueResource from 'vue-resource'
import VeeValidate from 'vee-validate'
import store from './store/store'

import '../node_modules/font-awesome/css/font-awesome.min.css'
import '../node_modules/vue-material/dist/vue-material.css'
import './styles/form.less'
import './styles/iataaa.less'

Vue.config.productionTip = false
Vue.use(VueResource)
var VueMaterial = require('vue-material')
Vue.use(VueMaterial)
Vue.use(VeeValidate)

/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  store,
  template: '<App/>',
  components: { App }
})
