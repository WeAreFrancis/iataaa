export class Player {
  constructor (id, name, ip, port, path, difficulty, token) {
    this.id = id
    this.name = name
    this.ip = ip
    this.port = Number(port)
    this.path = path
    this.difficulty = difficulty
    this.token = token
  }
}
