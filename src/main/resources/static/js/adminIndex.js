window.onload = function(){
//路由
const routes = [
    { path: '/feedReserve', name: 'feedReserve', component: feedReserve, alias: '/' },
    { path: '/feedProvice', component: feedProvice },
    { path: '/feedStore', component: feedStore },
    { path: '/userMes', component: userMes },
    { path: '/history', component: history },
    { path: '/infoCount', component: infoCount }
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
        fr_show: false,
        fs_show: false,
        um_show: false,
         //编辑界面
        frEdit_show: false,
        fsEdit_show: false,
        umEdit_show: false,
        fp_data: {    //饲料发放页面数据
            name: '',
            lists: [
                { kind: '', num: '', unit: ''}
            ]
        },    //饲料储量页面数据
        feedStores: [],//饲料储量
        fr_data: {
            addData: { kind: '', unit: '' }
        },
        fs_data: {
            tableData: [
                { kind: '', num: '', unit: ''}
            ],
            addData: { _kind: '', _num: '', _unit: '' }
        },
        //用户信息
        um_data: {
            um_users: [ {name: '', sex: '', usr: '', pass: '', id: ''} ],
            addData: {name: '', sex: '', usr: '', pass: '', id: ''} 
        }
    },
    mutations: {
        //delList, addList, clearList 发放页面操作函数
        delList: (state, index) => state.fp_data.lists.splice(state.fp_data.lists.indexOf(index),1),
        addList: state => state.fp_data.lists.push( { kind: '', num: '', unit: ''} ),
        clearList: state => state.fp_data.lists.splice(1),
        //showFrAdd, hideFsAdd 饲料属性添加界面的显示或者隐藏
        showFrAdd: state => state.fr_show = true,
        hideFrAdd: state => state.fr_show = false,
        //showFrEdit, hideFrEdit 饲料属性编辑界面的显示或隐藏
        showFrEdit: (state, obj) => {
            state.frEdit_show = true;
            let _index = obj.index;

            //填充要编辑的数据      
            state.fr_data.addData.kind = state.mainData[_index].type;
            state.fr_data.addData.unit = state.mainData[_index].unit;
            state.fr_data.addData.id = obj.id;
            state.fr_data.addData.index = _index;
        },
        hideFrEdit: state => {
            state.frEdit_show = false;
            state.fr_data.addData.kind = '';
            state.fr_data.addData.unit = '';
            state.fs_data.addData.id = '';
            state.fs_data.addData.index = '';
        },
        //showFsAdd, hideFsAdd 饲料储量页面的添加界面显示或者隐藏
        showFsAdd: state => state.fs_show = true,
        hideFsAdd: state => state.fs_show = false,
        //showFsEdit, hideFsEdit 饲料储量页面的编辑界面显示或者隐藏
        showFsEdit: (state, obj) => {
            state.fsEdit_show = true;
            let _index = obj.index;
            //填充要编辑的数据      
            state.fs_data.addData._kind = state.feedStores[_index].type;
            state.fs_data.addData._num = state.feedStores[_index].number;
            state.fs_data.addData._unit = state.feedStores[_index].unit;
            state.fs_data.addData.id = obj.id;
            state.fs_data.addData.index = _index;
        },
        hideFsEdit: state => state.fsEdit_show = false,
        //showUmAdd, hideUmAdd 用户信息页面的添加界面显示或者隐藏
        showUmAdd: state => state.um_show = true,
        hideUmAdd: state => {
            state.um_show = false;

            state.um_data.addData.name = '';
            state.um_data.addData.sex = '';
            state.um_data.addData.usr = '';
            state.um_data.addData.pass = ''; 
            state.um_data.addData.id = '';
            state.um_data.addData.index = '';
        },
        //showUmEdit, hideFsEdit 用户信息页面的编辑界面显示或者隐藏
        showUmEdit: (state, obj) => {
            state.umEdit_show = true;
            let _index = obj.index;

            //填充要编辑的数据      
            state.um_data.addData.name = state.um_data.um_users[_index].name;
            state.um_data.addData.sex = state.um_data.um_users[_index].sex;
            state.um_data.addData.type = state.um_data.um_users[_index].usr;
            state.um_data.addData.password = state.um_data.um_users[_index].pass;
            state.um_data.addData.id = obj.id;
            state.um_data.addData.index = _index;
        },
        hideUmEdit: state => {
            state.umEdit_show = false;

            state.um_data.addData.name = '';
            state.um_data.addData.sex = '';
            state.um_data.addData.type = '';
            state.um_data.addData.password = ''; 
            state.um_data.addData.id = '';
            state.um_data.addData.index = '';
        }
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
        //饲料储量页面 -- 获取
        getFeedStore: function(content){
            axios.get(URL +'/forageStoreGet')
                .then( (response)=>{
                    if(response.status != 200){
                        alert('抱歉, 出错了!')
                    }else{
                        content.state.feedStores = response.data;
                    }
                } )
        },
        //饲料储量页面 -- 添加
        fsDetermine: content => {
            let _data = {};
            _data.type = content.state.fs_data.addData._kind;
            _data.number = content.state.fs_data.addData._num;
            _data.unit = content.state.fs_data.addData._unit;
            
            axios.post(`${URL}/forageStoreAndInfoSave`, [_data])
                .then( (response)=>{
                    if(response.data == 0){
                        content.commit('hideFsAdd');
                        alert('操作成功!')
                    }else{
                        alert('抱歉, 有错误发生!')
                    }
                } )    //逻辑上存在先后, 同步异步
                .then( ()=>{
                    //刷新页面
                    content.dispatch('getFeedStore');
                } ) 
        },
        //饲料储量页面 -- 删除
        fsDelStoreItem: (content, obj) => {
            axios.get( `${URL}/forageStoreDelete?id=${obj.id}` )
                .then( (response)=>{
                    if( response.data == 0 ){
                        content.state.feedStores.splice( obj.index, 1 );
                        alert('删除成功')
                    }else{
                        alert('未知错误')
                    }
                } )
        },
        //饲料储量页面 -- 修改   传递两个参数要用obj
        fsUpStoreItem: (content) => {
            let _data = content.state.fs_data.addData;

            axios.post(`${URL}/forageStoreUpdate`, [{
                id: _data.id,
                type: _data._kind,
                number: _data._num,
                unit: _data._unit
            }] ).then( (response)=>{
                if(response.data == 0 && response.status == 200){
                    alert('恭喜你,修改成功!');
                    //隐藏界面, 重置fs_data.addData
                    content.commit('hideFsEdit');

                    //刷新页面
                    content.dispatch('getFeedStore');
                }
            } )
        },
        //饲料属性页面 -- 获取
        frGetData: (content) =>{
            axios.get(URL + '/forageGet')
            .then( function(response){
                let _data = response.data;
                let _types = [], _units = [[],[]];
                content.state.mainData = _data;
                //设置饲料种类与对应单位
                //设置单位
                for(let i=0; i<_data.length; i++){
                    _types.push( _data[i].type );
                    _units[0].push( _data[i].type );
                    _units[1].push( _data[i].unit );
                }
                content.state.feedProvice.kind = _types;
                content.state.feedProvice.unit = _units

            } )
        },
        //饲料属性页面 -- 添加
        frDetermine: (content) => {
            let _data = {};
            _data.type = content.state.fr_data.addData.kind;
            _data.unit = content.state.fr_data.addData.unit;

            axios.post(`${URL}/forageAdd`, [_data])
                .then( (response)=>{
                    if(response.data == 0 && response.status == 200){
                        content.commit('hideFrAdd');
                        alert('操作成功!')
                    }else{
                        alert('抱歉, 有错误发生!')
                    }
                } )    //逻辑上存在先后, 同步异步
                .then( ()=>{
                    //刷新页面
                    content.state.fr_data.addData.kind = '';
                    content.state.fr_data.addData.unit = '';
                    content.dispatch('frGetData');
                } ) 
        },
        //饲料属性页面 -- 删除
        frDelStoreItem: (content, obj) => {
            axios.get( `${URL}/forageDelete?id=${obj.id}` )
                .then( (response)=>{
                    if( response.data == 0 ){
                        content.state.mainData.splice( obj.index, 1 );
                        alert('删除成功')
                        content.dispatch('frGetData');
                    }else{
                        alert('未知错误')
                    }
                } )
        },
        //饲料属性页面 -- 修改
        frUpStoreItem: (content) => {
            let _data = content.state.fr_data.addData;
            axios.post(`${URL}/forageUpdate`, [{
                id: _data.id,
                type: _data.kind,
                unit: _data.unit
            }] ).then( (response)=>{
                if(response.data == 0 && response.status == 200){
                    alert('恭喜你,修改成功!');
                    //隐藏界面, 重置fs_data.addData
                    content.commit('hideFrEdit');
                    //刷新页面
                    content.dispatch('frGetData');
                }
            } )
        },
        //用户信息页面 -- 获取
        umGetData: content => {              
            axios.get(URL + '/userGet')
                .then( (response)=>{
                    if(response.status != 200){
                        alert('抱歉, 错误了!')
                    }else{
                        let _uArr = content.state.um_data.um_users;
                        for(let i=0; i<response.data.length; i++){
                            if(_uArr.length < response.data.length)
                                _uArr.push( {name: '', sex: '', usr: '', pass: '', id: ''} );
                            _uArr[i].name = response.data[i].name;
                            _uArr[i].sex = response.data[i].sex;
                            _uArr[i].usr = response.data[i].type;
                            _uArr[i].pass = response.data[i].password;
                            _uArr[i].id = response.data[i].id;
                        }
                    }
                } )
        },
        //用户信息页面 -- 添加
        umDetermine: content => {
            let _data = {};
            _data.name = content.state.um_data.addData.name;
            _data.sex = content.state.um_data.addData.sex;
            _data.type = content.state.um_data.addData.usr;
            _data.password = content.state.um_data.addData.pass;

            axios.post(`${URL}/userAdd`, [_data])
                .then( (response)=>{
                    if(response.data == 0){
                        content.commit('hideUmAdd');
                        content.dispatch('setProvice');
                        alert('操作成功!')
                    }else{
                        alert('抱歉, 有错误发生!')
                    }
                } )    //逻辑上存在先后, 同步异步
                .then( ()=>{
                    //刷新页面
                    content.dispatch('umGetData');
                } ) 
        },
        //用户信息页面 -- 删除
        umDelStoreItem: (content, obj) => {
            let _do = window.confirm('确定删除吗?');
            if(_do){
               axios.get( `${URL}/userDelete?id=${obj.id}` )
                .then( (response)=>{
                    if( response.data == 0 ){
                        content.state.um_data.um_users.splice( obj.index, 1 );
                        alert('删除成功')
                        content.dispatch('setProvice');
                    }else{
                        alert('未知错误')
                    }
                } ) 
            }else{}           
        },
        //用户信息页面 -- 修改
        umUpStoreItem: (content) => {
            let _data = content.state.um_data.addData;

            axios.post(`${URL}/userUpdate`, [ _data ] )
                .then( (response)=>{
                if(response.data == 0 && response.status == 200){
                    alert('恭喜你,修改成功!');
                    content.commit('hideUmEdit');
                    //刷新页面
                    content.dispatch('umGetData');
                    content.dispatch('setProvice');
                }
            } )
        },
        //设置发放人员
        setProvice: (content)=>{
            axios.get(URL + '/userGet')
            .then( (response)=>{
                if(response.status != 200){
                    alert('抱歉, 出错了!')
                }else{
                    content.state.proviceWho = response.data.filter((item)=>item.type.length === 4 ? item.name : '');
                }
            } )
        }
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
                    that.$store.dispatch('umGetData');
                    break;

                case '/feedStore':
                    that.$store.dispatch('getFeedStore');
                    break;
                default: 
                    break;
            }
        }
    },
    //初始化,请求饲料属性页面数据
    beforeCreate(){
        let that = this;

        this.$store.dispatch('frGetData');
        this.$store.dispatch('setProvice');
    }
}).$mount('#app')

}