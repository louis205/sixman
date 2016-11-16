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

	

}