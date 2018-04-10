const t_problem = {
    template: `
<div>
    <div class="p-container">
        <input type="radio" name="feedProblem" id="feedProblem1" value="1"/>
        <label for="feedProblem1">1号饲料室    饲料不足</label>
        <input type="radio" name="feedProblem" id="feedProblem2" value="2"/>
        <label for="feedProblem2">1号饲料室    饲料质量有问题</label>
        <input type="radio" name="feedProblem" id="feedProblem3" value="3"/>
        <label for="feedProblem3">2号饲料室    饲料不足</label>
        <input type="radio" name="feedProblem" id="feedProblem4" value="4"/>
        <label for="feedProblem4">2号饲料室    饲料质量有问题</label>
        <input type="radio" name="feedProblem" id="feedProblem5" value="5"/>
        <label for="feedProblem5">1号猪舍 猪食欲不振</label>
        <input type="radio" name="feedProblem" id="feedProblem6" value="6"/>
        <label for="feedProblem6">1号猪舍 猪感冒了</label>
        <input type="radio" name="feedProblem" id="feedProblem7" value="7"/>
        <label for="feedProblem7">1号猪舍 猪发烧了</label>
        <input type="radio" name="feedProblem" id="feedProblem8" value="8"/>
        <label for="feedProblem8">2号猪舍 猪食欲不振</label>
        <input type="radio" name="feedProblem" id="feedProblem9" value="9"/>
        <label for="feedProblem9">2号猪舍 猪感冒了</label>
        <input type="radio" name="feedProblem" id="feedProblem10" value="10"/>
        <label for="feedProblem10">2号猪舍 猪发烧了</label>
        <input type="text" name="note" placeholder="备注" id="p-note"/>
        <button id="btn-submit" type="button" class="btn-submit" onclick="problemSave()">提交</button>
    </div>
</div>
    `
};
const t_foragegain = {
    template: `
    <div>
        <h4>请选择饲料领取室</h4>
        <div id="form-div">
            <form id="form-foragegain">
            <input type="radio" name="forageRoom" value="1" id="forageRoom" />
            <label for="forageRoom">1号饲料室</label>
            <br/>
            <input type="radio" name="forageRoom" value="2" id="forageRoom2" />
            <label for="forageRoom2">2号饲料室</label>
            <br/>
            <button id="btn-submit" type="button" class="btn-submit" onclick="forageGainSave()">提交</button>
            </form>
        </div>
    </div>
    `
};
const t_feedtask = {
    template: `
        <div>
        <h2 class="header">华农猪场饲料管理系统</h2>
<h3>请选择喂食地点</h3>
<div id="form-div">
    <form id="form-task">
        <div class="one-wrap">
            <span>1号猪舍</span>
            <div class="one">
                <input type="radio" name="feedTask" value="1号猪舍1号猪栏"/>
                <label>1号猪栏</label>
                <input type="radio" name="feedTask" value="1号猪舍2号猪栏"/>
                <label>2号猪栏</label>
            </div>
        </div>
        <div class="two-wrap">
            <span>2号猪舍</span>
            <div class="two">
                <input type="radio" name="feedTask" value="2号猪舍1号猪栏"/>
                <label>1号猪栏</label>
                <input type="radio" name="feedTask" value="2号猪舍2号猪栏"/>
                <label>2号猪栏</label>
            </div>
        </div>
        <button id="btn-produce" type="button" class="btn-produce" onclick="taskProduce()">生成任务</button>
    </form>
</div>
<div id="task-list">
    <ul id="feed-task"></ul>
    <button id="btn-submit" type="button" class="btn-submit" onclick="taskSubmit()">提交任务</button>
    <button id="btn-cancel" type="button" class="btn-cancel" onclick="taskCancel()">取消任务</button>
</div>
        </div>
    `
}