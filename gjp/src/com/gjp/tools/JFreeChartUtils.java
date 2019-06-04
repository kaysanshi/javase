package com.gjp.tools;


import java.io.File;
import java.util.Map;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

public class JFreeChartUtils {
	
	public static void pie(String title, Map<String,Double> totalMap, double sum, String path) {
		DefaultPieDataset pieDataset = new DefaultPieDataset();
		for(String dataName : totalMap.keySet()) {
			double dataValue = totalMap.get(dataName);
			String bf = String.format("%.2f%%", dataValue / sum * 100);
			dataName = dataName + ":" + dataValue + "鍏�(" + bf + ")";
			pieDataset.setValue(dataName, dataValue);
		}
		JFreeChart chart = ChartFactory.createPieChart3D(title, pieDataset, true, true, false);
		
		try {
			ChartUtilities.saveChartAsJPEG(new File(path), chart, 500, 300);
		} catch(Exception e) {
			throw new RuntimeException(e);
		}
	}
}
