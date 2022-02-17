package kr.co.greenart.service;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.greenart.model.InflowInfo;
import kr.co.greenart.repository.YearCountDao;

@Service
public class YearCountServices implements lYearCountSerivce{
	public static int pickId;

	@Autowired
	private YearCountDao dao;
	//2022년 총 금액
	@Override
	public int totalCost(String date) {
		// TODO Auto-generated method stub
		return dao.totalCost(date);
	}
	
	//2022년 총 고객
	@Override
	public int totalmember(String date) {
		// TODO Auto-generated method stub
		return dao.totalmember(date);
	}
	
	@Override
	public int totalRound(String date) {
		// TODO Auto-generated method stub
		return dao.totalRound(date);
	}
	//2022년 총 유입수
	@Override
	public List<InflowInfo> totalInflow(String date) {
		// TODO Auto-generated method stub
		return null;
	}

	
	@Override
	public int inflowBlog(String date, String blog) {
		// TODO Auto-generated method stub
		return dao.inflowBlog(date,blog);
	}
	
	@Override
	public int inflowInstar(String date, String instar) {
		// TODO Auto-generated method stub
		return dao.inflowInstar(date,instar);
	}
	
	@Override
	public int inflowFaceBook(String date, String face) {
		return dao.inflowFaceBook(date,face);
	}
	
	@Override
	public int inflowFriend(String date, String friend) {
		return dao.inflowFriend(date, friend);
	}
	
	@Override
	public int inflowother(String date, String other) {
		// TODO Auto-generated method stub
		return dao.inflowother(date, other);
	}
	
	@Override
	public int experinceCustomer(String date, int data) {
		// TODO Auto-generated method stub
		return dao.experinceCustomer(date, data);
	}

	@Override
	public int buyCustomer(String date, int data, int dats) {
		// TODO Auto-generated method stub
		return dao.buyCustomer(date, data, dats);
	}

	@Override
	public int starinceCustomer(String date, int data) {
		// TODO Auto-generated method stub
		return dao.starinceCustomer(date, data);
	}


	
	
	
}
