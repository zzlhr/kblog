import HelloWorld from '../components/HelloWorld'
import ArticleList from '../pages/article/List'
import ArticleAdd from '../pages/article/Add'
const routes = [
    // 动态路径参数 以冒号开头
    {path: '/', component: HelloWorld},
    {path: '/article',
        component: ArticleList,
        children:[
            {
                path: 'list',
                component: ArticleList,
            },
            {
                path: 'add',
                component: ArticleAdd,
            }
        ]
    }
]

export default routes