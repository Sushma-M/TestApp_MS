/*Copyright (c) 2016-2017 vcstest4.com All Rights Reserved.
 This software is the confidential and proprietary information of vcstest4.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with vcstest4.com*/
package com.testallservicesforvcs.adventureworks2014.controller;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.sql.Date;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wavemaker.commons.wrapper.StringWrapper;
import com.wavemaker.runtime.data.export.DataExportOptions;
import com.wavemaker.runtime.data.export.ExportType;
import com.wavemaker.runtime.data.expression.QueryFilter;
import com.wavemaker.runtime.data.model.AggregationInfo;
import com.wavemaker.runtime.file.manager.ExportedFileManager;
import com.wavemaker.runtime.file.model.Downloadable;
import com.wavemaker.tools.api.core.annotations.WMAccessVisibility;
import com.wavemaker.tools.api.core.models.AccessSpecifier;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;

import com.testallservicesforvcs.adventureworks2014.VemployeeDepartmentHistory;
import com.testallservicesforvcs.adventureworks2014.VemployeeDepartmentHistoryId;
import com.testallservicesforvcs.adventureworks2014.service.VemployeeDepartmentHistoryService;


/**
 * Controller object for domain model class VemployeeDepartmentHistory.
 * @see VemployeeDepartmentHistory
 */
@RestController("AdventureWorks2014.VemployeeDepartmentHistoryController")
@Api(value = "VemployeeDepartmentHistoryController", description = "Exposes APIs to work with VemployeeDepartmentHistory resource.")
@RequestMapping("/AdventureWorks2014/VemployeeDepartmentHistory")
public class VemployeeDepartmentHistoryController {

    private static final Logger LOGGER = LoggerFactory.getLogger(VemployeeDepartmentHistoryController.class);

    @Autowired
	@Qualifier("AdventureWorks2014.VemployeeDepartmentHistoryService")
	private VemployeeDepartmentHistoryService vemployeeDepartmentHistoryService;

	@Autowired
	private ExportedFileManager exportedFileManager;

