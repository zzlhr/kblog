<template>
    <el-card class="box-card">
        <div slot="header" class="clearfix">
            <span>文章列表</span>
            <el-button style="float: right; padding: 3px 5px" type="text" @click="goAdd()"><i class="el-icon-plus"></i>添加</el-button>
            <el-button style="float: right; padding: 3px 5px" type="text" @click="reloadData"><i class="el-icon-refresh"></i>刷新</el-button>
        </div>
        <div>
            <el-table
                    :data="tableData"
                    border
                    stripe
                    style="width: 100%">
                <el-table-column
                        fixed
                        prop="aid"
                        label="#"
                        width="50">
                </el-table-column>
                <el-table-column
                        prop="articleTitle"
                        label="标题"
                        min-width="250">
                </el-table-column>
                <el-table-column
                        prop="articleAuthorName"
                        label="作者"
                        width="70">
                </el-table-column>
                <el-table-column
                        prop="tags"
                        label="标签"
                        min-width="120">
                </el-table-column>
                <el-table-column
                        prop="articleClick"
                        label="点击数"
                        width="70">
                </el-table-column>
                <el-table-column
                        prop="articleZan"
                        label="点赞数"
                        width="70">
                </el-table-column>
                <el-table-column
                        prop="articleCommemtNumber"
                        label="评论数"
                        width="70">
                </el-table-column>
                <el-table-column
                        prop="articleStatus"
                        label="状态"
                        width="50">
                </el-table-column>
                <el-table-column
                        prop="createTime"
                        label="创建时间"
                        min-width="150">
                </el-table-column>
                <el-table-column
                        prop="updateTime"
                        label="更新时间"
                        min-width="150">
                </el-table-column>
                <el-table-column
                        fixed="right"
                        label="操作"
                        width="100">
                    <template slot-scope="scope">
                        <el-button @click="handleClick(scope.row)" type="text" size="small">查看</el-button>
                        <el-button type="text" size="small">编辑</el-button>
                    </template>
                </el-table-column>
            </el-table>
            <div class="pagination">
                <el-pagination
                        @size-change="handleSizeChange"
                        @current-change="handleCurrentChange"
                        :current-page="currentPage"
                        :page-sizes="[5, 10, 50]"
                        :page-size="pageSize"
                        layout="total, sizes, prev, pager, next, jumper"
                        :total="totalCount">
                </el-pagination>
            </div>
        </div>
    </el-card>
</template>

<script>
    import http from '../../util/HttpUtil'

    export default {
        methods: {
            goAdd(){
              this.$router.push({path: '/article/add'})
            },
            // 切换每页数量
            handleSizeChange(val) {
                console.log(`每页 ${val} 条`);
                this.pageSize = val
                this.page = 1
                this.loadData();
            },
            // 切换页数
            handleCurrentChange(val) {
                this.page = val;
                this.loadData();
            },
            handleClick(row) {
                console.log(row);
            },
            reloadData(){
                this.page--;
                this.loadData();
            },
            loadData() {
                const that = this;
                http.post(this, 'api', 'articles',
                    {
                        page: this.page,
                        pageSize: this.pageSize
                    },
                    function (data) {
                        console.log(data)
                        that.tableData = data.body.data.arr
                        that.totalCount = data.body.data.totalCount
                        that.currentPage = data.body.data.currentPage
                        that.page++;
                    })
            },
        },
        name: 'ArticleList',
        mounted() {
            this.loadData()
        },
        data() {
            return {
                totalCount: 0,
                currentPage: 0,
                pageSize: 5, // 默认加载数据条数
                page: 1,
                tableData: [{
                    date: '2016-05-03',
                    name: '王小虎',
                    province: '上海',
                    city: '普陀区',
                    address: '上海市普陀区金沙江路 1518 弄',
                    zip: 200333
                }, {
                    date: '2016-05-02',
                    name: '王小虎',
                    province: '上海',
                    city: '普陀区',
                    address: '上海市普陀区金沙江路 1518 弄',
                    zip: 200333
                }, {
                    date: '2016-05-04',
                    name: '王小虎',
                    province: '上海',
                    city: '普陀区',
                    address: '上海市普陀区金沙江路 1518 弄',
                    zip: 200333
                }, {
                    date: '2016-05-01',
                    name: '王小虎',
                    province: '上海',
                    city: '普陀区',
                    address: '上海市普陀区金沙江路 1518 弄',
                    zip: 200333
                }]
            }
        }
    }
</script>

<style scoped>
    .pagination{
        margin-top: 10px;
        text-align: center;
    }
</style>