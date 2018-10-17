<template>
    <el-card class="box-card">
        <div slot="header" class="clearfix">
            <span>卡片名称</span>
            <el-button style="float: right; padding: 3px 0" type="text" @click="saveArticle()"><i
                    class="el-icon-circle-plus"></i>发布
            </el-button>
        </div>
        <div class="article-edit">
            <el-form ref="form" :model="articleForm" label-width="80px">
                <el-form-item label="文章标题">
                    <el-input v-model="articleForm.articleTitle"></el-input>
                </el-form-item>
                <el-form-item label="文章描述">
                    <el-input type="textarea" v-model="articleForm.articleDescribe"></el-input>
                </el-form-item>
                <el-form-item label="文章内容">
                    <mavon-editor v-model="articleForm.articleContentMd"></mavon-editor>
                </el-form-item>
            </el-form>
        </div>
    </el-card>
</template>

<script>

    export default {
        name: "ArticleAdd",
        data() {
            return {
                articleForm: {
                    articleTitle: '',
                    articleDescribe: '',
                    articleContentMd: '',
                },
            }
        },
        methods: {
            saveArticle() {
                console.log(this.articleForm)
            }
        }
    }
</script>

<style scoped>

</style>