<template>
  <div id="app">
    <h2>{{$store.state.counter}}</h2>
    <button @click="addition">+</button>
    <button @click="subtraction">-</button>

    <hr />

    <h2>Getters 相关信息</h2>
    <h2>{{$store.getters.powerCounter}}</h2>
    <h2>{{$store.getters.cubicCounter}}</h2>
    <h2>{{$store.getters.multiCounter(5)}}</h2>

    <hr />

    <h2>Hello Component 相关信息</h2>
    <hello></hello>
  </div>
</template>

<script>
import Hello from './components/Hello/Hello'

export default {
  name: 'App',
  components: {
    Hello
  },
  data() {
    return {
      message: 'Hello World'
    }
  },
  methods: {
    addition() {
      this.$store.commit('increment')
    },
    subtraction() {
      this.$store.commit('subtraction')
    }
  }
}
</script>