import Vue from 'vue'
import App from './App.vue'
import vuetify from './plugins/vuetify';
import splitPane from 'vue-splitpane'

Vue.config.productionTip = false
Vue.component('split-pane', splitPane);

new Vue({
    vuetify,
    render: h => h(App)
}).$mount('#app')