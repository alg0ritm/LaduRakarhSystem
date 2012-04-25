<%@page import="ttu.rakarh1.backend.constant.Constant"%>
<%@ page import="java.util.*"%>
<%@ page import="ttu.rakarh1.backend.model.data.*"%>
<%@ page import="ttu.rakarh1.web.forms.*"%>
<%@ page import="ttu.rakarh1.web.view.*"%>
<%@ page import="ttu.rakarh1.log.MyLogger"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<html>
<head>
<title>Rakarh1:tegevuste jarjekorra naide</title>

<link rel="stylesheet" href="/jsp/rakarh.css" type="text/css" />
<script language="javascript">
	function show_confirm() {
		var r = confirm("Are you sure you want to logout?");
		if (r == true) {
			document.location.href = "c?logout";
		} else {

		}
	}

	function checkAnswerForItemRemoval() {
		var r = confirm("Kas olete kindel et tahate kustutada valitud tooteid, koos kõike olemasolevate nende kohta andmetega?");
		if (r == true) {
			return true;
		} else {
			return false;
		}
	}


	function hideNotAvailableStores(selectSource, selectDestination) {

		/*var x=document.getElementById("mySelect").selectedIndex;
		var y=document.getElementById("mySelect").options;
		alert("Index: " + y[x].index + " is " + y[x].text);

		var k=document.getElementById("mySelect1").selectedIndex;
		var m=document.getElementById("mySelect1").options;
		alert("IndexSize: " + m[1].text);

		for(i=0; i<y.length; i++) {
			 if(m[i].text == y[x].text) {
			   m[i].style.display="none";
			}
			 else m[i].style.display="block";
			}
		}*/
		var selectSourceIndex = document.getElementById(selectSource).selectedIndex;
		var selectSourceValue =document.getElementById(selectSource).options;
		var valueToHide = selectSourceValue[selectSourceIndex].text;

		var selectDestinationIndex=document.getElementById(selectDestination).selectedIndex;
		var selectDestinationValue=document.getElementById(selectDestination).options;
		var previousSelection = selectDestinationValue.length-1;
		var tempIndex;
		var tempValue;

		for(i=0; i<selectSourceValue.length; i++) {

		 if(selectDestinationValue[i].text == valueToHide) {
			 if(selectDestinationValue[selectDestinationIndex]==selectDestinationValue[i]) {
				 tempIndex = selectDestinationValue[selectDestinationIndex].index;
				 tempValue = selectDestinationValue[selectDestinationIndex].text;

			     selectDestinationValue[selectDestinationIndex].index = selectDestinationValue[previousSelection].index;
			     selectDestinationValue[selectDestinationIndex].text = selectDestinationValue[previousSelection].text;

			     selectDestinationValue[previousSelection].index = tempIndex;
			     selectDestinationValue[previousSelection].text = tempValue;
			     selectDestinationValue[previousSelection].style.display="none";
			 }
			 else
			 selectDestinationValue[i].style.display="none";
		}
		 else {
			selectDestinationValue[i].style.display="block";
		 	previousSelection = selectDestinationValue[i];
		 }
		}

	}

	/*function show_location(url) {
		document.getElementById("takeForm").submit();
		document.location.href = "c?" + url;

	}*/
</script>

