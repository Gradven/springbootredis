package com.gradven.springboot.redis.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

public class Paging<T> implements Serializable {
	private static final long serialVersionUID = 1464694386266977339L;

	private int count;
	private Collection<T> rows = new ArrayList();

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public Collection<T> getRows() {
		return rows;
	}

	public void setRows(Collection<T> rows) {
		this.rows = rows;
	}
}
