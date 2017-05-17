import Vue from 'vue'

export default {
  get (url, request) {
    return Vue.http.get(url, request)
  },
  post (url, request) {
    return Vue.http.post(url, request)
  },
  delete (url, request) {
    return Vue.http.delete(url, request)
  }
}