
package com.devzb.framework.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {
	private final static SimpleDateFormat	sdfYear	= new SimpleDateFormat("yyyy");
	private final static SimpleDateFormat	sdfDay	= new SimpleDateFormat("yyyy-MM-dd");
	private final static SimpleDateFormat	sdfDays	= new SimpleDateFormat("yyyyMMdd");
	private final static SimpleDateFormat	sdfTime	= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	/**
	 * 获取YYYY格式
	 * 
	 * @return
	 */
	public static String getYear() {
		return sdfYear.format(new Date());
	}

	/**
	 * 获取YYYY-MM-DD格式
	 * 
	 * @return
	 */
	public static String getDay() {
		return sdfDay.format(new Date());
	}

	/**
	 * 获取YYYYMMDD格式
	 * 
	 * @return
	 */
	public static String getDays() {
		return sdfDays.format(new Date());
	}

	/**
	 * 获取YYYY-MM-DD hh:mm:ss格式
	 * 
	 * @return
	 */
	public static String getTime() {
		return sdfTime.format(new Date());
	}

	public static String getTime(Date date) {
		return sdfTime.format(date);
	}

	/**
	 * 转换时间为：N小时/分钟/周/月/年之前
	 * 
	 * @param paramData
	 * @return string
	 */
	public static String convertDataTime(Date paramData) {
		if (paramData != null) {
			Date nowDate = new Date();
			// 时间差转换
			long between = (nowDate.getTime() - paramData.getTime()) / 1000;
			long year = between / (365 * 24 * 3600);
			long month = between / (30 * 24 * 3600);
			long week = between / (7 * 24 * 3600);
			long day = between / (24 * 3600);
			long hour = between / 3600;
			long minute = between / 60;
			if (year > 0) {
				return year + "年以前";
			} else if (month > 0) {
				return month + "月以前";
			} else if (week > 0) {
				return week + "周以前";
			} else if (day > 0) {
				return day + "天以前";
			} else if (hour > 0) {
				return hour + "小时以前";
			} else if (minute > 0) {
				return minute + "分钟以前";
			} else {
				return between + "秒以前";
			}
		}
		return null;
	}

	/***
	 * 在当前日期上增加天数
	 * 
	 * @param day
	 * @return
	 */
	public static Calendar getAddDaysForCalendar(int day) {
		Calendar cal = Calendar.getInstance();
		// 在当前时间上增加day天
		cal.add(Calendar.DATE, day);
		return cal;
	}

	/**
	 * 获得当前日期几点的时间
	 * 
	 * @param hour
	 * @return
	 */
	public static Date getTimeForHour(int hour) {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.HOUR_OF_DAY, hour);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		return cal.getTime();
	}
}
