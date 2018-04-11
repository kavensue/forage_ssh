//管理员界面路由模板
const feedReserve = {
    template: `
<div>
<div id="table-wrapper">
    <div class="table-header">
        <span class="i-width">编号</span><span class="i-width">种类</span><span class="i-width">单位</span><span class="l-width"></span>
    </div>
    <div class="table-main" v-for="item in $store.state.mainData">
        <span  class="i-width">{{item.num}}</span><span  class="i-width">{{item.kind}}</span><span class="i-width">{{item.unit}}</span>
        <span class="l-width"><button class="edit-btn">编辑</button><button class="del-btn">删除</button></span>
    </div>
</div>
</div>
`
}

const feedProvice = {
    template: `
<div>
<div id="fp-container">
    <div class="fp-head">
        <label for="select-p">发放给</label>
        <input type="text" class="fp-select feeder-input" placeholder="选择" list="select-lists"/>
        <datalist id="select-lists">
            <option v-for="item in $store.state.proviceWho" :value="item" />
        </datalist>
    </div>
    <div class="fp-table-wrap">
        <div class="fp-table-header">
            <span class="i-width">编号</span><span class="i-width">饲料种类</span><span class="i-width">数量</span><span class="i-width">单位</span>
            <span class="i-width">操作</span>
        </div>
        <div class="fp-table-item" v-for="item in $store.state.feedLists">
            <span class="i-width">{{item}}</span>
            <input type="text" class="i-width k-input" list="kind-list" />
            <datalist id="kind-list">
                <option v-for="item in $store.state.feedProvice.kind" :value="item" />
            </datalist>
            <input type="text" class="i-width n-input" />
            <input type="text" class="i-width u-input" list="unit-kinds" />
            <datalist id="unit-kinds">
                <option v-for="item in $store.state.feedProvice.unit" :value="item" />
            </datalist>
            <i class="fp-del-btn" @click="$store.commit('delList', item)"></i>
            <i class="fp-add-btn" @click="$store.commit('addList')"></i>
        </div>
    </div>
    <div class="fp-btns-wrap">
        <button class="fp-clear-btn" @click="$store.commit('clearList')">清空</button>
        <button class="fp-submit-btn" >提交</button>
    </div>
</div>
</div>
`
}

