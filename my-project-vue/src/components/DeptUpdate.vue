<template>
  <div>
    <el-form :model="ruleForm" :rules="rules" ref="ruleForm" label-width="100px" class="demo-ruleForm">
      <el-form-item label="编号" prop="deptno">
        <el-input v-model="ruleForm.deptno" readonly></el-input>
      </el-form-item>
      <el-form-item label="部门名称" prop="dname">
        <el-input v-model="ruleForm.dname"></el-input>
      </el-form-item>
      <el-form-item label="地址" prop="loc">
        <el-input v-model="ruleForm.loc"></el-input>
      </el-form-item>

      <el-form-item>
        <el-button type="primary" @click="submitForm('ruleForm')">修改</el-button>
        <el-button @click="resetForm('ruleForm')">重置</el-button>
      </el-form-item>
    </el-form>

  </div>
</template>
<script>
  export default {
    data() {
      return {
        ruleForm: {
          deptno:'',
          dname: '',
          loc: ''
        },
        rules: {
          dname: [
            { required: true, message: '请输入部门名称', trigger: 'blur' },
            { min: 3, max: 5, message: '长度在 3 到 5 个字符', trigger: 'blur' }
          ],
          loc: [
            { required: true, message: '请输入部门地址', trigger: 'blur' },
            { min: 3, max: 5, message: '长度在 3 到 5 个字符', trigger: 'blur' }
          ]
        }
      };
    },
    methods: {
      submitForm(formName) {
        this.$refs[formName].validate((valid) => {
          if (valid) {
            this.$http.put("http://localhost:8081/dept/update",this.ruleForm).then(resp=>{
              // console.log(this.ruleForm);
              if(resp.data=="success"){
                this.$alert('修改成功', '消息', {
                  confirmButtonText: '确定',
                  callback: action => {
                    this.$router.push("/DeptManager");
                  }
                });
              }
            })
          } else {
            console.log('error submit!!');
            return false;
          }
        });
      },
      resetForm(formName) {
        this.$refs[formName].resetFields();
      }
    },
    created() {
      // console.log(this.$route.query.deptno);
      this.$http.get("http://localhost:8081/dept/findById/"+this.$route.query.deptno).then(res=>{
        this.ruleForm=res.data;
      })
    }
  }
</script>
