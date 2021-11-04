package com.resources;


import javax.ws.rs.GET;

import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.Model.Country;
import com.dao.CountryDAO;
import com.google.gson.Gson;



@Path("/rate") 
public class GDPGrowth {
	
	Country countryObj = new Country();
	CountryDAO daoObj = new CountryDAO();
	Gson gsonObject = new Gson();

	@GET
	@Path("/{countryCode, year1, year2}")
	@Produces(MediaType.APPLICATION_JSON)
	public String getGDPGrowthRate(@PathParam("countryCode") String code, @PathParam("year1") int year1, @PathParam("year2") int year2) {
		
		countryObj.setCode(code);
		countryObj.setYear1(year1);
		countryObj.setYear2(year2);
		
		double res = daoObj.calGDPGrowthRate(countryObj);
		
		return gsonObject.toJson(res);
	}
	
	
	

}
