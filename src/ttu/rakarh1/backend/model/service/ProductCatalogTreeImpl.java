package ttu.rakarh1.backend.model.service;

import java.util.List;

import ttu.rakarh1.backend.dao.ProductCatalogDAO;
import ttu.rakarh1.backend.dao.ProductCatalogDAOImpl;
import ttu.rakarh1.backend.dao.dbconnection;
import ttu.rakarh1.backend.model.data.ProductCatalog;
import ttu.rakarh1.log.MyLogger;

public class ProductCatalogTreeImpl implements ProductCatalogTree
{

	ProductCatalogDAO ProductCatalogDAO;
	dbconnection dbconnection = null;

	public ProductCatalogTreeImpl() {
		this.ProductCatalogDAO = new ProductCatalogDAOImpl();

		dbconnection = new dbconnection();
		ProductCatalogDAO.setDbConnection(dbconnection);
	}

	public List<ttu.rakarh1.backend.model.data.ProductCatalog> getTreeWithOneOpenPath(
			int selected_catalog)
	{
		List<ttu.rakarh1.backend.model.data.ProductCatalog> CatalogList = null;
		ProductCatalog TipOfSelectedPath = null;

		ProductCatalog ProductCatalog = null;
		CatalogList = ProductCatalogDAO.getFirstlevelCatalogs();
		if (selected_catalog != 0)
		{
			ProductCatalog = ProductCatalogDAO.getCatalogByIdWithSubCatalogs(selected_catalog);
			TipOfSelectedPath = getPathCatalog(ProductCatalog);
			CatalogList = replaceOneChild(CatalogList, TipOfSelectedPath);
		}
		dbconnection.close();
		return CatalogList;
	}

	public ProductCatalog getPathCatalog(ProductCatalog ProductCatalog)
	{

		ProductCatalog iProductCatalog = null;
		int upper_catalog = 0;
		upper_catalog = ProductCatalog.getUpper_catalog();
		if (upper_catalog != 0)
		{

			List<ttu.rakarh1.backend.model.data.ProductCatalog> subCatalogList = null;
			iProductCatalog = ProductCatalogDAO.getCatalogByIdWithSubCatalogs(upper_catalog);
			subCatalogList = iProductCatalog.getSubCatalogs();
			subCatalogList = replaceOneChild(subCatalogList, ProductCatalog);
			iProductCatalog.setSubCatalogs(subCatalogList);
			iProductCatalog = getPathCatalog(iProductCatalog);
		} else
		{
			iProductCatalog = ProductCatalog;
		}
		dbconnection.close();
		return iProductCatalog;
	}

	public List<ProductCatalog> replaceOneChild(List<ProductCatalog> subCatalogList,
			ProductCatalog ProductCatalog)
	{
		ProductCatalog catalog = null;
		for (int i = 0; i < subCatalogList.size(); i++)
		{
			catalog = (ProductCatalog) subCatalogList.get(i);
			if (catalog.getProduct_catalog() == ProductCatalog.getProduct_catalog())
			{
				subCatalogList.set(i, ProductCatalog);
			}
		}
		return subCatalogList;
	}

	public ProductCatalog getProductCatalogById(int catalogId)
	{
		ProductCatalogDAO pcd = new ProductCatalogDAOImpl();
		ProductCatalog productCatalog = ProductCatalogDAO.getCatalogByIdWithSubCatalogs(catalogId);
		MyLogger.LogMessage("NO NULL SET CATLOG 1");
		MyLogger.LogMessage("NO NULL SET CATLOG 2" + productCatalog==null? "null": "CORRECT OBJ" );
		return productCatalog;
	}
}
