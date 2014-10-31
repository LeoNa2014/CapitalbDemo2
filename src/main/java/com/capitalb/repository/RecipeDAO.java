package com.capitalb.repository;

import com.capitalb.model.Recipe;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 * Recipe Data Access Object
 * 
 * Please Note: {@link @Transactional} could be marked in service layer 
 * to control propagation level, which will override the transaction 
 * propagation in DAO layer
 * 
 * 
 * @author Leo Na
 */
@Repository
@Transactional
public class RecipeDAO {

	@PersistenceContext
	private EntityManager entityManager;

	public List<Recipe> getAll() {
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<Recipe> criteria = cb.createQuery( Recipe.class );
		Root<Recipe> recipe = criteria.from( Recipe.class );
		criteria.select( recipe ).orderBy( cb.asc( recipe.get( "name" ) ) );
		return entityManager.createQuery( criteria ).getResultList();
	}

	public Recipe getById( Long id ) {
		return entityManager.find ( Recipe.class, id );
	}
	
	@Transactional(readOnly=false)
	public void register( Recipe recipe) {
		entityManager.persist( recipe );
        return;
    }
	
	@Transactional(readOnly=false)
	public void remove( Recipe recipe ) {
		this.remove( recipe.getId() );
    }
	
	@Transactional(readOnly=false)
	public void remove( Long id ) {
		Recipe persistentRecipe = this.getById( id );
		if ( persistentRecipe == null ) {
			/* error message should be generated here*/
			return;
		}
		entityManager.remove( persistentRecipe );
    }
}
