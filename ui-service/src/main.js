import Vue from 'vue'
import App from './App'
import router from './router'
import VueResource from 'vue-resource'
import store from './store/store'
import '../node_modules/font-awesome/css/font-awesome.min.css'
import '../node_modules/vuetify/dist/vuetify.min.css'
import Vuetify from 'vuetify'

Vue.config.productionTip = false
Vue.use(VueResource)
Vue.use(Vuetify)

/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  store,
  template: '<App/>',
  components: { App }
})
