import Vue from 'vue'
import App from './App'
import axios from 'axios'

Vue.config.productionTip = false

new Vue({
  el: '#app',
  render: h => h(App)
})

// axios({
//   url: 'http://123.207.32.32:8000/home/multidata'
// }).then(res => {
//   console.log(res)
// })

axios.defaults.baseURL = 'http://123.207.32.32:8000'
axios.defaults.timeout = 5000   // ms

axios.all(
    [ 
      axios({
        url: '/home/multidata'
      }),
      axios({
        url: '/home/data',
        params: {
          type : 'sell',
          page: 5
        }
      })
    ]
  )
  // .then(res => {
  //   console.log(res)
  // })
  .then(axios.spread((res1, res2) => {
    console.log(res1)
    console.log(res2)
  }))