	@ApiOperation(value = "Creates a new VemployeeDepartmentHistory instance.")
    @RequestMapping(method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public VemployeeDepartmentHistory createVemployeeDepartmentHistory(@RequestBody VemployeeDepartmentHistory vemployeeDepartmentHistory) {
		LOGGER.debug("Create VemployeeDepartmentHistory with information: {}" , vemployeeDepartmentHistory);

		vemployeeDepartmentHistory = vemployeeDepartmentHistoryService.create(vemployeeDepartmentHistory);
		LOGGER.debug("Created VemployeeDepartmentHistory with information: {}" , vemployeeDepartmentHistory);

	    return vemployeeDepartmentHistory;
	}

    @ApiOperation(value = "Returns the VemployeeDepartmentHistory instance associated with the given composite-id.")
    @RequestMapping(value = "/composite-id", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public VemployeeDepartmentHistory getVemployeeDepartmentHistory(@RequestParam("businessEntityId") Integer businessEntityId, @RequestParam("title") String title, @RequestParam("firstName") String firstName, @RequestParam("middleName") String middleName, @RequestParam("lastName") String lastName, @RequestParam("suffix") String suffix, @RequestParam("shift") String shift, @RequestParam("department") String department, @RequestParam("groupName") String groupName, @RequestParam("startDate") Date startDate, @RequestParam("endDate") Date endDate) {

        VemployeeDepartmentHistoryId vemployeedepartmenthistoryId = new VemployeeDepartmentHistoryId();
        vemployeedepartmenthistoryId.setBusinessEntityId(businessEntityId);
        vemployeedepartmenthistoryId.setTitle(title);
        vemployeedepartmenthistoryId.setFirstName(firstName);
        vemployeedepartmenthistoryId.setMiddleName(middleName);
        vemployeedepartmenthistoryId.setLastName(lastName);
        vemployeedepartmenthistoryId.setSuffix(suffix);
        vemployeedepartmenthistoryId.setShift(shift);
        vemployeedepartmenthistoryId.setDepartment(department);
        vemployeedepartmenthistoryId.setGroupName(groupName);
        vemployeedepartmenthistoryId.setStartDate(startDate);
        vemployeedepartmenthistoryId.setEndDate(endDate);

        LOGGER.debug("Getting VemployeeDepartmentHistory with id: {}" , vemployeedepartmenthistoryId);
        VemployeeDepartmentHistory vemployeeDepartmentHistory = vemployeeDepartmentHistoryService.getById(vemployeedepartmenthistoryId);
        LOGGER.debug("VemployeeDepartmentHistory details with id: {}" , vemployeeDepartmentHistory);

        return vemployeeDepartmentHistory;
    }



    @ApiOperation(value = "Updates the VemployeeDepartmentHistory instance associated with the given composite-id.")
    @RequestMapping(value = "/composite-id", method = RequestMethod.PUT)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public VemployeeDepartmentHistory editVemployeeDepartmentHistory(@RequestParam("businessEntityId") Integer businessEntityId, @RequestParam("title") String title, @RequestParam("firstName") String firstName, @RequestParam("middleName") String middleName, @RequestParam("lastName") String lastName, @RequestParam("suffix") String suffix, @RequestParam("shift") String shift, @RequestParam("department") String department, @RequestParam("groupName") String groupName, @RequestParam("startDate") Date startDate, @RequestParam("endDate") Date endDate, @RequestBody VemployeeDepartmentHistory vemployeeDepartmentHistory) {

        vemployeeDepartmentHistory.setBusinessEntityId(businessEntityId);
        vemployeeDepartmentHistory.setTitle(title);
        vemployeeDepartmentHistory.setFirstName(firstName);
        vemployeeDepartmentHistory.setMiddleName(middleName);
        vemployeeDepartmentHistory.setLastName(lastName);
        vemployeeDepartmentHistory.setSuffix(suffix);
        vemployeeDepartmentHistory.setShift(shift);
        vemployeeDepartmentHistory.setDepartment(department);
        vemployeeDepartmentHistory.setGroupName(groupName);
        vemployeeDepartmentHistory.setStartDate(startDate);
        vemployeeDepartmentHistory.setEndDate(endDate);

        LOGGER.debug("VemployeeDepartmentHistory details with id is updated with: {}" , vemployeeDepartmentHistory);

        return vemployeeDepartmentHistoryService.update(vemployeeDepartmentHistory);
    }


    @ApiOperation(value = "Deletes the VemployeeDepartmentHistory instance associated with the given composite-id.")
    @RequestMapping(value = "/composite-id", method = RequestMethod.DELETE)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public boolean deleteVemployeeDepartmentHistory(@RequestParam("businessEntityId") Integer businessEntityId, @RequestParam("title") String title, @RequestParam("firstName") String firstName, @RequestParam("middleName") String middleName, @RequestParam("lastName") String lastName, @RequestParam("suffix") String suffix, @RequestParam("shift") String shift, @RequestParam("department") String department, @RequestParam("groupName") String groupName, @RequestParam("startDate") Date startDate, @RequestParam("endDate") Date endDate) {

        VemployeeDepartmentHistoryId vemployeedepartmenthistoryId = new VemployeeDepartmentHistoryId();
        vemployeedepartmenthistoryId.setBusinessEntityId(businessEntityId);
        vemployeedepartmenthistoryId.setTitle(title);
        vemployeedepartmenthistoryId.setFirstName(firstName);
        vemployeedepartmenthistoryId.setMiddleName(middleName);
        vemployeedepartmenthistoryId.setLastName(lastName);
        vemployeedepartmenthistoryId.setSuffix(suffix);
        vemployeedepartmenthistoryId.setShift(shift);
        vemployeedepartmenthistoryId.setDepartment(department);
        vemployeedepartmenthistoryId.setGroupName(groupName);
        vemployeedepartmenthistoryId.setStartDate(startDate);
        vemployeedepartmenthistoryId.setEndDate(endDate);

        LOGGER.debug("Deleting VemployeeDepartmentHistory with id: {}" , vemployeedepartmenthistoryId);
        VemployeeDepartmentHistory vemployeeDepartmentHistory = vemployeeDepartmentHistoryService.delete(vemployeedepartmenthistoryId);

        return vemployeeDepartmentHistory != null;
    }


    /**
     * @deprecated Use {@link #findVemployeeDepartmentHistories(String, Pageable)} instead.
     */
    @Deprecated
    @ApiOperation(value = "Returns the list of VemployeeDepartmentHistory instances matching the search criteria.")
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<VemployeeDepartmentHistory> searchVemployeeDepartmentHistoriesByQueryFilters( Pageable pageable, @RequestBody QueryFilter[] queryFilters) {
        LOGGER.debug("Rendering VemployeeDepartmentHistories list by query filter:{}", (Object) queryFilters);
        return vemployeeDepartmentHistoryService.findAll(queryFilters, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of VemployeeDepartmentHistory instances matching the optional query (q) request param. If there is no query provided, it returns all the instances. Pagination & Sorting parameters such as page& size, sort can be sent as request parameters. The sort value should be a comma separated list of field names & optional sort order to sort the data on. eg: field1 asc, field2 desc etc ")
    @RequestMapping(method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<VemployeeDepartmentHistory> findVemployeeDepartmentHistories(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering VemployeeDepartmentHistories list by filter:", query);
        return vemployeeDepartmentHistoryService.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of VemployeeDepartmentHistory instances matching the optional query (q) request param. This API should be used only if the query string is too big to fit in GET request with request param. The request has to made in application/x-www-form-urlencoded format.")
    @RequestMapping(value="/filter", method = RequestMethod.POST, consumes= "application/x-www-form-urlencoded")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<VemployeeDepartmentHistory> filterVemployeeDepartmentHistories(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering VemployeeDepartmentHistories list by filter", query);
        return vemployeeDepartmentHistoryService.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns downloadable file for the data matching the optional query (q) request param. If query string is too big to fit in GET request's query param, use POST method with application/x-www-form-urlencoded format.")
    @RequestMapping(value = "/export/{exportType}", method = {RequestMethod.GET,  RequestMethod.POST}, produces = "application/octet-stream")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Downloadable exportVemployeeDepartmentHistories(@PathVariable("exportType") ExportType exportType, @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
         return vemployeeDepartmentHistoryService.export(exportType, query, pageable);
    }

    @ApiOperation(value = "Returns a URL to download a file for the data matching the optional query (q) request param and the required fields provided in the Export Options.") 
    @RequestMapping(value = "/export", method = {RequestMethod.POST}, consumes = "application/json")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public StringWrapper exportVemployeeDepartmentHistoriesAndGetURL(@RequestBody DataExportOptions exportOptions, Pageable pageable) {
        String exportedFileName = exportOptions.getFileName();
        if(exportedFileName == null || exportedFileName.isEmpty()) {
            exportedFileName = VemployeeDepartmentHistory.class.getSimpleName();
        }
        exportedFileName += exportOptions.getExportType().getExtension();
        String exportedUrl = exportedFileManager.registerAndGetURL(exportedFileName, outputStream -> vemployeeDepartmentHistoryService.export(exportOptions, pageable, outputStream));
        return new StringWrapper(exportedUrl);
    }

	@ApiOperation(value = "Returns the total count of VemployeeDepartmentHistory instances matching the optional query (q) request param. If query string is too big to fit in GET request's query param, use POST method with application/x-www-form-urlencoded format.")
	@RequestMapping(value = "/count", method = {RequestMethod.GET, RequestMethod.POST})
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public Long countVemployeeDepartmentHistories( @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query) {
		LOGGER.debug("counting VemployeeDepartmentHistories");
		return vemployeeDepartmentHistoryService.count(query);
	}

    @ApiOperation(value = "Returns aggregated result with given aggregation info")
	@RequestMapping(value = "/aggregations", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public Page<Map<String, Object>> getVemployeeDepartmentHistoryAggregatedValues(@RequestBody AggregationInfo aggregationInfo, Pageable pageable) {
        LOGGER.debug("Fetching aggregated results for {}", aggregationInfo);
        return vemployeeDepartmentHistoryService.getAggregatedValues(aggregationInfo, pageable);
    }


    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service VemployeeDepartmentHistoryService instance
	 */
	protected void setVemployeeDepartmentHistoryService(VemployeeDepartmentHistoryService service) {
		this.vemployeeDepartmentHistoryService = service;
	}

}