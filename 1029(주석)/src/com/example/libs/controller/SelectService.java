package com.example.libs.controller;

import java.sql.SQLException;
import java.util.ArrayList;

import com.example.libs.model.CityDao;
import com.example.libs.model.CityVO;

//view - Service(Controller) - DAO(Model) - DB
public class SelectService {
	public static ArrayList getCountryCode() {			//앞에서 넘어올때 파라미터 안넘어오므로
		ArrayList<String> list = null;		
		try {
			list = CityDao.getCountryCode();		//dao에서의 메소드 호출해서 그 반환값을 list에 담음.
		} catch (SQLException ex) {	
			System.out.println(ex);
		}
		return list;			//view에게 list넘겨줌
	}

	public static ArrayList<CityVO> getCityList(String code) {
		ArrayList<CityVO> list = null;
		try {
			list = CityDao.getCityList(code);			//code 파라미터를 dao에 넘겨줌	//dao의 getCityList()의 반환값을 list에 저장.
		} catch (SQLException ex) {
			System.out.println(ex);
		}
		return list;
	}
	
}
