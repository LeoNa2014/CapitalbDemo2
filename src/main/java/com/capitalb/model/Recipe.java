package com.capitalb.model;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Recipe
 *
 * @author Leo Na
 */
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Entity
@Table(name = "Recipe")
@TableGenerator(
        name = "RecipeIdGenerator",
        table = "sequence_table",
        pkColumnName = "generatorName",
        pkColumnValue = "RecipeIdGenerator",
        valueColumnName = "generatorValue",
        initialValue = 1,
        allocationSize = 1
)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Recipe implements Serializable {

    private static final long serialVersionUID = -6059703463574434976L;

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "RecipeIdGenerator")
    private Long id;

    @NotBlank
    @Column(nullable = false)
    @Pattern(regexp = "[A-Za-z ]*", message = "must contain only letters and spaces")
    private String name;

    @NotBlank
    @Column(nullable = false)
    private String method;

    @OneToMany(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
    private List<Ingredient> ingredients;

    @Column(updatable = false, nullable = false)
    @Temporal(TemporalType.DATE)
    private Date created;

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

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    @PrePersist
    public void onPersist() {
        this.created = Calendar.getInstance().getTime();
    }
}
