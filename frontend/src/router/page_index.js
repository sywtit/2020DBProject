import Vue from 'vue'
import VueRouter from 'vue-router'

Vue.use(VueRouter);


const MainPage = () => {
    return import ( /* webpackChunkName: "mainpage" */ '../views/MainPage.vue')
}
const LoginPage = () => {
    return import ('../views/LoginPage.vue')
}
const MyCinemaPage = () => {
    return import ('../views/MyCinemaPage.vue')
}
const MyAccountPage = () => {
    return import ('../views/MyAccountPage.vue')
}
const MovieRentalShopPage = () => {
    return import ('../views/MovieRentalShopPage.vue')
}
const vueRouter = new VueRouter({
    mode: 'history',
    base: process.env.BASE_URL,
    routes: [{
            path: '/home',
            name: 'MainPage',
            component: MainPage
        },
        {
            path: '/',
            name: 'LoginPage',
            component: LoginPage
        },
        {
            path: '/myCinema',
            name: 'MyCinemaPage',
            component: MyCinemaPage
        },
        {
            path: '/myAccount',
            name: 'MyAccountPage',
            component: MyAccountPage
        },
        {
            path: '/movieRentalShop',
            name: 'MovieRentalShopPage',
            component: MovieRentalShopPage
        }
        // { path: '*', component: NotFoundComponent }
    ]
})

export default vueRouter;