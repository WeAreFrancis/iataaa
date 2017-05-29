import Vue from 'vue'
import {AI_PLAYER_API} from '../../config/prod.env'

export default {
  create (player) {
    return Vue.http.post(AI_PLAYER_API, player)
  },
  delete (player) {
    return Vue.http.delete(AI_PLAYER_API + '/' + player.id)
  },
  getAll (pageNb) {
    return Vue.http.get(AI_PLAYER_API + '?page=' + pageNb)
  },
  update (playerId, player) {
    return Vue.http.put(AI_PLAYER_API + '/' + playerId, player)
  }
}
