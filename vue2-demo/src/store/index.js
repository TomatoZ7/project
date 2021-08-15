import Vue from 'vue'
import Vuex from 'vuex'
import { ADDNUM } from './mutations-types.js'

// 1. 安装插件
Vue.use(Vuex)

// 2. 创建对象
const store = new Vuex.Store({
    state: {
        counter: 100,
        author: {
            name: 'tz7',
            age: 18,
            gender: 'man'
        }
    },
    mutations: {
        increment(state) {
            state.counter++
        },
        decrement(state) {
            state.counter--
        },
        updateAuthor(state) {
            state.author.age = 81
        },
        [ADDNUM](state, num) {
            state.counter += num
        }
    },
    actions: {
        // 可以暂时认为 context 就是 store 对象
        updateAuthorAction(context) {
            setTimeout(() => {
                context.commit('updateAuthor')
            }, 2000)
        }
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