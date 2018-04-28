//饲养员界面路由模板
const t_problem = {
    template: `
<div>
<div class="p-container"> 
    <el-dropdown class="drop-warpper">
        <span class="el-dropdown-link">
            问题地点<i class="el-icon-arrow-down el-icon--right"></i>
        </span>
        <el-dropdown-menu slot="dropdown">
            <el-dropdown-item>1号猪舍</el-dropdown-item>
            <el-dropdown-item>2号猪舍</el-dropdown-item>
            <el-dropdown-item>1号饲料室</el-dropdown-item>
            <el-dropdown-item>2号饲料室</el-dropdown-item>
        </el-dropdown-menu>
    </el-dropdown>
    <el-dropdown class="drop-warpper">
        <span class="el-dropdown-link">
            问题描述<i class="el-icon-arrow-down el-icon--right"></i>
        </span>
        <el-dropdown-menu slot="dropdown">
            <el-dropdown-item @click="test">饲料不足</el-dropdown-item>
            <el-dropdown-item>饲料质量有问题</el-dropdown-item>
            <el-dropdown-item>猪食欲不振</el-dropdown-item>
            <el-dropdown-item>猪发烧了</el-dropdown-item>
            <el-dropdown-item>猪感冒了</el-dropdown-item>
        </el-dropdown-menu>
    </el-dropdown>
    <input type="text" name="note" placeholder="备注" id="p-note"/>
    <button id="btn-submit" type="button" class="btn-submit" onclick="test">提交</button>
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
    <div class="f-container-body">
        <span class="t-item">1</span>
        <span class="t-item">
            <el-dropdown class="drop-warpper">
                <span class="el-dropdown-link">
                    饲料种类<i class="el-icon-arrow-down el-icon--right"></i>
                </span>
                <el-dropdown-menu slot="dropdown">
                    <el-dropdown-item @click="test">大猪料</el-dropdown-item>
                    <el-dropdown-item>小猪料</el-dropdown-item>
                </el-dropdown-menu>
            </el-dropdown>
        </span>
        <input type="text" class="t-item" value="" />
        <input type="text" class="t-item" />
        <div>
            <span class="t-item-do t-item-do-r">-</span>
            <span class="t-item-do">+</span>
        </div>
    </div>
    <div class="f-container-btns">
        <button>清空</button>
        <button>提交</button>
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
    <div class="t-container-body">
        <span class="t-item">1</span>
        <span class="t-item">
            <el-dropdown class="drop-warpper">
                <span class="el-dropdown-link">
                    喂食地点<i class="el-icon-arrow-down el-icon--right"></i>
                </span>
                <el-dropdown-menu slot="dropdown">
                    <el-dropdown-item @click="test">1号猪舍</el-dropdown-item>
                    <el-dropdown-item>2号猪舍</el-dropdown-item>
                </el-dropdown-menu>
            </el-dropdown>
        </span>
        <span class="t-item">
            <el-dropdown class="drop-warpper">
                <span class="el-dropdown-link">
                    喂食对象<i class="el-icon-arrow-down el-icon--right"></i>
                </span>
                <el-dropdown-menu slot="dropdown">
                    <el-dropdown-item @click="test">大猪</el-dropdown-item>
                    <el-dropdown-item>小猪</el-dropdown-item>
                </el-dropdown-menu>
            </el-dropdown>
        </span>
        <span class="t-item-do t-item-do-r">-</span>
        <span class="t-item-do">+</span>
    </div>
    <div class="t-container-btns">
        <button>清空</button>
        <button>提交</button>
    </div>
</div>
</div>
`
}