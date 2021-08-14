import Vue from 'vue'
import Vuex from 'vuex'

// 1. 安装插件
Vue.use(Vuex)

// 2. 创建对象
const store = new Vuex.Store({
    state: {
        counter: 100
    },
    mutations: {
        increment(state) {
            state.counter++
        },
        decrement(state) {
            state.counter--
        },
        addNum(state, num) {
            state.counter += num
        }
    },
    actions: {

    },
    getters: {
        powerCounter(state) {
            return state.counter * state.counter
        },
        cubicCounter(state, getters) {
            return getters.powerCounter * state.counter
        },
        multiCounter(state) {
            return function (n) {
                return n * state.counter
            }
        }
    },
    modules: {

    }
})

// 3. 导出
export default store