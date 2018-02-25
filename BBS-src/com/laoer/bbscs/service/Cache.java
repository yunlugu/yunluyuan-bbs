package com.laoer.bbscs.service;

public interface Cache {

	/**
	 *
	 * @param key
	 * @param value
	 */
	public void add(Object key, Object value);

	/**
	 *
	 * @param key
	 * @return
	 */
	public Object get(Object key);

	/**
	 *
	 * @param key
	 */
	public void remove(Object key);

	/**
	 *
	 *
	 */
	public void removeAll();

}
