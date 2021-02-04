package com.apeces.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apeces.dao.AddressDao;
import com.apeces.domain.Address;
import com.apeces.service.AddressService;

@Service
public class AddressServiceImpl implements AddressService {
	@Autowired
	AddressDao addressDao;
	
	@Override
	public List<List<?>> queryAddrByUser(Map<String, Object> param){
		return addressDao.queryAddrByUser(param);
	}
	
	@Override
	public Address queryAddr(int id){
		return addressDao.queryAddr(id);
	}

	@Override
	public int insertAddr(Address address){
		return addressDao.insertAddr(address);
	}

	@Override
	public int updateAddr(Address address){
		return addressDao.updateAddr(address);
	}

	@Override
	public int delAddr(int id){
		return addressDao.delAddr(id);
	}
}
