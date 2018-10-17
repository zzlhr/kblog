<template>
    <el-menu
            :default-active="activeIndex"
            class="el-menu-vertical-demo"
            @open="handleOpen"
            @close="handleClose"
            background-color="#545c64"
            text-color="#fff"
            active-text-color="#ffd04b"
            router>
        <el-menu-item index="/">
            <icon name="home" scale="2"/>
            <span slot="title">首&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;页</span>
        </el-menu-item>
        <el-submenu index="1">
            <template slot="title">
                <icon name="article" scale="2"/>
                <span>文章管理</span>
            </template>
            <el-menu-item-group>
                <el-menu-item index="/article/list">文章列表</el-menu-item>
                <el-menu-item index="/article/add">写文章</el-menu-item>
            </el-menu-item-group>
            <el-menu-item-group title="分组2">
                <el-menu-item index="1-3">选项3</el-menu-item>
            </el-menu-item-group>
            <el-submenu index="1-4">
                <template slot="title">选项4</template>
                <el-menu-item index="1-4-1">选项1</el-menu-item>
            </el-submenu>
        </el-submenu>
        <el-menu-item index="2">
            <i class="el-icon-menu"></i>
            <span slot="title">导航二</span>
        </el-menu-item>
        <el-menu-item index="3" disabled>
            <i class="el-icon-document"></i>
            <span slot="title">导航三</span>
        </el-menu-item>

    </el-menu>
</template>

<script>
    export default {
        name: "Aside",
        data() {
            return {
                activeIndex: "/"
            }
        },
        methods: {
            handleOpen() {
            },
            handleClose() {
            }
        },
        mounted() {
        },
        watch:{
            $route(val){
                // 通过监听路由变化从而改变当前的选中菜单
                this.activeIndex =  val.fullPath
            }
        }
    }
</script>

<style scoped>
    .svg-icon {
        margin-right: 5px;
    }
</style>