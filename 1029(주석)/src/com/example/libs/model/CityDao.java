package com.example.libs.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


//view - Service(Controller) - DAO(Model) - DB
public class CityDao {
	public static ArrayList<String> getCountryCode() throws SQLException {
		//resultset을 가져와서 arrayList에 담아서
		DBConnection dbconn = new DBConnection();
		Connection conn = dbconn.getConnection();		//2, 3step
		Statement stmt = conn.createStatement();		//4step : Statement생성
		String sql = "SELECT DISTINCT Code FROM Country ORDER BY Code";
		ResultSet rs = stmt.executeQuery(sql);		//5step		//SELECT이므로 executeQuery()
		ArrayList<String> list = new ArrayList<String>();		//기본적으로 방 10개 생성.
		//방 채우기
		while(rs.next()) {		//6step		//next몇번 돌 지 모르므로 while 사용
			String code = rs.getString("code");
			list.add(code);
		}
		
		DBClose.close(conn, stmt, rs);		//7step.
		return list;
	}

	public static ArrayList<CityVO> getCityList(String code) throws SQLException {
		DBConnection dbconn = new DBConnection();
		Connection conn = dbconn.getConnection();		//2,3 step
		String sql = "SELECT * FROM City WHERE Countrycode = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);		//4step	//아직도 불완전한 SQL문!
		pstmt.setString(1, code); 		//비로소 완전한 SQL문!
		pstmt.executeQuery(); 	//SELECT이므로 executeQuery()사용
		ResultSet rs = pstmt.executeQuery();		//5step
		
		ArrayList<CityVO> list = new ArrayList<CityVO>();
		while(rs.next()) {
			int id = rs.getInt("id");			//칼럼의 이름은 대소문자 구분 X  //값은 대소문자 구분 O  ex)사원의 이름 값 : MIKE
			String name = rs.getString("name");
			String countrycode = rs.getString("countrycode");
			String district = rs.getString("district");
			int population = rs.getInt("population");
			CityVO city = new CityVO(id, name, countrycode, district, population);
			list.add(city);
		}
		DBClose.close(conn, pstmt, rs);		//7step
		return list;
	}
}
