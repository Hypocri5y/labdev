<template>
  <div id="app">
    <router-link to="/home">首页</router-link>
    <router-link to="/login">登录</router-link>
    <router-view />
  </div>
</template>

<script>
export default {
  name: 'App',
};
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  text-align: center;
  margin-top: 20px;
}
</style>