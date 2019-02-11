package com.goodhouse.house_track.model;

import java.util.*;

public interface HouseTrackDAO_interface {

	public void insert(HouseTrackVO houTraVO);
	public void update(HouseTrackVO houTraVO);
	public void delete(HouseTrackVO houTraVO);
	public HouseTrackVO findByPrimaryKey(String houTraId);
	public List<HouseTrackVO> getAll();
}
