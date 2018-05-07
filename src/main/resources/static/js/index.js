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

    const store = new Vuex.Store({
        state: {
            title: '问题地点',
            problemSpace: ['1号猪舍', '2号猪舍', '1号饲料室', '2号饲料室'],
            commitData: {
                place: '',
                type: '',
                remark: ''
            },
            p_Dis: '问题描述',
            dis_problems: ['饲料不足', '饲料质量有问题', '猪食欲不振', '猪发烧了', '猪感冒了'],
            alias: '', //备注
            getFeed: [{
                type: '',
                number: '',
                unit: ''
            }],
            getKind: '问题种类',
            getKinds: ['大猪料', '小猪料'],
            getFeeds: [{}],
            feedPlace: '喂食地点',
            feedPlaces: ['1号猪舍', '2号猪舍'],
            feedObj: '喂食对象',
            feedObjs: ['大猪', '小猪'],
            subFeedObj: [{   //用于提交
                place: '',
                obj: '' 
            }]  
        },
        mutations: {
            //问题反馈 -- 问题地点
            changeSpace(state, index){
                state.title = state.problemSpace[index];
            },
                //问题描述
            problemDis(state, index){
                state.p_Dis = state.dis_problems[index];
            },
            //领取饲料 -- 饲料种类
            selectKind(state, o){
                state.getKind = state.getKinds[o.index];
            },
                    //---删除
            delItem(state, o){
                let _do = confirm('确认删除?');
                if(_do){
                    state.getFeeds.splice(o.index, 1)
                }
            },
            addItem(state){
                state.getFeeds.push({})
            },
            clearAll(state){
                state.getFeeds.splice(0, state.getFeeds.length - 1)
            },
            //
            selectPlace(state, o){
                state.feedPlace = state.feedPlaces[o.index];
                let _id = state.subFeedObj[o.id];
                _id.place = state.feedPlaces[o.index];
            },
            selectObj(state, o){
                state.feedObj = state.feedObjs[o.index];
                let _id = state.subFeedObj[o.id];
                _id.obj = state.feedObjs[o.index];
            },
            addPlace(state){
                state.subFeedObj.push({place: '', obj: ''})
            },
            delPlace(state, index){
                if(state.subFeedObj.lnegth === 1) return;
                state.subFeedObj.splice(index, 1);
            },
            clearPlace(state){
                state.subFeedObj.splice(0, state.subFeedObj.length - 1);
            }
        },
        actions: {
            subProblem(content){
                let obj = {};
                obj.place = content.state.title == '问题地点' ? '' : content.state.title;
                obj.type = content.state.p_Dis == '问题描述' ? '' : content.state.p_Dis;
                obj.remark = content.state.alias;
                console.log(obj);

                axios.post(URL + '/feederProblemAdd/', obj)
                    .then( (response)=>{
                        console.log('response')
                    } )
            },
            subFeedData(content){
                let obj = {};
                console.log(content.state.getFeeds);

                axios.post(URL + '/feederForageGainAdd', content.state.getFeeds)
                    .then( (response)=>{
                        console.log(response)
                    } )
            },
            subTask(content){
                let obj = [{}];
                for(let i=0, l=content.state.subFeedObj.length; i<l; i++){
                    obj.push({});
                    obj[i].place = content.state.subFeedObj[i].place;
                    obj[i].target = content.state.subFeedObj[i].obj;
                    obj[i].note = '';
                }
                axios.post(URL + '/feederTaskAdd', obj)
                    .then( (response) =>{
                        console.log(response);
                    } )
            }
        }
    })


    const vm = new Vue({
        el: '#app',
        router,
        store,
        data: {
            navIndex: 1
        }
    })
}
