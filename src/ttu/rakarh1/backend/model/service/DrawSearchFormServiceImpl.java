package ttu.rakarh1.backend.model.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import ttu.rakarh1.backend.dao.DrawSearchFormDAO;
import ttu.rakarh1.backend.dao.DrawSearchFormDAOImpl;
import ttu.rakarh1.backend.dao.dbconnection;
import ttu.rakarh1.backend.model.data.DrawSearchForm;
import ttu.rakarh1.backend.model.data.FormAttribute;
import ttu.rakarh1.backend.model.data.ProductCatalog;
import ttu.rakarh1.log.MyLogger;

public class DrawSearchFormServiceImpl implements DrawSearchFormService
{

	DrawSearchFormDAO drawSearchFormDAO = null;
	ttu.rakarh1.backend.dao.dbconnection dbconnection = null;
	String sql;
	Connection db;
	Statement st;
	PreparedStatement ps;

	@Override
	public int getActionResult()
	{
		// TODO Auto-generated method stub
		return 0;
	}

	public void setDbConnection(dbconnection dbconnection)
	{
		this.dbconnection = dbconnection;
	}

	@Override
	public HashMap getErrors()
	{
		// TODO Auto-generated method stub
		return null;
	}

	public List<ttu.rakarh1.backend.model.data.FormAttribute> getAttributesForItem(
			int selected_item_type)
	{
		List<FormAttribute> formAttributes = null;
		// ProductCatalog TipOfSelectedPath = null;
		this.drawSearchFormDAO = new DrawSearchFormDAOImpl();
		dbconnection dbconnection = null;
		dbconnection = new dbconnection();
		drawSearchFormDAO.setDbConnection(dbconnection);
		// ProductCatalog ProductCatalog = null;
		formAttributes = drawSearchFormDAO.getItemFormAttributes(selected_item_type);
		dbconnection.close();
		return formAttributes;
	}

	public List<ttu.rakarh1.backend.model.data.FormAttribute> getAttributesForItem(
			int selected_item_type, int item)
	{
		List<FormAttribute> formAttributes = null;
		// ProductCatalog TipOfSelectedPath = null;
		this.drawSearchFormDAO = new DrawSearchFormDAOImpl();
		dbconnection dbconnection = null;
		dbconnection = new dbconnection();
		drawSearchFormDAO.setDbConnection(dbconnection);
		// ProductCatalog ProductCatalog = null;
		formAttributes = drawSearchFormDAO.getItemFormAttributes(selected_item_type, item);
		dbconnection.close();
		return formAttributes;
	}

}
