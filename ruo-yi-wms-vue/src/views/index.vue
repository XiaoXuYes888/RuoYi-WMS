<template xmlns="http://www.w3.org/1999/html">
  <div class="home-wrapper">
    <el-row class="pl20 pr20 pb20 pt20" :gutter="10">
      <el-col :span="12">
        <el-card shadow="always" style="padding-bottom: 20px;font-size: 14px" >
          <div slot="header">
            <span style="font-size: large;font-weight: bold">光艺仓储管理系统介绍</span>
          </div>
          <div style="display: flex;align-items: center">
            <div class="first" style="font-size:20px;line-height: 50px;">
              光艺仓储管理系统介绍，光艺仓储管理系统介绍！！！！！！！！<br>
              光艺仓储管理系统介绍，光艺仓储管理系统介绍！！！！！！！！
            </div>
          </div>
        </el-card>
      </el-col>
      <el-col :span="12">
        <el-card style="font-size: 14px">
          <div slot="header">
            <span style="font-size: large;font-weight: bold">通知公告</span>
          </div>
          <div>
            <div style="font-size:20px;line-height: 50px;">
              <div>
                <span style="font-size: large;font-weight: bold">2024年12月中下旬交论文初稿</span>
              </div>
              <div>
                <span style="font-size: large;font-weight: bold">2025年毕业答辩</span>
              </div>
            </div>
          </div>

        </el-card>

      </el-col>
    </el-row>

    <el-row class="pl20 pr20" :gutter="10">
      <el-col :span="12">
        <el-card shadow="always" style="padding-bottom: 20px;">
          <div>
            <el-row :gutter="40" class="panel-group">
              <el-col :xs="12" :sm="12" :lg="8" class="card-panel-col">
                <div class="card-panel" @click="handleGo('/warehouse')">
                  <div class="card-panel-icon-wrapper icon-message">
                    <svg-icon icon-class="table" class-name="card-panel-icon" />
                  </div>
                  <div class="card-panel-description">
                    <div class="card-panel-text">
                      仓库
                    </div>
                    <count-to :start-val="0" :end-val="warehouseList.length" :duration="3000" class="card-panel-num" />
                  </div>
                </div>
              </el-col>
              <el-col :xs="12" :sm="12" :lg="8" class="card-panel-col">
                <div class="card-panel" @click="handleGo('/relation/supplier')">
                  <div class="card-panel-icon-wrapper icon-people">
                    <svg-icon icon-class="peoples" class-name="card-panel-icon" />
                  </div>
                  <div class="card-panel-description">
                    <div class="card-panel-text">
                      供应商
                    </div>
                    <count-to :start-val="0" :end-val="supplierList.length" :duration="2600" class="card-panel-num" />
                  </div>
                </div>
              </el-col>
              <el-col :xs="12" :sm="12" :lg="8" class="card-panel-col">
                <div class="card-panel" @click="handleGo('/relation/carrier')">
                  <div class="card-panel-icon-wrapper icon-people">
                    <svg-icon icon-class="guide" class-name="card-panel-icon" />
                  </div>
                  <div class="card-panel-description">
                    <div class="card-panel-text">
                      承运商
                    </div>
                    <count-to :start-val="0" :end-val="carrierList.length" :duration="2600" class="card-panel-num" />
                  </div>
                </div>
              </el-col>
              <el-col :xs="12" :sm="12" :lg="8" class="card-panel-col">
                <div class="card-panel" @click="handleGo('/relation/customer')">
                  <div class="card-panel-icon-wrapper icon-message">
                    <svg-icon icon-class="star" class-name="card-panel-icon" />
                  </div>
                  <div class="card-panel-description">
                    <div class="card-panel-text">
                      客户
                    </div>
                    <count-to :start-val="0" :end-val="customerList.length" :duration="3000" class="card-panel-num" />
                  </div>
                </div>
              </el-col>
              <el-col :xs="12" :sm="12" :lg="8" class="card-panel-col">
                <div class="card-panel" @click="goAnchor('warn')">
                  <div class="card-panel-icon-wrapper icon-money">
                    <svg-icon icon-class="eye-open" class-name="card-panel-icon" />
                  </div>
                  <div class="card-panel-description">
                    <div class="card-panel-text">
                      预警
                    </div>
                    <count-to :start-val="0" :end-val="totalWarn" :duration="3200" class="card-panel-num" />
                  </div>
                </div>
              </el-col>
              <el-col :xs="12" :sm="12" :lg="8" class="card-panel-col">
                <div class="card-panel" @click="goAnchor('expiry')">
                  <div class="card-panel-icon-wrapper icon-money">
                    <svg-icon icon-class="bug" class-name="card-panel-icon" />
                  </div>
                  <div class="card-panel-description">
                    <div class="card-panel-text">
                      过期
                    </div>
                    <count-to :start-val="0" :end-val="totalExpiry" :duration="3200" class="card-panel-num" />
                  </div>
                </div> 
              </el-col>
            </el-row>
          </div>
        </el-card>
        <el-card shadow="always" style="padding-bottom: 20px; font-size: 14px;margin-top: 20px;margin-bottom: 20px;">
          <div slot="header" ref="warn"><span>预警</span></div>
          <WmsTable v-loading="loading" :data="warnList">
            <el-table-column align="left" label="编号" prop="id" width="72"></el-table-column>
            <el-table-column align="left" label="物料" prop="itemName">
              <template v-slot="{ row }"><span style="color:red">{{ row.itemName }}</span></template>
            </el-table-column>
            <el-table-column align="left" label="编码" prop="itemNo"></el-table-column>
            <el-table-column align="left" label="仓库/库区">
              <template v-slot="{ row }"><span v-if="row.warehouseName">{{ row.warehouseName }}</span><span
                  v-if="row.areaName">/{{ row.areaName }}</span></template>
            </el-table-column>
            <el-table-column align="left" label="当前库存">
              <template v-slot="{ row }"><span style="color:red;font-weight: bold;">{{ row.quantity }}</span></template>
            </el-table-column>
            <el-table-column align="left" label="安全库存" prop="saftyQuantity"></el-table-column>
          </WmsTable>

          <pagination v-show="totalWarn > 0" :total="totalWarn" :page.sync="queryWarnParams.pageNum"
            :limit.sync="queryWarnParams.pageSize" @pagination="getWarnList" :autoScroll="ifScroll" />
        </el-card>
        <el-card shadow="always" style="padding-bottom: 20px;font-size: 14px;margin-bottom: 20px;" >
          <div slot="header">
            <span style="font-size: large;font-weight: bold">光艺校园招聘</span>
          </div>
          <div style="display: flex;align-items: center">
            <div class="first" style="font-size:20px;line-height: 50px;">
              要求：对广州理工学院有一定的认知。并且有一定的空余时间。<br>
              全职、兼职、实习都可。<br>
            </div>
          </div>
        </el-card>
        <el-card shadow="always" style="padding-bottom: 20px;font-size: 14px;margin-bottom: 20px;" >
          <div slot="header">
            <span style="font-size: large;font-weight: bold">光艺广理特招</span>
          </div>
          <div style="display: flex;align-items: center">
            <div class="first" style="font-size:20px;line-height: 50px;">
              前端开发  1k  软件测试 1k <br>
              要求：只要广州理工人才,别的不要 <br>
            </div>
          </div>
        </el-card>
      </el-col>
      <el-col :span="12">
        <el-card style="padding-bottom: 20px; font-size: 14px">
          <div slot="header"><span>我的毕业设计/论文日记</span></div>
          <el-timeline>
            <el-timeline-item placement="top" timestamp="2024-09-20">
              <el-card>
                <h4>毕设论文选题未通过重新选题中......</h4>
              </el-card>
            </el-timeline-item>
            <el-timeline-item placement="top" timestamp="2024-09-30">
              <el-card>
                <h4>基于Spring Boot光艺仓储管理系统选题审核通过！！！！</h4>
              </el-card>
            </el-timeline-item>
            <el-timeline-item placement="top" timestamp="2024-10-20">
              <el-card>
                <h4>修改开题报告。。。。。。。。。。。。。。。</h4>
              </el-card>
            </el-timeline-item>
            <el-timeline-item placement="top" timestamp="2024-11-01">
              <el-card>
                <h4>指导老师指导毕业论文。。。。。。。。。。。</h4>
              </el-card>
            </el-timeline-item>
            <el-timeline-item placement="top" timestamp="2024-12-10">
              <el-card>
                <h4>毕业论文初稿完成百分之40.。。。。。。。。。。。。</h4>
              </el-card>
            </el-timeline-item>
            <el-timeline-item placement="top" timestamp="2024-12-19">
              <el-card>
                <h4>论文初稿还剩一点当前时间凌晨两点四十二分！！！！！</h4>
              </el-card>
            </el-timeline-item>
            <el-timeline-item placement="top" timestamp="2024">
              <el-card>
                <h4>11111111111111</h4>
              </el-card>
            </el-timeline-item>
          </el-timeline>
        </el-card>
        <el-card style="padding-bottom: 20px; font-size: 14px;margin-top: 20px;">
          <div slot="header" ref="expiry"><span>过期物料</span></div>
          <WmsTable v-loading="loading" :data="expiryList">
            <el-table-column label="编号" align="center" prop="itemNo" v-if="columns[0].visible" />
            <el-table-column label="名称" align="center" prop="itemName" v-if="columns[1].visible">
              <template slot-scope="scope">
                <span style="color:red;">{{ scope.row.itemName }}</span>
              </template>
            </el-table-column>
            <el-table-column label="分类" align="center" prop="itemTypeName" v-if="columns[2].visible" />
            <el-table-column label="单位类别" align="center" prop="unit" v-if="columns[3].visible" />
            <el-table-column label="所属仓库" align="center" prop="warehouseName" v-if="columns[6].visible" />
            <el-table-column label="所属库区" align="center" prop="areaName" v-if="columns[5].visible" />
            <el-table-column label="所属货架" align="center" prop="rackName" v-if="columns[4].visible" />
            <el-table-column label="安全库存" align="center" prop="quantity" v-if="columns[7].visible" />
            <el-table-column label="有效期" align="center" prop="expiryDate" width="180" v-if="columns[8].visible">
              <template slot-scope="scope">
                <span style="color:red;font-weight: bold;">{{ parseTime(scope.row.expiryDate, '{yyyy}-{mm}-{dd}')
                }}</span>
              </template>
            </el-table-column>
            <el-table-column label="备注" align="center" prop="remark" v-if="columns[9].visible" />
          </WmsTable>
          <pagination v-show="totalExpiry > 0" :total="totalExpiry" :page.sync="queryExpiryParams.pageNum"
            :limit.sync="queryExpiryParams.pageSize" @pagination="getExpiryList" :autoScroll="ifScroll" />
        </el-card>
      </el-col>
    </el-row>
  </div>
