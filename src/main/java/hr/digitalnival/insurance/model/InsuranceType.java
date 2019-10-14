package hr.digitalnival.insurance.model;

import javax.persistence.*;

@Entity
@Table(name = "INSURANCE_TYPES")
public class InsuranceType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;
    private Double riskPercentage;
    private Double coverageAmountBottomLimit;
    private Double coverageAmountTopLimit;
    private String imageUrl;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getRiskPercentage() {
        return riskPercentage;
    }

    public void setRiskPercentage(Double riskPercentage) {
        this.riskPercentage = riskPercentage;
    }

    public Double getCoverageAmountBottomLimit() {
        return coverageAmountBottomLimit;
    }

    public void setCoverageAmountBottomLimit(Double coverageAmountBottomLimit) {
        this.coverageAmountBottomLimit = coverageAmountBottomLimit;
    }

    public Double getCoverageAmountTopLimit() {
        return coverageAmountTopLimit;
    }

    public void setCoverageAmountTopLimit(Double coverageAmountTopLimit) {
        this.coverageAmountTopLimit = coverageAmountTopLimit;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @Override
    public String toString() {
        return "InsuranceType{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", riskPercentage=" + riskPercentage +
                ", coverageAmountBottomLimit=" + coverageAmountBottomLimit +
                ", coverageAmountTopLimit=" + coverageAmountTopLimit +
                ", imageUrl='" + imageUrl + '\'' +
                '}';
    }
}
