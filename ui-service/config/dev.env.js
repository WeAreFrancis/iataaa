var merge = require('webpack-merge')
var prodEnv = require('./prod.env')

module.exports = merge(prodEnv, {
  NODE_ENV: '"development"',
  AI_PLAYER_API: 'http://172.16.0.50:8080/aiplayer-service/players'
})
