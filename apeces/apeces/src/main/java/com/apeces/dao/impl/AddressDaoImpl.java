package com.apeces.dao.impl;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.apeces.dao.AddressDao;
import com.apeces.domain.Address;

@Component
public class AddressDaoImpl implements AddressDao {
	@Autowired
    SqlSessionTemplate ssTemplate;

	@Override
	public List<List<?>> queryAddrByUser(Map<String, Object> param){
		return ssTemplate.getMapper(AddressDao.class).queryAddrByUser(param);
	}
	
	@Override
	public Address queryAddr(int id){
		return ssTemplate.getMapper(AddressDao.class).queryAddr(id);
	}

	@Override
	public int insertAddr(Address address){
		return ssTemplate.getMapper(AddressDao.class).insertAddr(address);
	}

	@Override
	public int updateAddr(Address address){
		return ssTemplate.getMapper(AddressDao.class).updateAddr(address);
	}

	@Override
	public int delAddr(int id){
		return ssTemplate.getMapper(AddressDao.class).delAddr(id);
	}
}
