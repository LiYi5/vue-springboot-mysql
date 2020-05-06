<template>
  <div>
  <el-table
    :data="tableData"
    border
    style="width: 100%">
    <el-table-column
      fixed
      prop="deptno"
      label="编号"
      width="330">
    </el-table-column>
    <el-table-column
      prop="dname"
      label="部门"
      width="300">
    </el-table-column>
    <el-table-column
      prop="loc"
      label="地址"
      width="300">
    </el-table-column>

    <el-table-column
      fixed="right"
      label="操作"
      width="280">
      <template slot-scope="scope">
        <el-button @click="edit(scope.row)" type="text" size="small">修改</el-button>
        <el-button @click="remove(scope.row)" type="text" size="small">删除</el-button>
      </template>
    </el-table-column>
  </el-table>
<!--    分页-->
  <el-pagination
  background
  layout="prev, pager, next"
  :page-size="pageSize"
  :total="total"
  @current-change="page">
</el-pagination>
</div>
</template>

<script>
  export default {
    methods: {
      edit(row) {
        console.log(row);
        this.$router.push({
          path:"/update",
          query:{
            deptno:row.deptno
          }
        });

      },
      remove(row) {
        console.log(row.deptno);
        this.$http.delete("http://localhost:8081/dept/delete/"+row.deptno).then(resp=>{
            this.$alert('删除成功', '消息', {
              confirmButtonText: '确定',
              callback: action => {
                window.location.reload();
              }
            });


        })
      },
      page(currentpage){
        this.$http.get("http://localhost:8081/dept/findAll/"+(currentpage-1)+"/6").then(resp=>{
          console.log(resp);
          this.tableData=resp.data.content;
          this.pageSize=resp.data.size;
          this.total=resp.data.totalElements;
        })
      }
    },

    data() {
      return {
        pageSize: 1,
        total:11,
        tableData: [{
          deptno: '001',
          dname: '王小虎',
          loc: '上海'
        }, {
          deptno: '002',
          dname: '王小虎',
          loc: '上海'
        },{
          deptno: '003',
          dname: '王小虎',
          loc: '上海'
        }]
      }
    },created() {
      this.$http("http://localhost:8081/dept/findAll/0/6").then(resp=>{
        this.tableData=resp.data.content;
        this.pageSize=resp.data.size;
        this.total=resp.data.totalElements;

      })
    }
  }
</script>
