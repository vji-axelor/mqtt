/**
 * Axelor Business Solutions
 *
 * Copyright (C) 2017 Axelor (<http://axelor.com>).
 *
 * This program is free software: you can redistribute it and/or  modify
 * it under the terms of the GNU Affero General Public License, version 3,
 * as published by the Free Software Foundation.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.axelor.apps.sale.exception;

/**
 * Interface of Exceptions.
 * 
 * @author dubaux
 * 
 */
public interface IExceptionMessage {

	/**
	 * Sales Order Stock Move Service
	 */
	static final String SALES_ORDER_STOCK_MOVE_1 = /*$$(*/ "Invoice by delivery impose that all sale order lines must have service or stockable product with provision from stock" /*)*/ ;
	
	/**
	 * Sales Order Service Impl
	 */
	static final String SALES_ORDER_1 = /*$$(*/ "The company %s doesn't have any configured sequence for sale orders" /*)*/ ;
	
	/**
	 * Sale Config Service
	 */
	static final String SALE_CONFIG_1 = /*$$(*/ "%s : You must configure Sales module for company %s" /*)*/ ;
	
	/**
	 * Merge sale order
	 */

	static final public String SALE_ORDER_MERGE_ERROR_CURRENCY = /*$$(*/ "The currency is required and must be the same for all sale orders" /*)*/;
	static final public String SALE_ORDER_MERGE_ERROR_CLIENT_PARTNER = /*$$(*/ "The client Partner is required and must be the same for all sale orders" /*)*/;
	static final public String SALE_ORDER_MERGE_ERROR_COMPANY = /*$$(*/ "The company is required and must be the same for all sale orders" /*)*/;

	/**
	 * Configurator generator
	 */

	static final String CONFIGURATOR_GENERATED = /*$$(*/ "The configurator is generated. Please check the configurators menu." /*)*/;
	String CONFIGURATOR_CREATOR_MISSING_VALUES = /*$$(*/ "Please fill the default values in the attribute list in order to test this configurator creator." /*)*/;
	String CONFIGURATOR_CREATOR_SCRIPT_ERROR = /*$$(*/ "At least one script has errors, please see the logs for more details." /*)*/;
	String CONFIGURATOR_CREATOR_SCRIPT_WORKING = /*$$(*/ "All scripts are working." /*)*/;

	/**
	 * Configurator Service
	 */
	String CONFIGURATOR_SCRIPT_CLASS_NOT_FOUND = /*$$(*/ "Class %s is not a model class." /*)*/;

	/**
	 * Product Sale service
	 */

	static final String CONFIGURATOR_NOT_FOUND = /*$$(*/ "This product has no configurator." /*)*/;

}