</head>
<body onload="checkForAvailableFunctinsLoading();" bgcolor="white">




	<b> Rakarh1:Ladu Süsteem</b>
	<br>
	<hr>

	<br>
	<br>

	<table>
		<tr>
			<td valign=top bgcolor=#CCCCCC>
				<p>

					<%
						HorisontalMenu horisontalMenu = (HorisontalMenu) request.getAttribute(Constant.HORISONTAL_MENU);
						HorisontalMenuUi horisontalMenuUi = new HorisontalMenuUi();
						horisontalMenuUi.createMenu(horisontalMenu);
						if (session.getAttribute("user") != null) {
							MyLogger.LogMessage("Session is not null");
							DrawCatalog DrawCatalog = null;
							String showAddProduct = "false";
							String moveProduct = "false";
							String takeOnAccount = "false";
							String removeFromAccount = "false";
							String selected_catalog_id_s = "";
							int selected_catalog_id = 0;

							if (request.getAttribute("moveProduct") != null) {
								MyLogger.LogMessage("moveProduct NOT NULL " + request.getAttribute("moveProduct"));
								moveProduct = (String) request.getAttribute("moveProduct");
							}
							if (request.getAttribute("takeOnAccount") != null) {
								MyLogger.LogMessage("takeOnAccount NOT NULL " + request.getAttribute("takeOnAccount"));
								takeOnAccount = (String) request.getAttribute("takeOnAccount");
							}
							if (request.getAttribute("removeFromAccount") != null) {
								MyLogger.LogMessage("removeFromAccount NOT NULL " + request.getAttribute("removeFromAccount"));
								removeFromAccount = (String) request.getAttribute("removeFromAccount");
							}
							if (request.getAttribute("showAddProduct") != null) {
								MyLogger.LogMessage("showAddProduct NOT NULL " + request.getAttribute("showAddProduct"));
								showAddProduct = (String) request.getAttribute("showAddProduct");
							}
							if (request.getParameter("catalog") != null) {
								if (!(request.getParameter("catalog").equals(""))) {
									selected_catalog_id_s = request.getParameter("catalog");
									try {
										selected_catalog_id = Integer.parseInt(selected_catalog_id_s);
									} catch (Exception ex) {
										MyLogger.LogMessage("Error parsing catalog id" + ex.getMessage());
									}
								}
							}

							if (request.getAttribute("CatalogTree") != null) {
								DrawCatalog = new DrawCatalog();
								List<ttu.rakarh1.backend.model.data.ProductCatalog> CatalogTree = (List<ttu.rakarh1.backend.model.data.ProductCatalog>) request
										.getAttribute("CatalogTree");
								String CatalogTreeString = DrawCatalog.DrawCatalogTree(CatalogTree, selected_catalog_id);
								out.println(CatalogTreeString);
							}
					%>

			</td>
			<c:if test="${horisontalMenu ne null}">

				<td valign=top><c:set var="result"
						value="${horisontalMenu.menuResult}" /> ${result}
			</c:if>
			<c:if test="${popupNotifications ne null}">
					<c:forEach items="${popupNotifications}" var="entry">
						<br>${entry.value}
					</c:forEach>
			</c:if>
			<c:if test="${removableItemsForm ne null}">
					${removableItemsForm.html}
			</c:if>
			<%
					SearchForm SearchForm = null;
					List<FormAttribute> formAttributes = null;
					DrawSearchFormView drawSearchForm = null;
					ProductForm ProductForm = null;
					MoveForm moveProductForm = null;
					OperationOnProductForm operationOnProductForm = null;
					MyLogger.LogMessage("LOg");
					String searchString = "";
					String formAttributesActionType = "";
					ProductCatalog selectedCatalog = DrawCatalog.getSelectedCatalog();
					if (request.getAttribute("SearchForm") != null) {

						SearchForm = (SearchForm) request.getAttribute("SearchForm");

						if (selectedCatalog != null) {
							drawSearchForm = new DrawSearchFormView();
							searchString = drawSearchForm.generateSearchForm(SearchForm, selectedCatalog);
							out.println(searchString);
						} else {
							drawSearchForm = new DrawSearchFormView();
							searchString = drawSearchForm.generateGeneralSearchForm(SearchForm);
							out.println(searchString);

						}
						if (request.getAttribute("formAttributes") != null) {
							formAttributesActionType = (String) request.getAttribute("formAttributesActionType");
							formAttributes = (List<FormAttribute>) request.getAttribute("formAttributes");
							String retString = "";
							drawSearchForm = new DrawSearchFormView();
							searchString = drawSearchForm.generateSpecialSearchForm(SearchForm, formAttributes,
									selectedCatalog);
							out.println(searchString);
						}
						out.println(DrawSearchFormView.submitButton());
					}
					if (request.getAttribute("takeOnTheAccountForm") != null) {
						operationOnProductForm = (OperationOnProductForm) request.getAttribute("takeOnTheAccountForm");
						String result = operationOnProductForm.getHtmlForm();
						/*TakeOnTheAccountFormUI takeOnTheAccountFormUI = new TakeOnTheAccountFormUI();
						String result = takeOnTheAccountFormUI.generateTakeOnTheAccountForm(takeOnTheAccountForm);*/
						out.println(result);
					}
					if (request.getAttribute("moveProductForm") != null) {

						/*	public final String SHOW_ADD_PRODUCT = "showAddProduct";
							public final String UPDATE_PRODUCT_FORM = "UpdateProductForm";
							public final String MOVE_PRODUCT = "moveProduct";
							public final String TAKE_ON_ACCOUNT = "takeOnAccount";
							public final String REMOVE_FROM_ACCOUNT = "removeFromAccount";
							public final String MOVE_PRODUCT_FORM = "moveProductForm";
							public final String WAREHOUSES_FROM = "warehousesFrom";
							public final String WAREHOUSES_TO = "warehousesTo"; */
						MyLogger.LogMessage("before showing form");
						if (request.getAttribute("warehousesFrom") != null && request.getAttribute("warehousesTo") != null) {
							moveProductForm = (MoveForm) request.getAttribute("moveProductForm");
							MoveProductFormUI moveProductFormUI = new MoveProductFormUI();
							ArrayList<ItemStore> storesFrom = (ArrayList<ItemStore>) request.getAttribute("warehousesFrom");
							ArrayList<ItemStore> storesTo = (ArrayList<ItemStore>) request.getAttribute("warehousesTo");
							String result = moveProductFormUI
									.generateMoveProductForm(moveProductForm, storesFrom, storesTo);
						}
					}
					if (request.getAttribute("UpdateProductForm") != null) {
						ProductForm = (ProductForm) request.getAttribute("UpdateProductForm");

						DrawUpdateForm drawUpdateForm = new DrawUpdateForm();
						String action = "update_product";
						String result = drawUpdateForm.generateUpdateForm(ProductForm, selected_catalog_id, action);

						out.println(result);
						if (request.getAttribute("formAttributes") != null) {
							MyLogger.LogMessage("FormAttribute!=null");
							formAttributes = (List<FormAttribute>) request.getAttribute("formAttributes");
							formAttributesActionType = (String) request.getAttribute("formAttributesActionType");
							String retString = "";
							drawUpdateForm = new DrawUpdateForm();
							retString = drawUpdateForm.generateSpecialUpdateForm(formAttributes, selected_catalog_id,
									formAttributesActionType);
							out.println(retString);
						}
						out.println(drawUpdateForm.generateSubmitButton());
					}

					if (request.getAttribute("NewProductForm") != null) {
						ProductForm = (ProductForm) request.getAttribute("NewProductForm");

						DrawUpdateForm drawUpdateForm = new DrawUpdateForm();
						String action = "insert_product";
						String result = drawUpdateForm.generateInsertForm(ProductForm, selected_catalog_id, action);
						out.println(result);
						if (request.getAttribute("formAttributes") != null) {
							formAttributesActionType = (String) request.getAttribute("formAttributesActionType");
							formAttributes = (List<FormAttribute>) request.getAttribute("formAttributes");
							String retString = "";
							drawSearchForm = new DrawSearchFormView();
							searchString = drawUpdateForm.generateSpecialUpdateForm(formAttributes,selected_catalog_id,
									formAttributesActionType);
							out.println(searchString);
						}
						out.println(drawUpdateForm.generateSubmitButton());

					}

					if (request.getAttribute("products") != null) {

						Product Product = null;
						List<Product> products = null;
						String product_URL = "c?";
						String product_URL_parameters = "&catalog=";

						/*if (!(selected_catalog_id_s.equals(""))) {
							product_URL_parameters = product_URL_parameters + "catalog=" + selected_catalog_id_s;
						}*/

						//		product_URL = product_URL + product_URL_parameters;

						products = (List<Product>) request.getAttribute("products");
						out.println("<p><div class=\"product_list\">Kaubad:<table class=\"product_list\">");
						for (Product product : products) {
							out.println("<tr><td class=\"product_list\"><a href=" + product_URL + "product_id="
									+ product.getProduct() + product_URL_parameters + product.getProduct_catalog()  + ">" + product.getName()
									+ "</a></td><td>" + Float.toString(product.getStore_price()) + "</td></tr>");
						}
						out.println("</table></div></p>");
					}

				} else {
					DrawLoginForm loginForm = new DrawLoginForm();
					out.println(loginForm.drawForm());

				}
			%>
			</td>
		</tr>
	</table>
</body>
</html>
