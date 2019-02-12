package com.goodhouse.article_clasiflcation.model;

import java.util.*;

public interface ArticleClasicicationDAO_interface {

	public void insert(ArticleClasicicationVO articleClasicicationVO);
	public void update(ArticleClasicicationVO articleClasicicationVO);
	public void delete(String article_cla_id);
	public ArticleClasicicationVO findByPrimaryKey(String article_cla_id);
	public List<ArticleClasicicationVO> getAll();

}
