package ttu.rakarh1.web.view;

import java.util.*;


import ttu.rakarh1.backend.model.data.*;
import ttu.rakarh1.backend.model.service.*;
import ttu.rakarh1.log.MyLogger;

public class DrawCatalog {

    public ProductCatalog selectedCatalog = null;

    public String DrawCatalogTree(
            List<ttu.rakarh1.backend.model.data.ProductCatalog> ProductCatalogTree,
            int selected_catalog_id) {
        String catalog_out = "";
        ProductCatalog catalog = null;
        for (int i = 0; i < ProductCatalogTree.size(); i++) {
            catalog = (ProductCatalog) ProductCatalogTree.get(i);
            catalog_out = catalog_out
                    + drawCatalog(catalog, selected_catalog_id);
        }
        return catalog_out;

    }

    public String drawCatalog(ProductCatalog catalog, int selected_catalog_id) {
        String catalog_out = "";
        String selected_indicator_before = "";
        String selected_indicator_after = "";
        if (selected_catalog_id == catalog.getProduct_catalog()) {
            this.selectedCatalog = catalog;
            selected_indicator_before = "<b>*";
            selected_indicator_after = "</b>";
        }
        ProductCatalog subcatalog = null;
        for (int i = 0; i < (catalog.getLevel() - 1); i++) {
            catalog_out = catalog_out + "--";
        }
        catalog_out = catalog_out + "<a href=\"?catalog="
                + catalog.getProduct_catalog() + "\">"
                + selected_indicator_before + catalog.getName()
                + selected_indicator_after + "</a><br>\n";

        if (catalog.getSubCatalogs() != null) {
            Iterator iter = catalog.getSubCatalogs().iterator();
            while (iter.hasNext()) {
                subcatalog = (ProductCatalog) iter.next();
                catalog_out = catalog_out
                        + drawCatalog(subcatalog, selected_catalog_id);
            }
        }
        return catalog_out;
    }

    public ProductCatalog getSelectedCatalog()
    {
        return this.selectedCatalog;
    }
}
