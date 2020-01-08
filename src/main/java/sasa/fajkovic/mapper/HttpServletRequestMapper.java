package sasa.fajkovic.mapper;

import sasa.fajkovic.model.InsuranceType;

import javax.servlet.http.HttpServletRequest;

public class HttpServletRequestMapper {

    public static InsuranceType toInsuranceType(HttpServletRequest request) {
        InsuranceType insuranceType = new InsuranceType();
        if (!request.getParameter("id").trim().equals("")) { // When creating a new entity, the ID will be an empty string
            insuranceType.setId(Long.parseLong(request.getParameter("id")));
        }
        insuranceType.setName(request.getParameter("name"));
        insuranceType.setDescription(request.getParameter("description"));
        insuranceType.setRiskPercentage(Double.parseDouble(request.getParameter("riskPercentage")));
        insuranceType.setCoverageAmountBottomLimit(Double.parseDouble(request.getParameter("coverageAmountBottomLimit")));
        insuranceType.setCoverageAmountTopLimit(Double.parseDouble(request.getParameter("coverageAmountTopLimit")));
        insuranceType.setImageUrl(request.getParameter("imageUrl"));

        return insuranceType;
    }
}
