<template>
  <el-main style="height: 90vh;">
    <!-- <div id="title">
      数据统计
    </div> -->
    <hr>

    <!-- 图表和统计卡片的布局 -->
    <div style="display: flex; justify-content: space-between; flex-wrap: wrap; gap: 20px;height: 100%;">

      <!-- 图表区域：左侧 -->
      <div style="flex: 1; min-width: 600px; display: flex; flex-direction: column; gap: 20px;margin-top: 100px;">
        <!-- 饼图 -->
        <div id="main2" style="height: 400px; width: 100%;"></div>

        <!-- 折线图 -->
        <div id="main1" style="height: 400px; width: 100%;"></div>
      </div>

      <!-- 统计卡片区域：右侧 -->
      <div style="flex: 1; min-width: 300px; height: 100%; display: flex; flex-direction: column; gap: 20px;">
        <!-- 四个统计卡片：上部 -->
        <div style="display: flex; justify-content: space-between; gap: 20px;">
          <!-- 读者总数 -->
          <el-card :style="cardStyle('#4CAF50')" class="stat-card">
            <div class="card-content">
              <div class="show-num">{{ readerCount }}</div>
              <span class="bottom-text-no">读者总数</span>
            </div>
          </el-card>

          <!-- 读者待审核 -->
          <el-card :style="cardStyle('#4CAF50')" class="stat-card">
            <div class="card-content">
              <div class="show-num">{{ applyReader }}</div>
              <div class="bottom-text-no">读者待审核</div>
            </div>
          </el-card>

          <!-- 借书待审核 -->
          <el-card :style="cardStyle('#4CAF50')" class="stat-card">
            <div class="card-content">
              <div class="show-num">{{ borrowApplyCount }}</div>
              <div class="bottom-text-no">借书待审核</div>
            </div>
          </el-card>

          <!-- 期待还书 -->
          <el-card :style="cardStyle('#4CAF50')" class="stat-card">
            <div class="card-content">
              <div class="show-num">{{ borrowReturnCount }}</div>
              <div class="bottom-text-no">期待还书</div>
            </div>
          </el-card>
        </div>

        <!-- 公告列表：下部 -->
        <el-card class="box-card" style="flex: 1; margin-top: 20px;">
          <div slot="header" class="announcement">
            <span style="color: #000000; font-weight: 600">系统公告</span>
          </div>
          <div v-for="o in noticeList" :key="o.noticeId" class="text item">
            <span style="font-weight:600;font-size:14px;">{{ o.noticeTitle }}</span>
            <span style="margin-left:30px;font-size:14px">{{ o.noticeContent }}</span>
            <span style="float: right;font-size:14px">{{ o.createTime }}</span>
            <el-divider></el-divider>
          </div>
        </el-card>
      </div>
    </div>
  </el-main>
</template>

<script>
import { getUserType, getUserId } from '@/utils/auth'
import { getReaderCountApi, getApplyReaderCountApi } from '@/api/reader'
import { getBorrowApplyCountApi, getBorrowReturnCountApi } from '@/api/borrow'
import { categoryCountApi } from '@/api/category'
import { getHotBookApi } from '@/api/book'
import { getTopListApi } from '@/api/notice'

export default {
  name: 'Dashboard',
  data() {
    return {
      readerCount: 0,
      applyReader: 0,
      borrowApplyCount: 0,
      borrowReturnCount: 0,
      noticeList: [],
    }
  },
  mounted() {
    this.myechert1()
    this.myechert2()
    this.getReaderCount()
    this.getApplyReaderCount()
    this.getBorrowApplyCount()
    this.getBorrowReturnCount()
    this.getNoticeList()
  },
  methods: {
    async getNoticeList() {
      let res = await getTopListApi()
      if (res && res.code == 200) {
        this.noticeList = res.data
      }
    },
    async getReaderCount() {
      let res = await getReaderCountApi()
      if (res && res.code == 200) {
        this.readerCount = res.data
      }
    },
    async getApplyReaderCount() {
      let res = await getApplyReaderCountApi()
      if (res && res.code == 200) {
        this.applyReader = res.data
      }
    },
    async getBorrowApplyCount() {
      let res = await getBorrowApplyCountApi({
        userType: getUserType(),
        userId: getUserId()
      })
      if (res && res.code == 200) {
        this.borrowApplyCount = res.data
      }
    },
    async getBorrowReturnCount() {
      let res = await getBorrowReturnCountApi({
        userType: getUserType(),
        userId: getUserId()
      })
      if (res && res.code == 200) {
        this.borrowReturnCount = res.data
      }
    },
    async myechert1() {
      var myChart = this.$echarts.init(document.getElementById('main1'))
      var option = {
        title: { text: '图书分类统计' },
        xAxis: {
          data: [],
          axisLabel: { show: true, interval: 0, formatter: (params) => this.wrapText(params) }
        },
        yAxis: {},
        series: [{ name: '数量', type: 'line', data: [] }]
      }
      let res = await categoryCountApi()
      if (res && res.code == 200) {
        option.xAxis.data = res.data.names
        option.series[0].data = res.data.counts
      }
      myChart.setOption(option)
    },
    wrapText(params) {
      let newParamsName = "";
      let paramsNameNumber = params.length;
      let provideNumber = 3;
      let rowNumber = Math.ceil(paramsNameNumber / provideNumber);
      if (paramsNameNumber > provideNumber) {
        for (let p = 0; p < rowNumber; p++) {
          let tempStr = "";
          let start = p * provideNumber;
          let end = start + provideNumber;
          if (p === rowNumber - 1) {
            tempStr = params.substring(start, paramsNameNumber);
          } else {
            tempStr = params.substring(start, end) + "\n";
          }
          newParamsName += tempStr;
        }
      } else {
        newParamsName = params;
      }
      return newParamsName;
    },
    async myechert2() {
      var myChart = this.$echarts.init(document.getElementById('main2'))
      var option = {
        title: { text: '热门图书排行榜', left: 'center' },
        tooltip: { trigger: 'item' },
        legend: { orient: 'vertical', left: 'left' },
        series: [{
          name: '借阅次数',
          type: 'pie',
          data: [],
          emphasis: { itemStyle: { shadowBlur: 10, shadowOffsetX: 0, shadowColor: 'rgba(0, 0, 0, 0.5)' } }
        }]
      }
      let res = await getHotBookApi()
      if (res && res.code == 200) {
        option.series[0].data = res.data
      }
      myChart.setOption(option)
    },
    cardStyle(color) {
      return {
        background: `linear-gradient(135deg, ${color}, #ffffff)`,
        borderRadius: '10px',
        boxShadow: '0px 4px 12px rgba(0, 0, 0, 0.1)',
        textAlign: 'center',
        padding: '20px',
        width: '23%',  // 设置宽度为 23%，使四个卡片水平排列
        marginBottom: '20px'
      }
    }
  }
}
</script>

<style lang="scss" scoped>
#title {
  height: 50px;
  font-size: 30px;
  text-align: center;
  margin-bottom: 20px;
}

.stat-card {
  margin-bottom: 20px;
}

.card-content {
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  height: 100%;
}

.show-num {
  font-size: 40px;
  font-weight: bold;
  color: #fff;
}

.bottom-text-no{
  font-size: 14px;
  color: #fff;
  margin-top: 10px;
  font-weight: 600;
}

.announcement {
  font-weight: 600;
  color: #000000;
}

.text {
  margin-bottom: 10px;
}

::v-deep .el-main {
  height: 90vh !important;
}
</style>
