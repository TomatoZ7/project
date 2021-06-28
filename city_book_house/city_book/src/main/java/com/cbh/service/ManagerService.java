package com.cbh.service;

import java.util.List;
import java.util.Map;

import com.cbh.domain.Manager;

public interface ManagerService {
	// �������������mapper�в�һ�����������Ӧ@Param("����") ע�����У�����磺@Param("id") int Managerid
	List<List<?>> getManagerList(Map param);
	
	Manager getManagerById(int id);
    
    int delManagerById(int id);
    
    int updateManager(Manager Manager);

    int insertManager(Manager Manager);
    
    int countManager();
    
    Manager getManagerByLogin(Manager manager);
    
    int updateManagerBatch(Map<?,?> param);
}
