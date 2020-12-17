import Vue from 'vue'
import App from './App.vue'
import vuetify from './plugins/vuetify';
import splitPane from 'vue-splitpane'
import VueRouter from 'vue-router';
import router from './router/page_index.js'
import Carousel3d from 'vue-carousel-3d';
import BootstrapVue from 'bootstrap-vue'
import 'bootstrap/dist/css/bootstrap.min.css'
import 'bootstrap-vue/dist/bootstrap-vue.css'

Vue.use(BootstrapVue);
Vue.use(VueRouter); // router 기능 확장 선언
Vue.use(Carousel3d);

const DEFAULT_TITLE = 'ending_credit';
router.afterEach((to) => {
    // Use next tick to handle router history correctly
    // see: https://github.com/vuejs/vue-router/issues/914#issuecomment-384477609
    Vue.nextTick(() => {
        document.title = to.meta.title || DEFAULT_TITLE;
    });
});

Vue.config.productionTip = false
Vue.component('split-pane', splitPane);

new Vue({
    vuetify,
    render: h => h(App),
    router
}).$mount('#app')