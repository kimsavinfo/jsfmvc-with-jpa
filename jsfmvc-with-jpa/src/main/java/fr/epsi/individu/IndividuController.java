package fr.epsi.individu;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.sql.DataSource;

@Named
@RequestScoped
public class IndividuController {

	private final Individu individu = new Individu();
	private EntityManager entityManager;

	// TEMPO, works
	@Resource(name = "jdbc")
	private DataSource dataSource;

	public String create() {
		return "individu?faces-redirect=true";
	}

	public void delete(long individuId) 
	{
		entityManager.createNativeQuery("delete from individu where individuId = ?")
		.setParameter(1, individuId)
		.executeUpdate();
	}

	public List<Individu> getAll() {
		/*List<Individu> individus = null;
		individus = entityManager.createQuery("select i from Individu i", Individu.class)
				.getResultList();
		 */

		// TEMPO, works
		List<Individu> individus = new ArrayList<>();

		try( java.sql.Connection connection = dataSource.getConnection() )
		{
			String request = "SELECT id_individu, nom_individu, prenom_individu, age_individu  FROM INDIVIDUS";

			PreparedStatement pstmt = connection.prepareStatement(request);

			try(ResultSet resultSet = pstmt.executeQuery())
			{				
				while(resultSet.next())
				{
					Individu individu = new Individu();
					individu.setId(resultSet.getLong(1));
					individu.setNom(resultSet.getString(2));
					individu.setPrenom(resultSet.getString(3));
					individu.setAge(resultSet.getInt(4));

					individus.add(individu);
				}
			}
		} 
		catch (SQLException ex) 
		{
			ex.printStackTrace();
		}

		return individus;
	}

	public Individu getIndividu() {
		return individu;
	}
}
