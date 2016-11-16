package org.kosta.springmvc20.model.dao;

import java.util.List;

import javax.annotation.Resource;

import org.kosta.springmvc20.model.vo.MemberVO;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDAOImpl implements MemberDAO {
	@Resource	
	private SqlSessionTemplate template;

	@Override
	public List<String> getAddressList(){
		return template.selectList("member.getAddressList");
	}
	@Override
	public List<MemberVO> findMemberListByAddress(String address){
		return template.selectList("member.findMemberListByAddress",address);
	}

}



















