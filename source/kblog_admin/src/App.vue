<template>
    <div id="app">

        <el-container>
            <el-header>
                <Header />
            </el-header>
            <el-container>
                <el-aside width="200px">
                    <Aside />
                </el-aside>
                <el-container>
                    <el-main>
                        <router-view></router-view>
                    </el-main>
                    <el-footer>版权由lhr所有</el-footer>
                </el-container>
            </el-container>
        </el-container>
    </div>
</template>

<script>
    import HelloWorld from './components/HelloWorld.vue'
    import Header from './components/Header.vue'
    import Aside from './components/Aside.vue'
    export default {
        name: 'app',
        components: {
            HelloWorld,
            Header,
            Aside,
        },
    }
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

