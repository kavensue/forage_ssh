//管理员界面路由模板
//
//饲料属性
const feedReserve = {
    template: `
<div>
<div id="table-wrapper">
    <div class="table-header">
        <span class="i-width">编号</span><span class="i-width">种类</span><span class="i-width">单位</span><span class="l-width"></span>
    </div>
    <div class="table-main" v-for="item in $store.state.mainData">
        <span  class="i-width">{{item.id}}</span><span contenteditable class="i-width">{{item.type}}</span><span class="i-width">{{item.unit}}</span>
        <span class="l-width"><button class="edit-btn">确定</button><button class="del-btn">删除</button></span>
    </div>
</div>
</div>
`}

//饲料发放
const feedProvice = {
    template: `
<div>
<div id="fp-container">
    <div class="fp-head">
        <label for="select-p">发放给</label>
        <input type="text" class="fp-select feeder-input" v-model="$store.state.fp_data.name" placeholder="选择" list="select-lists"/>
        <datalist id="select-lists">
            <option v-for="item in $store.state.proviceWho" :value="item" />
        </datalist>
    </div>
    <div class="fp-table-wrap">
        <div class="fp-table-header">
            <span class="i-width">编号</span><span class="i-width">饲料种类</span><span class="i-width">数量</span><span class="i-width">单位</span>
            <span class="i-width">操作</span>
        </div>
        <div class="fp-table-item" v-for="item,index in $store.state.fp_data.lists">
            <span class="i-width">{{ index+1 }}</span>
            <input type="text" class="i-width k-input" list="kind-list" v-model="item.kind"/>
            <datalist id="kind-list">
                <option v-for="item in $store.state.feedProvice.kind" :value="item" />
            </datalist>
            <input type="text" class="i-width n-input" v-model="item.num" />
            <input type="text" class="i-width u-input" list="unit-kinds" v-model="item.unit" />
            <datalist id="unit-kinds">
                <option v-for="item in $store.state.feedProvice.unit" :value="item" />
            </datalist>
            <i class="fp-del-btn" @click="$store.commit('delList', item)"></i>
            <i class="fp-add-btn" @click="$store.commit('addList')"></i>
        </div>
    </div>
    <div class="fp-btns-wrap">
        <button class="fp-clear-btn" @click="$store.commit('clearList')">清空</button>
        <button class="fp-submit-btn" @click="$store.dispatch('fpSubData')">提交</button>
    </div>
</div>
</div>
`}

//饲料储量
const feedStore = {
    template: `
<div>
    <div id="fs-table-wraper">
        <div class="fs-table-head">
            <span class="fs-table-item">编号</span>
            <span class="fs-table-item">名称</span>
            <span class="fs-table-item">数量</span>
            <span class="fs-table-item">单位</span>
            <span class="fs-table-item">删除</span>
        </div>
        <div class="fs-table-contain" v-for="(item,index) in $store.state.feedStores">
            <span class="fs-table-item">{{ index+1 }}</span>
            <span class="fs-table-item">{{ item.kind }}</span>
            <span class="fs-table-item">{{ item.num }}</span>
            <span class="fs-table-item">{{ item.unit }}</span>
            <span class="fs-table-del" @click="$store.dispatch('fsDelStoreItem', index)"></span>
        </div>
        <div class="fs-add-btn">
            <button @click="$store.commit('showFsAdd')">添加</button>
        </div>
    </div>
    <div class="fs-add-window" v-if="$store.state.fs_show">
        <input type="text" list="name-lists" id="fs-input-kind" v-model="$store.state.fs_data.addData._kind"/>
            <datalist id="name-lists">
                <option  v-for="item in $store.state.feedProvice.kind" :value="item" />
            </datalist>
        <input type="text" id="fs-input-num" v-model="$store.state.fs_data.addData._num" />
        <input type="text" list="fs-unit-lists" id="fs-input-unit" v-model="$store.state.fs_data.addData._unit" />
            <datalist id="fs-unit-lists">
                <option v-for="item in $store.state.feedProvice.unit" :value="item" />
            </datalist>
        <button @click="$store.commit('hideFsAdd')">取消</button>
        <button class="fs-add-sure" @click="$store.dispatch('fsDetermine')" >确定</button>
    </div>
</div>
`}
//用户信息
const userMes = {
    template: `
<div>
    <div class="um-wrapper">
        <div class="um-table-head um-table">
            <span class="um-head-item">编号</span>
            <span class="um-head-item">姓名</span>
            <span class="um-head-item">性别</span>
            <span class="um-head-item">身份</span>
            <span class="um-head-pass">密码</span>
        </div>
        <div class="um-table-main um-table" v-for="( item,index ) in $store.state.um_data.um_users">
            <span class="um-head-item">{{ index+1 }}</span>
            <span class="um-head-item">{{ item.name }}</span>
            <span class="um-head-item">{{ item.sex }}</span>
            <span class="um-head-item">{{ item.usr }}</span>
            <span class="um-head-pass">{{ item.pass }}</span>
        </div>
    </div>
</div>
`}
