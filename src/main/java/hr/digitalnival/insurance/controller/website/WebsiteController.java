package hr.digitalnival.insurance.controller.website;

import hr.digitalnival.insurance.mapper.HttpServletRequestMapper;
import hr.digitalnival.insurance.model.InsuranceType;
import hr.digitalnival.insurance.service.InsuranceTypeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping(path = "")
public class WebsiteController {

    private Logger log = LoggerFactory.getLogger(WebsiteController.class);

    private InsuranceTypeService insuranceTypeService;

    public WebsiteController(InsuranceTypeService insuranceTypeService) {
        this.insuranceTypeService = insuranceTypeService;
    }

    @GetMapping("")
    public String showHomepage(Model model) {
        model.addAttribute("allInsuranceTypes", insuranceTypeService.getAll());
        return "index";
    }

    @GetMapping("/admin")
    public String showAdminDashboard(Model model) {
        List<InsuranceType> insuranceTypes = insuranceTypeService.getAll();

        model.addAttribute("allInsuranceTypes", insuranceTypes);

        return "/admin/dashboard";
    }

    @GetMapping("/admin/insurance-types/{id}")
    public String showInsuranceTypeDetails(Model model, @PathVariable Long id) {
        model.addAttribute("insuranceType", insuranceTypeService.getInsuranceType(id));

        return "/admin/insuranceTypeDetails";
    }

    @PostMapping("/admin/insurance-types/{id}")
    public String updateInsuranceTypeDetails(@PathVariable Long id, HttpServletRequest request, Model model) {
        InsuranceType insuranceType;

        try {
            insuranceType = HttpServletRequestMapper.toInsuranceType(request);
            insuranceTypeService.update(insuranceType);
            model.addAttribute("successMessage", "Changes have been saved!");
            model.addAttribute("insuranceType", insuranceType);
        } catch (Exception e) {
            log.error("There was an error trying to update insurance type with id: " + id);
            log.error(e.getMessage());
            model.addAttribute("errorMessage", "There was an error! Try again!");
            model.addAttribute("insuranceType", insuranceTypeService.getInsuranceType(id));
        }

        return "/admin/insuranceTypeDetails";
    }
}
