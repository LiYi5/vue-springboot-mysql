<template>
    <div>
        <table style=" border-collapse:collapse;">
          <tr>
            <td>编号</td>
            <td>部分名称</td>
            <td>地址</td>
          </tr>
          <tr v-for="it in depts">
            <td>{{it.deptno}}</td>
            <td>{{it.dname}}</td>
            <td>{{it.loc}}</td>
          </tr>
        </table>
    </div>
</template>

<script>
  export default {
    name: "Dept",
    data(){
      return{
        depts:[
          {
            deptno:1,
            dname:'研发部',
            loc:'北京'
          },
          {
            deptno:1,
            dname:'研发部',
            loc:'北京'
          },
          {
            deptno:2,
            dname:'人事部',
            loc:'北京'
          },
          {
            deptno:3,
            dname:'人行政部',
            loc:'北京'
          },
        ]
      }
    },
    created() {
      this.$http.get("http://localhost:8081/dept/findAll").then(resp=>{
          this.depts=resp.data;
      })
    }
  }
</script>

<style>
  table td{
    border: 1px solid;

  }
</style>