</template>

<script>
import PanelGroup from '@/views/components/PanelGroup'
import { mapGetters } from 'vuex'
import CountTo from "vue-count-to"
import { listWarnInventory } from "@/api/wms/inventory";
import { listExpiryItem } from "@/api/wms/item";

export default {
  components: {
    PanelGroup,
    CountTo
  },
  data() {
    return {
      tableData: [{
        date: '1',
        name: '应急',
        address: '20'
      }],
      nowTime: '',
      hello: '',
      warnList: [],
      expiryList: [],
      queryWarnParams: {
        pageNum: 1,
        pageSize: 10
      },
      queryExpiryParams: {
        pageNum: 1,
        pageSize: 10
      },
      //预警条数
      totalWarn: 0,
      totalExpiry: 0,
      columns: [
        { key: 1, label: "编号", visible: true },
        { key: 2, label: "名称", visible: true },
        { key: 3, label: "分类", visible: true },
        { key: 4, label: "单位类别", visible: true },
        { key: 5, label: "所属货架", visible: false },
        { key: 6, label: "所属库区", visible: true },
        { key: 7, label: "所属仓库", visible: true },
        { key: 8, label: "安全库存", visible: true },
        { key: 9, label: "有效期", visible: true },
        { key: 11, label: "备注", visible: false },
      ],
      ifScroll: false
    }
  },
  computed: {
    ...mapGetters([
      'avatar',
      'name',
      "areaList",
      "warehouseList",
      "supplierList",
      "customerList",
      "carrierList",
      "warehouseMap",
      "areaMap"
    ])
  },
  created() {
    this.showTimes()
    this.helloTimes()
    this.getWarnList()
    this.getExpiryList()
  },
  methods: {
    getWarnList() {
      this.loading = true;
      const { pageNum, pageSize } = this.queryWarnParams;
      const pageReq = { page: pageNum - 1, size: pageSize }
      listWarnInventory(pageReq).then((response) => {
        const { content, totalElements } = response
        this.warnList = content;
        this.totalWarn = totalElements;
        this.loading = false;
      });
    },
    getExpiryList() {
      this.loading = true;
      const { pageNum, pageSize } = this.queryExpiryParams;
      const pageReq = { page: pageNum - 1, size: pageSize }
      listExpiryItem(pageReq).then((response) => {
        const { content, totalElements } = response
        content.forEach((item) => {
          item.warehouseName = this.warehouseMap.get(item.warehouseId);
        });
        content.forEach((item) => {
          item.areaName = this.areaMap.get(item.areaId);
        });
        this.expiryList = content;
        this.totalExpiry = totalElements;
        this.loading = false;
      });
    },
    timeFormate(timeStamp) {
      let year = new Date(timeStamp).getFullYear()
      let month =
        new Date(timeStamp).getMonth() + 1 < 10
          ? '0' + (new Date(timeStamp).getMonth() + 1)
          : new Date(timeStamp).getMonth() + 1
      let date =
        new Date(timeStamp).getDate() < 10
          ? '0' + new Date(timeStamp).getDate()
          : new Date(timeStamp).getDate()
      let hh =
        new Date(timeStamp).getHours() < 10
          ? '0' + new Date(timeStamp).getHours()
          : new Date(timeStamp).getHours()
      let mm =
        new Date(timeStamp).getMinutes() < 10
          ? '0' + new Date(timeStamp).getMinutes()
          : new Date(timeStamp).getMinutes()
      let ss =
        new Date(timeStamp).getSeconds() < 10
          ? '0' + new Date(timeStamp).getSeconds()
          : new Date(timeStamp).getSeconds()
      let week = new Date(timeStamp).getDay()
      let weeks = ['日', '一', '二', '三', '四', '五', '六']
      let getWeek = '星期' + weeks[week]
      this.nowTime =
        year +
        '年' +
        month +
        '月' +
        date +
        '日' +
        ' ' +

        getWeek
    },
    showTimes() {
      this.timeFormate(new Date())

    },
    helloTimes() {
      let hh = new Date().getHours()
      if (0 < hh && hh < 12) {
        this.hello = '上午好'
      } else if (hh < 18) {
        this.hello = '下午好'
      } else {
        this.hello = '晚上好'
      }
    },
    handleGo(path) {
      this.$router.push(path)
    },
    goAnchor(elementName) {
      this.$refs[elementName].scrollIntoView({
        behavior: "smooth",  // 平滑过渡
        block: "start"  	// 上边框与视窗顶部平齐。默认值
      });
    }
  }
}
</script>

