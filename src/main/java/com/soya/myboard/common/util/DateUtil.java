package com.soya.myboard.common.util;


import com.soya.myboard.common.vo.DateVO;
import org.apache.commons.lang3.StringUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class DateUtil {
    /**
     * 데이터 이전 _시작일자
     */
    public final static String MAX_DATE = "99991231";
    /**
     * 데이터 이전_종료일자
     */
    public final static String MIN_DATE = "20000101";

    public static String nowYYYY() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy");
        return formatter.format(new Date());
    }

    public static String nowYYYYMM() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMM");
        return formatter.format(new Date());
    }

    public static String nowYYYYMMDD() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
        return formatter.format(new Date());
    }

    public static String nowMMDD() {
        SimpleDateFormat formatter = new SimpleDateFormat("MMdd");
        return formatter.format(new Date());
    }

    public static String nowYYYYMMDDHH24MMDD() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
        return formatter.format(new Date());
    }

    public static String nowHHMM() {
        SimpleDateFormat formatter = new SimpleDateFormat("HHmm");
        return formatter.format(new Date());
    }

    /**
     * 요일 String date -> 요일 구하기
     *
     * @param date
     * @return
     */
    public static String nowStrDay(String date) {
        String day = "";
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
        Date nDate = null;
        try {
            nDate = dateFormat.parse(date);
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        Calendar cal = Calendar.getInstance();
        cal.setTime(nDate);

        int dayNum = cal.get(Calendar.DAY_OF_WEEK);

        switch (dayNum) {
            case 1:
                day = "일";
                break;
            case 2:
                day = "월";
                break;
            case 3:
                day = "화";
                break;
            case 4:
                day = "수";
                break;
            case 5:
                day = "목";
                break;
            case 6:
                day = "금";
                break;
            case 7:
                day = "토";
                break;
        }
        return day;
    }

    /**
     * 날짜 더하고 빼기
     *
     * @param yyyymmdd 날짜
     * @param days     이동할 일수
     * @return String 타입 리턴
     * @throws ParseException
     */
    public static String addDate(String yyyymmdd, Integer days) {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        Date current = null;
        try {
            current = sdf.parse(yyyymmdd);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Calendar cal = Calendar.getInstance();
        cal.setTime(current);

        cal.add(Calendar.DATE, days);
        String strdate = sdf.format(cal.getTime());
        return strdate;
    }

    public static List<DateVO> arrageDate(String startdate, String enddate) {

        List<DateVO> list = new ArrayList<>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        Date sdate = null;

        try {
            sdate = sdf.parse(startdate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        DateVO dateVO = DateVO
                .builder()
                .cdate(startdate)
                .year(startdate.substring(0, 4))
                .month(startdate.substring(4, 6))
                .day(startdate.substring(6, 8))
                .wday(nowStrDay(startdate))
                .build();
        list.add(dateVO);
        Calendar cal = Calendar.getInstance();
        cal.setTime(sdate);

        while (true) {

            cal.add(Calendar.DATE, 1);
            String current = sdf.format(cal.getTime());
            String wday = nowStrDay(current);

            if (Integer.parseInt(current) > Integer.parseInt(enddate)) {
                break;
            } else {
                list.add(
                        DateVO.builder()
                                .cdate(current)
                                .year(current.substring(0, 4))
                                .month(current.substring(4, 6))
                                .day(current.substring(6, 8))
                                .wday(nowStrDay(current))
                                .build()
                );
            }

        }

        return list;
    }

    /**
     * 20160405162447 -> 2016-04-05
     *
     * @param date
     * @return
     */
    public static String formatDate(String date, String spliter) {
        String formatStr = "";
        if (StringUtils.isNotEmpty(date)) {
            if (date.length() == 14) {

                String year = date.substring(0, 4);
                String month = date.substring(4, 6);
                String day = date.substring(6, 8);

                formatStr += year + spliter + month + spliter + day;

                return formatStr;
            } else if (date.length() == 8) {

                String year = date.substring(0, 4);
                String month = date.substring(4, 6);
                String day = date.substring(6, 8);

                formatStr += year + spliter + month + spliter + day;

                return formatStr;
            } else {
                return date;
            }
        }
        return "";
    }

}
