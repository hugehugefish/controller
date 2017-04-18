package com.example.lenovo.controller.fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.lenovo.controller.R;

import java.util.ArrayList;
import java.util.List;

import lecho.lib.hellocharts.gesture.ContainerScrollType;
import lecho.lib.hellocharts.gesture.ZoomType;
import lecho.lib.hellocharts.model.Axis;
import lecho.lib.hellocharts.model.AxisValue;
import lecho.lib.hellocharts.model.Line;
import lecho.lib.hellocharts.model.LineChartData;
import lecho.lib.hellocharts.model.PointValue;
import lecho.lib.hellocharts.model.ValueShape;
import lecho.lib.hellocharts.model.Viewport;
import lecho.lib.hellocharts.view.LineChartView;

/**
 * Created by lenovo on 2017/4/14.
 */

public class ContentTodayFragment extends android.support.v4.app.Fragment{
    private LineChartView lineChart;
    String[] date={"8-00","9-00","10-00","11-00","12-00",
            "13-00","14-00","15-00","16-00","17-00"}; //x轴的标注
    int[] temperature={10,22,30,33,10,24,22,18,19,20}; //图表的数据点
    int[] humidity={10,20,30,25,34,12,45,23,12,23}; //第二个图标的数据点
    private List<PointValue> mPointValues1;
    private List<PointValue> mPointValues2;
    private List<AxisValue> mAxisValues;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.content_today_fragment,container,false);
        lineChart=(LineChartView)view.findViewById(R.id.line_chart);
        mPointValues1=new ArrayList<PointValue>();
        mPointValues2=new ArrayList<PointValue>();
        mAxisValues=new ArrayList<AxisValue>();
        Log.d("todayFragment","onCreateView");
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        getAxisXLabels(); //获取x轴的标注
        getAxisPoints(); //获取坐标点
        initLineChart(); //初始化
        Log.d("todayFragment","onActivityCreated");
    }

    //设置x轴的显示
    private void getAxisXLabels(){
        for(int i=0;i<date.length;i++){
            mAxisValues.add(new AxisValue(i).setLabel(date[i]));
            //Log.d("x",date[i]);
        }
    }

    //图表的每个点的显示
    private void getAxisPoints(){
        for(int i=0;i<temperature.length;i++){
            mPointValues1.add(new PointValue(i,temperature[i]).setLabel(temperature[i]+"℃"));
            mPointValues2.add(new PointValue(i,humidity[i]).setLabel(humidity[i]+"%rh"));
        }
    }

    private void initLineChart(){
        List<Line> lines=new ArrayList<Line>();

        Line line=new Line(mPointValues1).setColor(R.color.khaki); //折线的颜色
        line.setShape(ValueShape.CIRCLE); //折线图上每个数据点的形状（圆形）
        line.setCubic(true); //曲线是否平滑（曲线还是折线）
        line.setStrokeWidth(2); //线条的粗细，默认是3
        line.setFilled(true); //是否填充曲线的面积
        line.setHasLabels(true); //曲线的数据坐标是否加上备注
        //line.setHasLabelsOnlyForSelected(true); //点击数据坐标提示数据，设置了这个上面那个就无效
        line.setHasLines(true); //是否用线显示。false则没有曲线只有点
        line.setHasPoints(false); //是否显示圆点。false没有圆点只有点
        lines.add(line);

        Line line2=new Line(mPointValues2).setColor(R.color.darkforestgreen);
        line2.setShape(ValueShape.CIRCLE);
        line2.setCubic(true);
        line2.setStrokeWidth(2);
        //line2.setStrokeWidth(2);
        line2.setFilled(true);
        line2.setHasLabels(true);
        //line2.setHasLabelsOnlyForSelected(true);
        line2.setHasLines(true);
        line2.setHasPoints(false);
        lines.add(line2);

        LineChartData data=new LineChartData();
        data.setLines(lines);

        //坐标轴
        Axis axisX=new Axis(); //x轴
        //axisX.setHasTiltedLabels(true); //x坐标轴字体是斜的还是直的，true是斜的
        axisX.setTextColor(Color.BLACK); //设置字体颜色
        axisX.setName("TIME"); //表格名称
        axisX.setTextSize(8); //设置字体大小
        axisX.setMaxLabelChars(7); //最多几个x轴坐标
        axisX.setValues(mAxisValues); //填充x轴的坐标名称
        data.setAxisXBottom(axisX); //x轴在底部
        //axisX.setHasLines(true); //x轴分割线

        //y轴是根据数据的大小自动设置y轴上限（也可固定y轴的数据个数）
        Axis axisY1=new Axis(); //y轴
        //axisY1.setName("温度/℃"); //y轴标注
        axisY1.setTextSize(8); //设置字体大小
        //axisY1.setTextColor(R.color.yellow);
        data.setAxisYLeft(axisY1); //y轴设置在左边

        /*
        Axis axisY2=new Axis();
        axisY2.setName("湿度/%rh");
        axisY2.setTextSize(8);
        //axisY2.setTextColor(R.color.deeppink);
        data.setAxisYRight(axisY2);
        */

        //设置行为属性，支持缩放、滑动以及平移
        lineChart.setLineChartData(data);
        lineChart.setInteractive(true);
        lineChart.setZoomType(ZoomType.HORIZONTAL_AND_VERTICAL); //缩放类型，水平
        lineChart.setMaxZoom((float)3); //缩放比例
        lineChart.setContainerScrollEnabled(true, ContainerScrollType.HORIZONTAL);
        lineChart.setLineChartData(data);
        lineChart.setVisibility(View.VISIBLE);


        Viewport v=new Viewport(lineChart.getMaximumViewport());
        v.left=0;
        v.right=6;
        lineChart.setCurrentViewport(v);

    }

}
