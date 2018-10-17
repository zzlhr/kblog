import Vue from 'vue';
import ElementUI from 'element-ui';
import 'element-ui/lib/theme-chalk/index.css';
import App from './App.vue';
import VueRouter from 'vue-router'
import Vuex from 'vuex'
import routes from "./router/routes";
import Icon from 'vue-svg-icon/Icon.vue';
import VueResource from "vue-resource"
import mavonEditor from 'mavon-editor'
import 'mavon-editor/dist/css/index.css'
// use
Vue.use(mavonEditor)
Vue.use(VueResource);
Vue.component('icon', Icon);
Vue.use(Vuex)
Vue.use(VueRouter)
Vue.use(ElementUI);
const router = new VueRouter({routes})
new Vue({
    el: '#app',
    router,
    render: h => h(App)
});