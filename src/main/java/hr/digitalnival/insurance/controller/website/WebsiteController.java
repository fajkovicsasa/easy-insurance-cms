package hr.digitalnival.insurance.controller.website;

import hr.digitalnival.insurance.model.InsuranceType;
import hr.digitalnival.insurance.service.InsuranceTypeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping(path = "")
public class WebsiteController {

    private InsuranceTypeService insuranceTypeService;

    public WebsiteController(InsuranceTypeService insuranceTypeService) {
        this.insuranceTypeService = insuranceTypeService;
    }

    @GetMapping("")
    public String getHomepage(Model model) {
        model.addAttribute("allInsuranceTypes", insuranceTypeService.getAll());
        return "index";
    }

    @GetMapping("/admin")
    public String getAdminDashboard(Model model) {
        List<InsuranceType> insuranceTypes = insuranceTypeService.getAll();

        model.addAttribute("allInsuranceTypes", insuranceTypes);

        return "/admin/dashboard";
    }
}
