import Vue from 'vue'
import Vuex from 'vuex'
import {Player} from '../entities/player'

Vue.use(Vuex)

const state = {
  players: []
}

const mutations = {
  loadPlayers (state, players) {
    state.players = players
  }
}

const actions = {
  loadPlayers: ({ commit }) => commit('loadPlayers', [
    new Player('0', 'ai1', '127.0.0.1', '8080', null, 'HARD', 'token1'),
    new Player('1', 'ai2', '127.0.0.1', '8081', null, 'HARD', 'token2')
  ])
}

export default new Vuex.Store({
  state,
  actions,
  mutations
})
