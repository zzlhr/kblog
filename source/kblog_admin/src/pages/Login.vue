<template>
    <div>
        <el-card shadow="always">
            <div slot="header" class="clearfix">
                <span>后台登录</span>
            </div>
            <div>
                <el-form ref="登录表单" :model="loginForm" label-width="50px">
                    <el-form-item label="账  号">
                        <el-input v-model="loginForm.loginName"></el-input>
                    </el-form-item>
                    <el-form-item label="密  码">
                        <el-input type="password" v-model="loginForm.password"></el-input>
                    </el-form-item>
                    <el-button type="primary" style="width: 100%">登   录</el-button>
                </el-form>
            </div>

        </el-card>
    </div>
</template>

<script>
    export default {
        name: "Login",
        data() {
            return {
                loginForm: {
                    loginName: '',
                    password: '',
                    code: '',
                }
            }
        }
    }
</script>

<style scoped>
    .el-card {
        width: 500px;
        height: 300px;
        margin: 100px auto auto;
    }
</style>