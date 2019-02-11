package com.goodhouse.contract.model;

import java.util.*;

public interface ContractDAO_interface {
	public void insert(ContractVO conVO);
	public void update(ContractVO conVO);
	public void delete(String conId);
	public ContractVO findByPrimaryKey(String conId);
	public List<ContractVO> getAll();
	
	
}