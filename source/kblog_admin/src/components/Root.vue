<template>
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
</template>

<script>
    import HelloWorld from '../components/HelloWorld.vue'
    import Header from '../components/Header.vue'
    import Aside from '../components/Aside.vue'
    export default {
        name: 'Root',
        components: {
            HelloWorld,
            Header,
            Aside,
        },
    }
</script>

<style scoped>

</style>