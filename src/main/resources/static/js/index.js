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
        el: '#app',
        router,
        data: {
            navIndex: 1
        }
<<<<<<< HEAD
    })

=======
    }).$mount('#app');
>>>>>>> 2455000eabe6846227be7d2518d58f55ed13ac32
} 