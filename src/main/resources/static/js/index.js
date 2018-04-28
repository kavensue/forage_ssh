window.onload = function(){
    Vue.use(VueRouter);
    //路由配置
    let routes = [
        { path: '/problem', component: t_problem, alias: '/',  },
        { path: '/foragegain', component: t_foragegain },
        { path: '/feedtask', component: t_feedtask }
    ];
    const router = new VueRouter({
        // mode: 'history',
        routes
    }); 

    const vm = new Vue({
        el: '#app',
        router,
        data: {
            navIndex: 1
        }
    })
}
