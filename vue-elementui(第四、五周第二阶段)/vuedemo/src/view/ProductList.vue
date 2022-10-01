<template>
  <div>
  <h2>商品管理</h2>
  <div class="head">
    <el-row :gutter="20">
      <el-col :span="6"><el-input v-model="productsInfo.productName" placeholder="商品名称"></el-input></el-col>
      <el-col :span="6"><el-input v-model="productsInfo.productDescribe" placeholder="商品简介"></el-input></el-col>
      <el-col :span="6"><el-input v-model="productsInfo.productPrice" placeholder="商品价格"></el-input></el-col>
      <el-col :span="6"><el-input v-model="productsInfo.productNum" placeholder="商品库存"></el-input></el-col>
    </el-row>
    <el-button type="primary" class="btn-add" @click="addProduct">添加商品</el-button>
  </div>
  <div class="body">
    <el-table
          :data="tableData.slice((currentPage - 1) * pageSize, currentPage * pageSize)"
          style="width: 100%">
          <el-table-column

            label="序号"
            width="180">
             filter-placement="bottom-end">
                  <template slot-scope="scope">
                   {{scope.$index+1}}
                  </template>
          </el-table-column>
          <el-table-column
            prop="productName"
            label="商品名称"
            width="180">
          </el-table-column>
          <el-table-column
            prop="productDescribe"
            label="商品简介">
          </el-table-column>
          <el-table-column
            prop="productPrice"
            label="商品价格(元)">

          </el-table-column>
          <el-table-column
             prop="productNum"
             label="商品库存(个)">
           </el-table-column>
           <el-table-column
              label="操作">
              <template slot-scope="scope">

                <el-button type="primary" icon="el-icon-edit" circle @click="editProduct(scope.row,scope.$index)"></el-button>
                <el-button type="danger" icon="el-icon-delete" circle @click="delProduct(scope.$index)"></el-button>
                </template>
            </el-table-column>

        </el-table>
  </div>
  <!-- 商品修改弹框 -->
  <el-dialog
    title="商品信息修改"
    :visible.sync="dialogVisible"
    width="30%"
    :before-close="handleClose">
    <div>
      <el-form ref="form" :model="editInfo" label-width="80px">
        <el-form-item label="商品名称">
          <el-input v-model="editInfo.productName"></el-input>
        </el-form-item>
        <el-form-item label="商品描述">
          <el-input v-model="editInfo.productDescribe"></el-input>
        </el-form-item>
        <el-form-item label="价格">
          <el-input v-model="editInfo.productPrice"></el-input>
        </el-form-item>
        <el-form-item label="商品数量">
          <el-input v-model="editInfo.productNum"></el-input>
        </el-form-item>

      </el-form>
    </div>
    <span slot="footer" class="dialog-footer">
      <el-button @click="dialogVisible = false">取 消</el-button>
      <el-button type="primary" @click="confirm">确 定</el-button>
    </span>
  </el-dialog>
  <el-pagination
          @size-change="handleSizeChange"
          @current-change="handleCurrentChange"
          :current-page="currentPage"
          :page-sizes="[10, 20, 30, 40]"
          :page-size="10"
          layout="total, sizes, prev, pager, next, jumper"
           :total="tableData.length">
        </el-pagination>
  </div>
</template>

<script>
  export default {
    name: 'productList',
   data() {
       return {

         productsInfo:{
           // 添加的商品信息
           productName:'',
           productDescribe:'',
           productPrice:'',
           productNum:''
         },

          tableData: [
            {
              productName:'商品一',
              productDescribe:'商品描述（1）',
              productPrice:'99',
              productNum:'10000'
            }
          ],
          //当前页码
          currentPage:1,
          //每页显示的行数
          pageSize: 10,
          // total:this.tableData.length,
          dialogVisible:false,//弹窗的显示，
          // 商品索引
          productIndex:0,
          editInfo:{
            // 添加的商品信息
            productName:'',
            productDescribe:'',
            productPrice:'',
            productNum:''
          }
       }

     },

    methods: {
      //添加商品
      addProduct(){
        this.tableData.push(this.productsInfo);
        //添加完成后清空输入框

        this.productsInfo={
          productName:'',
          productDescribe:'',
          productPrice:'',
          productNum:''
        };


      },
      delProduct(idx){


                this.$confirm('确认删除？')
                  .then(_ => {
                     this.tableData.splice(idx,1);
                  })
                  .catch(_ => {});
              },
      // 编辑商品信息
      editProduct(item,idx){
        this.productIndex=idx;
        this.editInfo={
          productName:item.productName,
          productDescribe:item.productDescribe,
          productPrice:item.productPrice,
          productNum:item.productNum

        };
        console.log(item);
        this.dialogVisible=true;
      },
      // 关闭窗口
      handleClose(){
      this.dialogVisible=false;
      },
      confirm(){
        this.dialogVisible=false;
        //这种方法不能监听数组的改变
        // this.tableData[productIndex]=this.editInfo;
        this.$set(this.tableData,this.productIndex,this.editInfo)
      },
      //页面切换
      handleCurrentChange(val) {
          this.currentPage = val;
        }

    }
  }
</script>

<style scoped>
  .head{
    width:1024px;
    margin:0 auto;
  }

  .body{
    width:1024px;
    margin:0 auto;
    margin-top: 20px;
  }
  .btn-add{
      width: 100%;
      margin: 20px;
  }
  .el-row {
      margin-bottom: 20px;
      &:last-child {
        margin-bottom: 0;
      }
    }
    .el-col {
      border-radius: 4px;
    }
    .bg-purple-dark {
      background: #99a9bf;
    }
    .bg-purple {
      background: #d3dce6;
    }
    .bg-purple-light {
      background: #e5e9f2;
    }
    .grid-content {
      border-radius: 4px;
      min-height: 36px;
    }
    .row-bg {
      padding: 10px 0;
      background-color: #f9fafc;
    }
</style>
