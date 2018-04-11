window.addEventListener('load', function(){
//路由
const routes = [
    { path: '/feedReserve', name: 'feedReserve', component: feedReserve, alias: '/' }
]
const router = new VueRouter({
    routes
})
//状态管理
const store = new Vuex.Store({
    state: {
        mainData: [
            {
                num: 1,
                kind: 'pig',
                unit: 'kg'
            },
            {
                num: 2,
                kind: 'pig',
                unit: 'kg'
            },
            {
                num: 3,
                kind: 'pig',
                unit: 'kg'
            }
        ]
    }
})

var vm = new Vue({
    router,
    store,
    data: {
        navIndex: 1,
    }
}).$mount('#app')

    
}, false)