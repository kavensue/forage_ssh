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