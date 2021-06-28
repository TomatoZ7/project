package com.apeces.dao;

import java.util.List;
import java.util.Map;

import com.apeces.domain.Address;

public interface AddressDao {
	List<List<?>> queryAddrByUser(Map<String, Object> param);
	
	Address queryAddr(int id);
	
	int insertAddr(Address address);
	
	int updateAddr(Address address);
	
	int delAddr(int id);
}
