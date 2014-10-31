package com.capitalb.model;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Ingredient
 *
 * @author Leo Na
 */
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Entity
@Table(name = "Ingredient")
@TableGenerator(
        name = "IngredientIdGenerator",
        table = "sequence_table",
        pkColumnName = "generatorName",
        pkColumnValue = "IngredientIdGenerator",
        valueColumnName = "generatorValue",
        initialValue = 1,
        allocationSize = 1
)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Ingredient implements Serializable {

    private static final long serialVersionUID = 1695076438554922869L;

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "IngredientIdGenerator")
    private Long id;

    @NotBlank
    @NotEmpty
    @Column(nullable = false)
    private String name;

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
}
