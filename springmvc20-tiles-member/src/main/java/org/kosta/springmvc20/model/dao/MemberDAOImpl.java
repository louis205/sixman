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
	public MemberVO findMemberById(String id){
		return template.selectOne("member.findMemberById",id);
	}
	@Override
	public List<String> getAddressList(){
		return template.selectList("member.getAddressList");
	}
	@Override
	public List<MemberVO> findMemberListByAddress(String address){
		return template.selectList("member.findMemberListByAddress",address);
	}
	@Override
	public MemberVO login(MemberVO memberVO){
		return template.selectOne("member.login",memberVO);
	}
	@Override
	public int getMemberCount(){
		return template.selectOne("member.getMemberCount");
	}
	@Override
	public void updateMember(MemberVO vo) {
		template.update("member.updateMember",vo);			
	}	
	@Override
	public void registerMember(MemberVO vo) {
		template.insert("member.registerMember",vo);			
	}
	@Override
	public int idcheck(String id) {
		return template.selectOne("member.idcheck",id);				
	}
}



















