package com.cbh.dao;

import java.util.List;
import java.util.Map;

import com.cbh.domain.Manager;

public interface ManagerDao {
	// �������������mapper�в�һ�����������Ӧ@Param("����") ע�����У��
	List<List<?>> getManagerList(Map<?,?> param);
	
    Manager getManagerById(int id);
    
    int delManagerById(int id);
    
    int updateManager(Manager Manager);

    int insertManager(Manager Manager);
    
    int countManager();
    
    Manager getManagerByLogin(Manager manager);
}
