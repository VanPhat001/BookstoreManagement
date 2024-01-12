import axios from 'axios'

function create() {
    return axios.create({
        baseURL: 'http://localhost:8080',
        headers: {
            'Content-Type': 'application/json',
        }
    })
}

export default create