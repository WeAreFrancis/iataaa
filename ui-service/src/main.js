import Vue from 'vue'
import App from './App'
import router from './router'
import VueResource from 'vue-resource'
import store from './store/store'
import '../semantic/dist/semantic.min.css'
import 'semantic'
import '../node_modules/font-awesome/css/font-awesome.min.css'

Vue.config.productionTip = false
Vue.use(VueResource)

/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  store,
  template: '<App/>',
  components: { App },
  mounted: function () {
    $('.ui.accordion').accordion()
  }
})
