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
        mainData: [],
        //饲料发放
        feedLists: [1],
        feedProvice: {
            kind: ['大猪料', '小猪料', '自己吃', '不吃了'],
            unit: [[''],['']],
        },
        proviceWho: [],
         //添加界面
        fs_show: false,
        fp_data: {    //饲料发放页面数据
            name: '',
            lists: [
                { kind: '', num: '', unit: ''}
            ]
        },    //饲料储量页面数据
        feedStores: [],//饲料储量
        fs_data: {
            tableData: [
                { kind: '', num: '', unit: ''}
            ],
            addData: { _kind: '', _num: '', _unit: '' }
        },
        //用户信息
        um_data: {
            um_users: [ {name: '', sex: '', usr: '', pass: '', id: ''} ] 
        }
    },
    mutations: {
        //delList, addList, clearList 发放页面操作函数
        delList: (state, index) => state.fp_data.lists.splice(state.fp_data.lists.indexOf(index),1),
        addList: state => state.fp_data.lists.push( { kind: '', num: '', unit: ''} ),
        clearList: state => state.fp_data.lists.splice(1),
        //showFsAdd, hideFsAdd 饲料储量页面的添加界面显示或者隐藏
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
                url: URL + '/forageProvideInfo', 
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
    watch: {
        $route(to, from, next){
            let _path = to.path;
            let that = this;

            switch(_path){
                case '/userMes':                
                    axios.get(URL + '/userGet')
                    .then( (response)=>{
                        if(response.status != 200){
                            alert('抱歉, 错误了!')
                        }else{
                            let _uArr = that.$store.state.um_data.um_users;
                            for(let i=0; i<response.data.length; i++){
                                if(_uArr.length < response.data.length)
                                    _uArr.push( {name: '', sex: '', usr: '', pass: '', id: ''} );
                                _uArr[i].name = response.data[i].name;
                                _uArr[i].sex = response.data[i].sex;
                                _uArr[i].usr = response.data[i].name;
                                _uArr[i].pass = response.data[i].password;
                                _uArr[i].id = response.data[i].id;
                            }
                        }
                    } )
                    break;

                case '/feedStore':
                    axios.get(URL +'/forageStoreGet')
                    .then( (response)=>{
                        if(response.status != 200){
                            alert('抱歉, 出错了!')
                        }else{
                            that.$store.state.feedStores = response.data;
                        }
                    } )
                    break;
                default: 
                    break;
            }
        }
    },
    //初始化,请求饲料属性页面数据
    beforeCreate(){
        let that = this;
        let _url = URL + '/forageGet';
        let _usersURL = URL + '/userGet';
        axios.get(_url)
            .then( function(response){
                let _data = response.data;
                let _types = [], _units = [[],[]];
                that.$store.state.mainData = _data;
                //设置饲料种类与对应单位
                //设置单位
                for(let i=0; i<_data.length; i++){
                    _types.push( _data[i].type );
                    _units[0].push( _data[i].type );
                    _units[1].push( _data[i].unit );
                }
                that.$store.state.feedProvice.kind = _types;
                that.$store.state.feedProvice.unit = _units

            } )
                //设置发放人员
        axios.get(_usersURL)
            .then( (response)=>{
                if(response.status != 200){
                    alert('抱歉, 出错了!')
                }else{
                    that.$store.state.proviceWho = response.data.filter((item)=>item.type.length === 4 ? item.name : '');
                }
            } )
    }
}).$mount('#app')

}