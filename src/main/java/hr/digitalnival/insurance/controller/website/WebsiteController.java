package hr.digitalnival.insurance.controller.website;

import hr.digitalnival.insurance.mapper.HttpServletRequestMapper;
import hr.digitalnival.insurance.model.InsuranceType;
import hr.digitalnival.insurance.service.InsuranceTypeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("admin")
    public String showAdminDashboard(Model model, @RequestParam(value = "error", required = false) Boolean showError) {
        List<InsuranceType> insuranceTypes = insuranceTypeService.getAll();

        model.addAttribute("error", showError);
        model.addAttribute("allInsuranceTypes", insuranceTypes);

        return "admin/dashboard";
    }

    @GetMapping("/admin/insurance-types/{id}")
    public String showInsuranceTypeDetails(Model model, @PathVariable Long id) {
        log.info("Opening update for insurance type " + id);
        model.addAttribute("insuranceType", insuranceTypeService.getInsuranceType(id));

        return "admin/insuranceTypeDetails";
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

        return "admin/insuranceTypeDetails";
    }

    @GetMapping("/admin/insurance-types/new")
    public String createNewInsuranceType() {
        log.debug("Creating a new insurance type");

        return "admin/newInsuranceType";
    }

    @PostMapping("/admin/insurance-types/new")
    public String createNewInsuranceType( HttpServletRequest request, Model model) {
        try {
            InsuranceType insuranceType = HttpServletRequestMapper.toInsuranceType(request);
            insuranceTypeService.create(insuranceType);
        } catch (Exception e) {
            log.error("There was an error trying create a new insurance type");
            log.error(e.getMessage());
            model.addAttribute("errorMessage", "Error creating a new insurance type.");
            return "/admin/newInsuranceType";
        }

        return "redirect:/admin";
    }

    @GetMapping("/admin/insurance-types/{id}/delete")
    public String deleteInsuranceType( @PathVariable Long id) {
        try {
            insuranceTypeService.delete(id);
        } catch (Exception e) {
            log.error("There was an error trying to delete an insurance type " + id);
            log.error(e.getMessage());
            return "redirect:/admin?error=true";
        }

        return "redirect:/admin";
    }

}
