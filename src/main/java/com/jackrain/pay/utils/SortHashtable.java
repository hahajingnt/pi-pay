package com.jackrain.pay.utils;

import java.util.*;

public class SortHashtable {

    /**
     * 方法名称：getSortedHashtable
     * 参数：Hashtable h 引入被处理的散列表
     * 描述：将引入的hashtable.entrySet进行排序，并返回
     */
    public static Map.Entry[] getSortedHashtableByKey(Hashtable h) {

        Set set = h.entrySet();

        Map.Entry[] entries = (Map.Entry[]) set.toArray(new Map.Entry[set.size()]);

        Arrays.sort(entries, new Comparator() {
            @Override
            public int compare(Object arg0, Object arg1) {
                Object key1 = ((Map.Entry) arg0).getKey();
                Object key2 = ((Map.Entry) arg1).getKey();
                return ((Comparable) key1).compareTo(key2);
            }

        });

        return entries;
    }

    /**
     * 方法名称：getSortedHashtable
     * 参数：Hashtable h 引入被处理的散列表
     * 描述：将引入的hashtable.entrySet进行排序，并返回
     */
    public static Map.Entry[] getSortedHashtableByValue(Hashtable h) {
        Set set = h.entrySet();
        Map.Entry[] entries = (Map.Entry[]) set.toArray(new Map.Entry[set
                .size()]);

        Arrays.sort(entries, new Comparator() {
            @Override
            public int compare(Object arg0, Object arg1) {
                Object key1 = ((Map.Entry) arg0).getValue();
                Object key2 = ((Map.Entry) arg1).getValue();
                return ((Comparable) key1).compareTo(key2);
            }
        });

        return entries;
    }

    /**
     * value排序，截掉第一位，转换成int排序
     * 比如：a1,a2,a3...a10
     * @param h
     * @return
     */
    public static Map.Entry[] getSortedHashtableByValueInt(Hashtable h) {
        Set set = h.entrySet();
        Map.Entry[] entries = (Map.Entry[]) set.toArray(new Map.Entry[set
                .size()]);

        Arrays.sort(entries, new Comparator() {
            @Override
            public int compare(Object arg0, Object arg1) {
                int key1 = Integer.parseInt(((Map.Entry) arg0).getValue()
	            .toString().substring(1));
	            int key2 = Integer.parseInt(((Map.Entry) arg1).getValue()
	            .toString().substring(1));
	        return ((Comparable) key1).compareTo(key2);
            }
        });

        return entries;
    }


//    /**
//     * @param args
//     */
//    public static void main(String[] args) {
//        Hashtable t = new Hashtable();
//
//        t.put("10-11 02:45德利城VS德罗赫达联队", "a1");
//        t.put("sadfasdf福德城VS谢尔伯恩", "a12");
//        t.put("fd国民队VS托拉卡", "a3");
//        t.put("10-11 01:00巴西VS厄瓜多尔", "a2");
//
//
//        Map.Entry[] set = getSortedHashtableByValueInt(t);
//
//        // perportyTable
//        for (int i = 0; i < set.length; i++) {
//
//            System.out.println(set[i].getKey().toString());
//
//            System.out.println(set[i].getValue().toString());
//
//        }
//    }

}