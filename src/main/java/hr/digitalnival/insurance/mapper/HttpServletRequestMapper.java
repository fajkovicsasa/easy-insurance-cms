package hr.digitalnival.insurance.mapper;

import hr.digitalnival.insurance.model.InsuranceType;

import javax.servlet.http.HttpServletRequest;

public class HttpServletRequestMapper {

    public static InsuranceType toInsuranceType(HttpServletRequest request) {
        InsuranceType insuranceType = new InsuranceType();
        insuranceType.setId(Long.parseLong(request.getParameter("id")));
        insuranceType.setName(request.getParameter("name"));
        insuranceType.setDescription(request.getParameter("description"));
        insuranceType.setRiskPercentage(Double.parseDouble(request.getParameter("riskPercentage")));
        insuranceType.setCoverageAmountBottomLimit(Double.parseDouble(request.getParameter("coverageAmountBottomLimit")));
        insuranceType.setCoverageAmountTopLimit(Double.parseDouble(request.getParameter("coverageAmountTopLimit")));
        insuranceType.setImageUrl(request.getParameter("imageUrl"));

        return insuranceType;
    }
}
