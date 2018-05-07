//饲养员界面路由模板
const t_problem = {
    template: `
<div>
<div class="p-container"> 
    <el-dropdown class="drop-warpper">
        <span class="el-dropdown-link">
            {{$store.state.title}}<i class="el-icon-arrow-down el-icon--right"></i>
        </span>
        <el-dropdown-menu slot="dropdown">
            <el-dropdown-item v-for="(item, index) in $store.state.problemSpace"
             @click.native="$store.commit('changeSpace',index)" :key="index">{{item}}</el-dropdown-item>
        </el-dropdown-menu>
    </el-dropdown>
    <el-dropdown class="drop-warpper">
        <span class="el-dropdown-link">
            {{$store.state.p_Dis}}<i class="el-icon-arrow-down el-icon--right"></i>
        </span>
        <el-dropdown-menu slot="dropdown">
            <el-dropdown-item v-for="(item, index) in $store.state.dis_problems" 
            @click.native="$store.commit('problemDis', index)" :key="index">{{item}}</el-dropdown-item>
        </el-dropdown-menu>
    </el-dropdown>
    <input type="text" name="note" placeholder="备注" id="p-note" v-model="$store.state.alias" />
    <button id="btn-submit" type="button" class="btn-submit" 
     @click="$store.dispatch('subProblem')">提交</button>
</div>
</div>
    `
};

const t_foragegain = {
    template: `
<div>
<div class="f-container">
    <div class="f-container-head">
        <span>编号</span><span>饲料种类</span><span>数量</span><span>单位</span><span>操作</span>
    </div>
    <div class="f-container-body" v-for="(item, id) in $store.state.getFeeds">
        <span class="t-item">{{id + 1}}</span>
        <span class="t-item">
            <el-dropdown class="drop-warpper">
                <span class="el-dropdown-link">
                    {{$store.state.getKind}}<i class="el-icon-arrow-down el-icon--right"></i>
                </span>
                <el-dropdown-menu slot="dropdown">
                    <el-dropdown-item v-for="(item, index) in $store.state.getKinds" :key="index"
                    @click.native="$store.commit('selectKind', {index,id})">{{item}}</el-dropdown-item>
                </el-dropdown-menu>
            </el-dropdown>
        </span>
        <input type="text" class="t-item" value="" v-model="item.number"/>
        <input type="text" class="t-item" v-model="item.unit"/>
        <div>
            <span class="t-item-do t-item-do-r" @click="$store.commit('delItem', {index,id})">-</span>
            <span class="t-item-do" @click="$store.commit('addItem')">+</span>
        </div>
    </div>
    <div class="f-container-btns">
        <button @click="$store.commit('clearAll')">清空</button>
        <button @click="$store.dispatch('subFeedData')">提交</button>
    </div>
</div>
</div>
    `
};
const t_feedtask = {
    template: `
<div>
<div class="t-container">
    <div class="t-container-head">
        <span class="t-item">编号</span>
        <span class="t-item">喂食地点</span>
        <span class="t-item">喂食对象</span>
        <span class="t-item">操作</span>
    </div>
    <div class="t-container-body" v-for="(item, id) in $store.state.subFeedObj" :key="id">
        <span class="t-item">1</span>
        <span class="t-item">
            <el-dropdown class="drop-warpper">
                <span class="el-dropdown-link">
                    {{$store.state.feedPlace}}<i class="el-icon-arrow-down el-icon--right"></i>
                </span>
                <el-dropdown-menu slot="dropdown">
                    <el-dropdown-item v-for="(item, index) in $store.state.feedPlaces"
                     @click.native="$store.commit('selectPlace', {index, id})"
                     :key="index">{{item}}
                     </el-dropdown-item>
                </el-dropdown-menu>
            </el-dropdown>
        </span>
        <span class="t-item">
            <el-dropdown class="drop-warpper">
                <span class="el-dropdown-link">
                    {{$store.state.feedObj}}<i class="el-icon-arrow-down el-icon--right"></i>
                </span>
                <el-dropdown-menu slot="dropdown">
                    <el-dropdown-item v-for="(item, index) in $store.state.feedObjs" 
                     @click.native="$store.commit('selectObj', {index, id})" 
                     :key="index">{{item}}</el-dropdown-item>
                </el-dropdown-menu>
            </el-dropdown>
        </span>
        <span class="t-item-do t-item-do-r" @click="$store.commit('delPlace', id)">-</span>
        <span class="t-item-do" @click="$store.commit('addPlace')">+</span>
    </div>
    <div class="t-container-btns">
        <button @click="$store.commit('clearPlace')">清空</button>
        <button @click="$store.dispatch('subTask')">提交</button>
    </div>
</div>
</div>
`
}