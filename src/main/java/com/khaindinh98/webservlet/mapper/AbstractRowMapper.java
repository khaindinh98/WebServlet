package com.khaindinh98.webservlet.mapper;

import com.khaindinh98.webservlet.model.AbstractModel;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Logger;

public abstract class AbstractRowMapper<T extends AbstractModel>{

	private Logger logger = Logger.getLogger(AbstractRowMapper.class.toString());

	public abstract T mapping(ResultSet resultSet);

	protected T mappingDefaultFields(ResultSet resultSet, T model) throws SQLException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {

		if(model == null) {
			if(model.getClass()!=null && model.getClass().getConstructor()!=null) {
				model = (T) model.getClass().getConstructor().newInstance();
			}
		}
		Field[] fields =  model.getClass().getFields();
		logger.info("------Fields:");
		for(Field field:fields){
			logger.info("------"+field.getName());
		}
		model.setId(resultSet.getLong("id"));
		if(resultSet.getTimestamp("created_at")!=null) {
			model.setCreatedAt(resultSet.getTimestamp("created_at").toLocalDateTime());
		}
		model.setCreatedBy(resultSet.getString("created_by"));
		if(resultSet.getTimestamp("modified_at")!=null) {
			model.setModifiedAt(resultSet.getTimestamp("modified_at").toLocalDateTime());
		}
		model.setModifiedBy(resultSet.getString("modified_by"));
		return model;
	}
}