<style scoped lang="stylus">
.home-wrapper

  .li {
    float: left;
    width: 25%;
    font-size: 12px;
    color: rgb(185, 181, 189);
  }

  .da {
    float: left;
    width: 25%;
    font-size: 20px;
  }

  .first {
    display: flex;
    margin-bottom: 20px;
    align-items: center;
  }

  .el-table .warning-row {
    background: rgb(39, 138, 230);
  }
  .panel-group {
    margin-top: 18px;

    .card-panel-col {
      margin-bottom: 32px;
    }

    .card-panel {
      height: 108px;
      cursor: pointer;
      font-size: 12px;
      position: relative;
      overflow: hidden;
      color: #666;
      background: #fff;
      box-shadow: 4px 4px 40px rgba(0, 0, 0, .05);
      border-color: rgba(0, 0, 0, .05);

      &:hover {
        .card-panel-icon-wrapper {
          color: #fff;
        }

        .icon-people {
          background: #40c9c6;
        }

        .icon-message {
          background: #36a3f7;
        }

        .icon-money {
          background: #f4516c;
        }
      }

      .icon-people {
        color: #40c9c6;
      }

      .icon-message {
        color: #36a3f7;
      }

      .icon-money {
        color: #f4516c;
      }

      .card-panel-icon-wrapper {
        float: left;
        margin: 14px 0 0 14px;
        padding: 16px;
        transition: all 0.38s ease-out;
        border-radius: 6px;
      }

      .card-panel-icon {
        float: left;
        font-size: 48px;
      }

      .card-panel-description {
        float: right;
        font-weight: bold;
        margin: 26px;
        margin-left: 0px;

        .card-panel-text {
          line-height: 18px;
          color: rgba(0, 0, 0, 0.45);
          font-size: 16px;
          margin-bottom: 12px;
        }

        .card-panel-num {
          font-size: 20px;
        }
      }
    }
  }

  @media (max-width:550px) {
    .card-panel-description {
      display: none;
    }

    .card-panel-icon-wrapper {
      float: none !important;
      width: 100%;
      height: 100%;
      margin: 0 !important;

      .svg-icon {
        display: block;
        margin: 14px auto !important;
        float: none !important;
      }
    }
  }
</style>
