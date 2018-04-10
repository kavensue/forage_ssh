window.onload = function(){
    Vue.use(VueRouter);
    
    let routes = [
        { path: '/problem', component: t_problem, alias: '/' },
        { path: '/foragegain', component: t_foragegain },
        { path: '/feedtask', component: t_feedtask }
    ];
    const router = new VueRouter({
        // mode: 'history',
        routes
    }); 

    const vm = new Vue({
        router,
        data: {
            navIndex: 1
        }
    }).$mount('#app');



} 