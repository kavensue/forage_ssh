<template>
    <div id="form-div">
        <form id="form_problem">
            <input type="radio" name="feedProblem" value="1"/>
            <label>1号饲料室    饲料不足</label>
            <br/>
            <input type="radio" name="feedProblem" value="2"/>
            <label>1号饲料室    饲料质量有问题</label>
            <br/>
            <input type="radio" name="feedProblem" value="3"/>
            <label>2号饲料室    饲料不足</label>
            <br/>
            <input type="radio" name="feedProblem" value="4"/>
            <label>2号饲料室    饲料质量有问题</label>
            <br/>
            <input type="radio" name="feedProblem" value="5"/>
            <label>1号猪舍 猪食欲不振</label>
            <br/>
            <input type="radio" name="feedProblem" value="6"/>
            <label>1号猪舍 猪感冒了</label>
            <br/>
            <input type="radio" name="feedProblem" value="7"/>
            <label>1号猪舍 猪发烧了</label>
            <br/>
            <input type="radio" name="feedProblem" value="8"/>
            <label>2号猪舍 猪食欲不振</label>
            <br/>
            <input type="radio" name="feedProblem" value="9"/>
            <label>2号猪舍 猪感冒了</label>
            <br/>
            <input type="radio" name="feedProblem" value="10"/>
            <label>2号猪舍 猪发烧了</label>
            <br/>
            <label>备注</label><input type="text" name="note"/>
            <br/>
            <button id="btn-submit" type="button" class="btn-submit" onclick="problemSave()">提交</button>
        </form>
    </div>
</template>
<script>
    export default{
        name: 'problem'
    }
</script>