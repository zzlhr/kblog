<template>
    <div id="app">
        <router-view></router-view>
    </div>
</template>

<script>

</script>

<style>
    html,body{
        padding: 0;
        margin: 0;
        height: 100%;
    }
    #app {
        height: 100%;
        font-family: 'Avenir', Helvetica, Arial, sans-serif;
        -webkit-font-smoothing: antialiased;
        -moz-osx-font-smoothing: grayscale;
        /*text-align: center;*/
        color: #2c3e50;
    }
    .el-header{
        background-color: #545c64;
    }
    .el-aside{
        background-color: #545c64;
    }
    .el-container{
        height: 100%;
    }
    .el-menu{
        border-right: solid 0 #e6e6e6;
    }
</style>

