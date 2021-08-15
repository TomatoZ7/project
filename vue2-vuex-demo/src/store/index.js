import Vue from 'vue'
import Vuex from 'vuex'
import { ADDNUM } from './mutations-types.js'

// 1. 安装插件
Vue.use(Vuex)

// 2. 创建对象
const moduleA = {
    state: {
        'name': 'tz777-moduleA'
    },
    mutations: {
        updateName(state, payload) {
            state.name = payload
        }
    },
    actions: {
        // 此时的 context 仅表示 moduleA，commit 时只会 commit 到自己的 mutations 里
        updateNameAction(context) {
            setTimeout(() => {
                context.commit('updateName', 'Tomato')
            }, 1500)
        }
    },
    getters: {
        getRootAuthor(state, payload, rootState) {
            return rootState.author
        }
    }
}

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
        a: moduleA
    }
})

// 3. 导出
export default store