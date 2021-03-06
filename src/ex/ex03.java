﻿package ex;

import java.util.*;
/*
 * Topic: 請設計 Person 類別 (姓名,性別,身高,體重)，使用者可以新增個人資料，每新增一筆就會列出目前的資料串有哪些人，而這些資料請用插入排序法依每一個人的 BMI 值由大到小排序。
 * Date: 2016/12/05
 * Author: 105021031 孟京澤
 */

public class ex03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner src = new Scanner(System.in);
		 System.out.print("輸入性名,性別,身高,體重: ");
		ArrayList<Integer> dataList = new ArrayList<Integer>();
		String str = "Y";
		int i = 0, val = 0;
		boolean flag = false;
		while (!(str.equals("N") || str.equals("n"))) {
			System.out.print("input a val: ");
			val = src.nextInt();
			if (dataList.size() == 0) {
				dataList.add(val);
			} else if (dataList.size() == 1) {
				if (dataList.get(0) > val) {
					dataList.add(val);
				} else {
					dataList.add(0, val);
				}
			} else {
				flag = true;
				i = 0;
				while (flag && i < dataList.size() - 1) {
					if (i == 0 && dataList.get(0) < val) {
						dataList.add(0, val);
						flag = false;
					} else {
						if (dataList.get(i) < val && dataList.get(i + 1) <= val) {
							flag = false;
							dataList.add(i + 1, val);
						} else {
							i++;
						}
					}
				}
			}
			showListData(dataList);
			System.out.print("Continue?: ");
			str = src.next();
		}
	}
	private static void showListData(ArrayList list) {
		// TODO Auto-generated method stub
		int size = list.size();
		for (int i = 0; i < size; i++) {
			System.out.print(list.get(i) + "\t");
		}
		System.out.println(" ");
	}
}