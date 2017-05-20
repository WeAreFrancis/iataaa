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
    console.error('ERROR', error)
  },
  CREATE_PLAYER (state, player) {
    state.players.content.push(player)
    ++state.players.totalElements
  },
  DELETE_PLAYER (state, player) {
    let index = state.players.content.indexOf(player)
    state.players.content.splice(index, 1)
    --state.players.totalElements
  },
  LOAD_PLAYERS (state, players) {
    state.players = players
  },
  UPDATE_PLAYER (state, player) {
    let index = state.players.content.indexOf(player)
    state.players.content[index] = player
  }
}

const actions = {
  createPlayer: ({ commit }, player) => {
    return api.post(AI_PLAYER_API, player)
      .then(response => commit('CREATE_PLAYER', response.body))
      .catch(error => commit('API_FAILURE', error))
  },
  deletePlayer: ({ commit }, player) => {
    return api.delete(AI_PLAYER_API + '/' + player.id)
      .then(response => commit('DELETE_PLAYER', player))
      .catch(error => commit('API_FAILURE', error))
  },
  loadPlayers: ({ commit }) => {
    return api.get(AI_PLAYER_API)
      .then(response => commit('LOAD_PLAYERS', response.body))
      .catch(error => commit('API_FAILURE', error))
  },
  updatePlayer: (context, [playerId, player]) => {
    return api.put(AI_PLAYER_API + '/' + playerId, player)
      .then(response => context.commit('UPDATE_PLAYER', response.body))
      .catch(error => context.commit('API_FAILURE', error))
  }
}

export default new Vuex.Store({
  state,
  actions,
  mutations
})
