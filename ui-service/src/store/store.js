import Vue from 'vue'
import Vuex from 'vuex'
import api from './api'
import {AI_PLAYER_API} from '../../config/prod.env'

Vue.use(Vuex)

const state = {
  players: []
}

const mutations = {
  API_FAILURE (error) {
    console.log(error)
  },
  CREATE_PLAYER (state, player) {
    state.players.push(player)
  },
  DELETE_PLAYER (state, player) {
    let index = state.players.indexOf(player)
    state.players.splice(index - 1, 1)
  },
  LOAD_PLAYERS (state, players) {
    state.players = players
  }
}

const actions = {
  createPlayer: ({ commit }, player) => {
    return api.post(AI_PLAYER_API, player)
      .then((response) => commit('CREATE_PLAYER', response.body))
      .catch((error) => commit('API_FAILURE', error))
  },
  deletePlayer: ({ commit }, player) => {
    return api.delete(AI_PLAYER_API + '/' + player.id)
      .then((response) => commit('DELETE_PLAYER', player))
      .catch((error) => commit('API_FAILURE', error))
  },
  loadPlayers: ({ commit }) => {
    return api.get(AI_PLAYER_API)
      .then(
        (response) => commit('LOAD_PLAYERS', response.body.content)
      )
      .catch((error) => commit('API_FAILURE', error))
  }
}

export default new Vuex.Store({
  state,
  actions,
  mutations
})
