window.addEventListener('load', function(){
//路由
const routes = [
    { path: '/feedReserve', name: 'feedReserve', component: feedReserve, alias: '/' },
    { path: '/feedProvice', component: feedProvice }
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
            },{
                num: 2,
                kind: 'pig',
                unit: 'kg'
            },{
                num: 3,
                kind: 'pig',
                unit: 'kg'
            }
        ],
        feedLists: [1],
        feedProvice: {
            kind: ['大猪料', '小猪料', '自己吃', '不吃了'],
            unit: ['公斤', '包']
        }
        ,
        proviceWho: ["张三", "李四", "赵武"]
    },
    mutations: {
        delList: (state, index) => state.feedLists.splice(state.feedLists.indexOf(index),1),
        addList: state => state.feedLists.push(state.feedLists.length+1),
        clearList: state => state.feedLists = [1]
    }
})

var vm = new Vue({
    router,
    store,
    data: {
        navIndex: 1,
    }
}).$mount('#app')

const _submit_btn = document.querySelector('.fp-submit-btn');

_submit_btn.addEventListener('click', function(){
    let kInput = [], nInput = [], uInput = [], _arr = [];
    let _kInput = document.querySelectorAll('.k-input'),
        _nInput = document.querySelectorAll('.n-input'),
        _uInput = document.querySelectorAll('.u-input'),
        _feeder = document.querySelectorAll('.feeder-input')[0];
    
    _kInput.forEach( item => kInput.push(item.value) );
    _nInput.forEach( item => nInput.push(item.value) );
    _uInput.forEach( item => uInput.push(item.value) );

    let len = kInput.length;
    for(let i=0; i<len; i++){
        let obj = {};
        obj.kind = kInput[i];
        obj.num = nInput[i];
        obj.unit = uInput[i];
        obj.feeder = _feeder.value;

        _arr.push(obj);
    }

    //提交 Ajax请求
}, true)

}, false)



