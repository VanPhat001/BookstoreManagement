class Debounce {
    #callback = () => { }
    #timeout = 300
    #id = null

    constructor(callback = () => { }, timeout = 300) {
        this.#callback = callback
        this.#timeout = timeout
    }

    reStart() {
        this.stop()
        this.#id = setTimeout(() => {
            this.#callback(this)
            this.#id = null
        }, this.#timeout)
    }

    stop() {
        clearTimeout(this.#id)
        this.#id = null
    }
}

export default Debounce