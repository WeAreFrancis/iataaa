import Vue from 'vue'
import Vuex from 'vuex'
import playerService from '../service/playerService'
import * as types from './types'
import Toasted from 'vue-toasted'

Vue.use(Vuex)
Vue.use(Toasted)

const state = {
  players: []
}

const mutations = {
  [types.CREATE_PLAYER] (state, player) {
    state.players.content.push(player)
    ++state.players.totalElements
  },
  [types.LOAD_PLAYER] (state, players) {
    state.players = players
  },
  [types.UPDATE_PLAYER] (state, player) {
    let index = state.players.content.indexOf(player)
    state.players.content[index] = player
  }
}

const actions = {
  createPlayer: ({ commit }, player) => {
    return playerService.create(player)
      .then(
        response => commit(types.CREATE_PLAYER, response.body)
      )
  },
  deletePlayer: ({ commit }, player) => {
    // TODO : It's better to call loadPlayers action. But how to do ?
    return playerService.delete(player)
      .then(
        response => {
          let page = (state.players.numberOfElements < 2) ? state.players.number - 1 : state.players.number
          playerService.getAll(page)
            .then(
              response => commit(types.LOAD_PLAYER, response.body)
            )
        }
      )
  },
  loadPlayers: ({ commit }, pageNb) => {
    return playerService.getAll(pageNb)
      .then(
        response => commit(types.LOAD_PLAYER, response.body)
      )
  },
  updatePlayer: ({ commit }, [playerId, player]) => {
    return playerService.update(playerId, player)
      .then(
        response => commit(types.UPDATE_PLAYER, response.body)
      )
  }
}

export default new Vuex.Store({
  state,
  actions,
  mutations
})
