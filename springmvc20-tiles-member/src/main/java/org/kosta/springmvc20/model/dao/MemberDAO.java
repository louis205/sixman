package org.kosta.springmvc20.model.dao;

import java.util.List;

import org.kosta.springmvc20.model.vo.MemberVO;

/**
 * 야호야호
 * @author Administrator
 *
 */


public interface MemberDAO {

	
	List<String> getAddressList();

	List<MemberVO> findMemberListByAddress(String address);

	MemberVO loginForm(MemberVO vo);

	int getMemberCount();

	void updateMember(MemberVO vo);

	void registerMember(MemberVO vo);

	int idcheck(String id);

}