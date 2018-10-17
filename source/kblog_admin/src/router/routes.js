import HelloWorld from '../components/HelloWorld'
import Root from '../components/Root'
import ArticleList from '../pages/article/List'
import ArticleAdd from '../pages/article/ArticleAdd'
import Login from '../pages/Login'
const routes = [
    // 动态路径参数 以冒号开头
    {
        path: '/', component: Root,
        children: [
            {
                path: '/',
                component: HelloWorld
            },
            {
                path: '/article/list',
                component: ArticleList,
            },
            {
                path: '/article/add',
                component: ArticleAdd,
            }
        ]
    },
    {
        path:'/login',component: Login
    }

]

export default routes