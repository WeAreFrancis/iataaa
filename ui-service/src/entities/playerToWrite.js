export class PlayerToWrite {
  constructor (name, ip, port, path, difficulty) {
    this.name = name
    this.ip = ip
    this.port = Number(port)
    this.path = path
    this.difficulty = difficulty
  }
}
