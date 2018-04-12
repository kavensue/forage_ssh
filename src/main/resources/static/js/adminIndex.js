window.onload = function(){
//路由
const routes = [
    { path: '/feedReserve', name: 'feedReserve', component: feedReserve, alias: '/' },
    { path: '/feedProvice', component: feedProvice },
    { path: '/feedStore', component: feedStore },
    { path: '/userMes', component: userMes }
]
const router = new VueRouter({
    routes
})
//状态管理
const store = new Vuex.Store({
    state: {
        //饲料属性
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
        //饲料发放
        feedLists: [1],
        feedProvice: {
            kind: ['大猪料', '小猪料', '自己吃', '不吃了'],
            unit: ['公斤', '包']
        },
        proviceWho: ["张三", "李四", "赵武"],
         //添加界面
        fs_show: false,
        fp_data: {    //饲料发放页面数据
            name: '',
            lists: [
                { kind: '', num: '', unit: ''}
            ]
        },           //饲料储量页面数据
        feedStores: [   //饲料储量
            { kind: '大猪料', num: 100, unit: '公斤' }
        ],
        fs_data: {
            tableData: [
                { kind: '', num: '', unit: ''}
            ],
            addData: { _kind: '', _num: '', _unit: '' }
        },
        //用户信息
        um_data: {
            um_users: [
                {
                    name: '张三',
                    sex: '男',
                    usr: '饲养员',
                    pass: '111111111111111111111111111111'
                }
            ]
        }
    },
    mutations: {
        //delList, addList, clearList 发放页面操作函数
        delList: (state, index) => state.fp_data.lists.splice(state.fp_data.lists.indexOf(index),1),
        addList: state => state.fp_data.lists.push( { kind: '', num: '', unit: ''} ),
        clearList: state => state.fp_data.lists.splice(1),
        showFsAdd: state => state.fs_show = true,
        hideFsAdd: state => state.fs_show = false
    },
    actions: {
        //发放页面提交
        fpSubData: function(content){
            let name = content.state.fp_data.name;
            let list = content.state.fp_data.lists;
            let arr = [];
            let _content = content;
            for(let i=0; i<list.length; i++){
                arr.push({
                    feederName: name,
                    type: list[i].kind,
                    unit: list[i].unit,
                    number: list[i].num
                })
            }
            axios({ 
                method: 'post', 
                url: 'http://dd7b5591.ngrok.io/forageProvideInfo', 
                data: arr
            })
            .then(function(response){
                if(response.data === 0){
                    window.alert('提交成功!');
                }else{
                    window.alert('输入数据有误')
                }
            }).catch((err)=>{
                console.log(err);
            })
        },
        fsDetermine: content => console.log(content.state.fs_data.addData),
        fsDelStoreItem: (content, index) => content.state.feedStores.splice(index, 1)
    }
})

var vm = new Vue({
    router,
    store,
    data: {
        navIndex: 1
    },
    //初始化,请求饲料属性页面数据
    beforeCreate(){
        let that = this;
        axios.get('http://dd7b5591.ngrok.io/forageGet')
            .then( function(response){
                that.$store.state.mainData = response.data;
            } )
    }
}).$mount('#app')

}