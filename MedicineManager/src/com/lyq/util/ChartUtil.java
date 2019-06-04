package com.lyq.util;

import java.awt.Font;
import java.text.NumberFormat;
import java.util.List;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;
/**
 * 自定义制图工具类，用于生成制图对象
 * @author Li Yong Qiang
 */
public class ChartUtil {
	/**
	 * 根据List集合创建一个饼形图
	 * @param list List集合
	 * @return JFreeChart对象
	 */
	public JFreeChart categoryChart(List list){
		JFreeChart chart = null;
		if(list != null && list.size() > 0){
			// 创建饼形图的数据集合
			DefaultPieDataset dataset = new DefaultPieDataset();
			// 向数据集合中添加数据
			for (int i = 0; i < list.size(); i++) {
				Object[] objs = (Object[])list.get(i);
				dataset.setValue(objs[0].toString(), (Number)objs[1]);
			}
			chart = ChartFactory.createPieChart3D(
					"药品类别统计", 	// 图表的标题
					dataset, 			// 饼形图的数据集对象
					true, 				// 是否显示图例
					true, 				// 是否显示提示文本
					false); 				// 是否生成超链接
			//设置标题字体
			chart.getTitle().setFont(new Font("隶书",Font.BOLD,25));
			//设置图例类别字体
			chart.getLegend().setItemFont(new Font("宋体",Font.BOLD,15));
			// 获得绘图区对象
			PiePlot plot = (PiePlot) chart.getPlot(); 
			plot.setForegroundAlpha(0.5f); 	// 设置前景透明度
			// 设置分类标签的字体
			plot.setLabelFont(new Font("宋体",Font.PLAIN,12));
			plot.setCircular(true); 	// 设置饼形为正圆
			// 设置分类标签的格式
			plot.setLabelGenerator(new StandardPieSectionLabelGenerator("{0}={2}",
					NumberFormat.getNumberInstance(),
					NumberFormat.getPercentInstance()));
		}
		return chart;
	}
}
